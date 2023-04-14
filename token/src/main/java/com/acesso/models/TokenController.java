package com.acesso.models;


import com.acesso.repository.RedisRepository;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.inject.Inject;
import javax.ws.rs.Path;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Path("/redis")
public class TokenController {
    private ObjectMapper mapper;
    @Inject
    private RedisRepository repository;

    @Path("/validate")
    public TokenSimpleValidation validate(TokenSessionCredentials credentials) {
        var decodedJwt = JWT.decode(credentials.getToken());

        var appServerKey = decodedJwt.getClaim("appServerKey").asString();
        var userIdentifier = decodedJwt.getClaim("identifier").asString();

        if (!Objects.equals(appServerKey, credentials.getAppKey())) throw new RuntimeException("Erro");

        var tokenIdentifier = new TokenIdentifier(userIdentifier, "grant", 1L, "_");

        String redisKey = tokenIdentifier.toRedisKey();
        var redisValue = Optional.ofNullable(this.repository.getCountCommands().get(redisKey)).orElseThrow(() -> new RuntimeException(""));

        Map<String, Object> redisValueMap;
        try {
            redisValueMap = (Map<String, Object>) this.mapper.readValue(redisValue, Map.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        final Algorithm hmacAlgorithm = Algorithm.HMAC256("abc123" + redisValueMap.get("token"));
        var verifier = JWT.require(hmacAlgorithm).build();

        verifier.verify(credentials.getToken());

        var roles = (Map<String, List<Map<String, String>>>) redisValueMap.get("roles");

        if (!roles.containsKey(credentials.getAppKey())) {
            throw new RuntimeException("Erro");
        }

        var appRoles = roles.get(credentials.getAppKey());
        var appPermisions = appRoles.stream().map(e -> new Permission(e.get("role"), null)).collect(Collectors.toSet());

        this.repository.getCountCommands().setex(redisKey, Duration.ofMinutes(1440L).toSeconds(),  redisValue);

        return new TokenSimpleValidation(userIdentifier, "user", "access", appPermisions, LoginType.IDENTIFIER_AND_PASSWORD);
    }
}

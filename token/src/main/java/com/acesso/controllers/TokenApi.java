package com.acesso.controllers;

import com.acesso.models.*;
import com.acesso.repository.RedisRepository;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Path("/token")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TokenApi {

    private final ObjectMapper mapper;

    @Inject
    RedisRepository repository;

    public TokenApi(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @Path("/validate")
    @POST
    public TokenSimpleValidation validate(TokenSessionCredentials credentials) {
        var decodedJwt = JWT.decode(credentials.getToken());

        System.out.println("TOken aqui -> " + decodedJwt.getPayload());

        var appServerKey = decodedJwt.getClaim("appServerKey").asString();
        var userIdentifier = decodedJwt.getClaim("identifier").asString();

        if (!Objects.equals(appServerKey, credentials.getAppKey())) throw new RuntimeException("Erro");

        var tokenIdentifier = new TokenIdentifier(userIdentifier, "grant", 1L, "_");

        String redisKey = tokenIdentifier.toRedisKey();

        System.out.println("Key redus -> " + redisKey);

        var redisValue = Optional.ofNullable(repository.getCountCommands().get(redisKey)).orElseThrow(() -> new RuntimeException("Caiu aqui"));

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

        this.repository.getCountCommands().setex(redisKey, Duration.ofMinutes(1440L).toSeconds(), redisValue);

        return new TokenSimpleValidation(userIdentifier, "user", "access", appPermisions, LoginType.IDENTIFIER_AND_PASSWORD);
    }

}

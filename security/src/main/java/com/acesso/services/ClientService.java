package com.acesso.services;

import com.acesso.externalservices.TokenService;
import com.acesso.externalservices.models.LoginType;
import com.acesso.externalservices.models.Permission;
import com.acesso.externalservices.models.TokenSessionCredentials;
import com.acesso.models.SessionCredentials;
import com.acesso.models.SimpleAuthenticationResponse;
import com.acesso.models.UserInfo;
import com.acesso.repositories.ClientRepository;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Set;
import java.util.stream.Collectors;

@ApplicationScoped
public class ClientService {

    @Inject
    ClientRepository clientRepository;

    @Inject
    @RestClient
    TokenService tokenService;
    public SimpleAuthenticationResponse validate(SessionCredentials sessionCredentials) {

        var tokenResponse = tokenService.validate(new TokenSessionCredentials(sessionCredentials.getToken(), sessionCredentials.getAppServerKey()));

        var userSimplified = clientRepository.getSimplifiedUserByUserId(tokenResponse.identifier());

        var userInfo = new UserInfo(userSimplified.getUserId(), userSimplified.getName(), userSimplified.getEmail(), userSimplified.getImage(), userSimplified.getUserAccountInfo());

        Set<String> roles = tokenResponse.roles().stream().map(Permission::role).collect(Collectors.toSet());

        return new SimpleAuthenticationResponse(userInfo, sessionCredentials.getToken(), tokenResponse.tokenType(), roles, "", "BRONZE", tokenResponse.loginType().name());
    }

}

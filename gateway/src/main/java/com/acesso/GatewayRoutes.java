package com.acesso;

import com.acesso.externalservices.security.SecurityService;
import com.acesso.externalservices.security.models.SessionCredentials;
import com.acesso.externalservices.token.TokenService;
import com.acesso.externalservices.token.models.Permission;
import com.acesso.externalservices.token.models.TokenSessionCredentials;
import com.acesso.models.Roles;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Set;
import java.util.stream.Collectors;

@Path("/api")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GatewayRoutes  {

    @Inject
    @RestClient
    SecurityService securityService;

    @Inject
    @RestClient
    TokenService tokenService;

    @POST
    @Path("/clients/validate")
    public Response validate(@HeaderParam("Authorization") String token, @HeaderParam("Accept-Client") String appKey) {

        var simpleAuth = securityService.validate(new SessionCredentials(token, appKey));

        System.out.println(simpleAuth);

        return Response.ok(simpleAuth).build();
    }

    @GET
    public Response ping(@Context HttpHeaders headers) {
        IsAcessible(headers, Set.of(Roles.ROLE_SEGURANCA_ADM.name()));

        return Response.ok().build();
    }

    public void IsAcessible(HttpHeaders headers, Set<String> roles) {
        var simpleValidate = tokenService.validate(new TokenSessionCredentials(headers.getHeaderString("Authorization"), headers.getHeaderString("Accept-Client")));

        var tokenRoles = simpleValidate.roles().stream().map(Permission::role).collect(Collectors.toSet());

        if (!tokenRoles.containsAll(roles)) {
            throw new NotAuthorizedException("Usuário não autorizado");
        }
    }

}

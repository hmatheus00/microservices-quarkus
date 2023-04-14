package com.acesso.externalservices.token;

import com.acesso.externalservices.token.models.TokenSessionCredentials;
import com.acesso.externalservices.token.models.TokenSimpleValidation;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/token")
@RegisterRestClient
public interface TokenService {

    @POST
    @Path("/validate")
    TokenSimpleValidation validate(TokenSessionCredentials credentials);
}

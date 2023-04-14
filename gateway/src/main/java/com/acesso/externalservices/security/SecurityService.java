package com.acesso.externalservices.security;

import com.acesso.externalservices.security.models.SessionCredentials;
import com.acesso.externalservices.security.models.SimpleAuthenticationResponse;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/security")
@RegisterRestClient
public interface SecurityService {

    @POST
    @Path("/clients/validate")
    SimpleAuthenticationResponse validate(SessionCredentials credentials);


}

package com.acesso.controllers;

import com.acesso.models.SessionCredentials;
import com.acesso.models.SimpleAuthenticationResponse;
import com.acesso.services.ClientService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/security/clients")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ClientController {

    @Inject
    ClientService clientService;

    @POST
    @Path("/validate")
    public Response validate(SessionCredentials sessionCredentials) {

        SimpleAuthenticationResponse auth = clientService.validate(sessionCredentials);

        return Response.ok(auth).build();
    }

}

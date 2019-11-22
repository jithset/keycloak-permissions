package com.jitihn.service;

import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.jitihn.model.Account;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/permission-test")
@RegisterRestClient
public interface KeycloakService {

    @GET
    @Path("/users")
    @Produces(MediaType.APPLICATION_JSON)
    Set<Account> getUsers(@HeaderParam("Authorization") String token);

    @GET
    @Path("/users")
    @Produces(MediaType.APPLICATION_JSON)
    Set<Account> getUser(@HeaderParam("Authorization") String token, @QueryParam("username") String userName);

    @POST
    @Path("/users")
    @Produces(MediaType.APPLICATION_JSON)
    void addUser(@HeaderParam("Authorization") String token, Account account);
}
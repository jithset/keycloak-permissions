package com.jitihn.resource;

import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.jitihn.model.Account;
import com.jitihn.service.KeycloakService;

import org.eclipse.microprofile.rest.client.inject.RestClient;

@Produces(MediaType.APPLICATION_JSON)
@Path("/apis/keycloak")
public class KeycloakResource {

    @Inject
    @RestClient
    KeycloakService keycloakService;

    @GET
    @Path("/users")
    public Response get(@HeaderParam("Authorization") String token) {
        return Response.status(Status.OK).entity(keycloakService.getUsers(token)).build();
    }

    @GET
    @Path("/users/{username}")
    public Response getUser(@HeaderParam("Authorization") String token, @PathParam("username") String username) {
        Set<Account> accs = keycloakService.getUser(token, username);
        Account acc = accs != null && accs.size() > 0 ? accs.iterator().next() : null;
        return Response.status(Status.OK).entity(acc).build();
    }

    public Account getUserByUsername(String token, String userName) {
        Set<Account> accs = keycloakService.getUser(token, userName);
        Account acc = accs != null && accs.size() > 0 ? accs.iterator().next() : null;

        return acc;
    }

    @POST
    @Path("/users")
    public Response add(@HeaderParam("Authorization") String token, Account account) {
        System.out.println("Add user");
        System.out.println(account);
        keycloakService.addUser(token, account);
        return getUser(token, account.getUsername());
    }

}
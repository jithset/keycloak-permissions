package com.jitihn.resource;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.jitihn.model.Company;
import com.jitihn.service.CompanyService;

@Produces(MediaType.APPLICATION_JSON)
@Path("/apis/company")
public class CompanyResource {

    @Inject
    CompanyService companyService;

    @GET
    public Response get() {
        return Response.status(Status.OK).entity(companyService.getCompanies()).build();
    }

    @POST
    public Response add(Company company) {
        companyService.saveCompany(company);
        return Response.status(Status.CREATED).entity(true).build();
    }
}
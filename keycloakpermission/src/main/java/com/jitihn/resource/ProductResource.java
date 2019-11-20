package com.jitihn.resource;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.jitihn.model.Product;
import com.jitihn.service.ProductService;

@Produces(MediaType.APPLICATION_JSON)
@Path("/product")
public class ProductResource {

    @Inject
    ProductService productService;

    @GET
    public Response getProduct() {
        return Response.status(Status.OK).entity(productService.getProduct()).build();
    }

    @POST
    public Response add(Product product) {
        productService.saveProduct(product);
        return Response.status(Status.CREATED).entity(true).build();
    }
}
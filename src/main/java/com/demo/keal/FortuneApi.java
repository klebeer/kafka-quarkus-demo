package com.demo.keal;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.enterprise.context.Dependent;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author Kleber Ayala
 */
@Path("/api")
@Dependent
@RegisterRestClient
@Produces({MediaType.APPLICATION_JSON})
public interface FortuneApi {

    @GET
    @Path("/fortune")
    Fortune loadFortune();
}

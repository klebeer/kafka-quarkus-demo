package com.demo.keal;

import io.smallrye.reactive.messaging.annotations.Stream;
import org.reactivestreams.Publisher;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author Kleber Ayala
 */
@Path("/fortunes")
public class FortuneRestResource {

    @Inject
    @Stream("fortunes-stream")
    Publisher<String> fortune;


    @GET
    @Path("/stream")
    @Produces(MediaType.SERVER_SENT_EVENTS)
    public Publisher<String> stream() {
        return fortune;
    }
}
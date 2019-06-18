package com.demo.keal;

import io.smallrye.reactive.messaging.annotations.Broadcast;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import javax.enterprise.context.ApplicationScoped;

/**
 * @author Kleber Ayala
 */

@ApplicationScoped
public class FortuneConverter {


    @Incoming("fortunes")
    @Outgoing("fortunes-stream")
    @Broadcast
    public String process(String fortune) {
        return fortune.toUpperCase();
    }

}

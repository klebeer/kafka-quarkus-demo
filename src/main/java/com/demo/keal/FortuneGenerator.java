package com.demo.keal;

import io.reactivex.Flowable;
import org.eclipse.microprofile.reactive.messaging.Outgoing;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.concurrent.TimeUnit;

/**
 * @author Kleber Ayala
 */
@ApplicationScoped
public class FortuneGenerator {

    @Inject
    @RestClient
    private FortuneApi fortuneApi;

    @Outgoing("topic-fortune")
    public Flowable<String> generate() {

        return Flowable.interval(5, TimeUnit.SECONDS)
                .map(tick -> fortune());
    }

    private String fortune() {
        Fortune fortune = fortuneApi.loadFortune();
        return fortune.getFortune();
    }

}

package org.acme;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MyService {

    @RestClient
    MyRestClient client;

    void aMethod() {
        client.hello4()
                .chain(i -> client.hello())
                .chain(i -> client.hello2())
                .chain(i -> client.hello3(new Entity2()))
                .chain(i -> client.hello4())
                .chain(i -> client.hello5(new Entity4()))
                .chain(i -> client.hello6(new Entity3()))
                .subscribe().with(i -> {});
    }

}

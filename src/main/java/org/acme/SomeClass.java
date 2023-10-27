package org.acme;

import io.quarkus.runtime.Startup;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class SomeClass {

    @Inject
    MyService service;

    @Startup
    void myScheduledMethod() {
        service.aMethod();
    }

}

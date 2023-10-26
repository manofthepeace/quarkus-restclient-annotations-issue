package org.acme;

import static io.quarkus.scheduler.Scheduled.ConcurrentExecution.SKIP;

import io.quarkus.arc.WithCaching;
import io.quarkus.scheduler.Scheduled;
import jakarta.enterprise.inject.Instance;
import jakarta.inject.Inject;

public class SomeClass {

    @Inject
    @WithCaching
    Instance<MyService> service;

    @Scheduled(every = "5s", identity = "identity", concurrentExecution = SKIP)
    void myScheduledMethod() {

        if (service.isResolvable()) {
            service.get().aMethod();
        }
    }

}

package org.acme;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/")
public class GreetingResource {

    @RestClient
    MyRestClient annotatedClient;

    @RestClient
    MyRestClient2 contextResolverClient;

    @GET
    @Path("/hello")
    public Entity hello() {
        return new Entity("hello");
    }

    @GET
    @Path("/test")
    public Entity testclient() {
        return annotatedClient.hello();
    }

    @GET
    @Path("/test2")
    public Entity testclient2() {
        return contextResolverClient.hello();
    }
}

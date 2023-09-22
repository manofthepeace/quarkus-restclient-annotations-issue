package org.acme;

import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.logging.Logger;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@RegisterRestClient(baseUri = "http://localhost:8080")
@RegisterProvider(MyWriter.class)
public interface MyRestClient2 {

    Logger LOG = Logger.getLogger(MyRestClient2.class);

    @GET
    @Path("/hello")
    public Entity hello();

}

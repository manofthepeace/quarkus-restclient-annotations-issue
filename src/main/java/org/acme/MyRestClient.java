package org.acme;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.logging.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.quarkus.rest.client.reactive.ClientExceptionMapper;
import io.quarkus.rest.client.reactive.jackson.ClientObjectMapper;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@RegisterRestClient(baseUri = "http://httpbin.org")
public interface MyRestClient {

    Logger LOG = Logger.getLogger(MyRestClient.class);

    @GET
    @Path("/get")
    public Uni<Entity> hello();

    @GET
    @Path("/get")
    public Uni<Entity> hello2();

    @POST
    @Path("/post")
    public Uni<Entity2> hello3(Entity2 entity);

    @POST
    @Path("/post")
    public Uni<Entity3> hello4();

    @POST
    @Path("/post")
    public Uni<Entity2> hello5(Entity4 entity);

    @POST
    @Path("/post")
    public Uni<Entity4> hello6(Entity3 entity);

    @ClientExceptionMapper
    static RuntimeException toException(Response response) {
        return null;
    }

    @ClientObjectMapper
    static ObjectMapper objectMapper(ObjectMapper defaultObjectMapper) {
        ObjectMapper mapper = defaultObjectMapper.copy();
        LOG.infof("Copied mapper [%s] from original [%s]", mapper.toString(), defaultObjectMapper.toString());
        return mapper;
    }

}

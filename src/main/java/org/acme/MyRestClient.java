package org.acme;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.logging.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.quarkus.rest.client.reactive.ClientExceptionMapper;
import io.quarkus.rest.client.reactive.jackson.ClientObjectMapper;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@RegisterRestClient(baseUri = "http://localhost:8080")
public interface MyRestClient {

    Logger LOG = Logger.getLogger(MyRestClient.class);

    @GET
    @Path("/hello")
    public Entity hello();

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

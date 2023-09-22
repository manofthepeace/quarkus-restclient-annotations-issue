package org.acme;

import org.jboss.logging.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.ws.rs.ext.ContextResolver;

public class MyWriter implements ContextResolver<ObjectMapper> {

    Logger LOG = Logger.getLogger(MyRestClient2.class);

    private final ObjectMapper myMapper;

    MyWriter(ObjectMapper mapper) {
        this.myMapper = mapper.copy();
        LOG.infof("Copied mapper [%s] from original [%s]", myMapper.toString(), mapper.toString());
    }

    @Override
    public ObjectMapper getContext(Class<?> type) {
        LOG.infof("Using mapper [%s] from context resolver", myMapper.toString());
        return myMapper;
    }

}
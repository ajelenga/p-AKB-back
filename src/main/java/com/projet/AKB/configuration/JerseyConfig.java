package com.projet.AKB.configuration;

import com.projet.AKB.check.CheckController;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import javax.ws.rs.ApplicationPath;

@Configuration
@ApplicationPath("/api/v1")
public class JerseyConfig  extends ResourceConfig {

    public JerseyConfig() {
        register(CheckController.class);
    }
}

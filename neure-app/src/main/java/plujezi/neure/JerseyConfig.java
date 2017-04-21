package plujezi.neure;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.inject.Singleton;
import javax.ws.rs.ApplicationPath;

@ApplicationPath("neure/api")
@Configuration
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        packages("plujezi.neure.endpoint");
    }
}

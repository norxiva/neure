package plujezi.neure;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.inject.Singleton;
import javax.ws.rs.ApplicationPath;
import java.util.Calendar;
import java.util.TimeZone;

@ApplicationPath("neure/api")
@Configuration
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);
        packages("plujezi.neure.endpoint");
    }


    public static void main(String[] args){
        Calendar cal = Calendar.getInstance();
        TimeZone timeZone = cal.getTimeZone();
        System.out.println(timeZone.getID());
        System.out.println(timeZone.toString());
        System.out.println(timeZone.getDisplayName());
    }
}

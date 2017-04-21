package plujezi.neure.endpoint;

import org.springframework.stereotype.Component;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("heartbeat")
public class HeartbeatEndpoint {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response hi(){
        return Response.ok().entity("2").build();
    }
}

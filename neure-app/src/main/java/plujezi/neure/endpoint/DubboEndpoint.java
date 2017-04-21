package plujezi.neure.endpoint;

import org.springframework.stereotype.Component;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("dubbo")
@Component
public class DubboEndpoint {

    @POST

    public Response create(){
        return Response.ok().entity("").build();
    }
}

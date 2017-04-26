package plujezi.neure.endpoint;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import plujezi.neure.util.JacksonUtils;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Path("ribbon")
@Component
public class RibbonEndpoint {

    private RestTemplate restTemplate;

    private LoadBalancerClient loadBalancerClient;

    @Autowired
    public RibbonEndpoint(LoadBalancerClient loadBalancerClient,
                          RestTemplate restTemplate){
        this.loadBalancerClient = loadBalancerClient;
        this.restTemplate = restTemplate;
    }

    @GET
    @Path("request")
    public Response request(@QueryParam("name") String name){

//        ServiceInstance serviceInstance =  loadBalancerClient.choose("neureapp");
//        URI uri = serviceInstance.getUri();
//        log.info("uri:{}", uri);

        @SuppressWarnings("unchecked")
        Map<String, Object> map = restTemplate.getForEntity("http://NEUREAPP/neure/api/dubbo/13", HashMap.class).getBody();
        log.info("test response map:{}", map);

        return Response.ok().entity(JacksonUtils.writeValueAsString("{}")).build();
    }
}

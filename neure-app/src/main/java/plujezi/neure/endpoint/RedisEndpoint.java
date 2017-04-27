package plujezi.neure.endpoint;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Slf4j
@Path("redis")
@Component
public class RedisEndpoint {

    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    public RedisEndpoint(StringRedisTemplate stringRedisTemplate){
        this.stringRedisTemplate = stringRedisTemplate;
    }

    @GET
    @Path("get")
    public Response get(){
        String value = stringRedisTemplate.opsForValue().get("quarkloan-api-esb-cc-dev:LaInterfaceType:QUARKLOAN-API-00024");
        return Response.ok().entity(value).build();
    }
}

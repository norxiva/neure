package plujezi.neure.endpoint;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import plujezi.neure.bean.TestMongoModel;
import plujezi.neure.repository.TestMongoModelRepository;
import plujezi.neure.util.JacksonUtils;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.util.List;

@Slf4j
@Path("mongo")
@Component
public class MongoEndpoint {


    private TestMongoModelRepository testMongoModelRepository;

    @Autowired
    public MongoEndpoint(TestMongoModelRepository testMongoModelRepository){
        this.testMongoModelRepository = testMongoModelRepository;
    }

    @GET
    @Path("get")
    public Response get(){
        List<TestMongoModel> list = testMongoModelRepository.findAll();
        return Response.ok().entity(JacksonUtils.writeValueAsString(list)).build();
    }
}

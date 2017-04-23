package plujezi.neure.endpoint;

import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Component;
import plujezi.neure.api.DubboService;
import plujezi.neure.bean.TestModel;
import plujezi.neure.server.api.TestService;
import plujezi.neure.server.api.bean.Model;
import plujezi.neure.util.JacksonUtils;

import javax.validation.constraints.NotNull;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Slf4j
@Path("dubbo")
@Component
public class DubboEndpoint {

    private TestService testService;

    private DubboService dubboService;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    public DubboEndpoint(TestService testService,
                         DubboService dubboService
                         ){
        this.testService = testService;
        this.dubboService = dubboService;
    }

    @POST
    public Response create(@QueryParam("id") @NotNull Integer id){
        TestModel testModel = new TestModel();
        testModel.setId(id);
        testModel.setName("henry");
        testModel.setCreateTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()));
        testModel.setPassword("password");

        log.info("dubbo endpoint model: {}", testModel.toString());

        Model model = new Model();
        model.setFullName("marry");
        model.setAge(18);
//        model.setBirthday(LocalDateTime.now());
//        testService.test("hello");
        dubboService.create(testModel);
//        testService.testModel(model);
        return Response.ok().entity(JacksonUtils.writeValueAsString(testModel)).build();
    }


}

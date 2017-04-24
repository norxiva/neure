package plujezi.neure.endpoint;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
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

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Slf4j
@Path("test")
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
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(@Valid @NotNull TestModel testModel){
        log.info("creating test model: {}", testModel.toString());
        testModel.setCreateTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()));

        dubboService.create(testModel);
        return Response.ok().entity(JacksonUtils.writeValueAsString(testModel)).build();
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") @NotNull Integer id){
        log.info("deleting test model [id:{}]", id);
        dubboService.delete(id);
        Map<String, Object> respMap = Maps.newHashMap();
        respMap.put("success", true);
        return Response.ok().entity(JacksonUtils.writeValueAsString(respMap)).build();
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@Valid @NotNull TestModel testModel, @PathParam("id") @NotNull Integer id){
        log.info("updating test model: {}", testModel.toString());

        dubboService.update(testModel);
        return Response.ok().entity(JacksonUtils.writeValueAsString(testModel)).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findOne(@PathParam("id") @NotNull Integer id){
        log.info("finding test model [id:{}]", id);
        TestModel testModel = dubboService.findOne(id);
        return Response.ok().entity(JacksonUtils.writeValueAsString(testModel)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findWithPage(@QueryParam("pageNum") @NotNull Integer pageNum,
                                 @QueryParam("pageSize") @NotNull Integer pageSize){
        TestModel testModel = new TestModel();
        testModel.setPageNum(pageNum);
        testModel.setPageSize(pageSize);
        log.info("finding test model with page: {}", testModel.toString());
        PageInfo<TestModel> pageInfo = dubboService.findList(testModel);
        return Response.ok().entity(JacksonUtils.writeValueAsString(pageInfo)).build();
    }


}

package plujezi.neure.groovy;


import com.google.common.collect.Maps;
import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;
import groovy.lang.GroovyShell;
import groovy.lang.Script;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import plujezi.neure.groovy.bean.Request;
import plujezi.neure.groovy.bean.Response;
import plujezi.neure.groovy.shell.Bean;
import plujezi.neure.groovy.shell.RespBean;

import java.io.File;
import java.io.IOException;
import java.util.Map;

@Slf4j
@SpringBootApplication
@RestController
public class GroovyApp {

    @RequestMapping("/groovy")
    public @ResponseBody  Map<String,Object> groovy(@RequestBody String json){
        Map<String,Object> resp = Maps.newHashMap();
        resp.put("success", true);

        testGroovy5();
        return resp;
    }

    private void testGroovy1(){
        GroovyClassLoader groovyClassLoader = new GroovyClassLoader();
        try {
            Class clz = groovyClassLoader.parseClass(new File("C:\\Users\\jiashengxue\\IdeaProjects\\neure\\neure-groovy\\src\\main\\java\\plujezi\\neure\\groovy\\shell\\TestGroovy.groovy"));
            GroovyObject groovyObject = (GroovyObject)clz.newInstance();
            groovyObject.invokeMethod("test", null);
        } catch (IOException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private void testGroovy2(){
        GroovyShell groovyShell = new GroovyShell();
        try {
            Script script = groovyShell.parse(new File("C:\\Users\\jiashengxue\\IdeaProjects\\neure\\neure-groovy\\src\\main\\java\\plujezi\\neure\\groovy\\shell\\TestScript.groovy"));
            script.invokeMethod("run", new Object[]{});

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void testGroovy3(){
        GroovyClassLoader groovyClassLoader = new GroovyClassLoader();
        try {
            Class clz = groovyClassLoader.parseClass(new File("C:\\Users\\jiashengxue\\IdeaProjects\\neure\\neure-groovy\\src\\main\\java\\plujezi\\neure\\groovy\\shell\\TestScript.groovy"));
            Script groovyObject = (Script)clz.newInstance();
            groovyObject.invokeMethod("run", null);
        } catch (IOException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private void testGroovy4(){
        GroovyClassLoader groovyClassLoader = new GroovyClassLoader();
        try {
            Class clz = groovyClassLoader.parseClass(new File("C:\\Users\\jiashengxue\\IdeaProjects\\neure\\neure-groovy\\src\\main\\java\\plujezi\\neure\\groovy\\shell\\TestGroovy.groovy"));
            GroovyObject groovyObject = (GroovyObject)clz.newInstance();
            Bean bean = new Bean();
            bean.setName("haha");
            bean.setPassword("pwd");
            RespBean respBean = (RespBean)groovyObject.invokeMethod("test2", bean);
            log.info("resp: {}", respBean.getSuccess());
        } catch (IOException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private void testGroovy5(){
        GroovyClassLoader groovyClassLoader = new GroovyClassLoader();
        try {
            Class clz = groovyClassLoader.parseClass(new File("C:\\Users\\jiashengxue\\IdeaProjects\\neure\\neure-groovy\\src\\main\\java\\plujezi\\neure\\groovy\\shell\\TestGroovy.groovy"));
            GroovyObject groovyObject = (GroovyObject)clz.newInstance();
            Request request = new Request();
            request.setEmail("plujezi@qq.com");
            request.setStatus("0");
            Response response = (Response)groovyObject.invokeMethod("test3", request);
            log.info("resp: {}", response.toString());
        } catch (IOException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(GroovyApp.class, args);
    }

}


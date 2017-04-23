package plujezi.neure.server;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(value = {"classpath:spring/dubbo.xml"})
public class ServerApp extends SpringBootServletInitializer {

    public static void main(String[] args){
        new ServerApp().configure(new SpringApplicationBuilder(ServerApp.class)).run(args);
    }
}

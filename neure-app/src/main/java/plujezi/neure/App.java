package plujezi.neure;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(value = {"classpath:dubbo.xml"})
public class App extends SpringBootServletInitializer {

    public static void main(String[] args){
        new App().configure(new SpringApplicationBuilder(App.class)).run(args);
    }
}

package plujezi.neure;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableDiscoveryClient
@EnableTransactionManagement
@ImportResource(value = {"classpath:dubbo.xml"})
public class App extends SpringBootServletInitializer {

    public static void main(String[] args){
        new App().configure(new SpringApplicationBuilder(App.class)).run(args);
    }
}

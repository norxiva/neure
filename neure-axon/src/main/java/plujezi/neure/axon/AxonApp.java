package plujezi.neure.axon;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class AxonApp {

    public static void main(String[] args){
        SpringApplication.run(AxonApp.class, args);
    }


}

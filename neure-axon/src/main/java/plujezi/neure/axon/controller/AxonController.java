package plujezi.neure.axon.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/axon")
public class AxonController {

    @RequestMapping("/test1")
    public @ResponseBody String test1(){
        return "{}";
    }
}

package plujezi.neure.server.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import plujezi.neure.server.api.TestService;
import plujezi.neure.server.api.bean.Model;

@Slf4j
@Service
public class TestServiceImpl implements TestService {
    @Override
    public String test(String name) {

        log.info("Hi " + name);
        return "Hi " + name;
    }

    @Override
    public String testModel(Model model) {
        log.info("test model: {}", model.toString());
        return "success";
    }


}

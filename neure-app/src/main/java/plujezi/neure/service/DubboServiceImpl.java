package plujezi.neure.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import plujezi.neure.api.DubboService;
import plujezi.neure.bean.TestModel;
import plujezi.neure.mapper.TestModelMapper;

import javax.inject.Inject;

@Slf4j
@Service
public class DubboServiceImpl implements DubboService{

    private TestModelMapper testModelMapper;

    @Inject
    public DubboServiceImpl(TestModelMapper testModelMapper){
        this.testModelMapper = testModelMapper;
    }

    public void create(TestModel testModel){
        log.info("dubbo service create model: {}", testModel.toString());
        int count = testModelMapper.insert(testModel);
        log.info("insert one record: {}", count);
    }

}

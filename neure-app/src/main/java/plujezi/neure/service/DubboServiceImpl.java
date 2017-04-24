package plujezi.neure.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageRowBounds;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import plujezi.neure.api.DubboService;
import plujezi.neure.bean.TestModel;
import plujezi.neure.mapper.TestModelMapper;

import javax.inject.Inject;
import java.util.List;

@Slf4j
@Service
public class DubboServiceImpl implements DubboService{

    private TestModelMapper testModelMapper;

    @Autowired
    public DubboServiceImpl(TestModelMapper testModelMapper){
        this.testModelMapper = testModelMapper;
    }

    public void create(TestModel testModel){
        log.info("dubbo service create model: {}", testModel.toString());
        int count = testModelMapper.insert(testModel);
        log.info("insert one record: {}", count);
    }

    @Override
    public void delete(Integer id) {
        log.info("dubbo service delete model [id:{}]", id);
        int count = testModelMapper.deleteByPrimaryKey(id);
        log.info("delete one record: {}", count);
    }

    @Override
    public void update(TestModel testModel) {
        log.info("dubbo service update model: {}", testModel.toString());
        int count = testModelMapper.updateByPrimaryKey(testModel);
        log.info("update one record: {}", count);
    }

    @Override
    public TestModel findOne(Integer id) {
        log.info("dubbo service find model [id:{}]", id);
        return testModelMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageInfo<TestModel> findList(TestModel testModel) {
        log.info("dubbo service find model list with page: {}", testModel.toString());
        return PageHelper.startPage(testModel.getPageNum(), testModel.getPageSize())
                .doSelectPageInfo(()-> testModelMapper.selectWithPage(testModel));
    }

}

package plujezi.neure.api;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import plujezi.neure.bean.TestModel;

import java.util.List;

public interface DubboService {
    void create(TestModel testModel);

    void delete(Integer id);

    void update(TestModel testModel);

    TestModel findOne(Integer id);

    PageInfo<TestModel> findList(TestModel testModel);
}

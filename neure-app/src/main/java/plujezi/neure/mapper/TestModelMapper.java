package plujezi.neure.mapper;

import java.util.List;
import plujezi.neure.bean.TestModel;

public interface TestModelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TestModel record);

    TestModel selectByPrimaryKey(Integer id);

    List<TestModel> selectAll();

    int updateByPrimaryKey(TestModel record);
}
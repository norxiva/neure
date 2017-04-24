package plujezi.neure.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import plujezi.neure.bean.TestModel;

@Repository
@Mapper
public interface TestModelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TestModel record);

    TestModel selectByPrimaryKey(Integer id);

    List<TestModel> selectAll();

    int updateByPrimaryKey(TestModel record);

    List<TestModel> selectWithPage(TestModel testModel);
}
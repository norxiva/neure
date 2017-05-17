package plujezi.neure;


import com.alibaba.dubbo.common.serialize.support.SerializationOptimizer;
import plujezi.neure.bean.TestModel;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class SerializationOptimizerImpl implements SerializationOptimizer {

    @Override
    public Collection<Class> getSerializableClasses() {
        List<Class> classes = new LinkedList<>();
        classes.add(TestModel.class);
        return classes;
    }
}

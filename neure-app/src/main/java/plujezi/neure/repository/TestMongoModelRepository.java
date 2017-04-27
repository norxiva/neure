package plujezi.neure.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import plujezi.neure.bean.TestMongoModel;

public interface TestMongoModelRepository extends MongoRepository<TestMongoModel, String> {
}

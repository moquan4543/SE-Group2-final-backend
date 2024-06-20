package edu.ntcu;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import edu.ntcu.model.User;
public interface UserRepository extends MongoRepository<User,ObjectId> {
}

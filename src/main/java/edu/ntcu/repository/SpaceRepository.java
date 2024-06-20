package edu.ntcu.repository;

import edu.ntcu.model.Space;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SpaceRepository extends MongoRepository<Space, ObjectId> {
}

package com.kingkonsole.accountconfig.repositories;

import com.kingkonsole.accountconfig.models.Configs;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ConfigsRepository extends MongoRepository<Configs, String> {
    Configs findBy_id(ObjectId _id);
}

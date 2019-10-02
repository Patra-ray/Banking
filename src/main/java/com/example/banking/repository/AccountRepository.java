package com.example.banking.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.banking.model.Account;

//https://docs.spring.io/spring-data/mongodb/docs/current/api/org/springframework/data/mongodb/repository/MongoRepository.html
public interface AccountRepository extends MongoRepository<Account, String> {
      public Account findBy_Id(ObjectId _id);

}

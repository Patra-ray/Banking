package com.example.banking.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.banking.model.Transaction;

//https://docs.spring.io/spring-data/mongodb/docs/current/api/org/springframework/data/mongodb/repository/MongoRepository.html

public interface TransactionRepository extends MongoRepository<Transaction, String> {
    public Transaction findBy_Id(ObjectId _id);

}

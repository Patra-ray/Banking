package com.example.banking.controller;

import com.example.banking.model.Transaction;
import com.example.banking.repository.TransactionRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController //java REST api
@RequestMapping("api/v1/transactions") // routing  path and version we're going to use
public class TransactionController {

    @Autowired
    private TransactionRepository transactionRepository;

    //List all transactions
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Transaction> getTransactions(){
        return transactionRepository.findAll();
    }

    //List the transaction from transactions
    @RequestMapping(value = "/{_id}", method = RequestMethod.GET)
    public Transaction getTransaction(@PathVariable ObjectId _id) {
        return transactionRepository.findBy_Id(_id);
    }

    //create transaction
    //PK: TODO need for security, to prevent _id from allowing _id to be set on creation
    @RequestMapping(method = RequestMethod.POST)
    public Transaction create(@RequestBody Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    //update transaction
    @RequestMapping(value = "/{_id}", method = RequestMethod.PUT)
    public Transaction update(@PathVariable ObjectId _id, @RequestBody Transaction transaction) {
        transaction.set_Id(_id);
        transactionRepository.save(transaction);
        return transaction;
    }

    //delete transaction
    @RequestMapping(value = "/{_id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable ObjectId _id) {
        transactionRepository.delete(transactionRepository.findBy_Id(_id));

    }



}

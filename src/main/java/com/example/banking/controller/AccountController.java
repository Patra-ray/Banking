package com.example.banking.controller;

import com.example.banking.model.Account;
import com.example.banking.repository.AccountRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //java REST api
@RequestMapping("api/v1/accounts") // routing  path and version we're going to use
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;

    //List all accounts
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Account> getAccounts() {
        return accountRepository.findAll();
    }

    //    @RequestMapping(value = "account/{id}", method = RequestMethod.GET)
    //    public Account get(@PathVariable Long id) {
    //        return AccountStub.get(id);
    //    }

    //List the account from accounts
    @RequestMapping(value = "/{_id}", method = RequestMethod.GET)
    public Account getAccount(@PathVariable ObjectId _id) {
        return accountRepository.findBy_Id(_id);
    }

    //create account
    //PK: TODO need for security, to prevent _id from allowing _id to be set on creation
    @RequestMapping(method = RequestMethod.POST)
    public Account create(@RequestBody Account account) {
        return accountRepository.save(account);
    }

    //update account
    @RequestMapping(value = "/{_id}", method = RequestMethod.PUT)
    public Account update(@PathVariable ObjectId _id, @RequestBody Account account) {
        account.set_Id(_id);
        accountRepository.save(account);
        return account;
    }

    //delete account
    @RequestMapping(value = "/{_id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable ObjectId _id) {
        accountRepository.delete(accountRepository.findBy_Id(_id));

    }

}

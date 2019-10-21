package com.example.banking.controller;

import com.example.banking.model.AccountUser;
import com.example.banking.repository.AccountUserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //java REST api
@RequestMapping("api/v1/account-users") // routing  path and version we're going to use
public class AccountUserController {

    @Autowired
    private AccountUserRepository userRepository;

    //List all users
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<AccountUser> getUsers() {
        return userRepository.findAll();
    }

    //List the user from user
    @RequestMapping(value = "/{_id}", method = RequestMethod.GET)
    public AccountUser getUser(@PathVariable ObjectId _id) {
        return userRepository.findBy_Id(_id);
    }

    //create user
    @RequestMapping(method = RequestMethod.POST)
    public AccountUser create(@RequestBody AccountUser user) {
        return userRepository.save(user);
    }

    //update user
    @RequestMapping(value = "/{_id}", method = RequestMethod.PUT)
    public AccountUser update(@PathVariable ObjectId _id, @RequestBody AccountUser user) {
        user.set_Id(_id);
        userRepository.save(user);
        return user;
    }
    //delete user
    @RequestMapping(value = "/{_id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable ObjectId _id) {
        userRepository.delete(userRepository.findBy_Id(_id));

    }

}

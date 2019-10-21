package com.example.banking.controller;

import com.example.banking.model.Branch;
import com.example.banking.repository.BranchRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //java REST api
@RequestMapping("api/v1/branches") // routing  path and version we're going to use
public class BranchController {

    @Autowired
    private BranchRepository branchRepository;

    //List all branches
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Branch> getBranches() {
        return branchRepository.findAll();
    }

    //List the branch from branches
    @RequestMapping(value = "/{_id}", method = RequestMethod.GET)
    public Branch getBranch(@PathVariable ObjectId _id) {
        return branchRepository.findBy_Id(_id);
    }

    //create branch
    //PK: TODO need for security, to prevent _id from allowing _id to be set on creation
    @RequestMapping(method = RequestMethod.POST)
    public Branch create(@RequestBody Branch branch) {
        return branchRepository.save(branch);
    }

    //update branch
    @RequestMapping(value = "/{_id}", method = RequestMethod.PUT)
    public Branch update(@PathVariable ObjectId _id, @RequestBody Branch branch) {
        branch.set_Id(_id);
        branchRepository.save(branch);
        return branch;
    }
}

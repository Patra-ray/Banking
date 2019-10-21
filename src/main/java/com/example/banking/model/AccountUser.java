package com.example.banking.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User {

    @Id
    private ObjectId _Id;
    private String name;
    private String password;

    public User(ObjectId _Id, String name, String password) {
        this._Id = _Id;
        this.name = name;
        this.password = password;
    }

    public String get_Id() {
        return _Id.toHexString();
    }

    public void set_Id(ObjectId _Id) {
        this._Id = _Id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                ", name='" + name + '\'' +
                ", password="  + "???" +
                '}';
    }
}
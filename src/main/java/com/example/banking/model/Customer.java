package com.example.banking.model;

public class Customer {
    private String firstName;
    private String secondName;
    private int dob;
    private String password;    //change to a better type

    public Customer(String firstName, String secondName, int dob) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.dob = dob;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public int getDob() {
        return dob;
    }

    public void setDob(int dob) {
        this.dob = dob;
    }
}

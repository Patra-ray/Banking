package com.example.banking.model;

public class Branch {
    private String branchName = "PKBank";
    private String sortCode;
    private String address;

    public Branch(String branchName, String sortCode, String address) {
        this.branchName = branchName;
        this.sortCode = sortCode;
        this.address = address;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getSortCode() {
        return sortCode;
    }

    public void setSortCode(String sortCode) {
        this.sortCode = sortCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

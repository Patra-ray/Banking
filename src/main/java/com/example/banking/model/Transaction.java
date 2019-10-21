package com.example.banking.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.annotation.Generated;


// @Document used to signify the the Account Class represents a mongo document
@Document
public class Transaction {

    //@Id the key for the mongo document, value set by mongo
    @Id
    private ObjectId _Id;
    private long transId;
    private String transactionType;
    private float amount;

    public Transaction(ObjectId _Id, long transId, String transactionType, float amount) {
        this._Id = _Id;
        this.transId = transId;
        this.transactionType = transactionType;
        this.amount = amount;
    }

    public ObjectId get_Id() {
        return _Id;
    }

    public void set_Id(ObjectId _Id) {
        this._Id = _Id;
    }

    public long getTransId() {
        return transId;
    }

    public void setTransId(long transId) {
        this.transId = transId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                ", transId=" + transId +
                ", transactionType='" + transactionType + '\'' +
                ", amount=" + amount +
                '}';
    }


    //debit()
    //takes an account and takes an amount away from the balance - if overdrawn charge a fee
    public void doTransaction(Account theAccount, Transaction aTransaction) {

        String msgStr = null;
        float amount = aTransaction.amount;

        switch (aTransaction.transactionType) {
            case  "debit":
                if (theAccount.getBalance() >= amount) {
                    // set up debit string
                    theAccount.setBalance(theAccount.getBalance() - amount);
                }
                else {
                    msgStr = "Insufficient funds: " + theAccount.toString();
                }
                break;
            case "credit":
                theAccount.setBalance(theAccount.getBalance()+ amount);
                break;
        }

    }

}
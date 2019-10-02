/*
package com.example.banking.controller;

import com.example.banking.model.Account;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountStub {
    private static Map<Long, Account> accountsm = new HashMap<Long, Account>();
    private static Long idIndex = 3L;

    //populate initial wrecks
    static {
        Account a = new Account(1L, "acc1", 1994667);
        accountsm.put(1L, a);
        Account b = new Account(2L, "acc2", 80412138);
        accountsm.put(2L, b);
        Account c = new Account(3L, "acc3", 50441244);
        accountsm.put(3L, c);
    }

    public static List<Account> list() {
        return new ArrayList<Account>(accountsm.values());
    }

    public static Account create(Account acc) {
        idIndex += idIndex;
        acc.setAccountId(idIndex);
        accountsm.put(idIndex, acc);
        return acc;
    }

    public static Account get(Long id) {
        return accountsm.get(id);
    }

    public static Account update(Long id, Account acc) {
        accountsm.put(id, acc);
        return acc;
    }

    public static Account delete(Long id) {
        return accountsm.remove(id);
    }
}
*/

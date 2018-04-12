package com.sda.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankDatabase {
    private Map<BankUser, List<BankAccount>> database;

    public BankDatabase() {
        this.database = new HashMap<>();
    }

    public int numOfUsers() {
        return database.size();
    }

    public boolean addBankUser(BankUser user) {
        if (database.containsKey(user)) {
            return false;
        } else {
            database.put(user, new ArrayList<BankAccount>());
            return true;
        }

    }

    public List<BankAccount> getAccountsOf(BankUser bankUser) {
        return database.get(bankUser);
    }

    public boolean containsUser(BankUser user) {
        return database.keySet().contains(user);
    }

    public boolean createAccountForUser(BankUser user, BankAccount account) {
        return createAccountForUser(user, account.getId());
    }

    public boolean createAccountForUser(BankUser user, String accountName) {
        if (!database.containsKey(user)) {
            return false;
        } else {
            if (findAccoundDuplicate(user, accountName)) {
                return false;
            }
            database.get(user).add(new BankAccount(accountName));
            return true;
        }
    }

    boolean findAccoundDuplicate(BankUser user, String accountName) {
        for (BankAccount account : database.get(user)) {
            if (account.getId().toString().equals(accountName)) {
                return false;
            }
        }
        return true;
    }

    public void addAccount(BankUser user, BankAccount account) {
        database.get(user).add(account);
    }

    public int numberOfAccounts() {
        return database.entrySet()
                .stream()
                .mapToInt(e -> e.getValue()
                        .size()).sum();
    }


    public BankAccount getAccountWithId(String s) {
        return new BankAccount(s);
    }
    public void deposit(BankUser accountName, int x) {
        database.get(accountName).get(0).setAmmount(x);
        }
}
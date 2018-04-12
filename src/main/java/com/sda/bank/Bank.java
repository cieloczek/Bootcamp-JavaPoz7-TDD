package com.sda.bank;

import java.util.List;

public class Bank {
    private BankDatabase bankDatabase;

    public Bank(BankDatabase bankDatabase) {
        this.bankDatabase = new BankDatabase();
    }

    public int numOfUsers() {
        return bankDatabase.numOfUsers();
    }

    public boolean addBankUser(BankUser user) {
       return bankDatabase.addBankUser(user);
    }

    public List<BankAccount> getAccountsOf(BankUser bankUser) {
        return bankDatabase.getAccountsOf(bankUser);
    }

    public boolean containsUser(BankUser user) {
        return bankDatabase.containsUser(user);
    }

    public boolean createAccountForUser(BankUser user, BankAccount account) {
        return bankDatabase.createAccountForUser(user, account);
    }

    public boolean createAccountForUser(BankUser user, String accountName) {
        return bankDatabase.createAccountForUser(user, accountName);
    }

    private boolean findAccoundDuplicate(BankUser user, String accountName) {
        return bankDatabase.findAccoundDuplicate(user, accountName);
    }

    public void addAccount(BankUser user, BankAccount account) {
        bankDatabase.addAccount(user, account);
    }

    public int numberOfAccounts() {
        return bankDatabase.numberOfAccounts();

    }
    public BankAccount getAccountWithId(String s) {
        return bankDatabase.getAccountWithId(s);
    }
    public void deposit(BankUser account, int x) {
        bankDatabase.deposit( account,  x);
    }
}

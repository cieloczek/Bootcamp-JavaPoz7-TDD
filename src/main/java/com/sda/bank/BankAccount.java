package com.sda.bank;

public class BankAccount {
    private String id;
    private int ammount;

    public BankAccount(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAmmount() {
        return ammount;
    }

    public void setAmmount(int ammount) {
        this.ammount = ammount;
    }

    public void deposit(int x) {
        ammount+=x;
    }
    public static BankAccount instanceOf(String id, int amount){
        BankAccount bankAccount = new BankAccount(id);
        bankAccount.ammount = amount;
        return bankAccount;
    }
}

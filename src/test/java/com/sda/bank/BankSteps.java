package com.sda.bank;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.mockito.Mockito;

public class BankSteps {
    private static Bank bank;
    private static BankUser user;
    private static BankAccount account;
    private boolean userInsertResult;
    private boolean accInRes;
    private static BankDatabase bankDatabase;

    @Given("^I initialize bank$")
    public void IInitializeBank(){
        bank=new Bank(bankDatabase);
    }
    @And("^I instantiate bank$")
    public void InstantiateBank(){
        this.bank=new Bank(bankDatabase);
    }

    @When("^I create user with name: (.*) and pesel: (.*)$")
    public void iAddNewUser(String name, String pesel) {
        user = new BankUser(name, pesel);
    }

    @And("^I create an (.*) account$")
    public void iAddAnAccount(String id){
        account = new BankAccount(id);
    }

    @Then("^I can see an account was added$")
    public void iCanSeeAnAccount() {
        Assert.assertTrue(bank.getAccountsOf(user).contains(account));
    }

    @And("^I assure user is in the bank$")
    public void iAssureUserIsInTheBank()  {
        Assert.assertEquals(1,bank.numOfUsers());
    }

    @Then("^I add user to the Bank$")
    public void iAddUserToTheBank()  {
        userInsertResult = bank.addBankUser(new BankUser(user.getName(),user.getPesel()));
    }

    @And("^I add account to user$")
    public void iAddAccountToUser() {
        bank.addAccount(user,account);
    }

    @Then("^I assure user is not in the bank$")
    public void iAssureUserIsNotInTheBank() {
        Assert.assertFalse(userInsertResult);
        Assert.assertEquals(1,bank.numOfUsers());
    }

    @Then("^I see communicate that user cannot be created$")
    public void iSeeCommunicateThatUserCannotBeCreated() {
        Assert.assertFalse(userInsertResult);

        System.out.println("User cannot be created");
    }

    @And("^I add (.*) account to user$")
    public void iAddKontoOszczędnościoweAccountToUser(String accountName)   {
       accInRes= bank.createAccountForUser(user, accountName);
    }

    @Then("^I can see communicate that i cant duplicate an account$")
    public void iCanSeeCommunicateThatICantDuplicateAnAccount() {
        Assert.assertFalse(accInRes);
    }

    @When("^I try to add account to user$")
    public void iTryToAddAccountToUser()   {
       accInRes = bank.createAccountForUser(user,account);
    }

    @Then("^I can see an account was not added$")
    public void iCanSeeAnAccountWasNotAdded() {
        Assert.assertFalse(accInRes);

    }

    @When("^I deposit (\\d+) usd to an account$")
    public void iDepositMoneyToAnAccount(int x)  {
        bank.deposit(user,x);
    }

    @Then("^I see money was deposited$")
    public void iSeeMoneyWasDeposited()   {
    Assert.assertEquals(100, account.getAmmount());    }

    @Given("^I mock database for this case$")
    public void iMockDatabaseForThisCase()  {
    this.bankDatabase = Mockito.mock(BankDatabase.class);
    Mockito.when(bankDatabase.addBankUser(Mockito.any())).then(e->true);
    Mockito.when(bankDatabase.createAccountForUser(Mockito.any(),Mockito.anyString())).then(e->true);
    Mockito.when(bankDatabase.getAccountWithId(Mockito.anyString())).then(e-> BankAccount.instanceOf(null,1000));
    //Mockito.when(bankDatabase.deposit(Mockito.any(),Mockito.anyInt())).then(e->true);
    }
}

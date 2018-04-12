package com.sda.BookStore;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class BookStoreStepsTest {
    private BookStore bookstore;
    private Book book;

    @Given("^I initialize Book Store$")
    public void IinitializeBookStore(){
    this.bookstore=new BookStore();
    }
    @Given("^I create new Book with valid parameters$")
    public void ICreateNewBookWithValidParameters(){
    this.book = new Book("short tale about the moon", "unknown", "12.120.201.189",700);
    }

    @When("^I add book to the Book Store$")
    public void IAddBookToTheBookStore(){
    bookstore.add(book);
    }

    @Then("^I book is present in the Book Store$")
    public void IBookIsPresentInTheBookStore(){
    Assert.assertTrue(bookstore.getBooks().contains(book));
    }

    @And("^I change Books Title$")
    public void iChangeBooksTitle(){
       bookstore.updateTitle(book,"Another shitty title");
    }

    @Then("^Title is changed$")
    public void titleIsChanged(){
        Assert.assertEquals("Another shitty title", bookstore.getBooks().get(0).getTitle());
    }
}

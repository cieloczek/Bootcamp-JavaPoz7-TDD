package com.sda.BookStore;

import java.util.ArrayList;
import java.util.List;

public class BookStore {
    private final List<Book> books;

    public BookStore() {
        this.books = new ArrayList<>();
    }


    public void add(Book book){
    books.add(book);
    }

    public List<Book> getBooks() {
        return books;
    }
    public void updateTitle(Book book, String title){
        books.get(books.indexOf(book)).setTitle(title);

    }
}

package com.example.testserver.services;

import com.example.testserver.exceptions.PostArgumentNotValidException;
import com.example.testserver.models.Book;

import java.util.List;
import java.util.Set;

public interface IBookService {


    Book getById(int id);

    List<Book> getAll();

    void addBook(Book Book) throws PostArgumentNotValidException;

    Book updateBook(Book Book);
    Set<Book> findByTitle(String name);

    Set<Book> findByCategories(String categories);
    Set<Book> findByAuthor(String author);
    Set<Book> findByCategoriesAndTitle(String categories, String title);

    boolean deleteBook(int id);

}

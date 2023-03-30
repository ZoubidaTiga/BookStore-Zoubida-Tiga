
package com.example.testserver.controllers;

import com.example.testserver.models.Book;
import com.example.testserver.services.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@CrossOrigin
@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    IBookService bookService;

    @GetMapping
    public ResponseEntity<List<Book>> getAll(){
        List<Book> books= bookService.getAll();
        if(books.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(books,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable int id){
        return  bookService.getById(id);
    }

    @PutMapping
    Book updateLivre(@RequestBody Book newBook) {
        return bookService.updateBook(newBook);
    }

    @PostMapping
    public void addBook(@RequestBody Book book) {
        bookService.addBook(book);
    }

    @GetMapping("/titlesAndCategories")
    public Set<Book> getByNameAndCategories(@RequestParam(value="title", required=false) String title,
                                            @RequestParam(value="categories", required=false) String categories){
        return bookService.findByCategoriesAndTitle(categories, title);
    }
    @GetMapping("/author")
    public Set<Book> getByAuthor(@RequestParam(value="author", required=false) String author){
        return bookService.findByAuthor(author);
    }

    @DeleteMapping("/{id}")
    public boolean deleteBook(@PathVariable int id){
        return  bookService.deleteBook(id);
    }


}

package com.book.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.book.entity.BookDemo;

@RestController
@RequestMapping("/books")
public class BookController {
    List<BookDemo> allBooks=new ArrayList<>();

    @GetMapping
    public List<BookDemo> getAllBooks() {
        return allBooks;
    }

    @PostMapping
    public BookDemo addBook(@RequestBody BookDemo bookDemo){
        bookDemo.setId((long) (allBooks.size() + 1));
        allBooks.add(bookDemo);
        return bookDemo;
    }

    @GetMapping("/id")
    public BookDemo getBookDemo(@PathVariable long id){
        return allBooks.stream().filter(book->book.getId().equals(id)).findFirst().orElse(null);
    }
    
    @PutMapping("/id")
    public BookDemo updaBookDemo(@PathVariable long id, @RequestBody BookDemo upBookDemo){
    
        BookDemo bookDemo=getBookDemo(id);
        if(bookDemo!=null){
            bookDemo.setTitle(upBookDemo.getTitle());
            bookDemo.setAuthor(upBookDemo.getAuthor());
        }
        return bookDemo;

    }

    @DeleteMapping("/id")
    public void deleteBook(@PathVariable long id){
        allBooks.removeIf(book->book.getId().equals(id));

    }
}
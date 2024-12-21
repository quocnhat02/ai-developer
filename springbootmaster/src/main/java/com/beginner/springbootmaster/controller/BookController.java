package com.beginner.springbootmaster.controller;

import com.beginner.springbootmaster.entity.book.Book;
import com.beginner.springbootmaster.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("")
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookService.fetchAllBooks();
        return ResponseEntity.ok(books); // Đảm bảo trả về ResponseEntity
    }

    @PostMapping("")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        Book savedBook = bookService.addBook(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBook); // Trả về ResponseEntity với status CREATED
    }
}

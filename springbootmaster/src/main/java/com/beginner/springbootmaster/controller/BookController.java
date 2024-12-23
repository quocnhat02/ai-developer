package com.beginner.springbootmaster.controller;

import com.beginner.springbootmaster.base.request.NewBookRequest;
import com.beginner.springbootmaster.entity.book.Book;
import com.beginner.springbootmaster.service.BookService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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

    @GetMapping("/json")
    public ResponseEntity<Book> getJSON(ObjectMapper objectMapper) throws JsonProcessingException {
        String bookString = "{\"id\":1,\"title\":\"Light\",\"author\":\"Nhat\"}";
        Book book = objectMapper.readValue(bookString, Book.class);
        System.out.println(book);
        System.out.println(objectMapper.writeValueAsString(book));
        return ResponseEntity.ok(book); // Đảm bảo trả về ResponseEntity
    }

    @PostMapping("")
    public void addBook(@RequestBody NewBookRequest book) {
        Book newBook = new Book(null, book.title(), book.author());
        bookService.addBook(newBook);
    }
}

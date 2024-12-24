package com.beginner.springbootmaster.controller;

import com.beginner.springbootmaster.base.request.NewBookRequest;
import com.beginner.springbootmaster.entity.book.Book;
import com.beginner.springbootmaster.enums.SortingOrder;
import com.beginner.springbootmaster.service.BookService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @Autowired
    private Validator validator;

    @GetMapping("")
    public ResponseEntity<List<Book>> getAllBooks(@Param("sort") String sort) {
        SortingOrder sortingOrder = SortingOrder.valueOf(sort == null ? "asc" : sort);
        List<Book> books = bookService.fetchAllBooks(sortingOrder);
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
    public void addBook(@Valid @RequestBody NewBookRequest book) {
//        Set<ConstraintViolation<NewBookRequest>> validate = validator.validate(book);
//        validate.forEach(error -> System.out.println(error.getMessage()));
//        if (validate.isEmpty()) {
//            throw new ConstraintViolationException(validate);
//        }
        Book newBook = new Book(null, book.title(), book.author());
        bookService.addBook(newBook);
    }
}

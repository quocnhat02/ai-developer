package com.beginner.springbootmaster.service.impl;

import com.beginner.springbootmaster.entity.book.Book;
import com.beginner.springbootmaster.repository.BookRepository;
import com.beginner.springbootmaster.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public synchronized List<Book> fetchAllBooks() {
        System.out.println("Thread ID: " + Thread.currentThread().getId() + " is fetching all books");
        List<Book> books = null;
        try {
            // Logic
            books = bookRepository.findAll();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Thread ID: " + Thread.currentThread().getId() + " is finished fetching all books");
        return books;
    }

    @Override
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }
}

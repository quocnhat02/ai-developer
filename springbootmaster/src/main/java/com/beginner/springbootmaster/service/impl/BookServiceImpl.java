package com.beginner.springbootmaster.service.impl;

import com.beginner.springbootmaster.entity.book.Book;
import com.beginner.springbootmaster.repository.BookRepository;
import com.beginner.springbootmaster.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public synchronized List<Book> fetchAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

}

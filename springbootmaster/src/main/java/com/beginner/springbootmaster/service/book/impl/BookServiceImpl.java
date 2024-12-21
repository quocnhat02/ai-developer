package com.beginner.springbootmaster.service.book.impl;

import com.beginner.springbootmaster.entity.book.Book;
import com.beginner.springbootmaster.repository.book.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> fetchAllBooks() {
        return bookRepository.findAll();
    }
}

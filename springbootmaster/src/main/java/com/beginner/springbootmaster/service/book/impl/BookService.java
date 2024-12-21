package com.beginner.springbootmaster.service.book.impl;

import com.beginner.springbootmaster.entity.book.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {
    public List<Book> fetchAllBooks();
}

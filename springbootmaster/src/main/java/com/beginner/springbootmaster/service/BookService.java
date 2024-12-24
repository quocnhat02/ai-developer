package com.beginner.springbootmaster.service;

import com.beginner.springbootmaster.entity.book.Book;
import com.beginner.springbootmaster.enums.SortingOrder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {
    public List<Book> fetchAllBooks(SortingOrder sort);
    public Book addBook(Book book);
}

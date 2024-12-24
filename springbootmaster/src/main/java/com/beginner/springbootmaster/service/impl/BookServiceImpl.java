package com.beginner.springbootmaster.service.impl;

import com.beginner.springbootmaster.entity.book.Book;
import com.beginner.springbootmaster.enums.SortingOrder;
import com.beginner.springbootmaster.repository.BookRepository;
import com.beginner.springbootmaster.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public synchronized List<Book> fetchAllBooks(
            SortingOrder sort
    ) {
        return bookRepository.findAll(Sort.by(Sort.Direction.valueOf(sort.name()), "id"));
    }

    @Override
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

}

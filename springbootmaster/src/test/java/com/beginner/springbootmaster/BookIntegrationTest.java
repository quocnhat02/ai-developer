package com.beginner.springbootmaster;

import com.beginner.springbootmaster.service.BookService;
import com.beginner.springbootmaster.entity.book.Book;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest()
public class BookIntegrationTest {
    @Mock
    private BookService bookService;

    @InjectMocks
    private BookController bookController;

    @Test
    public void testGetAllBooks() {
        // Mocking service method
        List<Book> mockBooks = List.of(new Book(1L, "Title", "Author"));
        when(bookService.fetchAllBooks()).thenReturn(mockBooks);

        // Test controller method
        ResponseEntity<List<Book>> responseEntity = bookController.getAllBooks();
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(mockBooks, responseEntity.getBody());
    }

}

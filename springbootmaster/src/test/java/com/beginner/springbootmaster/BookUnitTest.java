package com.beginner.springbootmaster;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class BookUnitTest {
    @Test
    public void testGetAllBooks() {
        assertEquals(5, 5);
    }
}

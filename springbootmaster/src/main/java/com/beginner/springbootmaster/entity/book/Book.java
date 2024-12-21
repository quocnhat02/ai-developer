package com.beginner.springbootmaster.entity.book;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "book_001")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
}

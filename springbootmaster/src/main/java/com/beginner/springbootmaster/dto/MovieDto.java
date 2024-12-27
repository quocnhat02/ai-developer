package com.beginner.springbootmaster.dto;

import com.beginner.springbootmaster.domain.Genre;

public record MovieDto(Integer id,
                       String title,
                       Integer releaseYear,
                       Genre genre) {
}

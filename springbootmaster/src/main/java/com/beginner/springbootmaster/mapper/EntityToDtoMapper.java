package com.beginner.springbootmaster.mapper;

import com.beginner.springbootmaster.dto.MovieDto;
import com.beginner.springbootmaster.entity.Movie;

public class EntityToDtoMapper {

    public static MovieDto toDto(Movie movie) {
        return new MovieDto(
                movie.getId(),
                movie.getTitle(),
                movie.getReleaseYear(),
                movie.getGenre()
        );
    }


}

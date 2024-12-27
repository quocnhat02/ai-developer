package com.beginner.springbootmaster.controller;

import com.beginner.springbootmaster.dto.MovieDto;
import com.beginner.springbootmaster.service.MovieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping()
    public List<MovieDto> getMovies() {
        return this.movieService.findAll();
    }

    @GetMapping("{genre}")
    public List<MovieDto> getByGenre(String genre) {
        return this.movieService.findByGenre(genre);
    }
}

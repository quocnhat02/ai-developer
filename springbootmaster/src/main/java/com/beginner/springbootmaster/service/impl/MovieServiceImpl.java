package com.beginner.springbootmaster.service.impl;

import com.beginner.springbootmaster.dto.MovieDto;
import com.beginner.springbootmaster.mapper.EntityToDtoMapper;
import com.beginner.springbootmaster.repository.MovieRepository;
import com.beginner.springbootmaster.service.MovieService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<MovieDto> findAll() {
        return this.movieRepository.findAll()
                .stream()
                .map(EntityToDtoMapper::toDto)
                .toList();
    }

    public List<MovieDto> findByGenre(String genre) {
        return this.movieRepository.findByGenre(genre)
                .stream()
                .map(EntityToDtoMapper::toDto)
                .toList();
    }



}

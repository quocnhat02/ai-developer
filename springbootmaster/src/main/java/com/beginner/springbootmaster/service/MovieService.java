package com.beginner.springbootmaster.service;

import com.beginner.springbootmaster.dto.MovieDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MovieService {
    public List<MovieDto> findAll();
    public List<MovieDto> findByGenre(String genre);
}

package com.vtmovies.movies;

import org.bson.types.ObjectId;
import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    @Autowired                              // We want the framework to instantiate MovieRepository class.
    private MovieRepository movieRepository;
    
    public List<Movie> allMovies() {
        // System.out.println(movieRepository.findAll().toString());
        return movieRepository.findAll();
    }

    public Optional<Movie> movieById(String imdbId) {
        return movieRepository.findMovieByImdbId(imdbId);
    }
}

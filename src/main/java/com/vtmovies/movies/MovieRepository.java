package com.vtmovies.movies;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  MovieRepository extends MongoRepository<Movie, ObjectId> {

    // findBy<unique_attribute>
    Optional<Movie> findMovieByImdbId(String imdbId);
}

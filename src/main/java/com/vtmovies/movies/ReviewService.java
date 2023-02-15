package com.vtmovies.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public Review createReview(String reviewBody, String imdbId){
        Review review = reviewRepository.insert(new Review(reviewBody));    // insert() method returns an object (Review class).
        

        // Update operation on Movie class, to add a review to a movie with matching imdbId.
        mongoTemplate.update(Movie.class)       // Which class to update ?
                            .matching(Criteria.where("imdbId").is(imdbId))        // where(KEY).is(VALUE_TO_MATCH)
                            .apply(new Update().push("reviewIds").value(review))
                            .first();

        return(review);
    }
}

package org.wecancodeit.reviews.storage;

import org.springframework.stereotype.Service;
import org.wecancodeit.reviews.models.Review;



@Service
public class ReviewStorage {

    private ReviewRepository reviewRepo;

    public ReviewStorage(ReviewRepository reviewRepo){
        this.reviewRepo = reviewRepo;
    }
    public void addReview(Review reviewToAdd){
        reviewRepo.save(reviewToAdd);
    }
    public Iterable<Review> retrieveAllReviews(){
        return reviewRepo.findAll();
    }
    public Review retrieveReviewById(long id){
        return reviewRepo.findById(id).get();
    }
}

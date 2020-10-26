package org.wecancodeit.reviews.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.wecancodeit.reviews.models.Comments;
import org.wecancodeit.reviews.models.Hashtag;
import org.wecancodeit.reviews.storage.CommentStorage;
import org.wecancodeit.reviews.storage.HashtagStorage;
import org.wecancodeit.reviews.storage.ReviewStorage;

@Controller
public class ReviewController {
    private ReviewStorage reviewStorage;
    private HashtagStorage hashtagStorage;
    private CommentStorage commentStorage;

    public ReviewController(ReviewStorage reviewStorage, HashtagStorage hashtagStorage, CommentStorage commentStorage) {
        this.reviewStorage = reviewStorage;
        this.hashtagStorage = hashtagStorage;
        this.commentStorage = commentStorage;
    }

    @GetMapping({"/review/{id}"})
    public String showOneCerealPage(Model model, @PathVariable long id) {

        System.out.println(id);
        model.addAttribute("reviews", reviewStorage.retrieveReviewById(id));

        return "review-template";
    }
    @PostMapping({"/review/{id}"})
    public String addHashtagToReview(@RequestParam String hashtagName, @PathVariable long id) {

        if (!hashtagName.startsWith("#")) {
            hashtagName = "#" + hashtagName;
        } else {
        }

        Hashtag hashtagToAdd = hashtagStorage.retrieveHashtagByName(hashtagName);
        if(hashtagToAdd == null){
            hashtagToAdd = new Hashtag(hashtagName, reviewStorage.retrieveReviewById(id));
        } else {
            hashtagToAdd.addReview(reviewStorage.retrieveReviewById(id));
        }
        hashtagStorage.addHashtag(hashtagToAdd);
        System.out.println("Hey, Made it!");
        return "redirect:/review/{id}";
    }

    @RequestMapping(method = RequestMethod.POST, value= {"/review/{id}"},  params = {"rating", "authorText", "commentText"} )
    public String addCommentToReview(@RequestParam String rating, String authorText, String commentText, @PathVariable long id) {
        Comments commentToAdd = new Comments(rating, commentText, authorText, reviewStorage.retrieveReviewById(id));
        commentStorage.addComment(commentToAdd);
        return "redirect:/review/{id}";
    }





}
//move method to hashtag storage or review storage
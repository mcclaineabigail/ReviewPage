package org.wecancodeit.reviews;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.wecancodeit.reviews.models.Category;
import org.wecancodeit.reviews.models.Comments;
import org.wecancodeit.reviews.models.Hashtag;
import org.wecancodeit.reviews.models.Review;
import org.wecancodeit.reviews.storage.CategoryRepository;
import org.wecancodeit.reviews.storage.CommentRepository;
import org.wecancodeit.reviews.storage.HashTagRepository;
import org.wecancodeit.reviews.storage.ReviewRepository;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest

public class JPAWiringTest {

    @Autowired
    private CategoryRepository categoryRepo;

    @Autowired
    private ReviewRepository reviewRepo;

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private HashTagRepository hashTagRepo;

    @Autowired
    private CommentRepository commentRepo;

    @Test
    public void categoryHasManyReviewsAndReviewsHaveOneCategory () {
        Category testCategory = new Category("healthy", "/images/pic.jpg");
        categoryRepo.save(testCategory);
        Review testReview1 = new Review(testCategory, "Rice Chex", "/images/Rice Chex.png", "/images/Rice Chex-nutrition.png", "Description Description", "Rice Chex are crispy AF.");
        Review testReview2 = new Review(testCategory, "Raisin Bran", "/images/Rice Chex.png", "/images/Rice Chex-nutrition.png", "Description Description", "Raisin Bran is okay I guess.");
        reviewRepo.save(testReview1);
        reviewRepo.save(testReview2);
        testEntityManager.flush();
        testEntityManager.clear();
        Category retrievedCategory = categoryRepo.findById(testCategory.getId()).get();
        assertThat(retrievedCategory.getCereals()).contains(testReview1, testReview2);
        assertThat(retrievedCategory).isEqualTo(testCategory);
    }

    @Test
    public void reviewHasManyHashTagsAndHashTagsHaveManyReviews(){
        Category testCategory = new Category("healthy", "/images.png");
        categoryRepo.save(testCategory);
        Review testReview1 = new Review(testCategory, "Rice Chex", "/images/Rice Chex.png", "/images/Rice Chex-nutrition.png", "Description Description", "Rice Chex are crispy AF.");
        Review testReview2 = new Review(testCategory, "Raisin Bran", "/images/Rice Chex.png", "/images/Rice Chex-nutrition.png", "Description Description", "Raisin Bran is okay I guess.");
        reviewRepo.save(testReview1);
        reviewRepo.save(testReview2);
        Hashtag testHashTag1 = new Hashtag("#Crispy", testReview1, testReview2);
        Hashtag testHashTag2 = new Hashtag("#BurgerWanted", testReview1);
        Hashtag testHashTag3 = new Hashtag("#Unnecessary", testReview1, testReview2);
        hashTagRepo.save(testHashTag1);
        hashTagRepo.save(testHashTag2);
        hashTagRepo.save(testHashTag3);
        testEntityManager.flush();
        testEntityManager.clear();
        Review retrievedReview1 = reviewRepo.findById(testReview1.getId()).get();
        Review retrievedReview2 = reviewRepo.findById(testReview2.getId()).get();
        assertThat(retrievedReview1.getHashtag()).contains(testHashTag1, testHashTag2, testHashTag3);
        assertThat(retrievedReview2.getHashtag()).contains(testHashTag1, testHashTag3);
    }

    @Test
    public void reviewHasManyCommentsAndCommentsCanHaveManyReviews(){
        Category testCategory = new Category("healthy", "/images.png");
        categoryRepo.save(testCategory);
        Review testReview1 = new Review(testCategory, "Rice Chex", "/images/Rice Chex.png", "/images/Rice Chex-nutrition.png", "Description Description", "Rice Chex are crispy AF.");
        Review testReview2 = new Review(testCategory, "Raisin Bran", "/images/Rice Chex.png", "/images/Rice Chex-nutrition.png", "Description Description", "Raisin Bran is okay I guess.");
        reviewRepo.save(testReview1);
        reviewRepo.save(testReview2);
        Comments testComment1 = new Comments("5", "Dang ole tasty", "Tony", testReview1);
        Comments testComment2 = new Comments("3", "YeeHaw", "Muhammed", testReview2);
        commentRepo.save(testComment1);
        commentRepo.save(testComment2);
        testEntityManager.flush();
        testEntityManager.clear();
        Review retrievedReview1 = reviewRepo.findById(testReview1.getId()).get();
        Review retrievedReview2 = reviewRepo.findById(testReview2.getId()).get();
        assertThat(retrievedReview1.getComments()).contains(testComment1);
        assertThat(retrievedReview2.getComments()).contains(testComment2);
    }
}

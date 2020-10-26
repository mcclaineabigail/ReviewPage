package org.wecancodeit.reviews.models;

import javax.persistence.*;
import javax.xml.stream.events.Comment;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;

@Entity
public class Review {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    private Category category;
    private String cerealName;
    private String boxImage;
    private String nutritionImage;
    private String description;
    private String review;
    @ManyToMany(mappedBy = "reviews")
    private Set<Hashtag> hashtag;
    @ManyToMany(mappedBy = "reviews")
    private Collection<Comments> comments;


    public Review(Category category, String cerealName, String boxImage, String nutritionImage, String description, String review) {
        this.category = category;
        this.cerealName = cerealName;
        this.boxImage = boxImage;
        this.nutritionImage = nutritionImage;
        this.description = description;
        this.review = review;
    }

    protected Review(){}

    public long getId() {
        return id;
    }

    public Category getCategory() {
        return category;
    }

    public String getCerealName() {
        return cerealName;
    }

    public String getBoxImage() {
        return boxImage;
    }

    public String getNutritionImage() {
        return nutritionImage;
    }

    public String getDescription() {
        return description;
    }

    public String getReview() {
        return review;
    }

    public Collection<Hashtag> getHashtag() {
        return hashtag;
    }

    public Collection<Comments> getComments() {
        return comments;
    }


    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", category=" + category +
                ", cerealName='" + cerealName + '\'' +
                ", boxImage='" + boxImage + '\'' +
                ", nutritionImage='" + nutritionImage + '\'' +
                ", description='" + description + '\'' +
                ", review='" + review + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review1 = (Review) o;
        return id == review1.id &&
                Objects.equals(category, review1.category) &&
                Objects.equals(cerealName, review1.cerealName) &&
                Objects.equals(boxImage, review1.boxImage) &&
                Objects.equals(nutritionImage, review1.nutritionImage) &&
                Objects.equals(description, review1.description) &&
                Objects.equals(review, review1.review);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, category, cerealName, boxImage, nutritionImage, description, review);
    }
}




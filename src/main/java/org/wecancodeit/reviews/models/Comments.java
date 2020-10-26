package org.wecancodeit.reviews.models;


import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Objects;


@Entity
public class Comments {

    @Id
    @GeneratedValue
    private long id;

    private String comment;
    private String rating;
    private String author;
    @ManyToMany
    private Collection<Review> reviews;


    protected Comments() {
    }

    public Comments(String rating, String comment, String author, Review... reviews) {
        this.rating = rating;
        this.author = author;
        this.reviews = List.of(reviews);
        this.comment = comment;
    }

    public long getId() {
        return id;
    }

    public String getComment() {
        return comment;
    }

    public String getAuthor() {
        return author;
    }

    public String getRating() {
        return rating;
    }

    public Collection<Review> getReviews() {
        return reviews;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comments comments = (Comments) o;
        return id == comments.id &&
                Objects.equals(comment, comments.comment) &&
                Objects.equals(rating, comments.rating) &&
                Objects.equals(author, comments.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, comment, rating, author);
    }

    @Override
    public String toString() {
        return "Comments{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                ", rating='" + rating + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}




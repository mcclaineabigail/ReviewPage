package org.wecancodeit.reviews.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Collection;
import java.util.List;
import java.util.Objects;


@Entity
public class Hashtag {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    @ManyToMany
    private Collection<Review> reviews;

    protected Hashtag() {
    }

    public Hashtag(String name, Review...reviews) {
        this.name = name;
        this.reviews= List.of(reviews);
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Collection<Review> getReviews() {
        return reviews;
    }

    @Override
    public String toString() {
        return "Hashtag{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hashtag hashtag = (Hashtag) o;
        return id == hashtag.id &&
                Objects.equals(name, hashtag.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    public void addReview(Review reviewToAdd) {
        reviews.add(reviewToAdd);
    }
}

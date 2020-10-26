package org.wecancodeit.reviews.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Category {
    @Id
    @GeneratedValue
    private long id;
    private String type;
    private String categoryImage;
    @OneToMany(mappedBy="category")
    private Collection<Review> cereals;


    public Category(String type, String categoryImage) {
        this.type = type;
        this.categoryImage = categoryImage;
    }

    protected Category() {
    }

    public String getType() {
        return type;
    }

    public String getCategoryImage() {
        return categoryImage;
    }

    public Collection<Review> getCereals() {
        return cereals;
    }

    public long getId() {return id;}

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", categoryImage='" + categoryImage + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return id == category.id &&
                Objects.equals(type, category.type) &&
                Objects.equals(categoryImage, category.categoryImage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type);
    }
}

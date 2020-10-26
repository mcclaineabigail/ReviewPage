package org.wecancodeit.reviews.storage;

import org.springframework.stereotype.Service;
import org.wecancodeit.reviews.models.Category;

@Service
public class CategoryStorage {


    private CategoryRepository categoryRepo;

    public CategoryStorage(CategoryRepository categoryRepo){
        this.categoryRepo = categoryRepo;
    }

    public void addCategory(Category categoryToAdd) {
        categoryRepo.save( categoryToAdd);
    }
    public Iterable<Category> retrieveAllCategories(){
        return categoryRepo.findAll();
    }
    public Category retrieveCategoryById(Long id){
        return categoryRepo.findById(id).get();
    }
}

package org.wecancodeit.reviews.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wecancodeit.reviews.storage.CategoryStorage;


@Controller
public class CategoryController {


    private CategoryStorage categoryStorage;

    public CategoryController(CategoryStorage categoryStorage) {
        this.categoryStorage = categoryStorage;
    }

    @RequestMapping("/categories/{id}")
    public String displaySingleCategory(Model model, @PathVariable Long id) {
        model.addAttribute("categories", categoryStorage.retrieveCategoryById(id));
        return "category-template";
    }


}


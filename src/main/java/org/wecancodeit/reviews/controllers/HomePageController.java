package org.wecancodeit.reviews.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wecancodeit.reviews.models.Category;
import org.wecancodeit.reviews.storage.CategoryStorage;

import java.util.*;

@Controller
public class HomePageController{

    private CategoryStorage categoryStorage;

    public HomePageController(CategoryStorage categoryStorage) {
        this.categoryStorage = categoryStorage;
    }

    @RequestMapping("")
    public String displayHomePage (Model model) {

        model.addAttribute("categories", categoryStorage.retrieveAllCategories());

        return "home-template";
    }
}

package org.wecancodeit.reviews.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.wecancodeit.reviews.models.Hashtag;
import org.wecancodeit.reviews.storage.HashtagStorage;

@Controller
public class HashtagController {

    private HashtagStorage hashtagStorage;

    public HashtagController(HashtagStorage hashtagStorage) {
        this.hashtagStorage = hashtagStorage;
    }



    @RequestMapping("/hashtags")
    public String displayHashtagPage(Model model) {

        model.addAttribute("hashtags", hashtagStorage.retrieveAllHashtags());

        return "hashtag-template";
    }

    @PostMapping("/hashtags")
    public String addHashtag(@RequestParam String hashtagName) {
        if (!hashtagName.startsWith("#")) {
            hashtagName = "#" + hashtagName;
        } else {
        }
        Hashtag hashtagToAdd = new Hashtag(hashtagName);
        hashtagStorage.addHashtag(hashtagToAdd);

        return "redirect:/hashtags";

    }
}

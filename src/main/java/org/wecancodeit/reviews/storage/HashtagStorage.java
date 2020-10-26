package org.wecancodeit.reviews.storage;


import org.springframework.stereotype.Service;
import org.wecancodeit.reviews.models.Hashtag;
import org.wecancodeit.reviews.models.Review;

@Service
public class HashtagStorage {

    private HashTagRepository hashtagRepo;

    public HashtagStorage(HashTagRepository hashtagRepo){
        this.hashtagRepo = hashtagRepo;
    }
    public void addHashtag(Hashtag hashtagToAdd){
        hashtagRepo.save(hashtagToAdd);
    }
    public void addHashtagToSpecificReview(Hashtag hashtagToAdd){

    }

    public Iterable<Hashtag> retrieveAllHashtags(){
        return hashtagRepo.findAll();
    }
    public Hashtag retrieveHashtagById(long id){
        return hashtagRepo.findById(id).get();
    }

    public Hashtag retrieveHashtagByName(String hashtagName) {
        return hashtagRepo.findByName(hashtagName);
    }
}


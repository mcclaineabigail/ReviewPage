package org.wecancodeit.reviews.storage;


import org.attoparser.dom.Comment;
import org.springframework.stereotype.Service;
import org.wecancodeit.reviews.models.Comments;

@Service
public class CommentStorage {

    private CommentRepository commentRepo;

    public CommentStorage (CommentRepository commentRepo){
        this.commentRepo=commentRepo;
    }

    public void addComment(Comments commentToAdd){
        commentRepo.save(commentToAdd);
    }

    public Iterable <Comments> retrieveAllComments(){
        return commentRepo.findAll();
    }



}

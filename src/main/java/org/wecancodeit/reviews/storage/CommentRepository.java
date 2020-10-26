package org.wecancodeit.reviews.storage;

import org.attoparser.dom.Comment;
import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.reviews.models.Comments;

public interface CommentRepository extends CrudRepository<Comments, Long> {
}

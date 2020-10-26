package org.wecancodeit.reviews.storage;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.reviews.models.Review;

public interface ReviewRepository extends CrudRepository<Review, Long> {
}

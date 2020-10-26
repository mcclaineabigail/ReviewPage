package org.wecancodeit.reviews.storage;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.reviews.models.Hashtag;

public interface HashTagRepository extends CrudRepository<Hashtag, Long> {
    Hashtag findByName(String hashtagName);
}

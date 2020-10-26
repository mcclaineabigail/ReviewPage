package org.wecancodeit.reviews.storage;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.reviews.models.Category;

public interface CategoryRepository extends CrudRepository <Category, Long>
{
}

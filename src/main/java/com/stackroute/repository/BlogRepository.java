package com.stackroute.repository;

/* Add annotation to declare this class as a Repository class.
This interface should extend CRUD Repository
* */

import com.stackroute.domain.Blog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends CrudRepository<Blog, Integer> {
}

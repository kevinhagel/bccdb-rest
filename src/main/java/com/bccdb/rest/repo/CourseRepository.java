package com.bccdb.rest.repo;

import com.bccdb.rest.entity.Course;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

/**
 * CourseRepository
 *
 * @author Kevin Hagel
 * @since 2021-07-25
 */
@Repository
public interface CourseRepository extends ReactiveMongoRepository<Course, String> {
}

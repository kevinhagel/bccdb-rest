package com.bccdb.rest.data;

import com.bccdb.rest.model.Course;
import org.springframework.data.repository.CrudRepository;

/**
 * CourseRepository
 *
 * @author Kevin Hagel
 * @since 2021-07-24
 */
public interface CourseRepository extends CrudRepository<Course, String> {
}

package com.bccdb.rest.data;

import com.bccdb.rest.model.SummerCourse;
import org.springframework.data.repository.CrudRepository;

/**
 * SummerSchoolRepository
 *
 * @author Kevin Hagel
 * @since 2021-07-24
 */
public interface SummerCourseRepository extends CrudRepository<SummerCourse, String> {
}

package com.bccdb.rest.data;

import com.bccdb.rest.model.Instructor;
import com.bccdb.rest.model.SummerCourse;
import org.springframework.data.repository.CrudRepository;

/**
 * SummerSchoolRepository
 *
 * @author Kevin Hagel
 * @since 2021-07-24
 */
public interface InstructorRepository extends CrudRepository<Instructor, String> {
}

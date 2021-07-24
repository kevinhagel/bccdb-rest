package com.bccdb.rest.data;

import com.bccdb.rest.model.Student;
import org.springframework.data.repository.CrudRepository;

/**
 * StudentRepository
 *
 * @author Kevin Hagel
 * @since 2021-07-24
 */
public interface StudentRepository extends CrudRepository<Student, String> {
}

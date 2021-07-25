package com.bccdb.rest.repo;

import com.bccdb.rest.entity.Student;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

/**
 * StudentRepository
 *
 * @author Kevin Hagel
 * @since 2021-07-25
 */
@Repository
public interface StudentRepository extends ReactiveMongoRepository<Student, String> {
}

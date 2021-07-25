package com.bccdb.rest.repo;

import com.bccdb.rest.entity.Instructor;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * SummerSchoolRepository
 *
 * @author Kevin Hagel
 * @since 2021-07-24
 */
@Repository
public interface InstructorRepository extends ReactiveMongoRepository<Instructor, String> {
}

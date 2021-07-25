package com.bccdb.rest.repo;

import com.bccdb.rest.entity.Parent;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * ParentRepository
 *
 * @author Kevin Hagel
 * @since 2021-07-24
 */
@Repository
public interface ParentRepository extends ReactiveMongoRepository<Parent, String> {
}

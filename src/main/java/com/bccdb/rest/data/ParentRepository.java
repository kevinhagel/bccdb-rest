package com.bccdb.rest.data;

import com.bccdb.rest.model.Parent;
import org.springframework.data.repository.CrudRepository;

/**
 * ParentRepository
 *
 * @author Kevin Hagel
 * @since 2021-07-24
 */
public interface ParentRepository extends CrudRepository<Parent, String> {
}

package com.bccdb.rest.data;

import com.bccdb.rest.model.School;
import org.springframework.data.repository.CrudRepository;

/**
 * SchoolRepository
 *
 * @author Kevin Hagel
 * @since 2021-07-24
 */
public interface SchoolRepository extends CrudRepository<School, String> {
}

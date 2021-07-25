package com.bccdb.rest.service;

import com.bccdb.rest.dto.SchoolDto;
import com.bccdb.rest.entity.School;
import com.bccdb.rest.repo.SchoolRepository;
import com.bccdb.rest.utils.MapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * SchoolService maps reactive repository requests for {@link School}s.
 *
 * @author Kevin Hagel
 * @since 2021-07-25
 */
@Service
public class SchoolService {

  @Autowired
  private SchoolRepository repository;

  /**
   * Get all schools.
   *
   * @return a flux of schools.
   */
  public Flux<SchoolDto> getSchools() {
    return repository
        .findAll()
        .map(MapperUtils::entityToDto);
  }

  /**
   * Get a school by id
   *
   * @return a school if found.
   */
  public Mono<SchoolDto> getSchool(String id) {
    return repository
        .findById(id)
        .map(MapperUtils::entityToDto);
  }


  /**
   * Persist a new school
   *
   * @param schoolDtoMono the mono containing the school from the post.
   * @return the newly created school dto version.
   */
  public Mono<SchoolDto> saveSchool(Mono<SchoolDto> schoolDtoMono) {
    return schoolDtoMono
        .map(MapperUtils::dtoToEntity)
        .flatMap(repository::insert)
        .map(MapperUtils::entityToDto);
  }

  /**
   * Update an existing school.
   *
   * @param schoolDtoMono the school dto in a mono.
   * @param id            the id of the school to update
   * @return a mono containin the updated school dto.
   */
  public Mono<SchoolDto> updateSchool(Mono<SchoolDto> schoolDtoMono, String id) {
    return repository.findById(id)
        .flatMap(s -> schoolDtoMono.map(MapperUtils::dtoToEntity)
            .doOnNext(e -> e.setId(id)))
        .flatMap(repository::save)
        .map(MapperUtils::entityToDto);
  }


  /**
   * Delete an existing school
   *
   * @param id the id of the school
   * @return a void mono.
   */
  public Mono<Void> deleteSchool(String id) {
    return repository.deleteById(id);
  }

}

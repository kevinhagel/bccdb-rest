package com.bccdb.rest.service;

import com.bccdb.rest.dto.InstructorDto;
import com.bccdb.rest.dto.SchoolDto;
import com.bccdb.rest.entity.Instructor;
import com.bccdb.rest.entity.School;
import com.bccdb.rest.repo.InstructorRepository;
import com.bccdb.rest.repo.SchoolRepository;
import com.bccdb.rest.utils.MapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * InstructorService maps reactive repository requests for {@link Instructor}s.
 *
 * @author Kevin Hagel
 * @since 2021-07-25
 */
@Service
public class InstructorService {

  @Autowired
  private InstructorRepository repository;

  /**
   * Get all instructors.
   *
   * @return a flux of instructors.
   */
  public Flux<InstructorDto> getInstructors() {
    return repository
        .findAll()
        .map(MapperUtils::entityToDto);
  }

  /**
   * Get an instructor by id
   *
   * @return a instructor if found.
   */
  public Mono<InstructorDto> getInstructor(String id) {
    return repository
        .findById(id)
        .map(MapperUtils::entityToDto);
  }


  /**
   * Persist a new instructor
   *
   * @param instructorDtoMono the mono containing the instructor from the post.
   * @return the newly created instructor dto version.
   */
  public Mono<InstructorDto> saveInstructor(Mono<InstructorDto> instructorDtoMono) {
    return instructorDtoMono
        .map(MapperUtils::dtoToEntity)
        .flatMap(repository::insert)
        .map(MapperUtils::entityToDto);
  }

  /**
   * Update an existing instructor.
   *
   * @param instructorDtoMono the school dto in a mono.
   * @param id            the id of the school to update
   * @return a mono containin the updated school dto.
   */
  public Mono<InstructorDto> updateInstructor(Mono<InstructorDto> instructorDtoMono, String id) {
    return repository.findById(id)
        .flatMap(s -> instructorDtoMono.map(MapperUtils::dtoToEntity)
            .doOnNext(e -> e.setId(id)))
        .flatMap(repository::save)
        .map(MapperUtils::entityToDto);
  }


  /**
   * Delete an existing instructor
   *
   * @param id the id of the school
   * @return a void mono.
   */
  public Mono<Void> deleteInstructor(String id) {
    return repository.deleteById(id);
  }

}

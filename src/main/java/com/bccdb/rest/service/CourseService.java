package com.bccdb.rest.service;

import com.bccdb.rest.dto.CourseDto;
import com.bccdb.rest.repo.CourseRepository;
import com.bccdb.rest.utils.MapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * CourseService provides access to the course repository, for the various crud operations.
 *
 * @author Kevin Hagel
 * @since 2021-07-25
 */
@Service
public class CourseService {

  @Autowired
  private CourseRepository repository;

  /**
   * Get all courses.
   *
   * @return a flux of courses.
   */
  public Flux<CourseDto> getCourses() {
    return repository
        .findAll()
        .map(MapperUtils::entityToDto);
  }

  /**
   * get course by id
   *
   * @return the course dto if found.
   */
  public Mono<CourseDto> getCourse(String id) {
    return repository
        .findById(id)
        .map(MapperUtils::entityToDto);
  }


  /**
   * Persist a new Course.
   *
   * @param courseDtoMono the mono containing the course from the post.
   * @return the newly created course dto version.
   */
  public Mono<CourseDto> saveCourse(Mono<CourseDto> courseDtoMono) {
    return courseDtoMono
        .map(MapperUtils::dtoToEntity)
        .flatMap(repository::insert)
        .map(MapperUtils::entityToDto);
  }

  /**
   * Update an existing course
   *
   * @param courseDtoMono the course dto in a mono.
   * @param id            the id of the course to update
   * @return a mono containing the updated course dto.
   */
  public Mono<CourseDto> updateCourse(Mono<CourseDto> courseDtoMono, String id) {
    return repository.findById(id)
        .flatMap(s -> courseDtoMono.map(MapperUtils::dtoToEntity)
            .doOnNext(e -> e.setId(id)))
        .flatMap(repository::save)
        .map(MapperUtils::entityToDto);
  }

  /**
   * Delete an existing course
   *
   * @param id the id of the course
   * @return a void mono.
   */
  public Mono<Void> deleteCourse(String id) {
    return repository.deleteById(id);
  }

}

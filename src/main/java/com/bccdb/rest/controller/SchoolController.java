package com.bccdb.rest.controller;

import com.bccdb.rest.dto.CourseDto;
import com.bccdb.rest.dto.SchoolDto;
import com.bccdb.rest.entity.School;
import com.bccdb.rest.service.CourseService;
import com.bccdb.rest.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * SchoolController
 *
 * @author Kevin Hagel
 * @since 2021-07-25
 */
@RestController
@RequestMapping("/schools")
public class SchoolController {

  @Autowired
  private SchoolService service;


  /**
   * Fetch all the schools
   * @return all the schools
   */
  @GetMapping
  public Flux<SchoolDto> schools() {
    return service.getSchools();
  }

  /**
   * Get a course by id
   *
   * @param id the id
   * @return a course, possibly empty !
   */
  @GetMapping("/{id}")
  public Mono<SchoolDto> getSchool(@PathVariable String id) {
    return service.getSchool(id);
  }

  /**
   * Save a new school
   *
   * @param schoolDtoMono the new school data.
   * @return the newly created school.
   */
  @PostMapping()
  public Mono<SchoolDto> saveSchool(@RequestBody Mono<SchoolDto> schoolDtoMono) {
    return service.saveSchool(schoolDtoMono);
  }

  /**
   * Update a school
   *
   * @param schoolDtoMono the school data to use for the update
   * @param id            the id of the existing school
   * @return the updated course.
   */
  @PutMapping("/update/{id}")
  public Mono<SchoolDto> updateSchool(@RequestBody Mono<SchoolDto> schoolDtoMono, @PathVariable String id) {
    return service.updateSchool(schoolDtoMono, id);
  }

  /**
   * Delete a course
   *
   * @param id the id of the course to delete
   * @return a void.
   */
  @DeleteMapping("/delete/{id}")
  public Mono<Void> deleteSchool(@PathVariable String id) {
    return service.deleteSchool(id);
  }

}

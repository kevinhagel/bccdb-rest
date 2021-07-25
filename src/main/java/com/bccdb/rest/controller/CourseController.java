package com.bccdb.rest.controller;

import com.bccdb.rest.dto.CourseDto;
import com.bccdb.rest.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * CourseController
 *
 * @author Kevin Hagel
 * @since 2021-07-25
 */
@RestController
@RequestMapping("/courses")
public class CourseController {

  @Autowired
  private CourseService courseService;


  @GetMapping
  public Flux<CourseDto> courses() {
    return courseService.getCourses();
  }

  /**
   * Get a course by id
   *
   * @param id the id
   * @return a course, possibly empty !
   */
  @GetMapping("/{id}")
  public Mono<CourseDto> getCourse(@PathVariable String id) {
    return courseService.getCourse(id);
  }

  /**
   * Save a new course
   *
   * @param courseDtoMono the new course data.
   * @return the newly created course.
   */
  @PostMapping()
  public Mono<CourseDto> saveCourse(@RequestBody Mono<CourseDto> courseDtoMono) {
    return courseService.saveCourse(courseDtoMono);
  }

  /**
   * Update a course
   *
   * @param courseDtoMono the course data to use for the update
   * @param id            the id of the existing course
   * @return the updated course.
   */
  @PutMapping("/update/{id}")
  public Mono<CourseDto> updateCourse(@RequestBody Mono<CourseDto> courseDtoMono, @PathVariable String id) {
    return courseService.updateCourse(courseDtoMono, id);
  }

  /**
   * Delete a course
   *
   * @param id the id of the course to delete
   * @return a void.
   */
  @DeleteMapping("/delete/{id}")
  public Mono<Void> deleteCourse(@PathVariable String id) {
    return courseService.deleteCourse(id);
  }

}

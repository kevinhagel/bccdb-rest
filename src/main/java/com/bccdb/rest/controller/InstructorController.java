package com.bccdb.rest.controller;

import com.bccdb.rest.dto.InstructorDto;
import com.bccdb.rest.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * InstructorController providing reactive access to instructors
 *
 * @author Kevin Hagel
 * @since 2021-07-25
 */
@RestController
@RequestMapping("/instructors")
public class InstructorController {

  private InstructorService instructorService;

  /**
   * Create the new controller.
   *
   * @param instructorService
   */
  @Autowired
  public InstructorController(InstructorService instructorService) {
    this.instructorService = instructorService;
  }

  /**
   * Get all instructors.
   *
   * @return a flux containing all instructors.
   */
  @GetMapping
  public Flux<InstructorDto> getInstructors() {
    return instructorService.getInstructors();
  }

  /**
   * Get an instructor by id
   *
   * @param id the id
   * @return a instructor, possibly empty !
   */
  @GetMapping("/{id}")
  public Mono<InstructorDto> getInstructor(@PathVariable String id) {
    return instructorService.getInstructor(id);
  }

  /**
   * Save a new instructor
   *
   * @param instructorDtoMono the new instructor data.
   * @return the newly instructor course.
   */
  @PostMapping()
  public Mono<InstructorDto> saveInstructor(@RequestBody Mono<InstructorDto> instructorDtoMono) {
    return instructorService.saveInstructor(instructorDtoMono);
  }

  /**
   * Update an instructor
   *
   * @param instructorDtoMono the instructor data to use for the update
   * @param id                the id of the existing instructor
   * @return the updated instructor.
   */
  @PutMapping("/update/{id}")
  public Mono<InstructorDto> updateCourse(@RequestBody Mono<InstructorDto> instructorDtoMono, @PathVariable String id) {
    return instructorService.updateInstructor(instructorDtoMono, id);
  }

  /**
   * Delete an instructor
   *
   * @param id the id of the coinstructorrse to delete
   * @return a void.
   */
  @DeleteMapping("/delete/{id}")
  public Mono<Void> deleteCourse(@PathVariable String id) {
    return instructorService.deleteInstructor(id);
  }

}

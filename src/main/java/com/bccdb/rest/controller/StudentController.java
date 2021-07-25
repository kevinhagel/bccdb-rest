package com.bccdb.rest.controller;

import com.bccdb.rest.dto.StudentDto;
import com.bccdb.rest.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * StudentController providing reactive access to students.
 *
 * @author Kevin Hagel
 * @since 2021-07-25
 */
@RestController
@RequestMapping("/students")
public class StudentController {

  private StudentService studentService;

  /**
   * Create the new controller.
   *
   * @param studentService
   */
  @Autowired
  public StudentController(StudentService studentService) {
    this.studentService = studentService;
  }

  /**
   * Get all schools.
   *
   * @return a flux containing all schools.
   */
  @GetMapping
  public Flux<StudentDto> getStudents() {
    return studentService.getStudents();
  }

  /**
   * Get an instructor by id
   *
   * @param id the id
   * @return a instructor, possibly empty !
   */
  @GetMapping("/{id}")
  public Mono<StudentDto> getStudent(@PathVariable String id) {
    return studentService.getStudent(id);
  }

  /**
   * Save a new student
   *
   * @param studentDtoMono the new student data.
   * @return the newly student course.
   */
  @PostMapping()
  public Mono<StudentDto> saveStudent(@RequestBody Mono<StudentDto> studentDtoMono) {
    return studentService.saveStudent(studentDtoMono);
  }

  /**
   * Update a student
   *
   * @param studentDtoMono the student data to use for the update
   * @param id             the id of the existing student
   * @return the updated student.
   */
  @PutMapping("/update/{id}")
  public Mono<StudentDto> updateCourse(@RequestBody Mono<StudentDto> studentDtoMono, @PathVariable String id) {
    return studentService.updateStudent(studentDtoMono, id);
  }

  /**
   * Delete a student
   *
   * @param id the id of the student to delete
   * @return a void.
   */
  @DeleteMapping("/delete/{id}")
  public Mono<Void> deleteCourse(@PathVariable String id) {
    return studentService.deleteStudent(id);
  }

}

package com.bccdb.rest.service;

import com.bccdb.rest.dto.StudentDto;
import com.bccdb.rest.repo.StudentRepository;
import com.bccdb.rest.utils.MapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * StudentService
 *
 * @author Kevin Hagel
 * @since 2021-07-25
 */
@Service
public class StudentService {

  @Autowired
  private StudentRepository repository;

  /**
   * Get all students.
   *
   * @return a flux of students.
   */
  public Flux<StudentDto> getStudents() {
    return repository
        .findAll()
        .map(MapperUtils::entityToDto);
  }

  /**
   * Get a student by id
   *
   * @return a student if found.
   */
  public Mono<StudentDto> getStudent(String id) {
    return repository
        .findById(id)
        .map(MapperUtils::entityToDto);
  }


  /**
   * Persist a new student
   *
   * @param studentDtoMono the mono containing the student from the post.
   * @return the newly created student dto version.
   */
  public Mono<StudentDto> saveStudent(Mono<StudentDto> studentDtoMono) {
    return studentDtoMono
        .map(MapperUtils::dtoToEntity)
        .flatMap(repository::insert)
        .map(MapperUtils::entityToDto);
  }

  /**
   * Update an existing student.
   *
   * @param studentDtoMono the student dto in a mono.
   * @param id             the id of the student to update
   * @return a mono containin the updated student dto.
   */
  public Mono<StudentDto> updateStudent(Mono<StudentDto> studentDtoMono, String id) {
    return repository.findById(id)
        .flatMap(s -> studentDtoMono.map(MapperUtils::dtoToEntity)
            .doOnNext(e -> e.setId(id)))
        .flatMap(repository::save)
        .map(MapperUtils::entityToDto);
  }


  /**
   * Delete an existing student
   *
   * @param id the id of the stuent
   * @return a void mono.
   */
  public Mono<Void> deleteStudent(String id) {
    return repository.deleteById(id);
  }

}

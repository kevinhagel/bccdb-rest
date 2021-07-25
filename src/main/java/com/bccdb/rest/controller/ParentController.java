package com.bccdb.rest.controller;

import com.bccdb.rest.dto.InstructorDto;
import com.bccdb.rest.dto.ParentDto;
import com.bccdb.rest.service.InstructorService;
import com.bccdb.rest.service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * ParentController providing reactive access to parents
 *
 * @author Kevin Hagel
 * @since 2021-07-25
 */
@RestController
@RequestMapping("/parents")
public class ParentController {

  private ParentService parentService;

  /**
   * Create the new controller.
   *
   * @param parentService
   */
  @Autowired
  public ParentController(ParentService parentService) {
    this.parentService = parentService;
  }

  /**
   * Get all parents.
   *
   * @return a flux containing all parents.
   */
  @GetMapping
  public Flux<ParentDto> getParents() {
    return parentService.getParents();
  }

  /**
   * Get a parent by id
   *
   * @param id the id
   * @return a parents, possibly empty !
   */
  @GetMapping("/{id}")
  public Mono<ParentDto> getParent(@PathVariable String id) {
    return parentService.getParent(id);
  }

  /**
   * Save a new parents
   *
   * @param parentDtoMono the new parent data.
   * @return the newly created parent.
   */
  @PostMapping()
  public Mono<ParentDto> saveParent(@RequestBody Mono<ParentDto> parentDtoMono) {
    return parentService.saveParent(parentDtoMono);
  }

  /**
   * Update a parent.
   *
   * @param parentDtoMono the parent data to use for the update
   * @param id                the id of the existing parent
   * @return the updated parent.
   */
  @PutMapping("/update/{id}")
  public Mono<ParentDto> updateParent(@RequestBody Mono<ParentDto> parentDtoMono, @PathVariable String id) {
    return parentService.updateParent(parentDtoMono, id);
  }

  /**
   * Delete a parent.
   *
   * @param id the id of the parent to delete
   * @return a void.
   */
  @DeleteMapping("/delete/{id}")
  public Mono<Void> deleteCourse(@PathVariable String id) {
    return parentService.deleteParent(id);
  }

}

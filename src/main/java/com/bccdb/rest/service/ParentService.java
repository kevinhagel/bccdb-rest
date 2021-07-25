package com.bccdb.rest.service;

import com.bccdb.rest.dto.ParentDto;
import com.bccdb.rest.entity.Parent;
import com.bccdb.rest.entity.School;
import com.bccdb.rest.repo.ParentRepository;
import com.bccdb.rest.repo.SchoolRepository;
import com.bccdb.rest.utils.MapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * ParentService maps reactive repository requests for {@link Parent}s.
 *
 * @author Kevin Hagel
 * @since 2021-07-25
 */
@Service
public class ParentService {

  @Autowired
  private ParentRepository repository;

  /**
   * Get all parents.
   *
   * @return a flux of parents.
   */
  public Flux<ParentDto> getParents() {
    return repository
        .findAll()
        .map(MapperUtils::entityToDto);
  }

  /**
   * Get a parent by id
   *
   * @return a parent if found.
   */
  public Mono<ParentDto> getParent(String id) {
    return repository
        .findById(id)
        .map(MapperUtils::entityToDto);
  }


  /**
   * Persist a new parent
   *
   * @param parentDtoMono the mono containing the parent from the post.
   * @return the newly created parent dto version.
   */
  public Mono<ParentDto> saveParent(Mono<ParentDto> parentDtoMono) {
    return parentDtoMono
        .map(MapperUtils::dtoToEntity)
        .flatMap(repository::insert)
        .map(MapperUtils::entityToDto);
  }

  /**
   * Update an existing parent.
   *
   * @param parentDtoMono the parent dto in a mono.
   * @param id            the id of the parent to update
   * @return a mono containin the updated parent dto.
   */
  public Mono<ParentDto> updateParent(Mono<ParentDto> parentDtoMono, String id) {
    return repository.findById(id)
        .flatMap(s -> parentDtoMono.map(MapperUtils::dtoToEntity)
            .doOnNext(e -> e.setId(id)))
        .flatMap(repository::save)
        .map(MapperUtils::entityToDto);
  }


  /**
   * Delete an existing parent
   *
   * @param id the id of the parent
   * @return a void mono.
   */
  public Mono<Void> deleteParent(String id) {
    return repository.deleteById(id);
  }

}

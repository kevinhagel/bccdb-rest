package com.bccdb.rest.entity;

import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * Student
 *
 * @author Kevin Hagel
 * @since 2021-07-24
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Student {
  @Id
  private String id;
  private String firstName;
  private String familyName;
  private String homePhoneNumber;
  private String cellPhoneNumber;
  private String dateOfBirth;
  private String email;
  private String notes;
  private boolean active;

  @DBRef(lazy = true)
  private List<Course> courses = new ArrayList<>();

  @DBRef(lazy = true)
  private List<Parent> parents = new ArrayList<>();


}

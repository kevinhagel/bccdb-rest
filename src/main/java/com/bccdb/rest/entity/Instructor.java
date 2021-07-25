package com.bccdb.rest.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;


/**
 * Instructor teaches a course.
 *
 * @author Kevin Hagel
 * @since 2021-07-24
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "instructors")
public class Instructor implements Serializable {

  private static final long serialVersionUID = 6093224634486121162L;


  @Id
  private String id;
  private String phoneNumber;
  private String fullName;
  private String address;


}

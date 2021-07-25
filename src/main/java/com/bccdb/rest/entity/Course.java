package com.bccdb.rest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * Course is a course students take.  It also contains a current term, described as the user wants to describe it.
 *
 * @author Kevin Hagel
 * @since 2021-07-24
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "courses")
public class Course implements Serializable {
  private static final long serialVersionUID = -8083480363294987918L;

  @Id
  private String id;
  private String name;


}

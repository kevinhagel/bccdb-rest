package com.bccdb.rest.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * SummerCourse is very much like a regular course, but it is only for summer school day care students.  I suppose I
 * could just make this a regualr course, with a name like Summer July 2021, Summer August 2022 ... we'll see
 *
 * @author Kevin Hagel
 * @since 2021-07-24
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor(access= AccessLevel.PRIVATE, force=true)@Document
public class SummerCourse {
  @Id
  private String id;
  private String name;

  @DBRef(lazy = true)
  private List<Student> students;
}

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
 * School is an optional association for {@link Student}.  Adult students for example don't attend a school. A school
 * name includes the term, as in "German High School 2021-2022" ... of course the user of the database will be told this
 * fact, they can name the school anyway they want.  This is a nosql database. having an external "Term" table is not
 * useful.
 *
 * @author Kevin Hagel
 * @since 2021-07-24
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor(access= AccessLevel.PRIVATE, force=true)@Document
public class School {
  @Id
  private String id;

  private String name;
  private List<String> contacts;
  private String contactPhone;
  private String homePhoneNumber;
  private String address;
  private String notes;
}

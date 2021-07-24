package com.bccdb.rest.model;

import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;


/**
 * Parent is responsible for 0, 1, or many students.  A parent with 0 students is probably an archived parent.  Parents
 * are never deleted.
 *
 * @author Kevin Hagel
 * @since 2021-07-24
 */
@Data
@Builder
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor(access= AccessLevel.PRIVATE, force=true)@Document
public class Parent {

  @Id
  private String id;
  private String cellPhoneNumber;
  private String email;
  private String familyName;
  private String firstName;
  private String homePhoneNumber;
  private String notes;
  private String officePhoneNumber;
  private String workPhoneNumber;
}

package com.bccdb.rest.entity;

import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


/**
 * Parent is responsible for 0, 1, or many students.  A parent with 0 students is probably an archived parent.  Parents
 * are never deleted.  Not all people who pay for a student are "parents" ... maybe I should call this "contact"
 *
 * @author Kevin Hagel
 * @since 2021-07-24
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@Document
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

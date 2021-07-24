package com.bccdb.rest.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


/**
 * Parent is responsible for 0, 1, or many students.  A parent with 0 students is probably an archived parent.  Parents
 * are never deleted.
 *
 * @author Kevin Hagel
 * @since 2021-07-24
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor(access= AccessLevel.PRIVATE, force=true)@Document
public class Parent {

  @Id
  private String id;

  private String name;
  private String phoneNumber;
  private String homePhoneNumber;
  private String address;
}

package com.bccdb.rest.dto;

import com.bccdb.rest.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * StudentDto is a dto transferring {@link Student} information to the rest client.
 *
 * @author Kevin Hagel
 * @since 2021-07-24
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
  private String id;
  private String firstName;
  private String familyName;
  private String homePhoneNumber;
  private String cellPhoneNumber;
  private String dateOfBirth;
  private String email;
  private String notes;
  private boolean active;

}

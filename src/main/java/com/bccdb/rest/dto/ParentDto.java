package com.bccdb.rest.dto;

import com.bccdb.rest.model.Parent;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


/**
 * ParentDto is a dto transferring {@link Parent} information to the rest client.
 *
 * @author Kevin Hagel
 * @since 2021-07-24
 */
@Data
@Builder
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class ParentDto {

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

package com.bccdb.source;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

/**
 * XmlStudent is used to load
 *
 * @author Kevin Hagel
 * @since 19.09.20
 */
@Data
@JsonInclude
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class XmlSParent {

  private int id;
  private String familyName;
  private String firstName;
  private String homePhone;
  private String officePhone;
  private String gsm;
  private String email;
  private String notes;
  private String createTime;
  private String updateTime;

}

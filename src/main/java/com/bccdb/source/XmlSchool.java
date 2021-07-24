package com.bccdb.source;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

/**
 * XmlSchool
 *
 * @author Kevin Hagel
 * @since 19.09.20
 */
@Data
@JsonInclude
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class XmlSchool {

  private int id;
  private String name;
  private String addressStreet;
  private String addressCity;
  private String contactName;
  private String contactPhone;
  private String defaultClassesList;

}

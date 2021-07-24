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
public class XmlSchoolTerm {

  private int id;
  private int schoolId;
  private String periodStart;
  private String periodEnd;
  private String notes;
  private int current;
}

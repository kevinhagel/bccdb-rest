package com.bccdb.source;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

/**
 * XmlArchivedSchoolTerm
 *
 * @author Kevin Hagel
 * @since 20.09.20
 */
@Data
@JsonInclude
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class XmlArchivedStudentSchoolTerm {

  private int id;
  private String createTime;
  private String updateTime;
  private int current;
  private int studentId;
  private int schoolTermId;

}

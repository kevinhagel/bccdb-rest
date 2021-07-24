package com.bccdb.source;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

/**
 * XmlArchivedStudentLevelTerm
 *
 * @author Kevin Hagel
 * @since 20.09.20
 */
@Data
@JsonInclude
@JsonNaming(PropertyNamingStrategies.LowerCamelCaseStrategy.class)
public class XmlArchivedStudentLevelTerm {

  private int id;
  private String createTime;
  private String updateTime;
  private int current;
  private int studentId;
  private int levelTermId;
  private String totalPrice;

}

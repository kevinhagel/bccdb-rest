package com.bccdb.source;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
public class XmlStudent {

  private int id;
  private String firstName;
  private String familyName;
  private String homePhone;
  private String gsm;
  private String dateOfBirth;
  private String email;
  private String notes;
  private Integer primaryParentId;
  private Integer secondaryParentId;
  private int active;
  private String createTime;
  private String updateTime;
  private Integer currentLevelTermId;
  private Integer currentExamTermId;
  private Integer currentSchoolTermId;

  public List<Integer> getContactIds() {
    List<Integer> list = new ArrayList<>();
    Optional.ofNullable(primaryParentId).ifPresent(list::add);
    Optional.ofNullable(secondaryParentId).ifPresent(list::add);
    return list;
  }


}
package com.bccdb.source;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * XmlSourceConfiguration
 *
 * @author Kevin Hagel
 * @since 20.09.20
 */
@Configuration
public class XmlSourceConfiguration {

  @Autowired
  private ObjectMapper objectMapper;

  public XmlSourceConfiguration(ObjectMapper objectMapper) {
    this.objectMapper = objectMapper;
  }

  @Bean(name = "archivedStudentLevelTermProcessor")
  public XmlArchivedStudentLevelTermProcessor getXmlArchivedStudentLevelTermProcessor() {
    return new XmlArchivedStudentLevelTermProcessor(objectMapper);
  }

  @Bean(name = "archivedStudentSchoolTermProcessor")
  public XmlArchivedStudentSchoolTermProcessor getXmlArchivedStudentSchoolTermProcessor() {
    return new XmlArchivedStudentSchoolTermProcessor(objectMapper);
  }

  @Bean(name = "level")
  public XmlLevelProcessor getLevelProcessor() {
    return new XmlLevelProcessor(objectMapper);
  }

  @Bean(name = "levelTerm")
  public XmlLevelTermProcessor getLevelTermProcessor() {
    return new XmlLevelTermProcessor(objectMapper);
  }

  @Bean(name = "school")
  public XmlSchoolProcessor getSchoolProcessor() {
    return new XmlSchoolProcessor(objectMapper);
  }

  @Bean(name = "schoolTerm")
  public XmlSchoolTermProcessor getSchoolTermProcessor() {
    return new XmlSchoolTermProcessor(objectMapper);
  }

  @Bean(name = "sparent")
  public XmlSParentProcessor getSparentProcessor() {
    return new XmlSParentProcessor(objectMapper);
  }

  @Bean(name = "student")
  public XmlStudentProcessor getStudent() {
    return new XmlStudentProcessor(objectMapper);
  }


}

package com.bccdb.source;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

/**
 * XmlStudentProcessor
 *
 * @author Kevin Hagel
 * @since 19.09.20
 */
public class XmlArchivedStudentSchoolTermProcessor extends AbstractXmlProcessor<XmlArchivedStudentSchoolTerm> {


  public XmlArchivedStudentSchoolTermProcessor(ObjectMapper objectMapper) {
    super(objectMapper);
  }

  @Override
  protected XmlArchivedStudentSchoolTerm convert(Map<String, String> processingMap) {
    return objectMapper.convertValue(processingMap, XmlArchivedStudentSchoolTerm.class);
  }
}

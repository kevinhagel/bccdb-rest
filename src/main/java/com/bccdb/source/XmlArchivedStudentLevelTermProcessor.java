package com.bccdb.source;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

/**
 * XmlArchivedStudentLevelTermProcessor
 *
 * @author Kevin Hagel
 * @since 19.09.20
 */
public class XmlArchivedStudentLevelTermProcessor extends AbstractXmlProcessor<XmlArchivedStudentLevelTerm> {


  public XmlArchivedStudentLevelTermProcessor(ObjectMapper objectMapper) {
    super(objectMapper);
  }

  @Override
  protected XmlArchivedStudentLevelTerm convert(Map<String, String> processingMap) {
    return objectMapper.convertValue(processingMap, XmlArchivedStudentLevelTerm.class);
  }
}

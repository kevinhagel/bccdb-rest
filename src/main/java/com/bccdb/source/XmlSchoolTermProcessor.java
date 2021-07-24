package com.bccdb.source;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

/**
 * XmlStudentProcessor
 *
 * @author Kevin Hagel
 * @since 19.09.20
 */
public class XmlSchoolTermProcessor extends AbstractXmlProcessor<XmlSchoolTerm> {

  public XmlSchoolTermProcessor(ObjectMapper objectMapper) {
    super(objectMapper);
  }

  @Override
  protected XmlSchoolTerm convert(Map<String, String> processingMap) {
    return objectMapper.convertValue(processingMap, XmlSchoolTerm.class);
  }
}

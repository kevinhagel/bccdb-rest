package com.bccdb.source;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

/**
 * XmlStudentProcessor
 *
 * @author Kevin Hagel
 * @since 19.09.20
 */
public class XmlStudentProcessor extends AbstractXmlProcessor<XmlStudent> {


  public XmlStudentProcessor(ObjectMapper objectMapper) {
    super(objectMapper);
  }

  @Override
  protected XmlStudent convert(Map<String, String> processingMap) {
    return objectMapper.convertValue(processingMap, XmlStudent.class);
  }
}

package com.bccdb.source;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

/**
 * XmlStudentProcessor
 *
 * @author Kevin Hagel
 * @since 19.09.20
 */
public class XmlLevelTermProcessor extends AbstractXmlProcessor<XmlLevelTerm> {

  public XmlLevelTermProcessor(ObjectMapper objectMapper) {
    super(objectMapper);
  }

  @Override
  protected XmlLevelTerm convert(Map<String, String> processingMap) {
    return objectMapper.convertValue(processingMap, XmlLevelTerm.class);
  }

}

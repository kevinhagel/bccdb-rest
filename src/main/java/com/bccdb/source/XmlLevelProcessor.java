package com.bccdb.source;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

/**
 * XmlStudentProcessor
 *
 * @author Kevin Hagel
 * @since 19.09.20
 */
public class XmlLevelProcessor extends AbstractXmlProcessor<XmlLevel> {

  public XmlLevelProcessor(ObjectMapper objectMapper) {
    super(objectMapper);
  }

  @Override
  protected XmlLevel convert(Map<String, String> processingMap) {
    return objectMapper.convertValue(processingMap, XmlLevel.class);
  }
}

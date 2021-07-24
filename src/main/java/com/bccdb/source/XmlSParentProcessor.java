package com.bccdb.source;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

/**
 * XmlStudentProcessor
 *
 * @author Kevin Hagel
 * @since 19.09.20
 */
public class XmlSParentProcessor extends AbstractXmlProcessor<XmlSParent> {

  public XmlSParentProcessor(ObjectMapper objectMapper) {
    super(objectMapper);
  }

  @Override
  protected XmlSParent convert(Map<String, String> processingMap) {
    return objectMapper.convertValue(processingMap, XmlSParent.class);
  }
}

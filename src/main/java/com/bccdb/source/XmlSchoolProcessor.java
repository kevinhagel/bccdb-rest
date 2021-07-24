package com.bccdb.source;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * XmlStudentProcessor
 *
 * @author Kevin Hagel
 * @since 19.09.20
 */
@Component
public class XmlSchoolProcessor extends AbstractXmlProcessor<XmlSchool> {

  public XmlSchoolProcessor(ObjectMapper objectMapper) {
    super(objectMapper);
  }

  @Override
  protected XmlSchool convert(Map<String, String> processingMap) {
    return objectMapper.convertValue(processingMap, XmlSchool.class);
  }

}

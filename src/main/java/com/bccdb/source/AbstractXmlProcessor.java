package com.bccdb.source;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import java.util.*;

/**
 * AbstractXmlProcessor ancestor of the xml processors.
 *
 * @author Kevin Hagel
 * @since 2021-07-24
 */
public abstract class AbstractXmlProcessor<T> {

  protected final ObjectMapper objectMapper;
  private final List<T> processed = new ArrayList<>();
  private final Map<String, String> processingMap = new HashMap<>();
  private String currentField = null;

  protected AbstractXmlProcessor(ObjectMapper objectMapper) {
    this.objectMapper = objectMapper;
  }

  public String getName() {
    return getClass().getSimpleName();
  }


  public void startRow(StartElement startElement) {
    processingMap.clear();
  }

  public void processField(String fieldName) {
    currentField = Optional.ofNullable(fieldName).orElse(null);
  }

  public void processFieldContent(Characters fieldContent) {
    Optional.ofNullable(currentField).ifPresent(data -> processingMap.put(currentField, fieldContent.getData()));
  }

  public void endField(EndElement endElement) {
    currentField = null;
  }


  public void endRow(EndElement endElement) {
    T element = convert(processingMap);
    processed.add(element);
    processingMap.clear();
    currentField = null;
  }


  public List<T> getProcessed() {
    return processed;
  }

  protected abstract T convert(Map<String, String> processingMap);

  public int count() {
    return processed.size();
  }


}

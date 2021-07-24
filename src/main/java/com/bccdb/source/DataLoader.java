package com.bccdb.source;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.IOException;
import java.util.Optional;

import static io.vavr.API.*;

/**
 * DataLoader a class that knows how to load xml content.  Send it a resource location, it will set up an xml parser, a
 * sax parser, and ... callbacks and all that shit.
 *
 * @author Kevin Hagel
 * @since 19.09.20
 */
@Service
@Data
public class DataLoader {

  private final ObjectMapper objectMapper;

  @Autowired(required = true)
  XmlArchivedStudentLevelTermProcessor xmlArchivedStudentLevelTermProcessor;
  @Autowired(required = true)
  XmlArchivedStudentSchoolTermProcessor xmlArchivedStudentSchoolTermProcessor;


  @Autowired(required = true)
  XmlLevelProcessor xmlLevelProcessor;
  @Autowired
  XmlLevelTermProcessor xmlLevelTermProcessor;
  @Autowired
  XmlSchoolProcessor xmlSchoolProcessor;
  @Autowired
  XmlSchoolTermProcessor xmlSchoolTermProcessor;
  @Autowired
  XmlSParentProcessor xmlSParentProcessor;
  @Autowired
  XmlStudentProcessor xmlStudentProcessor;


  public DataLoader(ObjectMapper objectMapper) {
    this.objectMapper = objectMapper;
  }

  @PostConstruct
  public void init() {
  }

  public void load(Resource xmlResource) throws IOException, XMLStreamException {
    XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
    XMLEventReader reader = xmlInputFactory.createXMLEventReader(xmlResource.getInputStream());
    int i = 0;
    Optional<AbstractXmlProcessor> xmlProcessor = Optional.empty();

    while (reader.hasNext()) {
      XMLEvent nextEvent = reader.nextEvent();
      if (nextEvent.isStartElement()) {
        StartElement startElement = nextEvent.asStartElement();

        switch (startElement.getName().getLocalPart()) {
          case "table_data":
            Attribute tableDataName = startElement.getAttributeByName(QName.valueOf("name"));
            xmlProcessor = getXmlProcessor(tableDataName.getValue());
            break;

          case "row":
            xmlProcessor.ifPresent(processor -> processor.startRow(startElement));
            break;

          case "field":
            Attribute fieldName = startElement.getAttributeByName(QName.valueOf("name"));
            xmlProcessor.ifPresent(processor -> processor.processField(fieldName.getValue()));
            break;

          default:
            break;
        }

      } else if (nextEvent.isEndElement()) {
        EndElement endElement = nextEvent.asEndElement();
        String endElementName = endElement.getName().getLocalPart();
        switch (endElementName) {
          case "table_data":
            break;
          case "row":
            xmlProcessor.ifPresent(processor -> processor.endRow(endElement));
            break;
          case "field":
            xmlProcessor.ifPresent(processor -> processor.endField(endElement));
            break;
          default:
            break;
        }

      } else {
        if (nextEvent.getEventType() == 4) {
          boolean ignorable = nextEvent.asCharacters().isIgnorableWhiteSpace();
          if (ignorable) {
            continue;
          }
          xmlProcessor.ifPresent(processor -> processor.processFieldContent(nextEvent.asCharacters()));
        }
      }
    }

  }

  private Optional<AbstractXmlProcessor> getXmlProcessor(String localPart) {
    return Optional.ofNullable(Match(localPart).of(
        Case($("archived_student_level_term"), () -> xmlArchivedStudentLevelTermProcessor),
        Case($("archived_student_school_term"), () -> xmlArchivedStudentSchoolTermProcessor),
        Case($("level"), () -> xmlLevelProcessor),
        Case($("level_term"), () -> xmlLevelTermProcessor),
        Case($("school"), () -> xmlSchoolProcessor),
        Case($("school_term"), () -> xmlSchoolTermProcessor),
        Case($("sparent"), () -> xmlSParentProcessor),
        Case($("student"), () -> xmlStudentProcessor),
        Case($(), () -> null)
    ));
  }


}

package com.bccdb;

import com.bccdb.rest.model.Parent;
import com.bccdb.rest.model.School;
import com.bccdb.rest.model.Student;
import com.bccdb.source.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.io.Resource;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.*;
import java.util.stream.Collectors;

import static io.vavr.API.*;

@SpringBootApplication
public class BccdbRestApplication implements CommandLineRunner, ApplicationContextAware {

  @Autowired
  private ObjectMapper objectMapper;

  private final DataLoader dataLoader;
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
  @Value("${import.data:false}")
  private boolean importData;
  @Value("classpath:dump.xml")
  private Resource resource;
  private ApplicationContext applicationContext;

  private List<Student> students = new ArrayList<>();
  private List<Parent> parents = new ArrayList<>();
  private List<School> schools = new ArrayList<>();

  public BccdbRestApplication(DataLoader dataLoader) {this.dataLoader = dataLoader;}

  public static void main(String[] args) {
    SpringApplication.run(BccdbRestApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    System.out.println("ARGS " + args);
    System.out.println("importData= " + importData);
    if (importData) {
      System.out.println("data Loder " + dataLoader);
      System.out.println("resource " + resource + " : " + resource.exists());
      dataLoader.load(resource);
      Map<Integer, Integer> levelTermMap = new HashMap<>();
//      dataLoader.getXmlLevelTermProcessor()
//          .getProcessed()
//          .stream()
//          .forEach(xmlLevelTerm -> {
//            dataLoader.getXmlLevelProcessor()
//                .getProcessed()
//                .stream()
//                .filter(xmlLevel -> xmlLevel.getId() == xmlLevelTerm.getLevelId())
//                .findFirst()
//                .map(xmlLevel -> new Level().setCurrent(false)
//                    .setName(xmlLevel.getName())
//                    .setNotes(Optional.ofNullable(xmlLevelTerm.getNotes()).orElse(xmlLevel.getNotes()))
//                    .setStartDate(Date.valueOf(xmlLevelTerm.getPeriodStart()))
//                    .setEndDate(Date.valueOf(xmlLevelTerm.getPeriodEnd()))
//                    .setDefaultPrice(xmlLevelTerm.getDefaultPrice()))
//                .ifPresent(levelTerm -> {
//                  Level saved = levelService.insert(levelTerm);
//                  levelTermMap.put(xmlLevelTerm.getId(), saved.getId());
//                });
//          });

      Map<Integer, Integer> schoolMap = new HashMap<>();
      dataLoader.getXmlSchoolProcessor().getProcessed()
          .stream()
          .forEach(xmlSchool -> {
            School school = School
                .builder()
                .name(xmlSchool.getName())
                .addressStreet(xmlSchool.getAddressStreet())
                .addressCity(xmlSchool.getAddressCity())
                .contactName(xmlSchool.getContactName())
                .contactPhone(xmlSchool.getContactPhone())
                .build();
            schools.add(school);
//            School saved = schoolService.insert(school);
//            schoolMap.put(xmlSchool.getId(), saved.getId());
          });
      Map<Integer, Integer> schoolTermMap = new HashMap<>();
      dataLoader.getXmlSchoolTermProcessor().getProcessed()
          .stream()
          .forEach(schoolTerm -> {
            int schoolId = schoolTerm.getSchoolId();
            schoolTermMap.put(schoolTerm.getId(), schoolId);
          });
      Map<Integer, Integer> contactMap = new HashMap<>();
      parents = dataLoader.getXmlSParentProcessor().getProcessed()
          .stream()
          .map(xmlSParent ->
                  Parent
                      .builder()
                      .email(xmlSParent.getEmail())
                      .familyName(xmlSParent.getFamilyName())
                      .firstName(xmlSParent.getFirstName())
                      .cellPhoneNumber(xmlSParent.getGsm())
                      .homePhoneNumber(xmlSParent.getHomePhone())
                      .notes(xmlSParent.getNotes())
                      .workPhoneNumber(xmlSParent.getOfficePhone())
                      .build()

//            Contact saved = contactService.save(contact);
//            contactMap.put(xmlSParent.getId(), saved.getId());
          ).collect(Collectors.toList());

      Map<Integer, Integer> studentMap = new HashMap<>();
     students = dataLoader.getXmlStudentProcessor().getProcessed()
          .stream()
          .map(xmlStudent -> {
            int xmlStudentId = xmlStudent.getId();

            Student student = Student
                .builder()
                .active(xmlStudent.getActive() == 1)
                .cellPhoneNumber(xmlStudent.getGsm())
                .dateOfBirth(xmlStudent.getDateOfBirth())
                .email(xmlStudent.getEmail())
                .familyName(xmlStudent.getFamilyName())
                .firstName(xmlStudent.getFirstName())
                .homePhoneNumber(xmlStudent.getHomePhone())
                .notes(xmlStudent.getNotes())
                .build();
            return student;
          }).collect(Collectors.toList());

            // as long as we're here, add contacts
//            StreamSupport
//                .stream(xmlStudent.getContactIds().spliterator(), false)
//                .filter(Objects::nonNull)
//                .map(contactId -> contactMap.get(contactId))
//                .filter(Objects::nonNull)
//                .map(contactId -> contactService.findById(contactId))
//                .filter(Objects::nonNull)
//                .map(Optional::get)
//                .forEach(contact -> student.getContacts().add(contact));


            /*
             * Do the level terms
             */
//            dataLoader.getXmlArchivedStudentLevelTermProcessor()
//                .getProcessed()
//                .stream()
//                .filter(xmlArchivedStudentLevelTerm -> xmlArchivedStudentLevelTerm.getStudentId() == xmlStudentId)
//                .map(xmlArchivedStudentLevelTerm -> xmlArchivedStudentLevelTerm.getLevelTermId())
//                .map(xmlArchivedLevelTermId -> levelTermMap.get(xmlArchivedLevelTermId))
//                .filter(Objects::nonNull)
//                .map(savedLevelTermId -> levelService.findById(savedLevelTermId))
//                .filter(Optional::isPresent)
//                .map(Optional::get)
//                .forEach(levelTerm -> student.getLevels().add(levelTerm));

            /**
             * Do the school.
             */
//            Integer xmlCurrentSchoolTermId = xmlStudent.getCurrentSchoolTermId();
//            Integer schoolId = schoolTermMap.get(xmlCurrentSchoolTermId);
//            Optional.ofNullable(schoolMap.get(schoolId))
//                .ifPresent(s -> schoolService.findById(s).ifPresent(school -> student.setSchool(school)));
//            Student saved = studentService.save(student);
//            studentMap.put(xmlStudent.getId(), saved.getId());
//          });
    }
    System.out.println("students = " + students);
    Map<String, Object> studentMap = new HashMap<>();
    studentMap.put("students", students);
    FileOutputStream outputStream = new FileOutputStream("students.json");
    byte[] bytes = objectMapper.writeValueAsBytes(studentMap);
    outputStream.write(bytes);
    outputStream.close();

  }

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    this.applicationContext = applicationContext;
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

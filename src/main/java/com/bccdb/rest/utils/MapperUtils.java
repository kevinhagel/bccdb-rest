package com.bccdb.rest.utils;

import com.bccdb.rest.dto.*;
import com.bccdb.rest.entity.*;
import org.springframework.beans.BeanUtils;

/**
 * MapperUtils contains static mappers to create Dtos from Entities, and Entities from Dtos.
 *
 * @author Kevin Hagel
 * @since 2021-07-25
 */
public class MapperUtils {

  /**
   * Maps a {@link Student} to a {@link StudentDto}
   *
   * @param student the source student.
   * @return the destination student dto.
   */
  public static StudentDto entityToDto(Student student) {
    StudentDto studentDto = new StudentDto();
    BeanUtils.copyProperties(student, studentDto);
    return studentDto;
  }

  /**
   * Maps a {@link StudentDto} to a {@link Student}
   *
   * @param studentDto the source student dto.
   * @return the destination student.
   */
  public static Student dtoToEntity(StudentDto studentDto) {
    Student student = new Student();
    BeanUtils.copyProperties(studentDto, student);
    return student;
  }

  /**
   * Maps a {@link Course} to a {@link CourseDto}
   *
   * @param course the source course.
   * @return the destination course dto.
   */
  public static CourseDto entityToDto(Course course) {
    CourseDto courseDto = new CourseDto();
    BeanUtils.copyProperties(course, courseDto);
    return courseDto;
  }

  /**
   * Maps a {@link CourseDto} to a {@link Course}
   *
   * @param courseDto the source course dto.
   * @return the destination course.
   */
  public static Course dtoToEntity(CourseDto courseDto) {
    Course course = new Course();
    BeanUtils.copyProperties(courseDto, course);
    return course;
  }


  /**
   * Maps a {@link Parent} to a {@link ParentDto}
   *
   * @param parent the source course.
   * @return the destination course dto.
   */
  public static ParentDto entityToDto(Parent parent) {
    ParentDto parentDto = new ParentDto();
    BeanUtils.copyProperties(parent, parentDto);
    return parentDto;
  }

  /**
   * Maps a {@link CourseDto} to a {@link Course}
   *
   * @param parentDto the source course dto.
   * @return the destination course.
   */
  public static Parent dtoToEntity(ParentDto parentDto) {
    Parent parent = new Parent();
    BeanUtils.copyProperties(parentDto, parent);
    return parent;
  }

  /**
   * Maps a {@link School} to a {@link SchoolDto}
   *
   * @param school the source school.
   * @return the destination school dto.
   */
  public static SchoolDto entityToDto(School school) {
    SchoolDto schoolDto = new SchoolDto();
    BeanUtils.copyProperties(school, schoolDto);
    return schoolDto;
  }

  /**
   * Maps a {@link SchoolDto} to a {@link School}
   *
   * @param schoolDto the source school dto.
   * @return the destination school.
   */
  public static School dtoToEntity(SchoolDto schoolDto) {
    School parent = new School();
    BeanUtils.copyProperties(schoolDto, parent);
    return parent;
  }


  /**
   * Maps a {@link Instructor} to a {@link InstructorDto}
   *
   * @param instructor the source instructor.
   * @return the destination instructor dto.
   */
  public static InstructorDto entityToDto(Instructor instructor) {
    InstructorDto instructorDto = new InstructorDto();
    BeanUtils.copyProperties(instructor, instructorDto);
    return instructorDto;
  }

  /**
   * Maps a {@link InstructorDto} to a {@link Instructor}
   *
   * @param instructorDto the source school dto.
   * @return the destination school.
   */
  public static Instructor dtoToEntity(InstructorDto instructorDto) {
    Instructor instructor = new Instructor();
    BeanUtils.copyProperties(instructorDto, instructor);
    return instructor;
  }


}

package com.bccdb.rest.utils;

import com.bccdb.rest.dto.CourseDto;
import com.bccdb.rest.dto.ParentDto;
import com.bccdb.rest.dto.StudentDto;
import com.bccdb.rest.entity.Course;
import com.bccdb.rest.entity.Parent;
import com.bccdb.rest.entity.Student;
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


}

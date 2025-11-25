package com.harsh.demo.mapper;

import com.harsh.demo.dto.StudentDto;
import com.harsh.demo.entities.Student;

public class MapperUtil {

    public static Student toEntity(StudentDto studentDto){
        Student student = new Student();
        student.setId(studentDto.getId());
        student.setName(studentDto.getName());
        student.setState(studentDto.getState());
        student.setSurname(studentDto.getSurname());
        student.setRollNo(studentDto.getRollNo());
        student.setPhone(studentDto.getPhone());

        return student;

    }

    public static StudentDto toDto(Student student){
        StudentDto studentDto = new StudentDto();
        studentDto.setId(student.getId());
        studentDto.setName(student.getName());
        studentDto.setPhone(student.getPhone());
        studentDto.setState(student.getState());
        studentDto.setRollNo(student.getRollNo());
        studentDto.setSurname(student.getSurname());

        return studentDto;


    }
}

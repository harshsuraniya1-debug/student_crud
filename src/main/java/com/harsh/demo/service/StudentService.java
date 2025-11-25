package com.harsh.demo.service;

import com.harsh.demo.dto.StudentDto;
import com.harsh.demo.entities.Student;
import com.harsh.demo.mapper.MapperUtil;
import com.harsh.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<StudentDto> getAllStudents(){
        List<Student> studentList = studentRepository.findAll();

        List<StudentDto> studentDtoList = new ArrayList<>();
        for(Student s :studentList){
            StudentDto studentDto = MapperUtil.toDto(s);
            studentDtoList.add(studentDto);
        }
        return  studentDtoList;

    }
//    public StudentDto getStudentById (long id){
//       Optional<Student> student = studentRepository.findById(id);
//       MapperUtil.toDto(student)
//    }
}

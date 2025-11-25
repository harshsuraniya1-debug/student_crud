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
    public StudentDto getStudentById (long id){
       Optional<Student> student = studentRepository.findById(id);

       if(student.isPresent()){
           return MapperUtil.toDto(student.get());
       }

       throw new RuntimeException("Student with given id is not found ");

    }

   public void deleteAllStudents(){
        studentRepository.deleteAll();
   }

   public void deleteStudent(long id){
        studentRepository.deleteById(id);
   }

   public StudentDto createStudent(StudentDto studentDto){

       Student student = MapperUtil.toEntity(studentDto);

       Student savedStudent = studentRepository.save(student);

       return MapperUtil.toDto(savedStudent);

   }

   public StudentDto updateStudent(StudentDto studentDto,long id){

        Optional<Student> existingstudent = studentRepository.findById(id);

        if(existingstudent.isPresent()){

            Student optionalstudent = existingstudent.get();
            optionalstudent.setRollNo(studentDto.getRollNo());
            optionalstudent.setState(studentDto.getState());
            optionalstudent.setSurname(studentDto.getSurname());
            optionalstudent.setPhone(studentDto.getPhone());
            optionalstudent.setName(studentDto.getSurname());

            Student updatedstudent = studentRepository.save(optionalstudent);
            return MapperUtil.toDto(updatedstudent);
        }
        else{
            throw new RuntimeException("Student id is not found : " + id);
        }

   }
}

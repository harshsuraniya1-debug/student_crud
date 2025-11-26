package com.harsh.demo.controller;

import com.harsh.demo.dto.StudentDto;
import com.harsh.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<StudentDto> getAllStudents (){

       return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public StudentDto getStudentById (@PathVariable("id") long studentId){
        return studentService.getStudentById(studentId);
    }

    @PostMapping
    public StudentDto createStudent (@RequestBody StudentDto studentDto){
        return studentService.createStudent(studentDto);


    }

    @PutMapping("/{id}")
    public StudentDto updateStudent (@RequestBody StudentDto studentDto,
                                     @PathVariable("id") long studentId){

        return updateStudent(studentDto,studentId);
    }

      @DeleteMapping
      public void deleteAllStudents(){
          studentService.deleteAllStudents();

      }

     @DeleteMapping("/{id}")
     public void deleteStudent (@PathVariable("id") long studentId){
        studentService.deleteStudent(studentId);

    }
}

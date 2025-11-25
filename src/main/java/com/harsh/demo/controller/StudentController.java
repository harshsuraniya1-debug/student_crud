package com.harsh.demo.controller;

import com.harsh.demo.dto.StudentDto;
import com.harsh.demo.service.StudentService;
import jakarta.websocket.server.PathParam;
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

//    @GetMapping("/{id}")
//    public StudentDto getStudentById (@PathParam("id") long studentId){
//
//    }
//
//    @PostMapping
//    public StudentDto createStudent (@RequestBody StudentDto studentDto){
//
//
//    }
//
//    @PutMapping("/{id}")
//    public StudentDto updateStudent (@RequestBody StudentDto studentDto,
//                                     @PathParam("id") long studentId){
//
//    }
//
//    @DeleteMapping
//    public void deleteAllStudents(){
//
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteStudent (@PathParam("id") long studentId){
//
//    }
}

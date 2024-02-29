package com.develope.exercise11;

import com.develope.exercise11.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    StudentService studentService;

    @PostMapping("/createStudent")
    public void createStudent(@RequestBody Student student){
        studentRepository.save(student);
    }

    @GetMapping("/studentList")
    public List<Student>studentList(){
        return studentRepository.findAll();
    }

    @GetMapping("/getStudentById/{id}")
    public Optional<Student> studentById(@PathVariable Long id){
     return studentRepository.findById(id);
    }

    @PutMapping ("/updateId/{id}")
   public Student updatedStudentId (@PathVariable Long id, @RequestBody Student student){
        student.setId(id);
        return studentRepository.save(student);
    }

    @PutMapping("/updateIsWorking/{id}")
    public void updatedStudentIsWorking(@PathVariable Long id, @ RequestParam Boolean working ){
       studentService.isWokring(id,working);

    }

    @DeleteMapping("/deleteStudent")
    public void deleteStudent(Student student){
        studentRepository.delete(student);
    }

}

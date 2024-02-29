package com.develope.exercise11;

import com.develope.exercise11.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    public void isWokring (Long id, boolean isWorking){
        Optional<Student> student= studentRepository.findById(id);
        if(student.isEmpty()){
            return;
        }
        student.get().setIsWorking(isWorking);
       studentRepository.save(student.get());

    }
}

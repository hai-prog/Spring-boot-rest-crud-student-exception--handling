package com.example.demo.rest;

import com.example.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private List<Student> students;


    // define @PostConstruct to load the student data ... only once!
    @PostConstruct
    public void loadData()
    {
        students = new ArrayList<>();
        students.add(new Student("Haidy","Osama"));
        students.add(new Student("Rana","Osama"));
        students.add(new Student("Mahmoud","Osama"));
    }

    // get list of students
    @GetMapping("/students")
    public List<Student> getStudents(){

    return students;
    }

    // get a student by id
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId)
    {


        if( (studentId>= students.size()) || (studentId< 0) )
        {
            throw new StudentNotFoundException("student id not found - "+ studentId) ;
        }



        return students.get(studentId);
    }


   


}

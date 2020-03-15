package com.apache.solr.SolrTemplateExample.controller;

import com.apache.solr.SolrTemplateExample.model.Student;
import com.apache.solr.SolrTemplateExample.repo.StudentSolrRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.List;

@RestController
@Api(value = "Student API")
public class StudentController {

    @Autowired
    private StudentSolrRepository studentSolrRepository;

    @ApiOperation(value = "Create Student - POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful creation of student")
    })
    @PostMapping("/student")
    public void createStudent(@RequestBody Student student) {
        studentSolrRepository.save(student);
    }

    @ApiOperation(value = "Retrieve All Students - GET")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful retrieval of all students"),
            @ApiResponse(code = 404, message = "No Students")
    })
    @GetMapping("/students")
    public List<Student> getAllStudents(HttpServletResponse response) {
        List<Student> students = studentSolrRepository.findAll();
        if(students.size() == 0) {
            response.setStatus(HttpStatus.NOT_FOUND.value());
            return Collections.emptyList();
        }
        else
            return students;
    }

    @ApiOperation(value = "Retrieve Students by age - GET")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful retrieval of students by age"),
            @ApiResponse(code = 404, message = "No Students matching this age")
    })
    @GetMapping("/students/{age}")
    public List<Student> getStudentByAge(@PathVariable("age") Integer age, HttpServletResponse response) {
        List<Student> students = studentSolrRepository.findByAge(age);
        if(students.size() == 0) {
            response.setStatus(HttpStatus.NOT_FOUND.value());
            return Collections.emptyList();
        }
        else
            return students;
    }

    @EventListener
    public void handleContextRefreshEvent(ContextRefreshedEvent contextRefreshedEvent) {
        System.out.println("Context Refresh Event received.");
        Student first = new Student();
        first.setId("1");
        first.setAge(30);
        first.setSalary(300.0);
        studentSolrRepository.save(first);
    }
}
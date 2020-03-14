package com.apache.solr.SolrTemplateExample.controller;

import com.apache.solr.SolrTemplateExample.model.Student;
import com.apache.solr.SolrTemplateExample.repo.StudentSolrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentSolrRepository studentSolrRepository;

    @PostMapping("/create/student")
    public void createStudent(@RequestBody Student student) {
        studentSolrRepository.save(student);
    }

    @GetMapping("/students/all")
    public List<Student> getAllStudents() {
        return studentSolrRepository.findAll();
    }

    @GetMapping("/students/{age}")
    public List<Student> getStudentByAge(@PathVariable("age") Integer age) {
        return studentSolrRepository.findByAge(age);
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
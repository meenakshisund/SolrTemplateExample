package com.apache.solr.SolrTemplateExample.controller;

import com.apache.solr.SolrTemplateExample.model.Student;
import com.apache.solr.SolrTemplateExample.repo.StudentSolrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentSolrRepository studentSolrRepository;

    @PostMapping("/create/student")
    public void createStudent(@RequestBody Student student) {
        studentSolrRepository.save(student);
    }

    @GetMapping("/student/all")
    public List<Student> getAllStudents() {
        return studentSolrRepository.findAll();
    }
}
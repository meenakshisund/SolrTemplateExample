package com.apache.solr.SolrTemplateExample.repo;

import com.apache.solr.SolrTemplateExample.model.Student;
import org.springframework.data.solr.repository.SolrRepository;

import java.util.List;

public interface StudentSolrRepository extends SolrRepository<Student, String> {

    void save(Student student);

    List<Student> findAll();
}
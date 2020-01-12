package com.apache.solr.SolrTemplateExample.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

@SolrDocument(collection = "Student")
public class Student {

    @Id
    @Indexed
    private String id;

    @Indexed
    private Integer age;

    @Indexed
    private Double salary;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public Integer getAge() { return age; }
    public void setAge(Integer age) { this.age = age; }

    public Double getSalary() { return salary; }
    public void setSalary(Double salary) { this.salary = salary; }
}
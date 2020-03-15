package com.apache.solr.SolrTemplateExample.model;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

import static com.apache.solr.SolrTemplateExample.model.Constants.STUDENT_COLLECTION;

@SolrDocument(collection = STUDENT_COLLECTION)
public class Student {

    @Id
    @Indexed
    @ApiModelProperty(value = "student id")
    private String id;

    @Indexed
    @ApiModelProperty(value = "student age")
    private Integer age;

    @Indexed
    @ApiModelProperty(value = "student salary")
    private Double salary;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public Integer getAge() { return age; }
    public void setAge(Integer age) { this.age = age; }

    public Double getSalary() { return salary; }
    public void setSalary(Double salary) { this.salary = salary; }
}
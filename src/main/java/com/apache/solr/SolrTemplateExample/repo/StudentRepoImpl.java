package com.apache.solr.SolrTemplateExample.repo;

import com.apache.solr.SolrTemplateExample.model.SolrQueryUtils;
import com.apache.solr.SolrTemplateExample.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.query.Query;
import org.springframework.data.solr.core.query.result.ScoredPage;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.apache.solr.SolrTemplateExample.model.Constants.STUDENT_COLLECTION;

@Repository
public class StudentRepoImpl implements StudentSolrRepository {

    @Autowired
    private SolrTemplate solrTemplate;

    public void save(Student student) {
        solrTemplate.saveBean(STUDENT_COLLECTION, student);
        solrTemplate.commit(STUDENT_COLLECTION);
    }

    @Override
    public List<Student> findAll() {
        Query query = SolrQueryUtils.formQuery("*", "*").addSort(Sort.by(Sort.Direction.ASC, "age","id"));
        ScoredPage<Student> page = solrTemplate.queryForPage(STUDENT_COLLECTION, query, Student.class);
        return page.getContent();
    }

    @Override
    public List<Student> findByAge(Integer age) {
        Query query = SolrQueryUtils.formQuery("age", age);
        ScoredPage<Student> page = solrTemplate.queryForPage(STUDENT_COLLECTION, query, Student.class);
        return page.getContent();
    }

    /*@Override
    public List<Student> findByAgeBetween(Integer age1, Integer age2) {
        Query query = SolrQueryUtils.betweenQuery("age", age1, age2);
        ScoredPage<Student> page = solrTemplate.queryForPage(STUDENT_COLLECTION, query, Student.class);
        return page.getContent();
    }*/

    @Override
    public long count() { return 0; }
}

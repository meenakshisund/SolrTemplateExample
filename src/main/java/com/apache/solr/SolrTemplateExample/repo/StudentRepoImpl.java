package com.apache.solr.SolrTemplateExample.repo;

import com.apache.solr.SolrTemplateExample.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.query.SimpleQuery;
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
        ScoredPage<Student> page = solrTemplate.queryForPage(STUDENT_COLLECTION, new SimpleQuery("*:*"), Student);
        return page.getContent();
    }

    @Override
    public long count() {
        return 0;
    }
}

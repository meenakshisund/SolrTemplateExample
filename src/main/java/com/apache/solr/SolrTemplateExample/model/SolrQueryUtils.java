package com.apache.solr.SolrTemplateExample.model;

import org.springframework.data.solr.core.query.Query;
import org.springframework.data.solr.core.query.SimpleQuery;

public class SolrQueryUtils {

    public static Query formQuery(String field, Object value){
        return new SimpleQuery(field + ":" + value);
    }
}
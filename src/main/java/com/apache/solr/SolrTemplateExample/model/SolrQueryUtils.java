package com.apache.solr.SolrTemplateExample.model;

import org.springframework.data.solr.core.query.Query;
import org.springframework.data.solr.core.query.SimpleQuery;

public class SolrQueryUtils {
    public static Query formQuery(String field, Object value){
        return new SimpleQuery(field + ":" + value);
    }

    public static Query betweenQuery(String field, Object value1, Object value2){
        return new SimpleQuery(field + ":" + value1 + " TO " + field + ":" + value2);
    }
}
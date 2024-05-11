package com.navi.assignment.service;

import com.navi.assignment.model.Query;

import java.util.Set;

public interface QueryService {

    Query addQuery(Query query);

    Set<String> getQueryIds();

    Query getQuery(String queryId);

}

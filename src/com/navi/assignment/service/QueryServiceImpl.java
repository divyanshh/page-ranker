package com.navi.assignment.service;

import com.navi.assignment.model.Query;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class QueryServiceImpl implements QueryService {

    private int idGenerator = 1;
    private Map<String, Query> idToQueryMap = new HashMap<>();

    public Query addQuery(Query query) {
        query.setId("Q" + idGenerator++);
        idToQueryMap.put(query.getId(), query);
        return query;
    }

    public Set<String> getQueryIds() {
        return idToQueryMap.keySet();
    }

    public Query getQuery(String queryId) {
        return idToQueryMap.get(queryId);
    }

}

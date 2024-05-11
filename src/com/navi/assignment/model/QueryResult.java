package com.navi.assignment.model;

import java.util.List;
import java.util.stream.Collectors;

public class QueryResult {

    private String queryId;
    private List<String> webPageIds;

    public QueryResult(String queryId, List<String> webPageIds) {
        this.webPageIds = webPageIds;
        this.queryId = queryId;
    }

    public String getWebPageIds() {
        return webPageIds.stream().collect(Collectors.joining(" "));
    }

    public String getQueryId() {
        return queryId;
    }


}

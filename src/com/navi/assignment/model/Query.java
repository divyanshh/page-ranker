package com.navi.assignment.model;

import java.util.List;

public class Query {

    private String id;
    private List<String> keywords;

    public Query(List<String> keywords) {
        this.keywords = keywords;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getKeywords() {
        return keywords;
    }

}

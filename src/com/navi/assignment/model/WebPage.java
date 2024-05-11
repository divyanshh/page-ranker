package com.navi.assignment.model;

import java.util.List;

public class WebPage {

    private String id;
    private List<String> keywords;
    private List<WebPage> childWebPages;

    public WebPage(List<String> keywords, List<WebPage> childWebPages) {
        this.keywords = keywords;
        this.childWebPages = childWebPages;
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

    public List<WebPage> getChildWebPages() {
        return childWebPages;
    }
}

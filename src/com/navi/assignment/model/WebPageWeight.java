package com.navi.assignment.model;

import java.util.Map;

public class WebPageWeight {

    private String pageId;
    private Map<String, Double> keywordIdToTotalWeights;

    public WebPageWeight(String pageId, Map<String, Double> keywordIdToTotalWeights) {
        this.pageId = pageId;
        this.keywordIdToTotalWeights = keywordIdToTotalWeights;
    }

    public String getPageId() {
        return pageId;
    }

    public Map<String, Double> getKeywordIdToWeights() {
        return keywordIdToTotalWeights;
    }
}

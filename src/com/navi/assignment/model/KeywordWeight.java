package com.navi.assignment.model;

import java.util.Map;

public class KeywordWeight {

    private String keywordId;
    private Map<String, Double> pageIdToWeights;

    public KeywordWeight(String keywordId, Map<String, Double> pageIdToWeights) {
        this.keywordId = keywordId;
        this.pageIdToWeights = pageIdToWeights;
    }

    public String getKeywordId() {
        return keywordId;
    }

    public Map<String, Double> getPageIdToWeights() {
        return pageIdToWeights;
    }
}

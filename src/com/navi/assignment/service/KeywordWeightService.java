package com.navi.assignment.service;


import java.util.Set;

public interface KeywordWeightService {

    void addKeywordPageWeights(String keyword, String pageId, Double weight);

    Double getKeywordWeightInPage(String keyword, String pageId);

    Set<String> getPageIdsForAKeyword(String keyword);

}

package com.navi.assignment.service;

import com.navi.assignment.model.KeywordWeight;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class KeywordWeightServiceImpl implements KeywordWeightService {

    private Map<String, KeywordWeight> keywordToPageWeights = new HashMap<>();

    @Override
    public void addKeywordPageWeights(String keyword, String pageId, Double weight) {
        if (keywordToPageWeights.containsKey(keyword)) {
            KeywordWeight keywordWeight = keywordToPageWeights.get(keyword);
            keywordWeight.getPageIdToWeights().put(pageId, weight);
        } else {
            Map<String, Double> pageIdToWeights = new HashMap<>();
            pageIdToWeights.put(pageId, weight);
            KeywordWeight keywordWeight = new KeywordWeight(keyword, pageIdToWeights);
            keywordToPageWeights.put(keyword, keywordWeight);
        }
    }

    @Override
    public Double getKeywordWeightInPage(String keyword, String pageId) {
        return keywordToPageWeights.get(keyword).getPageIdToWeights().get(pageId);
    }

    @Override
    public Set<String> getPageIdsForAKeyword(String keyword) {
        KeywordWeight keywordWeight = keywordToPageWeights.get(keyword);
        if (keywordWeight == null) {
            return Collections.emptySet();
        }
        return keywordWeight.getPageIdToWeights().keySet();
    }
}

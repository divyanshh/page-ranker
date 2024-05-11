package com.navi.assignment.service;

import com.navi.assignment.model.Query;
import com.navi.assignment.model.QueryResult;
import com.navi.assignment.model.WebPage;

import java.util.*;
import java.util.stream.Collectors;


public class WeightBasedPageRanker implements PageRankerService {

    private QueryService queryServiceImpl;
    private KeywordWeightService keywordWeightServiceImpl;
    int MAX_RESULTS = 5;

    public WeightBasedPageRanker(QueryService queryServiceImpl,
                                 KeywordWeightService keywordWeightServiceImpl) {
        this.keywordWeightServiceImpl = keywordWeightServiceImpl;
        this.queryServiceImpl = queryServiceImpl;
    }

    @Override
    public void processWebPage(WebPage webPage) {
        Double weight = 8.0;
        for (String keyword: webPage.getKeywords()) {
            keywordWeightServiceImpl.addKeywordPageWeights(keyword, webPage.getId(), weight);
            weight--;
        }
    }

    @Override
    public QueryResult runQuery(Query query) {
        QueryResult queryResult = generateResults(getScoresForQuery(query), query.getId());
        return queryResult;
    }

    private QueryResult generateResults(Map<String, Double> scoresMap, String queryId) {
        List<Map.Entry<String, Double>> pageIds = new ArrayList<>(scoresMap.entrySet());
        Collections.sort(pageIds, (o1, o2) -> o2.getValue().compareTo(o1.getValue()) == 0 ?
                o1.getKey().compareTo(o2.getKey()) : o2.getValue().compareTo(o1.getValue()));
        return new QueryResult(queryId, pageIds.stream().limit(MAX_RESULTS).map(Map.Entry::getKey).collect(Collectors.toList()));
    }

    private Map<String, Double> getScoresForQuery(Query query) {
        Map<String, Double> pageScore = new HashMap<>();
        Double queryKeywordWeight = 8.0;
        for (String keyword : query.getKeywords()) {
            Set<String> pageIds = keywordWeightServiceImpl.getPageIdsForAKeyword(keyword);
            if (pageIds == null) {
                continue;
            }
            for (String pageId : pageIds) {
                pageScore.put(pageId , pageScore.getOrDefault(pageId, 0.0)
                        + queryKeywordWeight * keywordWeightServiceImpl.getKeywordWeightInPage(keyword, pageId));
            }
            queryKeywordWeight--;
        }
        return pageScore;
    }
}

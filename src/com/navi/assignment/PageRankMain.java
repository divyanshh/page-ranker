package com.navi.assignment;

import com.navi.assignment.model.Query;
import com.navi.assignment.model.QueryResult;
import com.navi.assignment.model.WebPage;
import com.navi.assignment.service.*;

import java.util.ArrayList;
import java.util.Arrays;

public class PageRankMain {

    public static void main(String[] args) {

        String input =
                "P Ford Car Review\n" +
                "P Review Car\n" +
                "P Review Ford\n" +
                "P Toyota Car\n" +
                "P Honda Car\n" +
                "P Car\n" +
                "Q Ford\n" +
                "Q Car\n" +
                "Q Review\n" +
                "Q Ford Review\n" +
                "Q Ford Car\n" +
                "Q cooking French";

        String[] inputStrings = input.split("\n");

        QueryService queryService = new QueryServiceImpl();
        WebPageService webPageService = new WebPageServiceImpl();
        KeywordWeightService keywordWeightService = new KeywordWeightServiceImpl();
        PageRankerService pageRankerService = new WeightBasedPageRanker(queryService, keywordWeightService);

        for (String inputString : inputStrings) {
            if (inputString.startsWith("P ")) {
                WebPage webPage = parseWebPage(inputString.substring(2));
                webPageService.addWebPage(webPage);
                pageRankerService.processWebPage(webPage);
            } else if (inputString.startsWith("Q ")) {
                Query query = parseQuery(inputString.substring(2));
                queryService.addQuery(query);
                QueryResult queryResult = pageRankerService.runQuery(query);
                System.out.println(queryResult.getQueryId() + ": " + queryResult.getWebPageIds());
            }
        }
    }

    private static WebPage parseWebPage(String inputString) {
        return new WebPage(Arrays.asList(inputString.toLowerCase().split(" ")), new ArrayList<>());
    }

    private static Query parseQuery(String inputString) {
        return new Query(Arrays.asList(inputString.toLowerCase().split(" ")));
    }
}

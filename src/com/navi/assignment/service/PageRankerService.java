package com.navi.assignment.service;


import com.navi.assignment.model.Query;
import com.navi.assignment.model.QueryResult;
import com.navi.assignment.model.WebPage;


public interface PageRankerService {

    void processWebPage(WebPage webPage);

    QueryResult runQuery(Query query);

}

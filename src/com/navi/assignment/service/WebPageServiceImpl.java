package com.navi.assignment.service;

import com.navi.assignment.model.WebPage;

import java.util.HashMap;
import java.util.Map;

public class WebPageServiceImpl implements WebPageService {

    private Map<String, WebPage> pageIdToWebPageMap = new HashMap<>();
    private int idGenerator = 1;

    @Override
    public void addWebPage(WebPage webPage) {
        webPage.setId("P" + idGenerator++);
        int childIdGenerator = 1;
        for (WebPage childWebPage : webPage.getChildWebPages()) {
            childWebPage.setId(webPage.getId() + "_C_" + childIdGenerator++);
        }
        pageIdToWebPageMap.put(webPage.getId(), webPage);
    }

    @Override
    public WebPage getWebPage(String id) {
        return pageIdToWebPageMap.get(id);
    }
}

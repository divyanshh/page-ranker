package com.navi.assignment.service;

import com.navi.assignment.model.WebPage;

public interface WebPageService {

    void addWebPage(WebPage webPage);

    WebPage getWebPage(String id);

}

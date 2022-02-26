package com.learn.spring.spring.selenium.page.google;


import com.learn.spring.spring.selenium.annotations.Page;
import com.learn.spring.spring.selenium.page.Base;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Page
public class GooglePage extends Base{

    @Autowired
    private ResultPage resultPage;

    @Autowired
    private SearchPage searchPage;

    public ResultPage getResultPage() {
        return resultPage;
    }

    public SearchPage getSearchPage() {
        return searchPage;
    }

    @Override
    public boolean isAt() {
        return this.searchPage.isAt();
    }

    public void close(){
        this.driver.quit();
    }


}

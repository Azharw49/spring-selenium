package com.learn.spring.spring.selenium.googleTest;

import com.learn.spring.spring.selenium.SpringBaseTestNGTest;
import com.learn.spring.spring.selenium.page.google.GooglePage;
import com.learn.spring.spring.selenium.service.ScreenshotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class GoogleTest2 extends SpringBaseTestNGTest {

    @Autowired
    GooglePage googlePage;

    @Lazy
    @Autowired
    ScreenshotService screenshotService;

    @Test
    public void searchResult() throws IOException {
        this.googlePage.goTo();
        Assert.assertTrue(this.googlePage.getSearchPage().isAt());
        this.googlePage.getSearchPage().searchText("Spring");
        Assert.assertTrue(this.googlePage.getResultPage().isAt());
        Assert.assertTrue(this.googlePage.getResultPage().getResultCount()>2);
        this.screenshotService.takeScreenshot();
        this.googlePage.close();

    }
    
}

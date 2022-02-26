package com.learn.spring.spring.selenium.windowTest;

import com.learn.spring.spring.selenium.SpringBaseTestNGTest;
import com.learn.spring.spring.selenium.page.window.MainPage;
import com.learn.spring.spring.selenium.page.window.PageA;
import com.learn.spring.spring.selenium.page.window.PageB;
import com.learn.spring.spring.selenium.page.window.PageC;
import com.learn.spring.spring.selenium.service.WindowSwitchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.TestPropertySource;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@TestPropertySource("classpath:application.properties")
public class WindowTest extends SpringBaseTestNGTest {

    @Autowired
    MainPage mainPage;

    @Autowired
    WindowSwitchService windowSwitchService;

    @Autowired
    PageA pageA;

    @Autowired
    PageB pageB;

    @Autowired
    PageC pageC;

    public static final Logger LOG = LoggerFactory.getLogger(WindowTest.class);

    @BeforeClass
    public void openAllPages(){
        mainPage.goTo("https://vins-udemy.s3.amazonaws.com/ds/window/main.html");
        mainPage.isAt();
        mainPage.clickLinks();

    }

    @Test
    public void enterTestData(){
        pageA.isAt();
        LOG.info("Switched to Page A");
        Assert.assertEquals(pageA.getDriver().getTitle(),"Page A");
        pageA.addText("2");
        pageB.isAt();
        LOG.info("Switched to Page B");
        Assert.assertEquals(pageB.getDriver().getTitle(),"Page B");
        pageB.addText("2");
        pageC.isAt();
        LOG.info("Switched to Page C");
        Assert.assertEquals(pageC.getDriver().getTitle(),"Page C");
        pageC.addText("2");

    }

    @AfterClass
    public void after(){
        pageC.closeBrowser();
    }



}

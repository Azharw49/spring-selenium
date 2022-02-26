package com.learn.spring.spring.selenium.page;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public abstract class Base {

    @Autowired
    protected WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    @Autowired
    protected WebDriverWait wait;

    @Value("${url:https://www.google.com/}")
    private String url;

    @PostConstruct
    public void init()
    {
        PageFactory.initElements(driver,this);
    }

    public void goTo(){
        driver.get(url);
        driver.manage().window().maximize();
    }

    public void goTo(String url){
        driver.get(url);
        driver.manage().window().maximize();
    }

    public abstract boolean isAt();


}

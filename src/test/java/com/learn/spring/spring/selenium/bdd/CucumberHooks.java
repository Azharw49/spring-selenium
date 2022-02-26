package com.learn.spring.spring.selenium.bdd;

import com.learn.spring.spring.selenium.service.ScreenshotService;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

public class CucumberHooks {

    @Autowired
    private ApplicationContext ctx;

    Scenario scenario;

    @Autowired
    ScreenshotService screenshotService;

    @After
    public void takeScreenshot(Scenario scenario){
        //if(scenario.isFailed()){
            this.scenario = scenario;
            scenario.log("Failed : " + scenario.getName());
            this.scenario.attach(this.screenshotService.takeSceenshotAsBytes(),"image/png",scenario.getName());
        //}
        this.ctx.getBean(WebDriver.class).quit();
    }

}

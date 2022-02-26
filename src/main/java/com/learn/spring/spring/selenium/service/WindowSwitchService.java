package com.learn.spring.spring.selenium.service;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Lazy
@Service
public class WindowSwitchService {

    @Autowired
    ApplicationContext ctx;

    public void switchWindowByTitle(String title){
        WebDriver driver=this.ctx.getBean(WebDriver.class);
        driver.getWindowHandles().stream()
                .map(handle -> driver.switchTo().window(handle).getTitle())
                .filter(t -> t.startsWith(title))
                .findFirst();
    }

    public void  switchWindowByIndex(int index){
        WebDriver driver=this.ctx.getBean(WebDriver.class);
        String[] handles = driver.getWindowHandles().toArray(new String[0]);
        driver.switchTo().window(handles[index]);
    }

}

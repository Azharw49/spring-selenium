package com.learn.spring.spring.selenium.aop;

import com.learn.spring.spring.selenium.annotations.Window;
import com.learn.spring.spring.selenium.service.WindowSwitchService;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class WindowAspect {

    @Autowired
    WindowSwitchService windowSwitchService;

    @Before("@target(window) && within(com.learn.spring.spring.selenium..*)")
    public void before(Window window){
        this.windowSwitchService.switchWindowByTitle(window.value());
    }

    /*@After("@target(window) && within(com.learn.spring.spring.selenium..*)")
    public void after(Window window){
        this.windowSwitchService.switchWindowByIndex(0);
    }*/
}

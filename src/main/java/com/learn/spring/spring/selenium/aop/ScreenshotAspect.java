package com.learn.spring.spring.selenium.aop;


import com.learn.spring.spring.selenium.annotations.TakeScreenshot;
import com.learn.spring.spring.selenium.service.ScreenshotService;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Aspect
public class ScreenshotAspect {

    @Autowired
    ScreenshotService screenshotService;

    @After("@annotation(takeScreenshot)")
    public void after(TakeScreenshot takeScreenshot ) throws IOException {
        this.screenshotService.takeScreenshot();

    }
}

package com.learn.spring.spring.selenium.service;


import com.github.javafaker.Faker;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Lazy
@Service
public class ScreenshotService {

    @Autowired
    ApplicationContext ctx;

    @Autowired
    Faker faker;

    @Value("${screenshot.path}/")
    private String screenshotPath;

    public void takeScreenshot() throws IOException {
        File SrcFile = this.ctx.getBean(TakesScreenshot.class).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(SrcFile,new File(screenshotPath+faker.number().digits(6)+".png"));

    }

    public byte[] takeSceenshotAsBytes() {
       return this.ctx.getBean(TakesScreenshot.class).getScreenshotAs(OutputType.BYTES);
    }


}

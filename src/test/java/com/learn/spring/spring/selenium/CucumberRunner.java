package com.learn.spring.spring.selenium;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "classpath:features",
        glue = "com.learn.spring.spring.selenium.bdd",
        //tags = "@google",
        plugin = {
                "json:target/cucumber.json"
        }
)
public class CucumberRunner extends AbstractTestNGCucumberTests {

        @DataProvider(parallel = true)
        @Override
        public Object[][] scenarios() {
                return super.scenarios();
        }
}

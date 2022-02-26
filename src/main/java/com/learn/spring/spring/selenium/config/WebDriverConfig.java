package com.learn.spring.spring.selenium.config;


import com.learn.spring.spring.selenium.annotations.LazyConfiguration;
import com.learn.spring.spring.selenium.annotations.ThreadScope;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

@LazyConfiguration
public class WebDriverConfig {


    @ThreadScope
    @ConditionalOnProperty(name = "browser", havingValue = "firefox")
    public WebDriver firefoxDriver() {
        WebDriverManager.firefoxdriver().driverVersion("0.30.0").setup();
        return new FirefoxDriver();
    }


    @ThreadScope
    @ConditionalOnProperty(name = "browser", havingValue = "chrome")
    public WebDriver chromeDriver()
    {
        WebDriverManager.chromedriver().driverVersion("98.0.4758.102").setup();
        return new ChromeDriver();
    }

}

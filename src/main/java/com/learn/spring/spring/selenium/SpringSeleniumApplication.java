package com.learn.spring.spring.selenium;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:${propertyFile:application}.properties")
@PropertySource(value = "classpath:input/foo.yml", factory = YamlPropertySourceFactory.class)
public class SpringSeleniumApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSeleniumApplication.class, args);
	}

}

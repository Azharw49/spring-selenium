package com.learn.spring.spring.selenium.config;

import com.github.javafaker.Faker;
import com.learn.spring.spring.selenium.annotations.LazyConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@LazyConfiguration
public class FakerConfig {

    @Bean
    public Faker getFaker()
    {
        return new Faker();
    }


}

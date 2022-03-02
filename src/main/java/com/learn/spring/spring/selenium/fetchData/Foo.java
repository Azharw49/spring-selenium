package com.learn.spring.spring.selenium.fetchData;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "yaml")
public class Foo {

    private String name;
    List<String> aliases;
    Map<String ,String> keyMapping;

    public Map<String, String> getKeyMapping() {
        return keyMapping;
    }

    public void setKeyMapping(Map<String, String> keyMapping) {
        this.keyMapping = keyMapping;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getAliases() {
        return aliases;
    }

    public void setAliases(List<String> aliases) {
        this.aliases = aliases;
    }
}

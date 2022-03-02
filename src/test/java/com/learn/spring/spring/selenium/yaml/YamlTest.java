package com.learn.spring.spring.selenium.yaml;

import com.learn.spring.spring.selenium.SpringBaseTestNGTest;
import com.learn.spring.spring.selenium.fetchData.Foo;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

public class YamlTest extends SpringBaseTestNGTest {

    @Autowired
    Foo foo;

    @Test
    public void fetchDataFromYml(){
        System.out.println(foo.getName());
        System.out.println(foo.getAliases());
        System.out.println(foo.getKeyMapping());
    }
}

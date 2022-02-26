package com.learn.spring.spring.selenium.page.google;

import com.learn.spring.spring.selenium.annotations.Page;
import com.learn.spring.spring.selenium.page.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Page
public class ResultPage extends Base {

    @FindBy(xpath = "//div[@class='g tF2Cxc']")
    private List<WebElement> resultList;

    public int getResultCount(){
       return this.resultList.size();
    }

    @Override
    public boolean isAt() {
        return wait.until(d -> !this.resultList.isEmpty());
    }
}

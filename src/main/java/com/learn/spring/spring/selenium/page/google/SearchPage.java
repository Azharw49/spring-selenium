package com.learn.spring.spring.selenium.page.google;

import com.learn.spring.spring.selenium.annotations.Page;
import com.learn.spring.spring.selenium.page.Base;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Page
public class SearchPage  extends Base {

    @FindBy(name="q")
    private WebElement textArea;

    @FindBy(name="btnK")
    private List<WebElement> btnList;


    @Override
    public boolean isAt() {
        return wait.until(d -> this.textArea.isDisplayed());
    }

    public void searchText(String input){
        this.textArea.sendKeys(input);
        this.textArea.sendKeys(Keys.TAB);
        this.btnList.stream()
                    .filter(e -> e.isDisplayed() && e.isEnabled())
                    .findFirst()
                    .ifPresent(e -> e.click());
    }
}

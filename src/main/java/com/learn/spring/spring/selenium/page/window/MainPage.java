package com.learn.spring.spring.selenium.page.window;

import com.learn.spring.spring.selenium.annotations.Page;
import com.learn.spring.spring.selenium.page.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

@Page
public class MainPage extends Base {



    @FindBy(tagName = "a")
    private List<WebElement> links;


    @Override
    public boolean isAt() {
        return wait.until(d -> !this.links.isEmpty());
    }

    public void clickLinks(){
        int i=1;
       for(WebElement ele:links){
           ele.click();
           this.wait.until(ExpectedConditions.numberOfWindowsToBe(i+1));
           i++;
       }
    }
}

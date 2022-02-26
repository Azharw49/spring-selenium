package com.learn.spring.spring.selenium.page.window;

import com.learn.spring.spring.selenium.annotations.Page;
import com.learn.spring.spring.selenium.annotations.TakeScreenshot;
import com.learn.spring.spring.selenium.annotations.Window;
import com.learn.spring.spring.selenium.page.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.security.PublicKey;

@Window("Page C")
public class PageC extends Base {



    @FindBy(tagName = "textarea")
    private WebElement textArea;


    @Override
    public boolean isAt() {
        return wait.until(d -> this.textArea.isEnabled());
    }

    @TakeScreenshot
    public void addText(String num)
    {
        this.textArea.sendKeys(num);
    }

    public  void closeBrowser(){
        this.driver.quit();
    }

}

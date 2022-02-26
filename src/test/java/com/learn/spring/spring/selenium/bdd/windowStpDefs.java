package com.learn.spring.spring.selenium.bdd;

import com.learn.spring.spring.selenium.page.google.GooglePage;
import com.learn.spring.spring.selenium.page.window.MainPage;
import com.learn.spring.spring.selenium.page.window.PageA;
import com.learn.spring.spring.selenium.page.window.PageB;
import com.learn.spring.spring.selenium.page.window.PageC;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.testng.Assert;

public class windowStpDefs {

    @Autowired
    MainPage mainPage;

    @Autowired
    PageA pageA;

    @Autowired
    PageB pageB;

    @Autowired
    PageC pageC;

    @Autowired
    ApplicationContext ctx;

    @Given("the user open {string}")
    public void the_user_open_something(String url)  {
        this.mainPage.goTo(url);
        Assert.assertTrue(this.mainPage.isAt());
        
    }

    @When("the user click all links")
    public void the_user_click_all_links()  {
        this.mainPage.clickLinks();
        
    }

    @And("the user switch to {string}")
    public void the_user_switch_to_something(String page)  {
        if(page.equalsIgnoreCase("Page A")) {
            Assert.assertTrue(this.pageA.isAt());
        }else if(page.equalsIgnoreCase("Page B")) {
            Assert.assertTrue(this.pageB.isAt());
        }else if(page.equalsIgnoreCase("Page C")) {
            Assert.assertTrue(this.pageC.isAt());
        }

    }

    @Then("the title of the page should be {string}")
    public void the_title_of_the_page_should_be_something(String pageTitle)  {
       Assert.assertEquals(this.ctx.getBean(WebDriver.class).getTitle(),pageTitle);
    }


}

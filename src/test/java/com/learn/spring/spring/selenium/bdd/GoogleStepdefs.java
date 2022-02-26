package com.learn.spring.spring.selenium.bdd;

import com.learn.spring.spring.selenium.page.google.GooglePage;
import com.learn.spring.spring.selenium.service.ScreenshotService;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.testng.Assert;

@SpringBootTest
@CucumberContextConfiguration
public class GoogleStepdefs {

    private static final Logger LOG = LoggerFactory.getLogger(GoogleStepdefs.class);
    private Scenario scenario;


    @Autowired
    GooglePage googlePage;

    @Autowired
    ApplicationContext ctx;

    @Before
    public void before(Scenario scenario) {
        this.scenario = scenario;
    }



    @Given("I am on Google Page")
    public void i_am_on_google_page()  {

        googlePage.goTo("https://www.google.com/");
        this.scenario.log("Navigated to google home Page");
        this.scenario.attach(this.ctx.getBean(ScreenshotService.class).takeSceenshotAsBytes(),"image/png",scenario.getName());
    }

    @When("I enter the {string} text")
    public void i_enter_the_something_text(String search)  {
        googlePage.getSearchPage().searchText(search);
        this.scenario.log("Entered the text : " + search);

    }

    @And("I click on the Search Button")
    public void i_click_on_the_search_button()  {
        Assert.assertTrue(googlePage.getResultPage().isAt());
    }

    @Then("the number of results should be greater than {int}")
    public void the_number_of_results_should_be_greater_than(int count )  {
        this.scenario.log("checking the Count");
        this.scenario.log("Actual Count : " + googlePage.getResultPage().getResultCount());
        LOG.info("Actual Count : " + googlePage.getResultPage().getResultCount() );
        Assert.assertTrue(googlePage.getResultPage().getResultCount() >= count);

    }


}

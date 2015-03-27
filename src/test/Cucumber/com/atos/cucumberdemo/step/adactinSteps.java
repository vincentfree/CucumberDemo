package com.atos.cucumberdemo.step;


import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import javafx.beans.binding.Bindings;
import org.apache.bcel.generic.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Map;

/**
 * Created by VincentFree on 27-3-2015.
 */


public class adactinSteps {
    private final WebDriver webDriver;
    private Map<String,String> table;
    public adactinSteps(SharedDriver webDriver) {
        this.webDriver = webDriver;
        //this.driver = new driver;
    }

    @Given("^I am on the adactin site$")
    public void I_am_on_the_adactin_site() throws Throwable {
        webDriver.get("http://adactin.com/HotelAppBuild2/");
    }

    @When("^I log in with my credentials$")
    public void I_log_in_with_my_credentials() throws Throwable {
        WebElement element = webDriver.findElement(By.id("username"));
        element.sendKeys("TestlabCucumberDemo");
        element = webDriver.findElement(By.id("password"));
        element.sendKeys("testlabcucumberdemo");
        element = webDriver.findElement(By.id("login"));
        element.click();
    }

    @Then("^I am logged in$")
    public void I_am_logged_in() throws Throwable {
        WebElement element = webDriver.findElement(By.id("username_show"));
        String WelcomeText = "Hello TestlabCucumberDemo!";
        WelcomeText.equals(element.getText());
    }

    @When("^I log in with the wrong credentials$")
    public void I_log_in_with_the_wrong_credentials() throws Throwable {
        WebElement element = webDriver.findElement(By.id("username"));
        element.sendKeys("TestlabFout");
        element = webDriver.findElement(By.id("password"));
        element.sendKeys("testlabFout");
        element = webDriver.findElement(By.id("login"));
        element.click();
    }

    @Then("^I should get a message$")
    public void I_should_get_a_message() {
        WebElement element = webDriver.findElement(By.className("auth_error"));
        String InvalidLogin = "Invalid Login Details";
        InvalidLogin.equals(element.getText());
    }

   /* @When("^I fill out \"([^\"]*)\" with \"([^\"]*)\"$")
    public void I_fill_out_with(String dorpdown, String choice) {
        WebElement element = webDriver.findElement(By.id(dorpdown.toLowerCase()));
        element.click();
        element.findElement(By.xpath(choice)).click();
        element.findElement(By.id("Submit")).click();
    }*/

    @And("^the day that I check in is \"([^\"]*)\" days from now$")
    public void the_day_that_I_check_in_is_days_from_now(String arg1) throws Throwable {

    }

    @And("^the day that I check out is \"([^\"]*)\" days from now$")
    public void the_day_that_I_check_out_is_days_from_now(String arg1) throws Throwable {

    }

    @Then("^the search results in an error message$")
    public void the_search_results_in_an_error_message() throws Throwable {
       System.out.println("is goed");
    }

}

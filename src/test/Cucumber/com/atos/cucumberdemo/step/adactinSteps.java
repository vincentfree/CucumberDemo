package com.atos.cucumberdemo.step;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.time.DateUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import static org.junit.Assert.assertEquals;

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
        webDriver.findElement(By.id("username")).sendKeys("TestlabCucumberDemo");
        webDriver.findElement(By.id("password")).sendKeys("testlabcucumberdemo");
        webDriver.findElement(By.id("login")).click();
    }

    @Then("^I am logged in$")
    public void I_am_logged_in() throws Throwable {
        WebElement element = webDriver.findElement(By.id("username_show"));
        String WelcomeText = "Hello TestlabCucumberDemo!";
        WelcomeText.equals(element.getText());
    }

    @When("^I log in with the wrong credentials$")
    public void I_log_in_with_the_wrong_credentials() throws Throwable {
        webDriver.findElement(By.id("username")).sendKeys("TestlabFout");
        webDriver.findElement(By.id("password")).sendKeys("Foutje");
        webDriver.findElement(By.id("login")).click();
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
    public void the_day_that_I_check_in_is_days_from_now(int days) throws Throwable {
        WebElement element = webDriver.findElement(By.xpath("//input[@id='datepick_in']"));
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String today = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        java.util.Date mydate = format.parse(today);
        mydate = DateUtils.addDays(mydate, days);
        String inputdate = new SimpleDateFormat("dd/MM/yyyy").format(mydate);
        element.clear();
        element.sendKeys(inputdate);
    }

    @And("^the day that I check out is \"([^\"]*)\" days from now$")
    public void the_day_that_I_check_out_is_days_from_now(int days) throws Throwable {
        WebElement element = webDriver.findElement(By.xpath("//input[@id='datepick_out']"));
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String today = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        java.util.Date mydate = format.parse(today);
        mydate = DateUtils.addDays(mydate, days);
        String inputdate = new SimpleDateFormat("dd/MM/yyyy").format(mydate);
        element.clear();
        element.sendKeys(inputdate);
    }

    @Then("^the search results in an error message$")
    public void the_search_results_in_an_error_message() throws Throwable {
        webDriver.findElement(By.id("Submit")).click();
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkin_span")));
        WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkout_span")));
        assertEquals("Check-In Date shall be before than Check-Out Date", element.getText());
        assertEquals("Check-Out Date shall be after than Check-In Date",element1.getText());
    }

    @When("^I set the location to \"([^\"]*)\"$")
    public void I_set_the_location_to(String location) throws Throwable {
        WebElement element = webDriver.findElement(By.id("location"));
        element.click();
        //element.findElement(By.xpath("//select[@id='location']/option[text()='"+location+"']")).click();
        element.findElement(By.id("location")).click();
        element.sendKeys(location);
    }

    @And("^I select Hotel \"([^\"]*)\"$")
    public void I_select_Hotel(String hotels) throws Throwable {
        WebElement element = webDriver.findElement(By.id("hotels"));
        element.click();
        element.sendKeys(hotels);
    }

    @And("^I select Room type \"([^\"]*)\"$")
    public void I_select_Room_type(String room) throws Throwable {
        WebElement element = webDriver.findElement(By.id("room_type"));
        element.click();
        element.sendKeys(room);
    }

    @And("^I select the number of rooms \"([^\"]*)\"$")
    public void I_select_the_number_of_rooms(String room) throws Throwable {
        WebElement element = webDriver.findElement(By.id("room_nos"));
        if (room == "1" && (element.getAttribute("value").contains("One")|| element.getAttribute("value").contains("1"))){

        }
        else {
            element.click();
            element.sendKeys(room);
        }
    }

    @And("^I select the amount of adults \"([^\"]*)\"$")
    public void I_select_the_amount_of_adults(String adult) throws Throwable {
        WebElement element = webDriver.findElement(By.id("adult_room"));
        if (adult == "1" && (element.getAttribute("value").contains("One")|| element.getAttribute("value").contains("1"))){

        }
        else {
            element.click();
            element.sendKeys(adult);
        }
    }
}

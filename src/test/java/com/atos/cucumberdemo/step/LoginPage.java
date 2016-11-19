package com.atos.cucumberdemo.step;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by nerom on 19-11-2016.
 */
public class LoginPage {
    private final WebDriver webDriver;
    WebDriverWait wait;

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        wait = new WebDriverWait(webDriver, 3);
    }

    @FindBy(id ="username")
    private WebElement username;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "login")
    private WebElement loginButton;


    public LoginPage enterUserName(String user) {
        wait.until(ExpectedConditions.visibilityOf(username));
        username.sendKeys(user);
        return this;
    }

    public LoginPage enterPassword(String pass) {
        wait.until(ExpectedConditions.visibilityOf(password));
        password.sendKeys(pass);
        return this;
    }

    public LoginPage logInAsUser() {
        wait.until(ExpectedConditions.visibilityOf(loginButton));
        loginButton.click();
        return this;
    }
}

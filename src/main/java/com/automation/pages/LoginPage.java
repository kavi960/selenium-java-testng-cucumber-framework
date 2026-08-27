package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    // Locators
    private final By userName = By.id("user-name");
    private final By passWord = By.id("password");
    private final By loginBtn = By.id("login-button");

    // Constructor
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    // Page Actions
    public void enterUsername(String username) {
        type(userName, username);
    }

    public void enterPassword(String password) {
        type(passWord, password);
    }

    public void clickLogin() {
        click(loginBtn);
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }
}

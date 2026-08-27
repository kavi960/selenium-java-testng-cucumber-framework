package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.automation.utilities.WaitUtility;


public class BasePage {

    protected WebDriver driver;

    protected WaitUtility waitUtility;


    public BasePage(WebDriver driver) {

        this.driver = driver;

        waitUtility = new WaitUtility(driver);

    }


    public void click(By locator) {

        WebElement element = driver.findElement(locator);

        waitUtility.waitForElementClickable(element);

        element.click();

    }


    public void type(By locator, String text) {

        WebElement element = driver.findElement(locator);

        waitUtility.waitForElementVisible(element);

        element.clear();

        element.sendKeys(text);

    }


    public String getText(By locator) {

        return driver.findElement(locator).getText();

    }


    public boolean isDisplayed(By locator) {

        return driver.findElement(locator).isDisplayed();

    }


    public String getPageTitle() {

        return driver.getTitle();

    }

}
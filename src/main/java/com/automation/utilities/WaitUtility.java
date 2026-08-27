package com.automation.utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {

    private WebDriverWait wait;


    public WaitUtility(WebDriver driver) {

        wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(10)
        );

    }


    public void waitForElementVisible(WebElement element) {

        wait.until(
                ExpectedConditions.visibilityOf(element)
        );

    }


    public void waitForElementClickable(WebElement element) {

        wait.until(
                ExpectedConditions.elementToBeClickable(element)
        );

    }

}
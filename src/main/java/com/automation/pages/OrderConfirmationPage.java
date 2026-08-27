package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderConfirmationPage extends BasePage{
    public OrderConfirmationPage (WebDriver driver)
    {
        super(driver);
    }

    private final By CheckoutTitle = By.className("complete-header");
    private final By ConfirmationMessage= By.xpath("//h2[text()='Thank you for your order!']");



    public String getConfirmationMessage() {

        return getText(ConfirmationMessage);

    }
}

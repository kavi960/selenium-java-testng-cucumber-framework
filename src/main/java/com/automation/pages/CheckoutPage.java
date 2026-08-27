package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    private final By checkoutTitle =
            By.className("title");

    private final By firstName =
            By.id("first-name");

    private final By lastName =
            By.id("last-name");

    private final By postalCode =
            By.id("postal-code");

    private final By continueButton =
            By.id("continue");


    public boolean isCheckoutPageDisplayed() {
        return isDisplayed(checkoutTitle);
    }


    public void enterCustomerInformation(
            String firstNameValue,
            String lastNameValue,
            String postalCodeValue) {

        System.out.println("Entering first name: " + firstNameValue);
        type(firstName, firstNameValue);

        System.out.println("Entering last name: " + lastNameValue);
        type(lastName, lastNameValue);

        System.out.println("Entering postal code: " + postalCodeValue);
        type(postalCode, postalCodeValue);

        System.out.println("Finished entering customer information");
    }


    public void clickContinue() {
        click(continueButton);
    }
}
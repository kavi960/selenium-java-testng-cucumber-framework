package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    // Cart page title
    private final By cartTitle =
            By.className("title");

    // Products displayed in cart
    private final By cartProducts =
            By.className("inventory_item_name");

    // Checkout button
    private final By checkoutButton =
            By.id("checkout");

    public boolean isCartPageDisplayed() {

        return isDisplayed(cartTitle);

    }

    public int getCartProductCount() {

        return driver.findElements(cartProducts).size();

    }

    public void clickCheckout() {

        click(checkoutButton);

    }

}
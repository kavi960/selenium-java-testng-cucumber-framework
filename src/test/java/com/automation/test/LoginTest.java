package com.automation.test;

import com.automation.hooks.TestListener;
import org.testng.annotations.Listeners;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.base.BaseTest;
import com.automation.pages.CartPage;
import com.automation.pages.CheckoutPage;
import com.automation.pages.LoginPage;
import com.automation.pages.ProductsPage;
import com.automation.pages.CheckoutOverviewPage;
import com.automation.pages.OrderConfirmationPage;
import com.automation.testdata.TestData;
import com.automation.data.TestDataProvider;

@Listeners(TestListener.class)
public class LoginTest extends BaseTest {


    @Test(dataProvider = "loginData",
            dataProviderClass = TestDataProvider.class)
    public void verifyLogin(TestData data) {

        // Create page objects
        LoginPage loginPage =
                new LoginPage(driver);

        ProductsPage productsPage =
                new ProductsPage(driver);

        // Login using Excel data
        loginPage.login(
                data.getUsername(),
                data.getPassword()
        );
        // Verify login
        Assert.assertTrue(
                driver.getCurrentUrl().contains("inventory"));

        // Verify Products page
        Assert.assertTrue(
                productsPage.isProductsPageDisplayed(),
                "Products page is not displayed"
        );

        // Print all products
        productsPage.printAllProducts();

        // Add all products to cart
        productsPage.addAllProductsToCart();

        // Open Cart
        productsPage.openCart();

        // Create CartPage
        CartPage cartPage =
                new CartPage(driver);

        // Verify Cart page
        Assert.assertTrue(
                cartPage.isCartPageDisplayed(),
                "Cart page is not displayed"
        );

        // Get number of products
        int cartProductCount =
                cartPage.getCartProductCount();

        System.out.println(
                "Products in cart: "
                        + cartProductCount
        );

        // Verify 6 products
        Assert.assertEquals(
                cartProductCount,
                6,
                "Incorrect number of products in cart"
        );

        // =========================
        // CHECKOUT
        // =========================

        // Click Checkout
        cartPage.clickCheckout();

        // Create CheckoutPage
        CheckoutPage checkoutPage =
                new CheckoutPage(driver);

        // Verify Checkout page
        Assert.assertTrue(
                checkoutPage.isCheckoutPageDisplayed(),
                "Checkout page is not displayed"
        );

        // Enter customer information
        checkoutPage.enterCustomerInformation(
                data.getFirstName(),
                data.getLastName(),
                data.getPostalCode()
        );
        // Continue
        checkoutPage.clickContinue();
        System.out.println("Current URL: " + driver.getCurrentUrl());
        System.out.println("Current Title: " + driver.getTitle());

        CheckoutOverviewPage overviewPage =
                new CheckoutOverviewPage(driver);

        Assert.assertTrue(
                overviewPage.isOverviewPageDisplayed(),
                "Checkout overview page is not displayed"
        );
        overviewPage.clickFinish();

        OrderConfirmationPage orderConfirmationPage =
                new OrderConfirmationPage(driver);

        String actualMessage =
                orderConfirmationPage.getConfirmationMessage();

        Assert.assertEquals(
                actualMessage,
                "Thank you for your order!",
                "Order confirmation message is incorrect"
        );
    }
}
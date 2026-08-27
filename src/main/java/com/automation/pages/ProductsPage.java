package com.automation.pages;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsPage extends BasePage{

    public ProductsPage(WebDriver driver)
    {
        super(driver);
    }

    // Page title
    private final By pageTitle =
            By.className("title");


    // All products
    private final By products =
            By.className("inventory_item");

    // Product names
    private final By productNames =
            By.className("inventory_item_name");


    // Cart button
    private final By cartButton =
            By.className("shopping_cart_link");


    //specific product using parent-child relationship
    private By addProduct(String productName)
    {
        return By.xpath(
                "//div[text()='"+productName+"']" +
                        "/ancestor::div[@class='inventory_item']//button"
        );


    }
    public boolean isProductsPageDisplayed(){

        return isDisplayed(pageTitle);

    }


    public void addProductToCart(String productName){

        click(addProduct(productName));

    }


    public void openCart(){

        click(cartButton);

    }

    public void printAllProducts() {

        List<WebElement> products =
                driver.findElements(productNames);


        for(WebElement product : products) {

            System.out.println(product.getText());

        }

    }

    public void addAllProductsToCart() {

        List<WebElement> productList =
                driver.findElements(products);


        for(WebElement product : productList) {

            product.findElement(By.tagName("button")).click();

        }

    }

}

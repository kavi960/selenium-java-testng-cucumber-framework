package com.automation.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage extends BasePage {
    public CheckoutOverviewPage(WebDriver driver)
    {
     super(driver);
    }
    private final By overviewTitle = By.className("title");
    private final By finishButton = By.id("finish");

    public boolean isOverviewPageDisplayed()
    {
        return isDisplayed(overviewTitle);
    }

    public void clickFinish()
    {
        click(finishButton);
    }
}

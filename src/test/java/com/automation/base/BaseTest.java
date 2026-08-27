package com.automation.base;
import com.automation.hooks.TestListener;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import com.automation.factory.DriverFactory;
import com.automation.utilities.ConfigReader;



@Listeners(TestListener.class)
public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {

        // Get browser from config.properties
        String browser =
                ConfigReader.getProperty("browser");

        // Start browser
        driver =
                DriverFactory.initializeDriver(browser);

        // Get application URL
        String url =
                ConfigReader.getProperty("url");

        // Open application
        driver.get(url);
    }

    @AfterMethod
    public void tearDown() {

        // Close browser after every test
        DriverFactory.quitDriver();
    }
}

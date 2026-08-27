package com.automation.factory;

import java.time.Duration;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.automation.utilities.ConfigReader;

public class DriverFactory {

    private static final ThreadLocal<WebDriver> driver =
            new ThreadLocal<>();

    public static WebDriver initializeDriver(String browser) {

        System.out.println("Launching browser: " + browser);

        switch (browser.toLowerCase()) {

            case "chrome":

                ChromeOptions options = new ChromeOptions();

                // Disable Chrome Password Manager
                options.setExperimentalOption(
                        "prefs",
                        Map.of(
                                "credentials_enable_service", false,
                                "profile.password_manager_enabled", false,
                                "profile.password_manager_leak_detection", false
                        )
                );

                driver.set(new ChromeDriver(options));

                break;

            case "firefox":

                driver.set(new FirefoxDriver());

                break;

            default:

                throw new IllegalArgumentException(
                        "Browser not supported: " + browser
                );
        }

        // Maximize browser
        driver.get().manage().window().maximize();

        // Read implicit wait from config.properties
        int implicitWait = Integer.parseInt(
                ConfigReader.getProperty("implicitWait")
        );

        // Read page load timeout from config.properties
        int pageLoadTimeout = Integer.parseInt(
                ConfigReader.getProperty("pageLoadTimeout")
        );

        // Set implicit wait
        driver.get().manage().timeouts().implicitlyWait(
                Duration.ofSeconds(implicitWait)
        );

        // Set page load timeout
        driver.get().manage().timeouts().pageLoadTimeout(
                Duration.ofSeconds(pageLoadTimeout)
        );

        System.out.println(
                "Implicit Wait: " + implicitWait + " seconds"
        );

        System.out.println(
                "Page Load Timeout: " + pageLoadTimeout + " seconds"
        );

        // Return WebDriver
        return driver.get();
    }

    public static WebDriver getDriver() {

        return driver.get();
    }

    public static void quitDriver() {

        if (driver.get() != null) {

            driver.get().quit();

            driver.remove();
        }
    }
}
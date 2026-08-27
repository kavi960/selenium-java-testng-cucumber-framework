package com.automation.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtility {

    public static String captureScreenshot(
            WebDriver driver,
            String testName) {

        String timestamp =
                new SimpleDateFormat("yyyyMMdd_HHmmss")
                        .format(new Date());

        String screenshotPath =
                "test-output/screenshots/"
                        + testName
                        + "_"
                        + timestamp
                        + ".png";

        File source =
                ((TakesScreenshot) driver)
                        .getScreenshotAs(OutputType.FILE);

        File destination =
                new File(screenshotPath);

        try {

            FileUtils.copyFile(source, destination);

            System.out.println(
                    "Screenshot saved: "
                            + screenshotPath
            );

        } catch (IOException e) {

            throw new RuntimeException(
                    "Failed to save screenshot",
                    e
            );
        }

        return screenshotPath;
    }
}
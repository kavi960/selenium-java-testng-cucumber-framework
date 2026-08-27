package com.automation.hooks;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.automation.factory.DriverFactory;
import com.automation.reports.ExtentReportManager;
import com.automation.utilities.ScreenshotUtility;

public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {

        String testName =
                result.getMethod().getMethodName();

        ExtentReportManager.createTest(testName);

        ExtentReportManager.getTest()
                .info("Test execution started");
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        ExtentReportManager.getTest()
                .pass("Test passed successfully");

        ExtentReportManager.flushReport();
    }

    @Override
    public void onTestFailure(ITestResult result) {

        String testName =
                result.getMethod().getMethodName();

        ExtentReportManager.getTest()
                .fail("Test failed");

        ExtentReportManager.getTest()
                .fail(result.getThrowable());

        String screenshotPath =
                ScreenshotUtility.captureScreenshot(
                        DriverFactory.getDriver(),
                        testName
                );

        ExtentReportManager.getTest()
                .addScreenCaptureFromPath(screenshotPath);

        ExtentReportManager.flushReport();
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        ExtentReportManager.getTest()
                .skip("Test skipped");

        ExtentReportManager.flushReport();
    }
}
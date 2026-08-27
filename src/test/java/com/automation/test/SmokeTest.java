package com.automation.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.base.BaseTest;
import com.automation.factory.DriverFactory;


public class SmokeTest extends BaseTest {


    @Test
    public void verifyHomePageTitle() {


        String actualTitle =
                DriverFactory.getDriver().getTitle();


        System.out.println(
                "Title: " + actualTitle
        );


        Assert.assertEquals(
                actualTitle,
                "Swag Labs",
                "Homepage title mismatch!"
        );

    }

}
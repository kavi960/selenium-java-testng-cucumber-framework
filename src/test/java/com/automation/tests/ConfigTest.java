package com.automation.tests;

import org.testng.annotations.Test;
import com.automation.utilities.ConfigReader;

public class ConfigTest {


    @Test
    public void readConfig() {

        System.out.println(
            ConfigReader.getProperty("browser")
        );

        System.out.println(
            ConfigReader.getProperty("url")
        );

    }
}
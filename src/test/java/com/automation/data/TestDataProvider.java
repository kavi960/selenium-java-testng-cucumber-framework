package com.automation.data;

import com.automation.testdata.TestData;
import com.automation.testdata.TestDataReader;
import org.testng.annotations.DataProvider;

public class TestDataProvider {

    @DataProvider(name = "loginData")
    public static Object[][] loginData() {

        TestData tc001 =
                TestDataReader.getTestData("TC001");

        TestData tc002 =
                TestDataReader.getTestData("TC002");

        TestData tc003 =
                TestDataReader.getTestData("TC003");

        return new Object[][] {
                { tc001 },
                { tc002 },
                { tc003 }
        };
    }
}
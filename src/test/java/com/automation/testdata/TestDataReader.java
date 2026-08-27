package com.automation.testdata;

import com.automation.utilities.ExcelUtility;
import org.apache.poi.ss.usermodel.Row;

public class TestDataReader {

    private static final String FILE_PATH =
            "src/test/resources/testdata/TestData.xlsx";

    private static final String SHEET_NAME =
            "Sheet 1";


    public static TestData getTestData(String testCase) {

        ExcelUtility excel =
                new ExcelUtility(
                        FILE_PATH,
                        SHEET_NAME
                );

        try {

            // Find TestCase only ONCE
            Row testCaseRow =
                    excel.findTestCaseRow(testCase);


            // Read all data from the same row
            String username =
                    excel.getDataFromRow(
                            testCaseRow,
                            "Username"
                    );

            String password =
                    excel.getDataFromRow(
                            testCaseRow,
                            "Password"
                    );

            String firstName =
                    excel.getDataFromRow(
                            testCaseRow,
                            "FirstName"
                    );

            String lastName =
                    excel.getDataFromRow(
                            testCaseRow,
                            "LastName"
                    );

            String postalCode =
                    excel.getDataFromRow(
                            testCaseRow,
                            "PostalCode"
                    );


            return new TestData(
                    testCase,
                    username,
                    password,
                    firstName,
                    lastName,
                    postalCode
            );

        } finally {

            try {

                excel.closeWorkbook();

            } catch (Exception e) {

                throw new RuntimeException(
                        "Unable to close Excel workbook",
                        e
                );
            }
        }
    }
}
package com.automation.utilities;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;

public class ExcelUtility {

    private Workbook workbook;
    private Sheet sheet;

    // =========================================================
    // Constructor
    // =========================================================

    public ExcelUtility(String filePath, String sheetName) {

        try {

            FileInputStream fis =
                    new FileInputStream(filePath);

            workbook =
                    WorkbookFactory.create(fis);

            System.out.println(
                    "Excel file loaded successfully"
            );

            sheet =
                    workbook.getSheet(sheetName);

            if (sheet == null) {

                throw new RuntimeException(
                        "Sheet not found: " + sheetName
                );
            }

            System.out.println(
                    "Selected sheet: "
                            + sheet.getSheetName()
            );

            fis.close();

        } catch (Exception e) {

            throw new RuntimeException(
                    "Unable to load Excel file: "
                            + filePath,
                    e
            );
        }
    }


    // =========================================================
    // Find TestCase Row
    // =========================================================

    public Row findTestCaseRow(String testCase) {

        // Excel Row 1 = POI Row 0
        // Excel Row 2 = POI Row 1

        for (int i = 1;
             i <= sheet.getLastRowNum();
             i++) {

            Row row =
                    sheet.getRow(i);

            if (row == null) {
                continue;
            }

            // TestCase is column 0
            Cell testCaseCell =
                    row.getCell(0);

            if (testCaseCell == null) {
                continue;
            }

            String currentTestCase =
                    testCaseCell
                            .toString()
                            .trim();

            System.out.println(
                    "Checking TestCase: "
                            + currentTestCase
            );

            if (currentTestCase
                    .equalsIgnoreCase(testCase)) {

                return row;
            }
        }

        throw new RuntimeException(
                "Test case not found: "
                        + testCase
        );
    }


    // =========================================================
    // Find Column Number
    // =========================================================

    public int getColumnNumber(String columnName) {

        Row headerRow =
                sheet.getRow(0);

        if (headerRow == null) {

            throw new RuntimeException(
                    "Header row not found"
            );
        }

        for (int i = 0;
             i < headerRow.getLastCellNum();
             i++) {

            Cell cell =
                    headerRow.getCell(i);

            if (cell == null) {
                continue;
            }

            String header =
                    cell.toString().trim();

            if (header.equalsIgnoreCase(columnName)) {

                return i;
            }
        }

        throw new RuntimeException(
                "Column not found: "
                        + columnName
        );
    }


    // =========================================================
    // Get Data From Specific TestCase Row
    // =========================================================

    public String getDataFromRow(
            Row row,
            String columnName) {

        int columnNumber =
                getColumnNumber(columnName);

        Cell dataCell =
                row.getCell(columnNumber);

        if (dataCell == null) {
            return "";
        }

        // DataFormatter prevents values such as
        // 12345 becoming 12345.0
        DataFormatter formatter =
                new DataFormatter();

        String value =
                formatter
                        .formatCellValue(dataCell)
                        .trim();

        return value;
    }


    // =========================================================
    // Original getData Method
    // =========================================================

    public String getData(
            String testCase,
            String columnName) {

        Row row =
                findTestCaseRow(testCase);

        return getDataFromRow(
                row,
                columnName
        );
    }


    // =========================================================
    // Get Number Of Rows
    // =========================================================

    public int getRowCount() {

        return sheet.getLastRowNum() + 1;
    }


    // =========================================================
    // Get Number Of Columns
    // =========================================================

    public int getColumnCount() {

        Row headerRow =
                sheet.getRow(0);

        if (headerRow == null) {
            return 0;
        }

        return headerRow.getLastCellNum();
    }


    // =========================================================
    // Get Cell Data Directly
    // =========================================================

    public String getCellData(
            int rowNumber,
            int columnNumber) {

        Row row =
                sheet.getRow(rowNumber);

        if (row == null) {

            throw new RuntimeException(
                    "Row not found: "
                            + rowNumber
            );
        }

        Cell cell =
                row.getCell(columnNumber);

        if (cell == null) {
            return "";
        }

        DataFormatter formatter =
                new DataFormatter();

        return formatter
                .formatCellValue(cell)
                .trim();
    }


    // =========================================================
    // Print Entire Excel Sheet
    // =========================================================

    public void printSheet() {

        for (int i = 0;
             i <= sheet.getLastRowNum();
             i++) {

            Row row =
                    sheet.getRow(i);

            if (row == null) {
                continue;
            }

            for (int j = 0;
                 j < row.getLastCellNum();
                 j++) {

                Cell cell =
                        row.getCell(j);

                if (cell != null) {

                    DataFormatter formatter =
                            new DataFormatter();

                    System.out.print(
                            formatter
                                    .formatCellValue(cell)
                    );
                }

                System.out.print(" | ");
            }

            System.out.println();
        }
    }


    // =========================================================
    // Close Workbook
    // =========================================================

    public void closeWorkbook()
            throws Exception {

        if (workbook != null) {

            workbook.close();
        }
    }
}
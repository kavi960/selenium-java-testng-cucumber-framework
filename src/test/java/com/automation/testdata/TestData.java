package com.automation.testdata;

public class TestData {

    private String testCase;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String postalCode;

    public TestData(
            String testCase,
            String username,
            String password,
            String firstName,
            String lastName,
            String postalCode) {

        this.testCase = testCase;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.postalCode = postalCode;
    }

    public String getTestCase() {
        return testCase;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPostalCode() {
        return postalCode;
    }
}
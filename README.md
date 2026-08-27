# Selenium Java TestNG Automation Framework

A Selenium WebDriver automation framework built using **Java, Selenium WebDriver, TestNG, Maven, Apache POI, and Extent Reports**.

The framework follows the **Page Object Model (POM)** design pattern and supports data-driven testing using Excel.

## 🛠️ Technologies Used

* Java 21
* Selenium WebDriver 4.23.0
* TestNG 7.10.2
* Maven
* Apache POI
* Extent Reports
* Git & GitHub
* IntelliJ IDEA

## 📁 Project Structure

```text
SeleniumFramework
│
├── src
│   ├── main
│   │   └── java
│   │       └── com.automation
│   │           ├── factory
│   │           │   └── DriverFactory.java
│   │           │
│   │           ├── pages
│   │           │   ├── BasePage.java
│   │           │   ├── LoginPage.java
│   │           │   ├── ProductsPage.java
│   │           │   ├── CartPage.java
│   │           │   ├── CheckoutPage.java
│   │           │   ├── CheckoutOverviewPage.java
│   │           │   └── OrderConfirmationPage.java
│   │           │
│   │           └── utilities
│   │               ├── ConfigReader.java
│   │               ├── ExcelUtility.java
│   │               ├── ScreenshotUtility.java
│   │               └── WaitUtility.java
│   │
│   └── test
│       ├── java
│       │   └── com.automation
│       │       ├── base
│       │       │   └── BaseTest.java
│       │       │
│       │       ├── data
│       │       │   └── TestDataProvider.java
│       │       │
│       │       ├── hooks
│       │       │   └── TestListener.java
│       │       │
│       │       ├── test
│       │       │   ├── LoginTest.java
│       │       │   ├── SmokeTest.java
│       │       │   └── ExcelTest.java
│       │       │
│       │       └── testdata
│       │           ├── TestData.java
│       │           └── TestDataReader.java
│       │
│       └── resources
│           ├── config
│           │   └── config.properties
│           │
│           └── testdata
│               └── TestData.xlsx
│
├── pom.xml
├── testng.xml
├── .gitignore
└── README.md
```

## 🏗️ Framework Design

The framework follows the **Page Object Model (POM)** pattern.

### Page Objects

Each application page has a separate Java class containing:

* Web element locators
* Page-specific actions
* Reusable methods

For example:

```text
LoginPage
     ↓
ProductsPage
     ↓
CartPage
     ↓
CheckoutPage
     ↓
CheckoutOverviewPage
     ↓
OrderConfirmationPage
```

### Driver Factory

`DriverFactory.java` is responsible for creating and managing the WebDriver instance.

It supports browser configuration such as:

* Chrome
* Firefox
* Edge

### Base Test

`BaseTest.java` provides common test setup and teardown functionality.

It handles:

* Browser initialization
* Application URL
* Wait configuration
* Browser cleanup

### Utilities

The framework contains reusable utility classes for:

* Configuration management
* Excel data reading
* Wait handling
* Screenshots

### TestNG Listener

`TestListener.java` listens to test execution events and supports reporting and test-result handling.

## 📊 Test Data Management

Test data is maintained in Excel using Apache POI.

Location:

```text
src/test/resources/testdata/TestData.xlsx
```

The framework uses TestNG `DataProvider` to execute tests with multiple sets of test data.

Example:

```text
TC001 → John Smith
TC002 → David Brown
TC003 → Sarah Wilson
```

## ⚙️ Configuration

Configuration is maintained in:

```text
src/test/resources/config/config.properties
```

Example:

```properties
browser=chrome
url=https://www.saucedemo.com/
implicitWait=10
pageLoadTimeout=30
```

## 🧪 Application Under Test

The framework currently automates the SauceDemo application.

Application:

https://www.saucedemo.com/

### Automated Flow

```text
Login
  ↓
Products
  ↓
Add Products to Cart
  ↓
Cart
  ↓
Checkout
  ↓
Customer Information
  ↓
Checkout Overview
  ↓
Order Confirmation
```

## ▶️ Running Tests

### Run all tests with Maven

```bash
mvn clean test
```

### Run tests using TestNG

The test suite can also be executed using:

```text
testng.xml
```

## 📈 Test Reporting

The framework uses **Extent Reports** to generate HTML test execution reports.

The report provides:

* Test name
* Test status
* Execution time
* Passed tests
* Failed tests
* System information
* Browser information

## 🔐 Git Ignore

The project excludes generated and IDE-specific files such as:

```text
target/
.idea/
*.iml
.DS_Store
*.log
reports/
screenshots/
```

## 🚀 Future Enhancements

Potential enhancements include:

* Cross-browser execution
* Parallel execution
* Jenkins CI/CD integration
* GitHub Actions
* API testing
* Database validation
* Docker execution
* Enhanced failure screenshots
* Retry mechanism
* Environment-specific configuration

## 👩‍💻 Author

**Kavipriya**

QA Automation Engineer

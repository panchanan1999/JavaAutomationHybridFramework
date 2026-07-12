# EAFramework Java - Selenium Test Automation Framework

A robust, scalable, and enterprise-grade test automation framework built on **Selenium WebDriver** and **Java** for automated testing of web applications. This framework follows industry best practices and design patterns to ensure maintainability, reusability, and efficiency in test automation.

---

## 📋 Table of Contents

- [Overview](#overview)
- [Key Features](#key-features)
- [Technology Stack](#technology-stack)
- [Project Structure](#project-structure)
- [Getting Started](#getting-started)
- [Framework Architecture](#framework-architecture)
- [Usage Examples](#usage-examples)
- [Best Practices](#best-practices)
- [Contributing](#contributing)
- [License](#license)

---

## 🎯 Overview

**EAFramework** is a comprehensive test automation framework designed to:
- Simplify web application testing using Selenium WebDriver
- Implement Page Object Model (POM) design pattern for maintainability
- Provide utility functions for common testing tasks (Excel handling, Database integration, Logging, Reporting)
- Support both Selenium tests and Behavior-Driven Development (BDD) with Cucumber
- Enable scalable, data-driven testing approaches
- Deliver structured test reports for better analysis and tracking

This framework is ideal for QA engineers, automation developers, and testing teams working on medium to large-scale test automation projects.

---

## ✨ Key Features

### 1. **Page Object Model (POM)**
- Encapsulates UI elements and interactions within page classes
- Reduces code duplication and improves maintainability
- Makes tests more readable and easier to update

### 2. **BaseDriver Management**
- Centralized WebDriver initialization and management
- Support for multiple browsers (Firefox, Chrome, Safari, Edge)
- Seamless driver lifecycle management

### 3. **Configuration Management**
- External configuration properties for environment-specific settings
- Settings class for dynamic configuration management
- Easy switching between test environments

### 4. **Comprehensive Utilities**
- **ExcelUtil**: Read/write Excel files for data-driven testing
- **DatabaseUtil**: Database connectivity and query execution
- **LogUtil**: Structured logging for debugging and analysis
- **ReportingUtil**: Test execution reporting and analytics
- **CucumberUtil**: Integration utilities for BDD tests

### 5. **Cucumber BDD Support**
- Feature-file based test scenarios
- Seamless integration with Selenium tests
- Better collaboration between technical and non-technical stakeholders

### 6. **Built-in Logging**
- Comprehensive test execution logs
- Debug and error tracking
- Performance monitoring

### 7. **Test Reporting**
- Detailed test execution reports
- Screenshot capture for failed tests
- Test execution metrics and analytics

---

## 🛠️ Technology Stack

| Component | Version | Purpose |
|-----------|---------|---------|
| **Selenium WebDriver** | 4.45.0 | Web browser automation |
| **Java** | 24 (JDK) | Programming language |
| **JUnit** | 4.13.2 | Unit testing framework |
| **Maven** | Latest | Build automation tool |
| **Firefox WebDriver** | Latest | Browser driver (can be customized) |

### Dependencies
- `org.seleniumhq.selenium:selenium-java:4.45.0` - Selenium WebDriver Java bindings
- `junit:junit:4.13.2` - JUnit testing framework

---

## 📁 Project Structure

```
EAFrameworkJava/
│
├── src/
│   ├── com/ea/framework/
│   │   ├── base/
│   │   │   ├── Base.java                  # Base class for all framework classes
│   │   │   ├── BasePage.java              # Base page object class with PageFactory
│   │   │   ├── Browser.java               # Browser management utilities
│   │   │   ├── DriverContext.java         # WebDriver context and initialization
│   │   │   └── FrameworkInitialize.java   # Framework initialization setup
│   │   │
│   │   ├── config/
│   │   │   ├── GlobalConfig.properties    # Global configuration settings
│   │   │   └── Settings.java              # Configuration management class
│   │   │
│   │   └── utilities/
│   │       ├── ExcelUtil.java             # Excel file handling utilities
│   │       ├── DatabaseUtil.java          # Database connectivity utilities
│   │       ├── LogUtil.java               # Logging utilities
│   │       ├── CucumberUtil.java          # Cucumber BDD utilities
│   │       └── ReportingUtil.java         # Test reporting utilities
│   │
│   └── test/com/ea/test/
│       ├── Features/
│       │   ├── CucumberFeature.feature    # Cucumber BDD feature files
│       │   └── SeleniumTest/
│       │       └── LoginTest.java         # Selenium test cases
│       │
│       └── Pages/
│           └── LoginPage.java             # Page object for login page
│
├── pom.xml                                # Maven configuration file
├── .gitignore                             # Git ignore rules
└── README.md                              # This file

```

---

## 🚀 Getting Started

### Prerequisites
- **Java JDK 24** or higher installed and configured
- **Maven 3.6.0** or higher
- **Git** for version control
- **IDE**: IntelliJ IDEA or Eclipse (recommended)
- **WebDriver**: GeckoDriver (Firefox), ChromeDriver (Chrome), etc.

### Installation

1. **Clone the Repository**
   ```bash
   git clone https://github.com/panchanan1999/DataDrivenFramework_Java_Selenium.git
   cd EAFrameworkJava
   ```

2. **Install Dependencies**
   ```bash
   mvn clean install
   ```

3. **Configure WebDriver**
   - Download the appropriate WebDriver (GeckoDriver for Firefox, ChromeDriver for Chrome, etc.)
   - Update the driver path in your test class or configuration file
   - Example: `System.setProperty("webdriver.gecko.driver", "path/to/geckodriver.exe");`

4. **Update Configuration Properties**
   - Edit `src/com/ea/framework/config/GlobalConfig.properties`
   - Set base URL, browser type, timeout values, etc.

5. **Run Tests**
   ```bash
   # Run all tests
   mvn test
   
   # Run specific test class
   mvn test -Dtest=LoginTest
   
   # Run with Cucumber
   mvn test -Dcucumber.filter.tags="@smoke"
   ```

---

## 🏗️ Framework Architecture

### Design Patterns Used

#### 1. **Page Object Model (POM)**
Encapsulates UI elements and interactions within dedicated page classes.

```
LoginPage (extends BasePage)
  ├── WebElements (@FindBy annotations)
  │   ├── username
  │   ├── password
  │   └── loginButton
  └── Page Methods
      └── login(user, password)
```

#### 2. **Base Page Pattern**
`BasePage` provides common functionality for all page objects using Selenium's `PageFactory`.

#### 3. **Singleton Pattern**
`DriverContext` manages single WebDriver instance across test lifecycle.

#### 4. **Factory Pattern**
`Browser` class handles WebDriver instantiation for different browsers.

#### 5. **Utility Pattern**
Dedicated utility classes for common operations (Excel, Database, Logging, Reporting).

### Architecture Layers

```
Test Cases (LoginTest.java)
    ↓
Page Objects (LoginPage.java extends BasePage)
    ↓
Base Framework (Base.java, BasePage.java)
    ↓
WebDriver Management (DriverContext.java, Browser.java)
    ↓
Utilities (ExcelUtil, DatabaseUtil, LogUtil, etc.)
    ↓
Selenium WebDriver
    ↓
Web Browser
```

---

## 📝 Usage Examples

### Example 1: Creating a Page Object

```java
package com.ea.test.Pages;

import com.ea.framework.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage extends BasePage {
    
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    
    // Element locators using @FindBy
    @FindBy(how = How.NAME, using = "loginname")
    public WebElement username;
    
    @FindBy(how = How.NAME, using = "password")
    public WebElement password;
    
    @FindBy(how = How.XPATH, using = "//button[@title='Login']")
    public WebElement loginButton;
    
    // Page methods
    public void Login(String user, String pass) {
        username.sendKeys(user);
        password.sendKeys(pass);
        loginButton.click();
    }
}
```

### Example 2: Writing a Test Case

```java
package com.ea.test.Features.SeleniumTest;

import com.ea.test.Pages.LoginPage;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginTest {
    private WebDriver driver = null;
    
    @Before
    public void Initialize() {
        System.setProperty("webdriver.gecko.driver", "path/to/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.navigate().to("https://automationteststore.com/index.php?rt=account/login");
    }
    
    @Test
    public void testLogin() {
        LoginPage page = new LoginPage(driver);
        page.Login("testuser_1", "Test@123");
        // Add assertions here
    }
}
```

### Example 3: Using Utility Classes

```java
// Excel Data-Driven Testing
import ea.framework.utilities.ExcelUtil;
ExcelUtil excel = new ExcelUtil("testdata.xlsx");
String username = excel.getCellData("LoginSheet", "username", 2);

// Database Testing
import ea.framework.utilities.DatabaseUtil;
DatabaseUtil db = new DatabaseUtil("jdbc:mysql://localhost:3306/testdb", "user", "pass");
ResultSet result = db.executeQuery("SELECT * FROM users WHERE id=1");

// Logging
import ea.framework.utilities.LogUtil;
LogUtil.info("Test execution started");
LogUtil.error("Login failed");

// Reporting
import ea.framework.utilities.ReportingUtil;
ReportingUtil.generateReport();
```

---

## 🎓 Best Practices

### 1. **Page Object Model**
- One page object per page/screen
- Keep locators and methods in page classes
- Use `@FindBy` annotations for element identification
- Implement meaningful method names representing user actions

### 2. **Test Organization**
- Group related tests in test classes
- Use descriptive test method names
- Keep setup and teardown logic clean
- Follow AAA pattern: Arrange, Act, Assert

### 3. **Code Reusability**
- Extend `BasePage` for all page objects
- Use utility classes for common operations
- Avoid code duplication
- Create helper methods for repeated actions

### 4. **Locator Strategy**
- Prefer stable locators (ID, Name, CSS Selectors)
- Avoid XPath unless necessary
- Use meaningful attribute values for locators
- Update locators during maintenance phase

### 5. **Test Data Management**
- Use external files (Excel, JSON, CSV) for test data
- Implement data-driven testing with `ExcelUtil`
- Keep sensitive data in configuration files
- Use environment-specific test data

### 6. **Logging and Reporting**
- Log all critical steps and actions
- Capture screenshots on test failure
- Generate detailed test execution reports
- Track test metrics and trends

### 7. **Error Handling**
- Use try-catch blocks for error handling
- Implement meaningful error messages
- Log stack traces for debugging
- Implement custom exceptions if needed

### 8. **Performance Optimization**
- Use implicit and explicit waits appropriately
- Minimize unnecessary navigations
- Optimize element locator performance
- Monitor test execution time

---

## 🔧 Configuration

### Global Configuration Properties

Edit `GlobalConfig.properties` to customize framework behavior:

```properties
# Browser Configuration
browser.type=firefox
browser.headless=false

# Application Settings
app.baseurl=https://automationteststore.com
app.timeout=10

# Database Configuration
db.url=jdbc:mysql://localhost:3306/testdb
db.username=root
db.password=password

# Reporting
report.path=./test-reports
screenshot.on.failure=true

# Logging
log.level=INFO
```

---

## 📊 Running Tests

### Maven Commands

```bash
# Run all tests
mvn clean test

# Run specific test class
mvn test -Dtest=LoginTest

# Run specific test method
mvn test -Dtest=LoginTest#testLogin

# Run with specific tags (Cucumber)
mvn test -Dcucumber.filter.tags="@smoke"

# Run tests in parallel
mvn test -DparallelSuite=true

# Generate test report
mvn surefire-report:report
```

### IDE Integration

**IntelliJ IDEA:**
- Right-click on test class → Run
- Right-click on test method → Run
- View test results in Test Runner window

**Eclipse:**
- Right-click on test class → Run As → JUnit Test
- View test results in JUnit view

---

## 📈 Extending the Framework

### Adding a New Page Object

1. Create a new class extending `BasePage`
2. Define WebElements using `@FindBy` annotations
3. Implement page methods representing user actions
4. Use in test classes

### Adding a New Utility

1. Create a new class in `utilities` package
2. Implement static or instance methods
3. Add meaningful javadoc comments
4. Use in test classes or page objects

### Integrating a New Tool/Library

1. Add dependency to `pom.xml`
2. Run `mvn clean install`
3. Create corresponding utility class if needed
4. Document usage in README

---

## 🐛 Troubleshooting

### WebDriver Issues
- **Issue**: WebDriver not found
  - **Solution**: Download correct WebDriver version for your OS and browser
  - Update driver path in configuration

### Element Not Found
- **Issue**: `NoSuchElementException`
  - **Solution**: Verify element locator accuracy
  - Increase wait time for slow-loading elements
  - Check if element is within iframe

### Stale Element Reference
- **Issue**: `StaleElementReferenceException`
  - **Solution**: Re-find element before interaction
  - Use explicit waits
  - Handle element references carefully

### Connection Refused
- **Issue**: Cannot connect to application
  - **Solution**: Verify application is running
  - Check base URL configuration
  - Verify network connectivity

---

## 📚 Resources

- [Selenium Documentation](https://www.selenium.dev/documentation/)
- [JUnit 4 Documentation](https://junit.org/junit4/)
- [Maven Documentation](https://maven.apache.org/)
- [Cucumber Documentation](https://cucumber.io/)
- [Page Object Model Pattern](https://www.selenium.dev/documentation/test_practices/encouraged/page_object_models/)

---

## 🤝 Contributing

Contributions are welcome! To contribute:

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

---

## 📄 License

This project is licensed under the MIT License - see the LICENSE file for details.

---

## 👨‍💻 Author

**Panchanan Mandal**
- GitHub: [@panchanan1999](https://github.com/panchanan1999)
- Repository: [DataDrivenFramework_Java_Selenium](https://github.com/panchanan1999/DataDrivenFramework_Java_Selenium)

---

## 📞 Support

For issues, questions, or suggestions, please:
- Open an issue on GitHub
- Contact the development team
- Check existing documentation

---

## 🎉 Acknowledgments

- Selenium WebDriver community
- JUnit testing framework
- Maven build automation
- All contributors and users of this framework

---

**Happy Testing! 🚀**

---

*Last Updated: July 2024*

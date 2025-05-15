# E2E API Testing Framework with Rest-Assured

## Overview
This project implements an end-to-end API testing framework using Rest-Assured, a powerful Java-based library designed specifically for REST API testing. The framework focuses on verifying and validating the functionality, reliability, performance, and security aspects of APIs.

## Table of Contents
- [Features](#features)
- [Tech Stack](#tech-stack)
- [Project Structure](#project-structure)
- [Setup Instructions](#setup-instructions)
- [Running Tests](#running-tests)
- [Test Report Generation](#test-report-generation)
- [Best Practices](#best-practices)
- [Contributing](#contributing)
- [License](#license)

## Features
- **Functional Testing**: Validates API responses, status codes, and payload structures against expected results
- **Reliability Testing**: Ensures consistent API behavior across multiple invocations and environments
- **Performance Testing**: Measures response times and throughput under various load conditions
- **Security Testing**: Implements authentication, authorization, and data validation checks
- **Data-Driven Testing**: Supports parameterized tests with multiple data sets
- **Environment Configuration**: Easily switches between development, staging, and production environments
- **Test Suites Organization**: Groups tests logically for functional, regression, and smoke testing
- **CI/CD Integration**: Seamlessly integrates with popular CI/CD pipelines

## Tech Stack
- **Rest-Assured**: Core library for API testing
- **TestNG**: Test framework for organizing and executing tests
- **Java**: Programming language
- **Maven**: Build and dependency management
- **Jackson**: JSON parsing and serialization
- **Lombok**: Reduces boilerplate code
- **Allure/ExtentReports**: Test reporting
- **Log4j**: Logging framework
- **AssertJ**: Fluent assertions library

## Project Structure
```
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com.api
│   │   │       ├── config/         # Environment configurations
│   │   │       ├── services/      # Test constants and enums
│   │   │       ├── models/         # POJO classes for request/response
│   │   │       ├── utils/          # Utility classes
│   │   │       └── listeners/      # Test listeners
│   │   └── resources
│   │       ├── config.properties   # Configuration properties
│   │       └── testdata/           # Test data files
│   └── test
│       ├── java
│       │   └── com.api
│       │       ├── functional/     # Functional test cases
│       │       ├── performance/    # Performance test cases
│       │       ├── reliability/    # Reliability test cases
│       │       ├── security/       # Security test cases
│       │       └── base/           # Base test setup classes
│       └── resources
│           └── testng.xml          # TestNG configuration
├── pom.xml                         # Maven project configuration
├── README.md                       # Project documentation
└── .gitignore                      # Git ignore file
```

## Setup Instructions

### Prerequisites
- Java JDK 11 or higher
- Maven 3.6.3 or higher / Gradle 7.0 or higher
- IDE (IntelliJ IDEA, Eclipse, etc.)

### Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/api-testing-rest-assured.git
   cd api-testing-rest-assured
   ```

2. Install dependencies:
   ```bash
   mvn clean install -DskipTests
   ```

3. Configure environment settings in `src/main/resources/config.properties`:
   ```properties
   # Base URLs
   base.url.dev=https://dev-api.example.com
   base.url.staging=https://staging-api.example.com
   base.url.prod=https://api.example.com
   
   # Default environment
   active.environment=dev
   
   # Authentication
   auth.username=testuser
   auth.password=******
   auth.token.endpoint=/auth/token
   ```

## Running Tests

### Running all tests
```bash
mvn clean test
```

### Running specific test suites
```bash
mvn clean test -Dsuite=functional
mvn clean test -Dsuite=performance
mvn clean test -Dsuite=security
```

### Running tests in specific environments
```bash
mvn clean test -Denv=staging
```

## Test Report Generation
After test execution, reports will be generated in the `target/reports` directory.

### Allure Reports
1. Generate Allure report:
   ```bash
   mvn allure:report
   ```
2. Open the report:
   ```bash
   mvn allure:serve
   ```

## Best Practices

### API Testing Guidelines
1. **Isolation**: Each test should be independent and not rely on other tests.
2. **Verification**: Always verify status codes, response formats, and payload contents.
3. **Data Management**: Use dedicated test data and clean up after tests when necessary.
4. **Authentication**: Include proper authentication methods for secured endpoints.
5. **Error Handling**: Test both happy paths and error scenarios.

### Code Examples:
**Basic GET Request**
``` 
java@Test
public void testGetUserDetails() {
    given()
        .header("Authorization", "Bearer " + getToken())
        .pathParam("userId", "123")
    .when()
        .get("/users/{userId}")
    .then()
        .statusCode(200)
        .contentType(ContentType.JSON)
        .body("id", equalTo("123"))
        .body("name", notNullValue());
}
```

**POST Request with JSON Body**
```
java@Test
public void testCreateUser() {
    User user = new User("John Doe", "john.doe@example.com");
    
    given()
        .header("Content-Type", ContentType.JSON)
        .header("Authorization", "Bearer " + getToken())
        .body(user)
    .when()
        .post("/users")
    .then()
        .statusCode(201)
        .body("id", notNullValue())
        .body("name", equalTo("John Doe"))
        .body("email", equalTo("john.doe@example.com"));
}
```

## Contributing

1. Fork the repository
2. Create a feature branch (git checkout -b feature/amazing-feature)
3. Commit your changes (git commit -m 'Add some amazing feature')
4. Push to the branch (git push origin feature/amazing-feature)
5. Open a Pull Request

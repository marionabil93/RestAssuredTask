# API Automation Framework (RestAssured + TestNG)

## 📌 Overview
This project is an API automation framework using **RestAssured** and **TestNG** for testing REST APIs. It includes test cases for:
- **GET** request to retrieve user details
- **POST** request to create a new user
- **PUT** request to update a user
- **Logging & reporting** using TestNG reports

## 🛠️ Prerequisites
Ensure you have the following installed:
- **Java 8+** 
- **Maven**
- **IDE** (IntelliJ IDEA)

## 🚀 Installation Steps

1. **Clone the repository**
```sh
git clone https://github.com/marionabil93/RestAssuredTask.git
cd <repository-folder>
```

2. **Build the project and install dependencies**
```sh
mvn clean install
```

## 🔥 Running the Tests

### Run all tests using TestNG
```sh
mvn test
```

### Run tests using TestNG XML suite
```sh
mvn test -DsuiteXmlFile=src/test/resources/testng.xml
```

## 📝Reports
- **TestNG Reports:** Available in `target/surefire-reports/emailable-report.html`

## 🛠️ Dependencies (from `pom.xml`)
```xml
<dependencies>
    <dependency>
        <groupId>io.rest-assured</groupId>
        <artifactId>rest-assured</artifactId>
        <version>5.4.0</version>
    </dependency>
    <dependency>
        <groupId>org.testng</groupId>
        <artifactId>testng</artifactId>
        <version>7.9.0</version>
        <scope>test</scope>
    </dependency>
    <dependency>
        <groupId>org.apache.logging.log4j</groupId>
        <artifactId>log4j-core</artifactId>
        <version>2.21.0</version>
    </dependency>
</dependencies>
```

## 🎯 Conclusion
This framework provides a simple yet powerful way to automate API testing using **RestAssured** and **TestNG**. Happy Testing! 🚀


# Selenium tests for Trello

The repository contains two test cases for logging into a Trello account.

## Prerequisites

1. JDK 1.8 installed: 
[Download](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html),
[How to set the PATH variable](https://docs.oracle.com/cd/E19182-01/821-0917/inst_jdk_javahome_t/index.html)
2. Maven 3.6.3 installed:
[Full installation guide](https://www.baeldung.com/install-maven-on-windows-linux-mac)
3. ChromeDriver: [Download](http://chromedriver.storage.googleapis.com/index.html?path=87.0.4280.20/)
4. Google Chrome ver. 87+: [Download](https://www.google.com/intl/pl_pl/chrome/)

## How to run

### Clone the repository
#### With Git
Run `git clone https://github.com/Woundteries/seleniumtrello.git` in your desired location for the repository. 
#### Without Git
Download the repository as a ZIP file and extract in your desired location for the repository.

### Configuration

In the `test.properties` file set the `chromeDriverPath` property to the path to `chromedriver` executable on your machine. File contains also the test data used in the test cases, they shouldn't get overwritten.
```
chromeDriverPath=webdriver/chromedriver.exe
test.userName=Selenium Test
(...)
```
### Running tests

Using command line, run `mvn test` while in your project directory.
```
C:\Projects\seleniumtrello>mvn test
```

Expected result:
```
Results :

Tests run: 2, Failures: 0, Errors: 0, Skipped: 0

[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
(...)
```

 

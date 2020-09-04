
### Test task of the company "Alice" 
#### Automation of testing a service that distributes apples between users
**Testable functionality:** Distribution of apples from the basket among users.

Positive and negative functional testing

**Number of automated tests:** 16

#### Description of the procedure for starting autotests:

##### 1. Running all autotests:

1) Launch IntelliJ IDEA;
2) Open the terminal IntelliJ IDEA (hereinafter - the "Terminal");
3) Enter the command "gradlew clean tests" into the Terminal;
4) Enter the command "gradlew downloadAllure" into the Terminal;
5) Enter the command "gradlew allureServe" into the Terminal.


##### 2. Running positive autotests:

1) Launch IntelliJ IDEA;
2) Open the terminal IntelliJ IDEA (hereinafter - the "Terminal");
3) Enter the command "gradlew clean positive_tests" into the Terminal;
4) Enter the command "gradlew downloadAllure" into the Terminal;
5) Enter the command "gradlew allureServe" into the Terminal.

##### 3. Running negative autotests:

1) Launch IntelliJ IDEA;
2) Open the terminal IntelliJ IDEA (hereinafter - the "Terminal");
3) Enter the command "gradlew clean negative_tests" into the Terminal;
4) Enter the command "gradlew downloadAllure" into the Terminal;
5) Enter the command "gradlew allureServe" into the Terminal.

##### 4. List of tools:
   * IntelliJ IDEA -  an Integrated Development Environment (IDE) for JVM language.
   * Java 8 - language for writing autotests.
   * GitHub - a project management and a code version control system.
   * JUnit - unit testing framework for the Java programming language. 
   * Gradle - a build automation tool for multi-language software development.
   * Selenide - a wrapper for Selenium WebDriver.
   * Allure Report - a flexible lightweight multi-language test report tool.
     
##### Comments:
1) The checklist is in the file ["Check_list_Alyce"](https://github.com/AlexandrZhuravel/alyce_test_task/blob/master/documents/Check_list%20Alyce.xlsx);
2) The excel Bug Report is in the file ["Bug_report_Alyce"](https://github.com/AlexandrZhuravel/alyce_test_task/blob/master/documents/Bug_report%20Alyce%20.xlsx);
3) The issue Bug Report is in the [Issue#1](https://github.com/AlexandrZhuravel/alyce_test_task/issues/1).

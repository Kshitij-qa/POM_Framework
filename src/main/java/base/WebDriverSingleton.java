package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


/*
Singleton design pattern is a creational design pattern that allows only one instance of a class to be created and ensures that this instance is globally accessible throughout the entire application.

        In the context of automation testing, the singleton pattern can be used to ensure that only one instance of a test object or driver object is created and used throughout the entire test suite. This can help to improve the performance and reliability of the tests, as well as simplify the test code.

        For example, in web automation testing using Selenium, the WebDriver object represents the web browser instance that controls the browser and interacts with the web page. Creating and destroying a new WebDriver object for each test case can be slow and resource-intensive, and can also lead to instability and flakiness in the tests.

        By using the singleton pattern, you can ensure that only one instance of the WebDriver object is created and used throughout the entire test suite. This can help to speed up the tests and improve their reliability, as the same browser instance can be reused across multiple test cases.

        Here's an example implementation of the singleton pattern for a WebDriver object in Java:*/
public class WebDriverSingleton {
    private static WebDriver driver = null;

    private WebDriverSingleton() {
        // Private constructor to prevent instantiation from outside the class
    }

    public static WebDriver getInstance() {
        if (driver == null) {
            // Initialize the driver object if it does not exist
            driver = new ChromeDriver();
        }
        return driver;
    }


 /*   In this implementation, the WebDriverSingleton class has a private constructor that prevents instantiation from outside the class.
  The class also has a static method getInstance() that returns a reference to the single instance of the WebDriver object.
  The getInstance() method first checks if the driver instance variable is null, and if so, initializes the driver object (in this case, a ChromeDriver object).
   The driver instance variable is stored as a private static member of the class.

    By using this implementation, you can ensure that only one instance of the WebDriver object is created and used throughout the entire test suite.
     This can help to improve the performance and reliability of the tests.
*/
}

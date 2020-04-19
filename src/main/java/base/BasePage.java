package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//import org.apache.log4j.LogManager;
//import org.apache.log4j.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;

import Utilities.ExcelReader;
import Utilities.ExtentManager;
import Utilities.Utilities;

public class BasePage {

	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;
	// public static Logger log = Logger.getLogger("devpinoyLogger");
	// public static Logger log = Logger.getLogger(BasePage.class.getName());
	public static Logger log = LogManager.getLogger(BasePage.class.getName());
	public static ExcelReader excel = new ExcelReader(
			System.getProperty("user.dir") + "\\src\\main\\java\\resources\\testdata.xlsx");
	public static WebDriverWait wait;

//	public ExtentReports rep = ExtentManager.createInstance(TC_name);
//	public static ExtentTest Etest;
	public static String browser;
	public static TopMenu menu;
	/*
	 * Logs, Properties - OR, Config Excel Implicit and ExplicitWait Extent Reports
	 * 
	 * 
	 * 
	 * 
	 */

	public WebDriver initializeDriver() {

		if (driver == null) {

			try {
				fis = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\main\\java\\resources\\Config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				config.load(fis);
				log.debug("Config file loaded !!!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				fis = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\main\\java\\resources\\OR.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				OR.load(fis);
				log.debug("OR file loaded !!!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// Jenkins Browser filter configuration
			if (System.getenv("browser") != null && !System.getenv("browser").isEmpty()) {

				browser = System.getenv("browser");
			} else {

				browser = config.getProperty("browser");

			}

			config.setProperty("browser", browser);

			if (config.getProperty("browser").equals("firefox")) {

				// System.setProperty("webdriver.gecko.driver", "gecko.exe");
				driver = new FirefoxDriver();

			} else if (config.getProperty("browser").equals("chrome")) {

				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver.exe");

				Map<String, Object> prefs = new HashMap<String, Object>();
				prefs.put("profile.default_content_setting_values.notifications", 2);
				prefs.put("credentials_enable_service", false);
				prefs.put("profile.password_manager_enabled", false);
				ChromeOptions options = new ChromeOptions();
				options.setExperimentalOption("prefs", prefs);
				options.addArguments("--disable-extensions");
				options.addArguments("--disable-infobars");

				driver = new ChromeDriver(options);
			} else if (config.getProperty("browser").equals("ie")) {

				System.setProperty("webdriver.ie.driver",
						System.getProperty("user.dir") + "\\src\\main\\java\\resources\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();

			}
			/*
			 * driver.get(config.getProperty("testsiteurl")); log.debug("Navigated to : " +
			 * config.getProperty("testsiteurl")); driver.manage().window().maximize();
			 * driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty
			 * ("implicit.wait")),TimeUnit.SECONDS); wait = new WebDriverWait(driver, 5);
			 */
			// menu = new TopMenu(driver);

		}
		return driver;
	}

	public void quit() {

		driver.quit();

	}

	// Common Keywords
	public static void object_Click(String locator) {
	
	
		if (locator.endsWith("_CSS")) {
	
			driver.findElement(By.cssSelector(OR.getProperty(locator))).click();
		} else if (locator.endsWith("_XPATH")) {
	
			driver.findElement(By.xpath(OR.getProperty(locator))).click();
		} else if (locator.endsWith("_ID")) {
	
			driver.findElement(By.id(OR.getProperty(locator))).click();
		}
		log.debug("Clicking on an Element : " + locator);
		// Etest.log(LogStatus.INFO, "Clicking on : " + locator);
		// Etest.log(Status.INFO, "Clicking on : " + locator);

	}

	public static void setText(String locator, String value) {

		if (locator.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(OR.getProperty(locator))).sendKeys(value);
		} else if (locator.endsWith("_XPATH")) {
			driver.findElement(By.xpath(OR.getProperty(locator))).sendKeys(value);
		} else if (locator.endsWith("_ID")) {
			driver.findElement(By.id(OR.getProperty(locator))).sendKeys(value);
		} else if (locator.endsWith("_NAME")) {
			driver.findElement(By.name(OR.getProperty(locator))).sendKeys(value);
		}

		log.debug("Typing in an Element : " + locator + " entered value as : " + value);

		// Etest.log(LogStatus.INFO, "Typing in : " + locator + " entered value as " +
		// value);
		// Etest.log(Status.INFO, "Typing in : " + locator + " entered value as " +
		// value);
	}

	public void Hover(String locator) {

		WebElement elementToHover = driver.findElement(By.xpath(locator));
		Actions action = new Actions(driver);
		action.moveToElement(elementToHover).perform();

	}

	public void HoverAndClick(String hover_locator1, String hover_locator2, String locator) {

		WebElement elementToHover1 = driver.findElement(By.xpath(hover_locator1));
		WebElement elementToHover2 = driver.findElement(By.xpath(hover_locator2));
		WebElement elementToClick = driver.findElement(By.xpath(locator));
		Actions action = new Actions(driver);
		action.moveToElement(elementToHover1).moveToElement(elementToHover2).click(elementToClick).build().perform();

	}

	static WebElement dropdown;

	public void select(String locator, String value) {

		if (locator.endsWith("_CSS")) {
			dropdown = driver.findElement(By.cssSelector(OR.getProperty(locator)));
		} else if (locator.endsWith("_XPATH")) {
			dropdown = driver.findElement(By.xpath(OR.getProperty(locator)));
		} else if (locator.endsWith("_ID")) {
			dropdown = driver.findElement(By.id(OR.getProperty(locator)));
		}

		Select select = new Select(dropdown);
		select.selectByVisibleText(value);

		log.debug("Selecting from an element : " + locator + " value as : " + value);
		// Etest.log(LogStatus.INFO, "Selecting from dropdown : " + locator + " value as
		// " + value);
		// Etest.log(Status.INFO, "Selecting from dropdown : " + locator + " value as "
		// + value);

	}

	public boolean isElementPresent(By by) {

		try {

			driver.findElement(by);
			return true;

		} catch (NoSuchElementException e) {

			return false;

		}

	}

	public static void verifyEquals(String expected, String actual) throws IOException {

		try {

			Assert.assertEquals(actual, expected);

		} catch (Throwable t) {

			// Utilities.captureScreenshot();
			// ReportNG
			// Reporter.log("<br>" + "Verification failure : " + t.getMessage() + "<br>");
			// Reporter.log("<a target=\"_blank\" href=" + Utilities.screenshotName + "><img
			// src=" + Utilities.screenshotName+ " height=200 width=200></img></a>");
			// Reporter.log("<br>");
			// Reporter.log("<br>");
			Assert.fail("User Reg Test Failed");
			// Extent Reports
			// Etest.log(Status.FAIL, " Verification failed with exception : " +
			// t.getMessage());
			// Etest.log(Status.FAIL, (Markup)
			// Etest.addScreenCaptureFromPath(Utilities.screenshotName));

		}

	}

	public void waitForElementToBeDisplayed(String locator, long timeout) {
		WebElement element = driver.findElement(By.xpath(locator));
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.visibilityOf(element));
		log.debug("Element : " + locator + "is displayed");
		// Etest.log(LogStatus.INFO, "Clicking on : " + locator);
		// Etest.log(Status.INFO, "Clicking on : " + locator);
		
	}

	public void waitForElementToBeClickable(String locator, long timeout) {
		WebElement element = driver.findElement(By.xpath(locator));
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		log.debug("Element : " + locator + "is Clickable");
	}
	
public void highlight(String locator) {
	
	WebElement element = driver.findElement(By.xpath(locator));
	// Create the  JavascriptExecutor object
	for (int i = 0; i <2; i++) {
	JavascriptExecutor js=(JavascriptExecutor)driver;
	// call the executeScript method
	//js.executeScript("arguments[0].setAttribute('style,'border: solid 2px red'');", element);
	js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "color: yellow; border: 2px solid yellow;");
    js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "");
	}
	
}


//public void keyboardKey(String locator, Keys key) {
	public void keyboardKey(String locator) {
	WebElement element = driver.findElement(By.xpath(locator));
	Actions action = new Actions(driver);
	action.sendKeys(Keys.ENTER).perform();
	element.sendKeys(Keys.ENTER);
}


}

package POM;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.WebDriverWait;

import base.BasePage;

public class HomePage extends BasePage{

	public void goToRegister() {
		
		System.out.println("in do login");
		driver = initializeDriver();
		driver.get(config.getProperty("testsiteurl"));
		log.debug("Navigated to : " + config.getProperty("testsiteurl"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")),TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 5);
		object_Click("register_XPATH");
		
	}

	public void doRegistration() {
		
				setText("firstname_ID", "firstName");
				setText("lastname_XPATH", "lastName");
				setText("address_ID", "address");
		
	}
	
}

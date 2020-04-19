package POM;

import java.util.concurrent.TimeUnit;

import org.omg.CORBA.OBJ_ADAPTER;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import base.BasePage;

public class LoginPage extends BasePage{

	
	public void doLogin(String username,String password) {
		System.out.println("in do login");
		driver = initializeDriver();
		driver.get(config.getProperty("testsiteurl"));
		log.debug("Navigated to : " + config.getProperty("testsiteurl"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")),TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 5);
		//setText("serach_NAME",username);

		setText("usename_ID",username);
		setText("password_ID",password);
		object_Click("submit_ID");

		
	}
	
	
	
}

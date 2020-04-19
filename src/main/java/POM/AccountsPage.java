package POM;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import base.BasePage;

public class AccountsPage extends BasePage{

	public void gotoAccounts() {
		try {
			Thread.sleep(15*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//waitForElementToBeClickable("accounts_tab_XPATH",30);
		object_Click("accounts_tab_XPATH");
	}
	
	public void placeOrder() {
		try {
			Thread.sleep(20000);
	 
		//waitForElementToBeClickable("search_XPATH",30);
			object_Click("quick_filter_XPATH");
		//setText("account_search_box_XPATH", "84500628");
		//Keys key = Keys.ENTER;
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")),TimeUnit.SECONDS);
		//waitForElementToBeClickable("search_XPATH",30);
		//keyboardKey("account_search_box_XPATH", key);
		Thread.sleep(20000);
		//highlight("search_XPATH");
		//object_Click("search_XPATH");
		//keyboardKey("account_search_box_XPATH");
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")),TimeUnit.SECONDS);
		Thread.sleep(10000);
	//	waitForElementToBeDisplayed("unlock_XPATH", 20);
	//	waitForElementToBeClickable("unlock_XPATH",20);
		//highlight("unlock_CSS");
	//	((JavascriptExecutor)driver).executeScript("arguments[0].removeAttribute('style')", driver.findElement(By.cssSelector(OR.getProperty("unlock_XPATH"))));
	//	object_Click("unlock_XPATH");
		//Hover("account_number_hovr_XPATH");
		//HoverAndClick("account_expand_XPATH");
		//object_Click("account_expand_XPATH");
		//HoverAndClick("Trade_XPATH");
		HoverAndClick("Trade_XPATH", "Equities_XPATH","Buy_XPATH");
		
		
	}

	catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}	
}

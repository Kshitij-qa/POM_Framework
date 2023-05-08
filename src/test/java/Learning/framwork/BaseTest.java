package Learning.framwork;

import org.testng.annotations.AfterTest;

import base.BasePage;

public class BaseTest extends BasePage{
	@AfterTest
	public void quit() {
		//driver.quit();
	}


}

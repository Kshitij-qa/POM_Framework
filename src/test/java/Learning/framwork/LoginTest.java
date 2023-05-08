package Learning.framwork;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import POM.LoginPage;
import Utilities.Utilities;

public class LoginTest extends BaseTest{
	
	@Test(dataProviderClass = Utilities.class, dataProvider = "dp")
	public void loginTest(Hashtable<String,String> data){
	//public void loginTest(){
		
		String un = data.get("username");
		String pwd= data.get("password");
		LoginPage lp = new LoginPage();
		lp.doLogin(un, pwd);

		
	
		//Assert.fail("Login test failed");
	
}
		

@AfterMethod

@AfterTest
public void tearDown() {
driver.quit();
}
	
	
}
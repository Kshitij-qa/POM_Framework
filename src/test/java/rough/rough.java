package rough;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import java.util.Hashtable;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import POM.AccountsPage;
import POM.LoginPage;
import Utilities.Utilities;
import base.BasePage;

public class rough extends BasePage {
	@Test(dataProviderClass = Utilities.class, dataProvider = "dp")
	public void placeOrder_EQ(Hashtable<String,String> data) throws InterruptedException{
	//public void loginTest(){
		String un = data.get("username");
		String pwd= data.get("password");
		LoginPage lp = new LoginPage();
		lp.doLogin(un, pwd);
		
		AccountsPage ap = new AccountsPage();
		ap.gotoAccounts();
		ap.placeOrder();
	

}
		

@AfterMethod
@AfterTest
public void tearDown() {

}

}
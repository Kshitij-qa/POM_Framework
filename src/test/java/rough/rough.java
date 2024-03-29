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
	
// update code
		ap.keyboardKey("Enter");
}
		

@AfterMethod
@AfterTest
public void tearDown() {

}


	public static void main(String[] args) {
		String str = "A common question that I've seen people asking in QA interviews";
		String vowels = "";
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
					c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
				vowels += String.valueOf(c);
			}
		}
		System.out.println(vowels);
	}


}
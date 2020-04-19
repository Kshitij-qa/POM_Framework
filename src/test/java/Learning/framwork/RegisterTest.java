package Learning.framwork;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import POM.HomePage;

public class RegisterTest extends BaseTest {

	@Test
	public void testRegistration() {
		HomePage h=new HomePage();
		h.goToRegister();
		h.doRegistration();  
	}
	
	
	
}

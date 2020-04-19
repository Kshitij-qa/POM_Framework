package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import POM.AccountsPage;

public class TopMenu{

	/*
	 * 
	 * TopMenu ISA Page ???
	 * 
	 * HomePage HASA TopMenu
	 * AccountsPAge HASA TopMenu
	 * 
	 * Page HASA TopMenu
	 * 
	 * 
	 */
	
	WebDriver driver;
	
	public TopMenu(WebDriver driver){
		
		this.driver = driver;
	}
	
	public void gotoHome() {

	}

	public void gotoFeeds() {

	}

	public void gotoLeads() {

	}

	public AccountsPage gotoAccounts() {
		
		
		BasePage.object_Click("accountstab_CSS");
		return new AccountsPage();
		
	
	}

	public void gotoContacts() {

	}
	
	
	public void signOut(){
		
		
	}

}

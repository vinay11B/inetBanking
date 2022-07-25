package inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {

	WebDriver driver;
	
	public loginPage(WebDriver ldriver){
		driver=ldriver;
		PageFactory.initElements(ldriver, this);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	//3 login page elements
	@FindBy(name="uid")
	@CacheLookup
	WebElement userName;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement txtpassword;
	
	@FindBy(name="btnLogin")
	@CacheLookup
	WebElement loginbt;
	
	@FindBy(xpath="/html/body/div[3]/div/ul/li[15]/a") 
	@CacheLookup
	WebElement logout;
	
	
	//action methods
	public void setUserName(String uname) {
		userName.sendKeys(uname);
	}
	
	public void setPassword(String pwd)
	{
		txtpassword.sendKeys(pwd);
	}
	
	public void clickSubmit() {
		loginbt.click();
	}
	
	public void clicklogout() {
		logout.click();
	}
	

}

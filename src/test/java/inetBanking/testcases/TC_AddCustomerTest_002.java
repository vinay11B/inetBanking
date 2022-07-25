package inetBanking.testcases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import inetBanking.pageObjects.AddCustomer;
import inetBanking.pageObjects.loginPage;

public class TC_AddCustomerTest_002 extends BaseClass {


	@Test
	public void addNewCustomer() throws InterruptedException, IOException {
		
	//	driver.get(baseUrl);
		loginPage lp=new loginPage(driver);
		
		lp.setUserName(username);
		logger.info("user name lprovided");
		lp.setPassword(password);
		logger.info("password");
		
		Thread.sleep(2000);
		
		lp.clickSubmit();
		logger.info("submit");
		
		Thread.sleep(2000);
		
		//adding new customer
		AddCustomer addcus=new AddCustomer(driver);
		addcus.clickAddNewCustomer();
		Thread.sleep(2000);
	//	driver.findElement(By.id("dismiss-button")).click();
		addcus.custName("vinay");
		addcus.custgender("male");
		addcus.custdob("10", "15", "1998");
		Thread.sleep(2000);
		addcus.custaddress("India");
		addcus.custcity("Noida");
		addcus.custstate("U.P");
		addcus.custpinno(201310);
		addcus.custtelephoneno("8287638715");
		addcus.custemailid(randomString()+"@gmail.com");
		
		addcus.custpassword("abcdef");
		Thread.sleep(1000);
		addcus.custsubmit();
		
		Thread.sleep(1000);
		
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		if(res==true) {
			Assert.assertTrue(true);
			logger.info("testcase passed");
		}
		else {
			Assert.assertTrue(false);
			logger.info("testcase failed");
			captureScreenshot(driver,"addNewCustomer");
			
		}
		
	}
	
	//generat random email id
	public String randomString() {
		String randomSt=RandomStringUtils.randomAlphabetic(5);
		return randomSt;
	}

}

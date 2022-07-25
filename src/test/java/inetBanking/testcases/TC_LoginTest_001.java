package inetBanking.testcases;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import inetBanking.pageObjects.loginPage;

public class TC_LoginTest_001 extends BaseClass {

	@Test
	public void loginTest() throws InterruptedException, IOException {
	//	driver.get(baseUrl);
		
		logger.info("Url is opened");//giving msg
	//	Thread.sleep(2000);
		
		//pageobject class ka object bnana pdega usem driver as a parameter pass krna pdega
		loginPage lp=new loginPage(driver);
		
		//username call krenge pageobject se
		lp.setUserName(username);
		logger.info("enetr username");
		Thread.sleep(2000);
		lp.setPassword(password);
		logger.info("enter password");
		Thread.sleep(2000);
		lp.clickSubmit();
		Thread.sleep(2000);
		
		String title=driver.getTitle();
		System.out.print(title);
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
			logger.info("login test passed");
		}
		else {
			captureScreenshot(driver, "login test");
			Assert.assertTrue(false);
			logger.info("login test failed");
		}
	}


}

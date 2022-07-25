package inetBanking.testcases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import inetBanking.pageObjects.loginPage;
import inetBanking.utilities.XLUtils;

public class TC_LoginDD_001 extends BaseClass {

	@Test(dataProvider="LoginData")
	public void loginDDT(String user,String pwd) throws InterruptedException{
	//	driver.get(baseUrl);
		loginPage lp=new loginPage(driver);
		lp.setUserName(user);
		logger.info("username is provided");
		lp.setPassword(pwd);
		Thread.sleep(2000);
		logger.info("password is provided");
		lp.clickSubmit();
		logger.info("submit");
		Thread.sleep(2000);
		
		if(isAlertPresent()==true) {
			driver.switchTo().alert().accept();
			Thread.sleep(2000);//closese the alert
			driver.switchTo().defaultContent();
			Thread.sleep(2000);//focus on main page again
			Assert.assertTrue(false);
			Thread.sleep(2000);
			logger.warn("login failed");
		}
		else {
			Assert.assertTrue(true);
			Thread.sleep(2000);
			logger.info("login passed");
			lp.clicklogout();
			Thread.sleep(2000);
			driver.switchTo().alert().accept();
			Thread.sleep(2000);//close logout allert
			driver.switchTo().defaultContent();
			Thread.sleep(2000);//focus on main page again
		}
	}
	
	
	//user defined method created to check alert is present or not on giving invalid creds
	public boolean isAlertPresent() {
		try {
		driver.switchTo().alert();
		return true;
		}
		catch(NoAlertPresentException e) {
			return false;
		}
	}
	
	
	@DataProvider(name="LoginData")
	String[][] getData() throws IOException{
		String path="D:\\Eclipse\\InetBanking_V1\\src\\test\\java\\inetBanking\\testData\\loginData.xlsx";
		
		int rownum=XLUtils.getRowCount(path,"Sheet1");
		int colcount=XLUtils.getCellCount(path,"Sheet1",1);
		
		//create 2 dimentional array 
		String logindata[][]= new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++) {
			//outer for looop for rows
			for(int j=0;j<colcount;j++) {
				//column loop
				//i-1 here because of headers
				logindata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		
		return logindata;
	}

}

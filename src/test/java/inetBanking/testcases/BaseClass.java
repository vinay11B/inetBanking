package inetBanking.testcases;


import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

import inetBanking.utilities.readConfig;

//yha apn common cheezein rkhenge
public class BaseClass {
	
	//make object for redconfig and replace values
	readConfig readC=new readConfig();
	public String baseUrl=readC.getUrl();
	public String username=readC.getuserName();
	public String password=readC.getPassword();
	public static WebDriver driver;
	public static Logger logger;
			

	@Parameters("browser")
	@BeforeClass
	public void setup(String br) throws InterruptedException {
		
		if(br.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver", readC.getChrome());
		driver=new ChromeDriver();
		
		}
		driver.get(baseUrl);
		//setup log4j
		 logger=Logger.getLogger("ebanking");
		PropertyConfigurator.configure("log4j.properties");
		
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	public void captureScreenshot(WebDriver driver ,String tname) throws IOException {
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File target=new File(System.getProperty("user.dir")+"/screenshots/"+tname+".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}

}

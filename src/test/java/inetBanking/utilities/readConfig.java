package inetBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

//read data from config.properties file
public class readConfig {

	Properties pro;
	
	public readConfig() {
		//file ka source bnana hai
		File src=new File("./configuration/config.properties");
		
		try {
			FileInputStream fis =new FileInputStream(src);
			pro= new Properties();
			//load complete file in run time
			pro.load(fis);
		}catch(Exception e){
			
			System.out.print("Exception is"+e.getMessage());
			
		}
		
	}
	
	//property file is loaded add method to read values
	public String getUrl() {
		String url=pro.getProperty("baseUrl");
		return url;
	}
	
	public String getuserName() {
		String userName=pro.getProperty("username");
		return userName;
	}
	
	public String getPassword() {
		String password=pro.getProperty("password");
		return password;
	}
	
	public String getChrome() {
		String chrome=pro.getProperty("Chromepath");
		return chrome;
	}
	

	
}

package com.qa.selenium.testbase;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
	
	public static WebDriver driver = null;
	public Properties properties = null;
	public static String browser = "chrome";
	public static String envUrl = "https://www.amazon.in";
	
	public TestBase() {
		try {
			File file = new File("./config.properties");
			FileInputStream fis = new FileInputStream(file);
			properties.load(fis);
			
		}catch (Exception e) {
			e.getMessage();
		}
		
	}
	
	public static void initialConfig(long pageloadTimeout, long imlicitWait, String envUrl) {
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(imlicitWait, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(pageloadTimeout, TimeUnit.SECONDS);
		driver.get(envUrl);
	}
	
	public static void init() {
				
		if(browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			driver = new ChromeDriver();
			initialConfig(60L,30L,envUrl);
		}
	}
	
	public static void tearDown() {
		driver.close();
	}

}

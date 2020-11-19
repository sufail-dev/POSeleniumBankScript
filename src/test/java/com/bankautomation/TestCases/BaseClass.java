package com.bankautomation.TestCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.bankautomation.Utilities.ReadConfig;


public class BaseClass  {
	ReadConfig read=new ReadConfig();
	public String baseURL=read.getApplicationUrl();
	public String username=read.getUserName();
	public String password=read.getPassword();
	public static WebDriver driver;
	public static Logger logger;
	@Parameters("browser")
	@BeforeClass
	public void setUp(String br) {
		logger=Logger.getLogger("BankAutomation");
		PropertyConfigurator.configure("Log4j.properties");
		if(br.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver", read.getchrome());
		driver=new ChromeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseURL);
		
	}
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	public void captureScreenshots(WebDriver driver, String name) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File sorce=ts.getScreenshotAs(OutputType.FILE);
		File target=new File(System.getProperty("user.dir")+"//Screenshots//"+name+".png");
		FileUtils.copyFile(sorce, target);
		System.out.println("Screemshfihpi");
		
		
	}
	public String randomstring() {
		String ch=RandomStringUtils.randomAlphabetic(5);
		return ch;
	}
}

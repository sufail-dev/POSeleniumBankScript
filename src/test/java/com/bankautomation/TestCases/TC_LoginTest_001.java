package com.bankautomation.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.bankautomation.pageObjects.LoginPage;



public class TC_LoginTest_001 extends BaseClass {
	@Test
		public void LoginTest() throws IOException {
			
			logger.info("URL Is entered");
			LoginPage lp=new LoginPage(driver);
			lp.setUserName(username);
			logger.info("User name is entered");
			lp.setPassword(password);
			logger.info("Password entered");
			lp.clickBtN();
			if(driver.getTitle().equals("Guru99 Bank Home Page")) {
				Assert.assertTrue(true);
				logger.info("Title is correct");
			}
			else {
				captureScreenshots(driver,"LoginTest");
				Assert.assertTrue(false);
				logger.info("Title is wrong");
			}
		}
}

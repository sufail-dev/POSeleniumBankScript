package com.bankautomation.TestCases;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.bankautomation.pageObjects.AddCustomerPage;
import com.bankautomation.pageObjects.LoginPage;



public class TC_AddCustomerTest_003 extends BaseClass {
	@Test
		public void addCustomer() throws InterruptedException {
			LoginPage lp=new LoginPage(driver);
			lp.setUserName(username);
			logger.info("username is provided");
			lp.setPassword(password);
			logger.info("password is provided");
			lp.clickBtN();
			Thread.sleep(2000);
			AddCustomerPage addcust=new AddCustomerPage(driver);
			logger.info("Providing customer details");
			addcust.custName("Pavan");
			addcust.custgender("male");
			addcust.custdob("10","15","1985");
			Thread.sleep(5000);
			addcust.custaddress("INDIA");
			addcust.custcity("HYD");
			addcust.custstate("AP");
			addcust.custpinno("5000074");
			addcust.custtelephoneno("987890091");
			
			String email=randomstring()+"@gmail.com";
			addcust.custemailid(email);
			addcust.custpassword("abcdef");
			addcust.custsubmit();
			Thread.sleep(2000);
			boolean res=driver.getPageSource().contains("Customer Registered Successfully");
			if(res==true) {
				Assert.assertTrue(true);
			}
			else {
				Assert.assertTrue(false);
				logger.info("testcase failed");
			}
			
			
		}
	
}

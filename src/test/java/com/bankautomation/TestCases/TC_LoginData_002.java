package com.bankautomation.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.bankautomation.Utilities.XLUtils;
import com.bankautomation.pageObjects.LoginPage;

public class TC_LoginData_002 extends BaseClass{

	
	
	@Test(dataProvider="LoginData")
	public void LoginTest(String username,String password) throws InterruptedException {
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		logger.info("User name provided");
		lp.setPassword(password);
		logger.info("Password provided");
		lp.clickBtN();
		Thread.sleep(2000);
		if(isAlertPresent()==true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("Login failed");
		}
		else {
			Assert.assertTrue(true);
			logger.warn("Login Passed");
			lp.clickLogout();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Thread.sleep(2000);
		}
	}
	
	public boolean isAlertPresent() {
		try {
		driver.switchTo().alert();
		return true;
		}
		catch(Exception e) {
		return false;
		}
	}
	
	
	
	@DataProvider(name="LoginData")
	String[][] getData() throws IOException{
		String xlPath=System.getProperty("user.dir")+"/src/test/java/com/bankautomation/testData/LoginData.xlsx";
		int rowNum=XLUtils.getRowCount(xlPath, "sheet1");
		int colCount=XLUtils.getCellCount(xlPath, "sheet1", 1);
		String LoginData[][]=new String[rowNum][colCount];
		for(int i=1;i<=rowNum;i++) {
			for(int j=0;j<colCount;j++) {
				LoginData[i-1][j]=XLUtils.getCellData(xlPath, "sheet1", i, j);
				
			}
		}
		return LoginData;
	}
}

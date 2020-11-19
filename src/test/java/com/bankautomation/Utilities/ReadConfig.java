package com.bankautomation.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	Properties pr;
	public ReadConfig() {
		File src=new File("./Configeration/config.properties");
		try {
			FileInputStream fis=new FileInputStream(src);
			pr=new Properties();
			pr.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Exception occured"+e.getMessage());
		}
	}
	public String getApplicationUrl() {
		String URL =pr.getProperty("baseURL");
		return URL;
	}
	public String getUserName() {
		String username =pr.getProperty("username");
		return username;
	}
	public String getPassword() {
		String password =pr.getProperty("password");
		return password;
	}
	public String getchrome() {
		String chrome =pr.getProperty("chromepath");
		return chrome;
	}
}

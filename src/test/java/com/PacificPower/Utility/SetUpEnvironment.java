package com.PacificPower.Utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SetUpEnvironment {
	
	WebDriver driver;
	//ReadConfigFile objReadConfig = new ReadConfigFile();
	FileInputStream fileInputStream;
	
	
	public WebDriver initialiseDriver(Properties prop) {
		System.out.println(prop.getProperty("browser"));
		if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			System.setProperty(prop.getProperty("CHROME_DRIVER_KEY"), prop.getProperty("CHROME_DRIVER_LOCATION"));
			this. driver = new ChromeDriver();
			return driver;
		} else if (prop.getProperty("browser").equalsIgnoreCase("firefox")) {
			System.setProperty(prop.getProperty("FIREFOX_DRIVER_KEY"), prop.getProperty("FIREFOX_DRIVER_LOCATION"));
			this. driver = new FirefoxDriver();
			return driver;
		}
		
		return driver;
	}
	

}

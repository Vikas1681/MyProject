package com.PacificPower.generic;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.PacificPower.Utility.CustomReporting;
import com.PacificPower.Utility.ExcelHelper;
import com.PacificPower.Utility.ReadConfigFile;
import com.PacificPower.Utility.SetUpEnvironment;
import com.PacificPower.Utility.Utility;

public class BaseTest extends Pojo {

	WebDriver driver;
	//ReadConfigFile objReadConfig = new ReadConfigFile();
	CommonFunction objCommonFunction;
	Utility utility;
	Properties prop;
	FileInputStream fileInputStream;
	Logger log;
	CustomReporting customReporting;
	ExcelHelper excelHelper;
	String excelFileName;
	

	
	public void initialiseWebEnvironment(String excelName) {
		loadConfigFile();
		this.utility = new Utility(this);
		this.utility.setLog();
		this.setObjUtility(this.utility);
		this.objCommonFunction = new CommonFunction(this);
		this.setObjCommonFunction(this.objCommonFunction);
		this.excelHelper = new ExcelHelper(this);
		this.setObjExcelHelper(this.excelHelper);
		this.excelHelper.loadExcelFile(excelName);
		SetUpEnvironment setupEnv = new SetUpEnvironment();
		this.driver = setupEnv.initialiseDriver(prop);
		this.setWebDriver(driver);
		this.getDriver().manage().window().maximize();
		this.loadBaseUrl();
		
	}

	public void loadBaseUrl() {
		if (!prop.getProperty("url").equals("")) {
			this.getDriver().get(prop.getProperty("url"));
			this.setBaseUrl(prop.getProperty("url"));
		}
	}

	public void loadConfigFile() {
		this.prop = new Properties();
		try {
			fileInputStream = new FileInputStream(
					System.getProperty("user.dir") + "\\Configuration\\config.properties");
			System.out.println(System.getProperty("user.dir") + "\\Configuration\\config.properties");
			prop.load(fileInputStream);
		} catch (IOException io) {
			System.out.println(io.getMessage());
		}
	}

	public void loadTestData(String RMIDNO) {
		
		excelHelper.loadTestData(RMIDNO);
	}
	
	


}

package com.PacificPower.Test;

import org.jsoup.Connection.Method;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class PracticeExtentLogs {
	
	ExtentReports extentReports;
	ExtentTest  extentTest;
	ExtentHtmlReporter extentHtmlReporter;
	
	@BeforeTest
	public void config() {
		extentHtmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/logGeneration.html");
		extentReports = new ExtentReports();
		extentReports.attachReporter(extentHtmlReporter);
		
	}
	
	@Test
	public void generateLogs1() {
		extentTest=extentReports.createTest(Method.GET.name());
		extentTest.log(Status.INFO, "abcd1");
		extentTest.log(Status.INFO, "abcd2");
		extentTest.log(Status.INFO, "abcd3");
		extentTest.log(Status.INFO, "abcd4");
	}
	
	@Test
	public void generateLogs2() {
		extentTest=extentReports.createTest(Method.GET.name());
		extentTest.log(Status.INFO, "abcd5");
		extentTest.log(Status.INFO, "abcd6");
		extentTest.log(Status.INFO, "abcd7");
		extentTest.log(Status.INFO, "abcd8");
	}
	
//	@AfterTest
//	public void endTest() {
//		extentReports.flush();
//		
//	}

}

package com.PacificPower.generic;

import java.util.HashMap;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import com.PacificPower.Utility.ExcelHelper;
import com.PacificPower.Utility.ExtentReporterHelper;
import com.PacificPower.Utility.ReadConfigFile;
import com.PacificPower.Utility.SetUpEnvironment;
import com.PacificPower.Utility.Utility;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class  Pojo {

	WebDriver driver;
	CommonFunction objCommonFunction;
	Utility utility;
	ExcelHelper objExcelHelper;
	SetUpEnvironment objSetUp = new SetUpEnvironment();
	ReadConfigFile objReadConfig;
	Properties prop;
	String url;
	HashMap<String, String> rowData;
	Logger log;
	ExtentTest extentTest;
	ExtentReports extentReports;
	ITestResult iTestResult;
	String methodName = "";
	boolean resultLog;
	ExtentReporterHelper objExtentReporterHelper;

	public void setWebDriver(WebDriver driver) {
		this.driver = driver;
	}

	public WebDriver getDriver() {
		return this.driver;
	}

	public void setObjConfig(Properties prop) {
		this.prop = prop;
	}

	public Properties getObjConfig() {
		return this.prop;
	}

	public void setBaseUrl(String url) {
		this.url = url;
	}

	public String getUrl() {
		return this.url;
	}

	public CommonFunction getObjCommonFunction() {
		return this.objCommonFunction;
	}

	public CommonFunction setObjCommonFunction(CommonFunction objCommonFunction) {
		return this.objCommonFunction = objCommonFunction;
	}

	public void setObjExcelHelper(ExcelHelper objExcelHelper) {
		this.objExcelHelper = objExcelHelper;
	}

	public ExcelHelper getObjExcelHelper() {
		return this.objExcelHelper;
	}

	public void setRowData(HashMap<String, String> rowData) {
		this.rowData = rowData;
	}

	public HashMap<String, String> getRowData() {
		System.out.println("getRowData" + this.rowData);
		return this.rowData;
	}

	public void setObjUtility(Utility utility) {
		this.utility = utility;
	}

	public Utility getObjUtility() {
		return this.utility;
	}

	public void setObjLog(Logger log) {
		this.log = log;
	}

	public Logger getLog() {
		return log;
	}

	public void setExtent(ExtentTest extentTest) {
		this.extentTest = extentTest;
	}

	public ExtentTest getExtent() {
		return this.extentTest;
	}

	public void setExtentReports(ExtentReports extentReports) {
		this.extentReports = extentReports;
	}

	public ExtentReports getExtentReports() {
		return this.extentReports;
	}

	public void setExtentReportsOnFailure(ExtentReports extentReports) {
		this.extentReports = extentReports;
	}

	public ExtentReports getExtentReportsOnFailure() {
		return this.extentReports;
	}

	public void setExtentReportsOnSkip(ExtentReports extentReports) {
		this.extentReports = extentReports;
	}

	public ExtentReports getExtentReportsOnSkip() {
		return this.extentReports;
	}

	public void setITestResult(ITestResult iTestResult) {
		this.iTestResult = iTestResult;
	}

	public ITestResult getITestResult() {
		return this.iTestResult;
	}

	public void setCurrentMethodName(String methodName) {
		this.methodName = methodName;
	}

	public String getCurrentMethodName() {
		return this.methodName;
	}

	public void setResultLog(boolean resultLog) {
		this.resultLog = resultLog;
	}
	
	public boolean getResultLog() {
		return this.resultLog;
	}
	
	public void setObjExtentReporterHelper(ExtentReporterHelper objExtentReporterHelper) {
		this.objExtentReporterHelper = objExtentReporterHelper;
	}
	
	public ExtentReporterHelper getObjExtentReporterHelper() {
		return this.objExtentReporterHelper;
	}
}

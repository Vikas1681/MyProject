package com.PacificPower.Utility;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterSuite;

import com.PacificPower.generic.Pojo;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import junit.framework.Assert;

public class Utility {
	
	Pojo objPojo;
	ScreenshotHelper screenshotHelper;
	ExtentReporterHelper extentReporterHelper;
	Logger log;
	
	public Utility(Pojo objPojo) {
		this.objPojo = objPojo;
		screenshotHelper = new ScreenshotHelper();
		extentReporterHelper = new ExtentReporterHelper(objPojo);
	}
	
	public void setLog() {
		log = LogManager.getLogger(Utility.class);
		objPojo.setObjLog(log);
	}
	
	public void verifyResult(String step,boolean resultLog) {
		if(resultLog) {
			log.info(step+":"+"Passed");
//			objPojo.setExtent(objPojo.getExtentReports().createTest(objPojo.getCurrentMethodName(), objPojo.getCurrentMethodName()+" "+"is passed"));
//			objPojo.getExtent().log(Status.PASS, MarkupHelper.createLabel(objPojo.getCurrentMethodName()+" PASSED ", ExtentColor.GREEN));
			objPojo.setResultLog(resultLog);
			System.out.println("result log is "+resultLog);
			Assert.assertTrue(resultLog);
			
		}
		else if(!resultLog) {
			log.info(step+":"+"Failed");
			screenshotHelper.takeScreenshot(objPojo.getDriver(), "screenshot");
//			System.out.println("currentMethodName is"+ objPojo.getCurrentMethodName());
//			System.out.println("printing extent object"+objPojo.getExtentReports());
//			objPojo.setExtent(objPojo.getExtentReports().createTest(objPojo.getCurrentMethodName(), objPojo.getCurrentMethodName()+" "+"is failed"));
//			objPojo.getExtent().log(Status.FAIL, MarkupHelper.createLabel(objPojo.getCurrentMethodName()+" FAILED ", ExtentColor.RED));
			objPojo.setResultLog(resultLog);
			System.out.println("result log is "+resultLog);
			Assert.assertTrue(resultLog);
		}
		
		else {
//			extentTest.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" SKIPPED ", ExtentColor.ORANGE));
			objPojo.setResultLog(resultLog);
		}
	}
	
	
	

}

package com.PacificPower.Utility;

import com.PacificPower.generic.Pojo;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporterHelper {
	
	ExtentHtmlReporter extentHtmlReporter;
	ExtentReports extentReports;
	ExtentTest extentTest;
	Pojo objPojo;
	
	public ExtentReporterHelper(Pojo objPojo) {
		this.objPojo = objPojo;
	}
	
	public void generateReport() {
		extentHtmlReporter = new ExtentHtmlReporter("./target/TestExtentReport.html");
		extentHtmlReporter.setAppendExisting(true);
		extentReports = new ExtentReports();
		extentReports.attachReporter(extentHtmlReporter);
		extentReports.setSystemInfo("Script Developer", "Vikas");
		extentReports.setSystemInfo("Script Environment", "QA");
		extentHtmlReporter.config().setDocumentTitle("Extent Facebook Test");
		extentHtmlReporter.config().setReportName("Facebook Test Report");
		extentHtmlReporter.config().setTheme(Theme.STANDARD);
		extentHtmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
		objPojo.setExtentReports(extentReports);
	}
	
	 public void getResult(boolean resultLog)
	    {
	        if(!resultLog)
	        {
				objPojo.setExtent(objPojo.getExtentReports().createTest(objPojo.getCurrentMethodName(), objPojo.getCurrentMethodName()+" "+"is passed"));
				objPojo.getExtent().log(Status.PASS, MarkupHelper.createLabel(objPojo.getCurrentMethodName()+" PASSED ", ExtentColor.GREEN));
//	        	extentTest.log(Status.FAIL, MarkupHelper.createLabel(objPojo.getCurrentMethodName()+" Test case FAILED due to below issues:", ExtentColor.RED));
	        	
	        }
	        else if(resultLog)
	        {
				objPojo.setExtent(objPojo.getExtentReports().createTest(objPojo.getCurrentMethodName(), objPojo.getCurrentMethodName()+" "+"is failed"));
				objPojo.getExtent().log(Status.FAIL, MarkupHelper.createLabel(objPojo.getCurrentMethodName()+" FAILED ", ExtentColor.RED));
//	        	extentTest.log(Status.PASS, MarkupHelper.createLabel(objPojo.getCurrentMethodName()+" Test Case PASSED", ExtentColor.GREEN));
	        }
	        else
	        {
	        	extentTest.log(Status.SKIP, MarkupHelper.createLabel(objPojo.getCurrentMethodName()+" Test Case SKIPPED", ExtentColor.ORANGE));
	        	
	        }
	    }
 
   

	
}



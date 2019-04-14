package com.PacificPower.Utility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import org.testng.IClass;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class CustomReporting extends TestListenerAdapter {

	public ExtentHtmlReporter extentHtmlReporter;
	public ExtentReports extentReports;
	public ExtentTest extentTest;

	public void onStart(ITestContext itestContext) {
		String date = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String reportName = "Test report_" + date;
		extentHtmlReporter = new ExtentHtmlReporter(
				System.getProperty("user.dir") + "\\test-output" + "\\" + reportName);
		System.out.println(System.getProperty("user.dir") + "\\test-output" + reportName);
		extentHtmlReporter.loadXMLConfig(System.getProperty("user.dir") + "\\extent_config.xml");
		extentHtmlReporter.config().setDocumentTitle("Vikas Ka Framework");
		extentHtmlReporter.config().setReportName("Pacific Power Functional Report");
		extentHtmlReporter.config().setTheme(Theme.DARK);
		extentReports = new ExtentReports();
		extentReports.attachReporter(extentHtmlReporter);
		extentReports.setSystemInfo("Hostname", "Localhost");
		extentReports.setSystemInfo("OS", "Windows 7");
		extentReports.setSystemInfo("Test-Engg-Name", "Vikas");
		extentReports.setSystemInfo("Browser", "Chrome");
	}

	public void testFinish() {
		extentReports.flush();
	}

	public void onTestSuccess(ITestResult iTestResult) {
		extentTest = extentReports.createTest(iTestResult.getName());
		extentTest.log(Status.PASS, MarkupHelper.createLabel(iTestResult.getName(), ExtentColor.GREEN));
	}

	public void onTestFailure(ITestResult iTestResult) {
		extentTest = extentReports.createTest(iTestResult.getName());
		extentTest.log(Status.FAIL, MarkupHelper.createLabel(iTestResult.getName(), ExtentColor.RED));
	}

	public void onTestSkip(ITestResult iTestResult) {
		extentTest = extentReports.createTest(iTestResult.getName());
		extentTest.log(Status.SKIP, MarkupHelper.createLabel(iTestResult.getName(), ExtentColor.GREY));
	}

}

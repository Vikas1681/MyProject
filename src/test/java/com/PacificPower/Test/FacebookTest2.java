package com.PacificPower.Test;

import java.lang.reflect.Method;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.PacificPower.Views.FacebookHomeView;
import com.PacificPower.generic.BaseTest;

public class FacebookTest2 extends BaseTest {

	FacebookHomeView objFacebookHomeView;

	// Initialize Views
	public void initializeViewsAndPages() {
		objFacebookHomeView = new FacebookHomeView(this);
	}

	@BeforeClass
	public void setUpEnvironment() {
		initializeViewsAndPages();
		initialiseWebEnvironment("vikas");
	}

	@Test
	public void facebookTest2() {
		loadTestData("100");
		objFacebookHomeView.clickFacebookHomePageEmailField();

	}

	@Test
	public void clickOnDummy1() {
		objFacebookHomeView.clickOnDummy();

	}

	@AfterClass
	public void afterClass() {
		this.getDriver().quit();
	}

	@BeforeMethod
	public void berforeMethod(Method method) {
		this.setCurrentMethodName(method.getName());
	}
}

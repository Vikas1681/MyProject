package com.PacificPower.Test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.PacificPower.PageObjects.FacebookHomePage;
import com.PacificPower.Views.FacebookHomeView;
import com.PacificPower.generic.BaseTest;

public class  FacebookTest extends BaseTest{
	
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
		public void facebookTest1() {
			loadTestData("100");
			objFacebookHomeView.clickFacebookHomePageEmailField();
		}
		
		@Test
		public void clickOnDummy() {
			objFacebookHomeView.clickOnDummy();
		}
		
		@AfterClass
		public void afterClass() {
			this.getDriver().quit();
		}
}

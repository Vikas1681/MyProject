package com.PacificPower.Views;

import com.PacificPower.PageObjects.FacebookHomePage;
import com.PacificPower.generic.Pojo;

public class FacebookHomeView {

	Pojo objPojo;
	FacebookHomePage objFacebookHomePage;
	private String testData;

	public FacebookHomeView(Pojo objPojo) {
		this.objPojo = objPojo;
		objFacebookHomePage = new FacebookHomePage(objPojo);

	}

	public void clickFacebookHomePageEmailField() {
		objFacebookHomePage.clickFacebookHomePageEmailField();
	}

	public void setFacebookHomePageEmail() {
		testData = objPojo.getObjExcelHelper().dpString("NAME");
		if (!testData.equals("")) {
			objFacebookHomePage.setFacebookHomePageEmail(testData);
		}

	}

	public void clickOnDummy() {
		objFacebookHomePage.clickOnDummy();
	}

	public void setFacebookHomePagePassword() {
		testData = objPojo.getObjExcelHelper().dpString("password");
		if (!testData.equals("")) {
			objFacebookHomePage.setFacebookHomePagePassword(testData);
		}
	}
	
	public void clickFacebookHomePagePassword() {
		objFacebookHomePage.clickFacebookHomePagePasswordField();
	}
}

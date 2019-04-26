package com.PacificPower.Views;

import com.PacificPower.PageObjects.FacebookHomePage;
import com.PacificPower.generic.Pojo;

public class FacebookHomeView {
	
	Pojo objPojo;
	FacebookHomePage objFacebookHomePage;
	public FacebookHomeView(Pojo objPojo){
		this.objPojo=objPojo;
		objFacebookHomePage = new FacebookHomePage(objPojo);
		
	}

	public void clickFacebookHomePageEmailField() {
		String testData = objPojo.getObjExcelHelper().dpString("NAME");
		if(!testData.equals("")) {
			objFacebookHomePage.clickFacebookHomePageEmailField();
			objFacebookHomePage.setFacebookHomePageEmail(testData);
		}
	}
	
	public void clickOnDummy() {
		objFacebookHomePage.clickOnDummy();
	}
}

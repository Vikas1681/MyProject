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
		System.out.println("excelObject"+objPojo.getObjExcelHelper());
		String testData = objPojo.getObjExcelHelper().dpString("NAME");
		System.out.println("testData is"+testData);
		if(!testData.equals("")) {
			objFacebookHomePage.clickFacebookHomePageEmailField();
			objFacebookHomePage.setFacebookHomePageEmail(testData);
		}
	}
	
	public void clickOnDummy() {
		objFacebookHomePage.clickOnDummy();
	}
}

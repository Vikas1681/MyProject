package com.PacificPower.PageObjects;

import org.openqa.selenium.By;

import com.PacificPower.generic.Pojo;

public class FacebookHomePage {

	Pojo objPojo;
	By inpEmailOrPhone = By.xpath("//input[@id='email']");
	By inpPass = By.xpath("//input[@name='pass']");
	By inpDummy = By.xpath("//input[@id='ghjjj']");

	public FacebookHomePage(Pojo objPojo) {
		this.objPojo = objPojo;
	}

	public void clickFacebookHomePageEmailField() {
		//objPojo.getObjCommonFunction().click(inpEmailOrPhone);
		objPojo.getObjUtility().verifyResult("click on email field",objPojo.getObjCommonFunction().click(inpEmailOrPhone));
	}

	public void clickOnDummy() {
		objPojo.getObjUtility().verifyResult("click on dummy field",objPojo.getObjCommonFunction().click(inpDummy));
	}

	public void setFacebookHomePageEmail(String email) {
		objPojo.getObjCommonFunction().sendKeys(inpEmailOrPhone, email);
	}
}

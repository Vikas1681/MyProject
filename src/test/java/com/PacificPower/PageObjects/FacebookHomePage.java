package com.PacificPower.PageObjects;

import java.util.List;

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
		objPojo.getObjUtility().verifyResult("click on email field",
				objPojo.getObjCommonFunction().click(inpEmailOrPhone));
	}

	public void clickOnDummy() {
		objPojo.getObjUtility().verifyResult("click on dummy field", objPojo.getObjCommonFunction().click(inpDummy));
	}

	public void setFacebookHomePageEmail(String email) {
		objPojo.getObjUtility().verifyResult("enter username or eamil",
				objPojo.getObjCommonFunction().sendKeys(inpEmailOrPhone, email));
//		List<org.openqa.selenium.WebElement> list = objPojo.getDriver().findElements(inpEmailOrPhone);

	}

	public void clickFacebookHomePagePasswordField() {
		objPojo.getObjUtility().verifyResult("click on Password Field", objPojo.getObjCommonFunction().click(inpPass));
	}

	public void setFacebookHomePagePassword(String password) {
		objPojo.getObjUtility().verifyResult("enter password on facebook home page",
				objPojo.getObjCommonFunction().sendKeys(inpPass, password));
	}
}

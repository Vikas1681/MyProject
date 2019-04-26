package com.PacificPower.generic;

import org.openqa.selenium.By;

public class  CommonFunction {

	Pojo objPojo;

	CommonFunction(Pojo objPojo) {
		this.objPojo = objPojo;
	}

	public boolean click(By locator) {
		try {
			objPojo.getDriver().findElement(locator).click();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean sendKeys(By locator, String textToEnter) {
		try {
		objPojo.getDriver().findElement(locator).sendKeys(textToEnter);
		return true;
		}
		catch(Exception e) {
			return false;
		}
	}

}

package com.PacificPower.Utility;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.PacificPower.generic.Pojo;

public class Utility {
	
	Pojo objPojo;
	ScreenshotHelper screenshotHelper;
	Logger log;
	
	public Utility(Pojo objPojo) {
		this.objPojo = objPojo;
		screenshotHelper = new ScreenshotHelper();
	}
	
	public void setLog() {
		log = LogManager.getLogger(Utility.class);
		objPojo.setObjLog(log);
	}
	
	public void verifyResult(String step,boolean resultLog) {
		if(resultLog) {
			log.info(step+":"+"Passed");
		}
		else {
			log.info(step+":"+"Failed");
			screenshotHelper.takeScreenshot(objPojo.getDriver(), "screenshot");
		}
	}

}

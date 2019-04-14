package com.PacificPower.Utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotHelper {

	public void takeScreenshot(WebDriver driver, String screenshotName) {
		TakesScreenshot takeScreenshot = (TakesScreenshot) driver;
		File source = takeScreenshot.getScreenshotAs(OutputType.FILE);
		String dest = System.getProperty("user.dir") + "\\Screenshots\\" + "screenshotName" + ".png";
		File destinationFile = new File(dest);
		try {
			FileUtils.copyFile(source, destinationFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

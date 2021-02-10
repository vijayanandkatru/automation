package com.sdindia.utils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.service.ExtentTestManager;

public class DriverUtils {

	private WebDriver driver;

	public DriverUtils(WebDriver driver) {
		this.driver = driver;

	}

	
	public void waitUnitAnimateLogiDisappears() {
		WebDriverWait  wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.xpath("//img[contains(@src,'logo-animate.gif')]"))));
		
	}
	
	public void waitUnitAnimateLogAppears() {
		WebDriverWait  wait = new WebDriverWait(driver, 7);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//img[contains(@src,'logo-animate.gif')]"))));
		
	}
	
	public boolean isElementPresent1(By locatorKey) {
		try {
			driver.findElement(locatorKey);
			return true;
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}

	public boolean isElementNotPresent(By locator) {
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

		if (driver.findElements(locator).size() < 1) {
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			return true;
		} else {
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			return false;

		}

	}

	
	public void embedScreenShotStep(String stepInfo) {
		
		try {
			Thread.sleep(2000);
			
			String ss = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
			ExtentTestManager.getTest().log(Status.INFO, stepInfo,MediaEntityBuilder.createScreenCaptureFromBase64String(ss).build());
			// ExtentTestManager.getTest().log(Status.ERROR, result.getThrowable());
		} catch (Exception e) {
			e.printStackTrace();
		
		}
	}
}

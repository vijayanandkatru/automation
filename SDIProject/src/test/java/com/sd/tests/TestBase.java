package com.sd.tests;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.service.ExtentTestManager;
import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import com.sdindia.utils.Utils;

@Listeners({ ExtentITestListenerClassAdapter.class })
public class TestBase {
	public WebDriver driver;
	public Properties prop;

	@BeforeClass
	@Parameters({ "browserName", "onGrid" })

	public void setUp(@Optional("chrome") String browserName, @Optional("false") String runOnGrid) {

		prop = Utils.loadConfigProperties();

		if (runOnGrid.equalsIgnoreCase("false")) {
			driver = Utils.selectBrowserDriver(browserName);
		} else {
			driver = Utils.selectGridBrowserDriver(browserName);
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(prop.getProperty("implicit.timeout")),
				TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
		driver.get(prop.getProperty("app.url"));

	}

	@AfterClass
	public void tearDown() {
		System.out.println("Closing the browser");
		// driver.quit();
	}

	@AfterMethod(alwaysRun = true)
	public void afterMethod(ITestResult result) {
		System.out.println("result of " + result.getStatus() + "name : " + result.getMethod().getMethodName());
		if (result.getStatus() == ITestResult.FAILURE) {

			String ss = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
			try {
				ExtentTestManager.getTest().fail("Failed test case : " + result.getMethod().getMethodName(),
						MediaEntityBuilder.createScreenCaptureFromBase64String(ss).build());
				// ExtentTestManager.getTest().log(Status.ERROR, result.getThrowable());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		if (result.getStatus() == ITestResult.SUCCESS) {

			String ss = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
			try {
				ExtentTestManager.getTest().pass("Passed test case : " + result.getMethod().getMethodName(),
						MediaEntityBuilder.createScreenCaptureFromBase64String(ss).build());
				// ExtentTestManager.getTest().log(Status.ERROR, result.getThrowable());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}

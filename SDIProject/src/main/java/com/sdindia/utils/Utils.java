package com.sdindia.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Utils {
	public static int getRandInt(int min, int max) {
		return ThreadLocalRandom.current().nextInt(min, max + 1);
	}

	public static void wait(int timeInMilliSec) {
		try {
			Thread.sleep(timeInMilliSec);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static char getRandomAlpha() {

		return (char) getRandInt(65, 90);
	}

	public static String getRandomName() {
		String[] name = new String[] { "Khan", "Reddy", "Green", "Lee", "Abdul", "Ping", "Ching", "John", "Paaji",
				"Bhai", "Anna", "Shaik", "Rao", "Kim", "Tim", "Laam", "Osborn" };
		return name[ThreadLocalRandom.current().nextInt(0, name.length)];
	}

	public static String getRandomEmail() {
		String[] name = new String[] { "@gmail.com", "@outlook.com", "@bt.com", "@aol.com", "@yahoo.co.uk", "@live.com",
				"@hotmail.com" };
		return name[ThreadLocalRandom.current().nextInt(0, name.length)];
	}
	public static String getTimeStamp() {
		return  new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

	}

	public static Properties loadConfigProperties() {
		Properties prop = null;
		try (InputStream input = new FileInputStream("src/test/resources/config.properties")) {

			prop = new Properties();
			prop.load(input);

		} catch (IOException ex) {
			ex.printStackTrace();
		}
		System.out.println("Config.properties Loaded...");
		return prop;

	}

	public static WebDriver selectBrowserDriver(String browserName) {
		WebDriver driver = null;
		switch (browserName.toLowerCase()) {

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println("Firefox browser Selected");
			return driver;

		case "firefox-headless":
			WebDriverManager.firefoxdriver().setup();
			FirefoxBinary firefoxBinary = new FirefoxBinary();
			firefoxBinary.addCommandLineOptions("--headless");
			FirefoxOptions options = new FirefoxOptions();
			options.setBinary(firefoxBinary);
			driver = new FirefoxDriver(options);

			System.out.println("Firefox headless browser Selected");
			return driver;

		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("Chrome browser Selected");
			return driver;
			
		/*case "chrome-headless":
			ChromeOptions options1 = new ChromeOptions();
			options1.addArguments("window-size=1400,800");
			
			options1.addArguments("headless");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options1);
			System.out.println("chrome headles browser Selected");
			return driver;*/

		case "ie":
			WebDriverManager.iedriver().arch32().setup();
			driver = new InternetExplorerDriver();
			System.out.println("IE browser Selected");
			return driver;

		case "edge":
			// WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			System.out.println("Edge browser Selected");
			return driver;

		case "chrome-headless":
			// WebDriverManager.chromedriver().setup();
			ChromeOptions options1 = new ChromeOptions();
			options1.addArguments("--headless");
			// options.addArguments("--disable-gpu");
			driver = new ChromeDriver(options1);
			System.out.println("Chrome headless browser Selected");
			return driver;

		default:
			System.out.println("I donot know which browser is this");
			return driver;

		}

	}

	public static WebDriver selectGridBrowserDriver(String browserName) {
		WebDriver driver = null;
		String clientURL = "http://localhost:4444/wd/hub"; // assuming you are running the hub on localhost

		DesiredCapabilities capabilities = new DesiredCapabilities();
		switch (browserName.toLowerCase()) {

		case "firefox":
			// WebDriverManager.firefoxdriver().setup();
			capabilities.setBrowserName("firefox");
			capabilities.setPlatform(Platform.WINDOWS);

			break;

		case "chrome":
			// WebDriverManager.chromedriver().setup();
			capabilities.setBrowserName("chrome");
			capabilities.setPlatform(Platform.WINDOWS);
			ChromeOptions options = new ChromeOptions();
			options.merge(capabilities);
			break;

		case "ie":
			// WebDriverManager.iedriver().arch32().setup();
			capabilities.setBrowserName("internet explorer");
			capabilities.setPlatform(Platform.WINDOWS);
			System.out.println("IE browser Selected");
			break;

		}
		try {
			driver = new RemoteWebDriver(new URL(clientURL), capabilities);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return driver;
	}
}

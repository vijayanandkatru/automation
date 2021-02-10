package com.sdindia.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Reg_Securitydetails {
	private WebDriver driver;
	
	By unam = By.name("User_Name");
	By pswrd = By.name("Password");
	By rpsw = By.name("Re_Password");
	By tc = By.name("Agree");
	By sbtfom = By.xpath("//button[@ng-click='insertNewDistributor()']");
	
	public Reg_Securitydetails(WebDriver driver) {
		this.driver = driver;
	}
	public void securtityDetails(String username, String Password, String ConfirmPassword) {
	driver.findElement(unam).sendKeys(username);
	driver.findElement(pswrd).sendKeys(Password);
	driver.findElement(rpsw).sendKeys(ConfirmPassword);
	driver.findElement(tc).click();
	driver.findElement(sbtfom).click();
}
}
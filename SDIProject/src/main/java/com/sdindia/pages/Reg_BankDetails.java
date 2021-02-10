package com.sdindia.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Reg_BankDetails {
	private WebDriver driver;
	
	By bnnma = By.name("Bank_Name");
	By brnam = By.name("Branch_Name");
	By actnum = By.name("Acc_No");
	By pan = By.name("Pan_No");
	By ifs = By.name("Ifsc_code");
	By gst = By.name("GSTIN_code");
	By aadhr = By.name("Aadhar_No");
	
	public Reg_BankDetails(WebDriver driver) {
		this.driver = driver;
	}
	
	public void bankDetails(String BankName, String BankBranch, String AccountNum, String PanNum, String ifsccode, String GSTCode, String aadharno) {
		
	
	driver.findElement(bnnma).sendKeys(BankName);
	driver.findElement(brnam).sendKeys(BankBranch);
	driver.findElement(actnum).sendKeys(AccountNum);
	driver.findElement(pan).sendKeys(PanNum);
	driver.findElement(ifs).sendKeys(ifsccode);
	driver.findElement(gst).sendKeys(GSTCode);
	driver.findElement(aadhr).sendKeys(aadharno);
}
}
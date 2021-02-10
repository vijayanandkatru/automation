package com.sdindia.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class Reg_Billingshiiping {
	private WebDriver driver;
	
	By bladrs = By.name("Bill_Add1");
	By bsrt = By.name("Bill_Add2");
	By state = By.name("Bill_State");
	By cty = By.name("Bill_City");
	By pstlcod = By.name("Bill_PostalCode");
	By mmail = By.name("Mem_Email");
	By mobil = By.name("Mem_Mobile");
	By shpadrs = By.name("chk_shipaddress");
	By delvry = By.name("Prefered_Delivery");
	
	public Reg_Billingshiiping(WebDriver driver) {
		this.driver = driver;
	}
	
	public void billing_Shippingetails(String BillingAddress1, String BillingAdress2, String PostalCode, String MEmail, String MMobile) {
	
	driver.findElement(bladrs).sendKeys(BillingAddress1);
		driver.findElement(bsrt).sendKeys(BillingAdress2);

		Select stat = new Select(driver.findElement(state));
		stat.selectByVisibleText("Karnataka");

		Select city = new Select(driver.findElement(cty));
		city.selectByIndex(1);

		driver.findElement(pstlcod).sendKeys(PostalCode);

		driver.findElement(mmail).sendKeys(MEmail);
		driver.findElement(mobil).sendKeys(MMobile);
		driver.findElement(shpadrs).click();;
		Select delivery = new Select(driver.findElement(delvry));
		delivery.selectByIndex(1);
		}
	}

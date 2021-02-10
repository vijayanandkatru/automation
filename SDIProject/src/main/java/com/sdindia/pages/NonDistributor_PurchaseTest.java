package com.sdindia.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NonDistributor_PurchaseTest {

	private WebDriver driver;
	
	By saname = By.xpath("//input[@name='Mem__FirstName_Name'][@type='text']");
	By saemail = By.xpath("//input[@name='Mem_Shipp_Email']");
	By samblnum = By.xpath("//input[@name='Mem_Shipp_Mobile']");
	By saaddrs1 = By.xpath("//input[@name='Ship_add1']");
	By saaddrs2 = By.xpath("//input[@name='Ship_Add2']");
	By shpstate = By.xpath("//select[@name='Ship_State']");
	By shpcty = By.xpath("//select[@name='Ship_City']"); 
	By sapstlcode = By.xpath("//input[@name='Ship_PostalCode']");
	By sanetbnkg = By.xpath("//input[@name='PaymentMethod'][@value='Net Banking']");
	By sacrdtdebt = By.xpath("//input[@name='PaymentMethod'][@value='Credit/Debit Card']");
	By procedPay = By.xpath("//*[@ng-click='btnPlaceOrder(false,formregistration)']");
	By regproced = By.xpath("//button[@ng-click='registrationPC(formregistration)']");
	
	public NonDistributor_PurchaseTest(WebDriver driver) {
		this.driver = driver;
	}
	
	public void nondist_purchaseorder(String name, String email, String miblnumbr, String postalcod) {
		
		WebDriverWait  wait = new WebDriverWait(driver, 30);
		
		driver.findElement(saname).sendKeys(name);
		driver.findElement(saemail).sendKeys(email);
		driver.findElement(samblnum).sendKeys(miblnumbr);
		driver.findElement(saaddrs1).sendKeys("31,Edkal Technologis,Koramangala,Bangalore");
		driver.findElement(saaddrs2).sendKeys("31,Edkal Technologis,Koramangala,Bangalore");
		Select state = new Select(driver.findElement(shpstate));
		state.selectByVisibleText("Karnataka");;
		
		Select city = new Select(driver.findElement(shpcty));
		city.selectByIndex(6);
		
		driver.findElement(sapstlcode).sendKeys(postalcod);
		driver.findElement(sanetbnkg).click();
		
		//driver.findElement(sacrdtdebt).sendKeys(miblnumbr);
		//driver.findElement(procedPay).click();
		
	}
	
	public void proceedtopay() {
		driver.findElement(procedPay).click();
	}
	
	public void registerproceedtopay() {
		driver.findElement(regproced).click();
	}
}

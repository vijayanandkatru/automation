package com.sdindia.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Distributor_LoginWithValidCredentialsPage {
	private WebDriver driver;
	
	By lgo = By.xpath("//img[@class=\"logo-img img-responsive\"]");
	
	By lgin = By.id("liLogin");
	
	By uname =By.xpath("//input[@name='loginUsername']");

	By upsw = By.name("loginPassword");
	
	By lgnbtn = By.xpath("//input[@type='submit'][@ng-click='loginAction()']");
	
	By vrfytxt = By.xpath("//span[@id='lnkAccInfo']");
	
	By lgout = By.xpath("//a[@id='liLogOut']");
	//a[@id='liLogOut']
	
	
	public Distributor_LoginWithValidCredentialsPage (WebDriver driver) {
		this.driver = driver;
	}
	
	public void verifyLogo() {
		boolean logo = driver.findElement(lgo).isDisplayed();
		
	}
	
	public void liginclick() {
		driver.findElement(lgin).click();
	}
	
	public void userlogin(String username, String password) {
		driver.findElement(uname).sendKeys(username);
		driver.findElement(upsw).sendKeys(password);
		driver.findElement(lgnbtn).click();
		
	}
	
	public void verifyid() {
		String distID = driver.findElement(vrfytxt).getText();
		System.out.println("Distributor ID is"+distID);
		}
	
	public void logout() {
		driver.findElement(lgout).click();
	}

}
;
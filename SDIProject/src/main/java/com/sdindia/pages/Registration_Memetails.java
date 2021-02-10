package com.sdindia.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Registration_Memetails {
	private WebDriver driver;
	
	By mtitl = By.name("Mem_Title");
	By mname = By.name("First_Name");
	By mmname = By.name("Middle_Name");
	By mlstname = By.name("Last_Name");
	By fhtitl = By.name("FH_Title");
	By fname = By.name("Father_Fname");
	By fmnam = By.name("Father_Mname");
	By flnam = By.name("Father_Lname");
	By dtob = By.name("Mem_DOB");
	By dpckr = By.id("ui-datepicker-div");
	By dpckyer = By.xpath("//select[@class='ui-datepicker-year'][@data-handler='selectYear']");
	By dpdate = By.xpath("//a[@class='ui-state-default']");
	By gen = By.name("Mem_Gender");
	By mstatus = By.name("Maritual_Status");
	By nfnam = By.name("Ne_Fname");
	By rltn = By.name("Ne_Relation");
	By nmdob = By.id("txtNeDOB");
	
	public Registration_Memetails(WebDriver driver) {
		this.driver = driver;
	}
	
	public void memberdetails(String MemFname, String MemMname, String MemLName, String FFname, String FMname, String FLname, String NFname) {
	Select memtitl = new Select(driver.findElement(mtitl));
	memtitl.selectByIndex(1);
	
	driver.findElement(mname).sendKeys(MemFname);
	driver.findElement(mmname).sendKeys(MemMname);
	driver.findElement(mlstname).sendKeys(MemLName);
	
	Select ftitl = new Select(driver.findElement(fhtitl));
	ftitl.selectByIndex(1);
	
	driver.findElement(fname).sendKeys(FFname);
	driver.findElement(fmnam).sendKeys(FMname);
	driver.findElement(flnam).sendKeys(FLname);
	
	WebElement didob = driver.findElement(dtob);//.sendKeys(dbirth);
	didob.click();
	
	WebElement dobyer = driver.findElement(dpckyer);
	dobyer.click();
	
	Select dyer = new Select(driver.findElement(dpckyer));
	dyer.selectByVisibleText("1988");
	
	driver.findElement(dpdate).click();
	
	Select gendr = new Select(driver.findElement(gen));
	gendr.selectByIndex(1);

	Select maritlstus = new Select(driver.findElement(mstatus));
	maritlstus.selectByIndex(1);

	driver.findElement(nfnam).sendKeys(NFname);
	Select nrelation = new Select(driver.findElement(rltn));
	nrelation.selectByIndex(5);
	WebElement nmob = driver.findElement(nmdob);//.sendKeys(NDOB);
	//nmob.click();
	nmob.sendKeys("0925989");
}
}
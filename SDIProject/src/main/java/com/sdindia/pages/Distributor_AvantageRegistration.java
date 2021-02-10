package com.sdindia.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Distributor_AvantageRegistration {
	private WebDriver driver;

	By sgnUp = By.xpath("//a[@id='liSignUp']");
	By dstsgnlnk = By.xpath("//a [@href='/distributor-registration']");
	By spid = By.name("SponsorId");
	By spnam = By.name("SponsorName");
	By jplan = By.xpath("//select[@ng-model='reg.joiningPlan']");
	By postn = By.xpath("//select[@ng-model='reg.joiningPosition']");
	By bsnstype = By.xpath("//select[@ng-model='reg.businessType']");
	By bsnsManul = By.xpath("//select[@ng-model='reg.businessManual']");
	By submt = By.xpath("//button[@ng-click='registration()']");

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
	By mnth = By.xpath("//select[@class='ui-datepicker-month']");
	By dpdate = By.xpath("//a[@class='ui-state-default']");
	By dat = By.xpath("//a[@class='ui-state-default'][text()='4']");
	By gen = By.name("Mem_Gender");
	By mstatus = By.name("Maritual_Status");
	By nfnam = By.name("Ne_Fname");
	By rltn = By.name("Ne_Relation");
	By nmdob = By.id("txtNeDOB");

	By bladrs = By.name("Bill_Add1");
	By bsrt = By.name("Bill_Add2");
	By state = By.name("Bill_State");
	By cty = By.name("Bill_City");
	By pstlcod = By.name("Bill_PostalCode");
	By mmail = By.name("Mem_Email");
	By mobil = By.name("Mem_Mobile");
	By shpadrs = By.name("chk_shipaddress");
	By delvry = By.name("Prefered_Delivery");

	By bnnma = By.name("Bank_Name");
	By brnam = By.name("Branch_Name");
	By actnum = By.name("Acc_No");
	By pan = By.name("Pan_No");
	By ifs = By.name("Ifsc_code");
	By gst = By.name("GSTIN_code");
	By aadhr = By.name("Aadhar_No");

	By unam = By.name("User_Name");
	By pswrd = By.name("Password");
	By rpsw = By.name("Re_Password");
	By tc = By.name("Agree");
	By sbtfom = By.xpath("//button[@ng-click='insertNewDistributor()']");

	By regconfrm = By.xpath("//h3[@id='newEventModal']");

	By lgout = By.id("liLogOut");

	By continu = By.xpath("//button[@id='btnContinue']");

	By firmname = By.xpath("//input[@name='Proprietor_Firm_Name']");

	/*
	 * Distributor_RegularRegistrationPage distregulr = new
	 * Distributor_RegularRegistrationPage(driver);
	 * 
	 * By firmname = By.xpath("//input[@name='Proprietor_Firm_Name']");
	 */

	public Distributor_AvantageRegistration(WebDriver driver) {
		this.driver = driver;

	}

	public void firname_advanatge(String Firamnme) {
		driver.findElement(firmname).sendKeys("ArtificialIntelligence");

	}
	
	public void advantage_regprocess(String SponsorID) {
		WebDriverWait  wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(sgnUp)));
		
		driver.findElement(sgnUp).click();
		driver.findElement(dstsgnlnk).click();
		driver.findElement(spid).sendKeys(SponsorID);
		
		driver.findElement(firmname).sendKeys("DataScience");
	}

	public void advantage_memdeails(String distfirmname,String MemFname, String MemMname, String MemLName,
			String FFname, String FMname, String FLname, String NFname) {
		Select joinplan = new Select(driver.findElement(jplan));
		joinplan.selectByIndex(2);
		Select posistion = new Select(driver.findElement(postn));
		posistion.selectByIndex(1);
		Select businestype = new Select(driver.findElement(bsnstype));
		businestype.selectByIndex(2);
		Select businesManual = new Select(driver.findElement(bsnsManul));
		businesManual.selectByIndex(1);
		driver.findElement(submt).click();
		
		Select memtitl = new Select(driver.findElement(mtitl));
		memtitl.selectByIndex(1);
		
		driver.findElement(firmname).sendKeys(distfirmname);
		driver.findElement(mname).sendKeys(MemFname);
		driver.findElement(mmname).sendKeys(MemMname);
		driver.findElement(mlstname).sendKeys(MemLName);
	}
	/*public void advantage_regProcess(String SponsorID, String Firamnme, String MemFname, String MemMname,
			String MemLName, String FFname, String FMname, String FLname, String NFname, String BillingAddress1,
			String BillingAdress2, String PostalCode, String MEmail, String MMobile, String BankName, String BankBranch,
			String AccountNum, String PanNum, String ifsccode, String GSTCode, String aadharno, String username,
			String Password, String ConfirmPassword) {

		distregulr.registrationprocess(SponsorID);
		firname_advanatge(Firamnme);
		distregulr.memberdetails(MemFname, MemMname, MemLName, FFname, FMname, FLname, NFname);
		distregulr.billing_Shippingetails(BillingAddress1, BillingAdress2, PostalCode, MEmail, MMobile);
		distregulr.bankDetails(BankName, BankBranch, AccountNum, PanNum, ifsccode, GSTCode, aadharno);
		distregulr.securtityDetails(username, Password, ConfirmPassword);
		distregulr.regConfirmation();
	}*/

}

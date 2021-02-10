package com.sdindia.pages;

import java.awt.Robot;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sdindia.utils.DriverUtils;
import com.sdindia.utils.ExcelUtil;
import com.sdindia.utils.Utils;

public class Distributor_RegularRegistrationPage {
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
	
	

	public Distributor_RegularRegistrationPage(WebDriver driver) {
		this.driver = driver;
	}

	public void registrationprocess(String SponsorID) {
		
		WebDriverWait  wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(sgnUp)));

		driver.findElement(sgnUp).click();
		driver.findElement(dstsgnlnk).click();
		driver.findElement(spid).sendKeys(SponsorID);
		//spienter.sendKeys(SponsorID);
				
		// Simulate key Events
		//spienter.sendKeys(Keys.TAB);
		//spienter.sendKeys(Keys.ENTER);
	}
	
	public void advfirmname() {
		driver.findElement(firmname).sendKeys("DataScience");
		
	}
		public void memberdetails(String MemFname, String MemMname, String MemLName,
				String FFname, String FMname, String FLname, String NFname) {
		//driver.findElement(spnam).sendKeys(Sponsorname);
			//**Comment for New System Changes**//
		/*Select joinplan = new Select(driver.findElement(jplan));
		joinplan.selectByIndex(1);
		Select posistion = new Select(driver.findElement(postn));
		posistion.selectByIndex(1);*/
		Select businestype = new Select(driver.findElement(bsnstype));
		businestype.selectByIndex(1);
		Select businesManual = new Select(driver.findElement(bsnsManul));
		businesManual.selectByIndex(1);
		driver.findElement(submt).click();
		
	
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
			dyer.selectByVisibleText("1999");
			
			driver.findElement(mnth).click();
			Select dbmnth = new Select(driver.findElement(mnth));
			dbmnth.selectByVisibleText("Aug");
			
			driver.findElement(dat).click();
			
			//driver.findElement(dpdate).click();
			
			Select gendr = new Select(driver.findElement(gen));
			gendr.selectByIndex(1);

			Select maritlstus = new Select(driver.findElement(mstatus));
			maritlstus.selectByIndex(1);

			driver.findElement(nfnam).sendKeys(NFname);
			Select nrelation = new Select(driver.findElement(rltn));
			nrelation.selectByIndex(5);
			WebElement nmob = driver.findElement(nmdob);//.sendKeys(NDOB);
			//nmob.click();
			//nmob.sendKeys("0925989");
		}
	
		
		
			public void billing_Shippingetails(String BillingAddress1, String BillingAdress2,
					String PostalCode, String MEmail, String MMobile) {
			driver.findElement(bladrs).sendKeys(BillingAddress1);
				driver.findElement(bsrt).sendKeys(BillingAdress2);

				Select stat = new Select(driver.findElement(state));
				stat.selectByVisibleText("Maharashtra");
				
				 Actions action = new Actions(driver); 
				   action.sendKeys(Keys.ENTER).build().perform();

				Select city = new Select(driver.findElement(cty));	
				city.selectByIndex(1);

				driver.findElement(pstlcod).sendKeys(PostalCode);
				
				driver.findElement(mmail).sendKeys(MEmail);
				
				driver.findElement(mobil).sendKeys(MMobile);
				driver.findElement(shpadrs).click();;
				Select delivery = new Select(driver.findElement(delvry));
				delivery.selectByIndex(1);
				
			}
		
		
			public void bankDetails(String BankName, String BankBranch, String AccountNum,
					String PanNum, String ifsccode, String GSTCode, String aadharno) {
			
			driver.findElement(bnnma).sendKeys(BankName);
			driver.findElement(brnam).sendKeys(BankBranch);
			
			driver.findElement(actnum).sendKeys(AccountNum);
		
			
			
			driver.findElement(pan).sendKeys(PanNum);
			driver.findElement(ifs).sendKeys(ifsccode);
			
			driver.findElement(gst).sendKeys(GSTCode);
			
			
			driver.findElement(aadhr).sendKeys(aadharno);
		
			}
		
		public void securtityDetails(String username, String Password,
				String ConfirmPassword) {
			
			driver.findElement(unam).sendKeys(username);
			driver.findElement(pswrd).sendKeys(Password);
			driver.findElement(rpsw).sendKeys(ConfirmPassword);
			driver.findElement(tc).click();
			driver.findElement(sbtfom).click();
			
			/*if(driver.findElement(regconfrm).isDisplayed()){
				System.out.println("Registration is successful");
			}
			else {
				System.out.println("Registration is failed");
			}*/
		}
	

		public String regConfirmation() {
		//	//DriverUtils du = new DriverUtils(driver);
	//du.waitUnitAnimateLogiDisappears();
			
	WebDriverWait  wait = new WebDriverWait(driver, 30);
	wait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.xpath("//img[contains(@src,'logo-animate.gif')]"))));
	wait.until(ExpectedConditions.visibilityOf(driver.findElement(continu)));
			return driver.findElement(regconfrm).getText();
	
		}
		
		public void Continue_logout() throws InterruptedException {
			
			driver.findElement(continu).click();
			DriverUtils du = new DriverUtils(driver);
			//du.waitUnitAnimateLogiDisappears();
			//Thread.sleep(7000);
			WebDriverWait  wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(lgout)));
			
			driver.findElement(lgout).click();
			//du.waitUnitAnimateLogAppears();
			du.waitUnitAnimateLogiDisappears();

			
		}
	
}

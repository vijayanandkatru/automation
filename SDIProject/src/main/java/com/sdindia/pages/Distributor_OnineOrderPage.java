package com.sdindia.pages;

import org.jsoup.select.Evaluator.Id;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Distributor_OnineOrderPage {
	private WebDriver driver;

	By cart = By.xpath("//a[@id='cart']/i[@class='fa fa-shopping-cart']");
	By contshopng = By.xpath("//button[@id='btnContinueShoping']");
	//Alternate for click on Shop
	//By Contunushp = By.xpath("//span[@class='cartQuantityitem']");
	By product = By.xpath("(//a[contains(text(),'Add to cart')])[2]");
	By cartqt = By.xpath("xpath=//a[@id='cart']/i");
	By tc = By.xpath("//input[@name='AgreeTerms']");

	By chkout = By.xpath("//button[contains(.,'Checkout')]");

	By shipmentmode = By.xpath("//input[@name='chkShipMode'][1]");
	By shipmode = By.xpath("//input[@name='chkShipMode'][2]");
	
	
	// By.cssSelector(".ng-pristine.ng-empty.ng-invalid.ng-invalid-required.ng-touched");
	By pickbranch = By.xpath("//select[@ng-model='formCheckout.selPkLocation']");
	By paynw = By.xpath("//input[@name='PaymentType'][@value='OL']");
	By pymethod = By.xpath("//input[@name='PaymentMethod'][@value='Net Banking']");
	By paymentmthd = By.xpath("//input[@name='PaymentMethod'][@value='Credit/Debit Card']");
	By captcha = By.xpath("//div[@id='divCaptcha']");
	By pcaptcha = By.xpath("//input[@name='validateReCaptcha']");
	By cretOrdr = By.xpath("//button[@class='btn btn-dm'][@ng-click='proceedtoPayment()']");
	//By cretOrdr = By.xpath("//button[@ng-click='btnPlaceOrder()']");
	// By ntbanng = By.id("//div[@id='netbanking']");
	By ntbank = By.xpath("//a[@href='#netbanking']");
	
	By slctBank = By.xpath("//select[@name='bankID']");
	
	By netbankcc= By.xpath("//a[@href='#creditcard'][@class='left-arrow']");
	By creditcrdno = By.xpath("//input[@id='ccCardNo']");
	By ccMonth = By.xpath("//select[@name='ccMonth']");
	By ccYear = By.xpath("//select[@name='ccYear']");
	By ccnum = By.xpath("//input[@name='ccCcv']");
	By nameoncc = By.xpath("//input[@name='ccCardName']");
	By bnkname = By.xpath("//input[@id='ccbinBankName']");
	By mblnum = By.xpath("//input[@id='ccSavedMobNumber']");
	By ccmail = By.xpath("//input[@id='ccSavedEmail']");
	By chekbx = By.xpath("//input[@id='sInstruction']");
	By pynw = By.xpath("//input[@id='paymentProcess']");
	By simulate = By.xpath("//input[@name='submit'][@value='Simulate Transaction']");
	
	//************DebitCard Payment*********//
	
	By netbankDc= By.xpath("//a[@href='#debitcard']");
	By deditcrdno = By.xpath("//input[@name='dcCardNo']");
	By dcMnth = By.xpath("//select[@name='dcMonth']");
	By dcYear = By.xpath("//select[@name='dcYear']");
	By dccvv = By.xpath("//input[@id='dcCcv']");
	By dcname = By.xpath("//input[@name='dcCardName']");
	By dcbanknam = By.xpath("//input[@name='dcbinBankName']");
	By dcMblnum = By.xpath("//input[@name='dcSavedMobNumber']");
	By dcemail = By.xpath("//input[@name='dcSavedEmail']");
	By dcpynw = By.xpath("//input[@id='paymentProcess']");
	
	
	By pynow = By.xpath("//input[@value='Pay Now']");
	//By cmplttrnsctin = By.ByXPath(//input[@type='submit']);
	By cmplttrnsctn = By.xpath("//input[@value='Click To Complete Transaction']");
	By Ordersucess = By.xpath("//h2[@ng-if='success']");
	By OrderID = By.xpath("//div[2]/h3");
	
	public void OrderProduct(WebDriver driver) throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(cart).click();
		
		Thread.sleep(3000);
		driver.findElement(contshopng).click();
		Thread.sleep(3000);
		driver.findElement(product).click();
		Thread.sleep(3000);
		driver.findElement(cart).click();
		
		driver.findElement(tc).click();
		driver.findElement(chkout).click();

	}

	public void order_checkout(WebDriver driver) {

		driver.findElement(shipmode).click();
		Select pckbrnch = new Select(driver.findElement(pickbranch));
		pckbrnch.selectByIndex(1);
		driver.findElement(paynw).click();
		driver.findElement(pymethod).click();
		WebElement cpthdta = driver.findElement(captcha);
		String cpthdata = cpthdta.getText();
		driver.findElement(pcaptcha).sendKeys(cpthdata);
		driver.findElement(cretOrdr).click();
	}
	
	public void order_netbank_creditcard(WebDriver driver) {
		driver.findElement(shipmentmode).click();
		Select pckbrnch = new Select(driver.findElement(pickbranch));
		pckbrnch.selectByIndex(3);
		driver.findElement(paynw).click();
		driver.findElement(pymethod).click();
		WebElement cpthdta = driver.findElement(captcha);
		String cpthdata = cpthdta.getText();
		driver.findElement(pcaptcha).sendKeys(cpthdata);
		driver.findElement(cretOrdr).click();
	}

	public void payment_gateway(WebDriver driver) {
		driver.findElement(ntbank).click();
		Select slcbnk = new Select(driver.findElement(slctBank));
		slcbnk.selectByIndex(0);

		driver.findElement(pynow).click();
		driver.findElement(cmplttrnsctn).click();

		driver.switchTo().alert().accept();
		
		System.out.println(driver.findElement(Ordersucess).getText());
	}
	
	public void payment_AtomCreditCard(WebDriver driver) {
		driver.findElement(netbankcc).click();
		driver.findElement(creditcrdno).sendKeys("4012888888881881");
		Select ccmonth=new Select(driver.findElement(dcMnth));
		ccmonth.selectByIndex(11);
		Select ccyer = new Select(driver.findElement(ccYear));
		ccyer.selectByIndex(6);
		
		driver.findElement(ccnum).sendKeys("456");
		driver.findElement(nameoncc).sendKeys("vijayanand");
		//driver.findElement(bnkname).sendKeys("456");
		driver.findElement(mblnum).sendKeys("1324124351");
		
		driver.findElement(ccmail).sendKeys("fhafefab@mailinator.com");
		driver.findElement(chekbx).click();
		driver.findElement(pynw).click();
		driver.findElement(simulate).click();
		driver.switchTo().alert().accept();
		driver.switchTo().alert().accept();
	}
	
	
	public void payment_AtomDebitCard(WebDriver driver) {
		driver.findElement(netbankDc).click();
		driver.findElement(deditcrdno).sendKeys("5555555555554444");
		Select dcmonth=new Select(driver.findElement(dcMnth));
		dcmonth.selectByIndex(11);
		Select dcyer = new Select(driver.findElement(dcYear));
		dcyer.selectByIndex(6);
		
		driver.findElement(dccvv).sendKeys("123");
		driver.findElement(dcname).sendKeys("vijayanand");
		//driver.findElement(bnkname).sendKeys("456");
		driver.findElement(dcMblnum).sendKeys("1324124351");
		
		driver.findElement(dcemail).sendKeys("fhafefab@mailinator.com");
		
		driver.findElement(dcpynw).click();
		
		driver.findElement(simulate).click();
		driver.switchTo().alert().accept();
		driver.switchTo().alert().accept();
		
	}
	
	public void Order_success(WebDriver driver) {
		 System.out.println(driver.findElement(OrderID).getText());
		
		
}
}
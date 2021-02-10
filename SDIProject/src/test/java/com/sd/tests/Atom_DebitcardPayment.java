package com.sd.tests;

import org.testng.annotations.Test;

import com.sdindia.pages.Distributor_LoginWithValidCredentialsPage;
import com.sdindia.pages.Distributor_OnineOrderPage;

public class Atom_DebitcardPayment extends TestBase{
	
	@Test
	public void atombankDebitcardPayment() throws InterruptedException {
		String unam = prop.getProperty("app.username");
		String psw = prop.getProperty("app.password");
		
		Distributor_LoginWithValidCredentialsPage credentials = new Distributor_LoginWithValidCredentialsPage(driver);
		Distributor_OnineOrderPage samiOrder = new Distributor_OnineOrderPage();
		credentials.liginclick();
		credentials.userlogin(unam, psw);
		samiOrder.OrderProduct(driver);
		samiOrder.order_checkout(driver);
		samiOrder.payment_AtomDebitCard(driver);
		samiOrder.Order_success(driver);
	}

}

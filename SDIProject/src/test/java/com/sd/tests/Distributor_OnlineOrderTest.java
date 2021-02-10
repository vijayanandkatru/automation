package com.sd.tests;

import org.testng.annotations.Test;

import com.sdindia.pages.Distributor_OnineOrderPage;
import com.sdindia.pages.Distributor_LoginWithValidCredentialsPage;

public class Distributor_OnlineOrderTest extends TestBase {

	@Test
	public void distriutor_Orderprocess() throws InterruptedException {
		String unam = prop.getProperty("app.username");
		String psw = prop.getProperty("app.password");

		Distributor_LoginWithValidCredentialsPage credentials = new Distributor_LoginWithValidCredentialsPage(driver);
		Distributor_OnineOrderPage samiOrder = new Distributor_OnineOrderPage();
		credentials.liginclick();
		credentials.userlogin(unam, psw);
		samiOrder.OrderProduct(driver);
		samiOrder.order_checkout(driver);
		samiOrder.payment_gateway(driver);
		samiOrder.Order_success(driver);

	}

}

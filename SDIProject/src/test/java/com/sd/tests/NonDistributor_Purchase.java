package com.sd.tests;

import org.testng.annotations.Test;

import com.sdindia.pages.Distributor_OnineOrderPage;
import com.sdindia.pages.NonDistributor_PurchaseTest;
import com.sdindia.utils.Utils;

public class NonDistributor_Purchase extends TestBase_NonDistributor {
	@Test
	
	public void nonDitstributor_Orderprocess() {
		prop.getProperty("app.nondisturl");
		
		NonDistributor_PurchaseTest ndst = new NonDistributor_PurchaseTest(driver);
		
		String name = Utils.getRandomName() + Utils.getRandomAlpha() + Utils.getRandomAlpha()
		+ Utils.getRandomAlpha() + Utils.getRandomAlpha() + Utils.getRandomAlpha();
		
		String email = Utils.getRandomName() + Utils.getRandInt(10000, 99999) + Utils.getRandomEmail();
		String miblnumbr = "44" + Utils.getRandInt(1000, 9999) + Utils.getRandInt(1000, 9999);
		
		String postalcod = "55"+Utils.getRandInt(1000, 9999);
		ndst.nondist_purchaseorder(name, email, miblnumbr, postalcod);
		
		//ndst.proceedtopay();
		ndst.registerproceedtopay();
		Distributor_OnineOrderPage ditpymt = new Distributor_OnineOrderPage();
		
		ditpymt.payment_gateway(driver);
		
	}

}

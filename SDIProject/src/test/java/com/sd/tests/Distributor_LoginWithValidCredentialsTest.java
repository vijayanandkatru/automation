package com.sd.tests;



import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.sdindia.pages.Distributor_LoginWithValidCredentialsPage;


public class Distributor_LoginWithValidCredentialsTest extends TestBase {
	@Test
	public void loginwithValid()  {
		String unam = prop.getProperty("app.username");
		String psw = prop.getProperty("app.password");
		
		Distributor_LoginWithValidCredentialsPage lgncrdntls = new Distributor_LoginWithValidCredentialsPage(driver);
		lgncrdntls.verifyLogo();
		lgncrdntls.liginclick();
		lgncrdntls.userlogin(unam,psw);
		lgncrdntls.verifyid();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		lgncrdntls.logout();
		//String idverifcation = lgncrdntls.verifyid();
		//assertTrue(idverifcation);
		
		
		}
		
}

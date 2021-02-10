package com.sd.tests;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sdindia.pages.Distributor_AvantageRegistration;
import com.sdindia.pages.Distributor_RegularRegistrationPage;
import com.sdindia.utils.DriverUtils;
import com.sdindia.utils.ExcelUtil;
import com.sdindia.utils.Utils;

public class Advantage_Registration extends TestBase {
	
	@Test(dataProvider = "advregistration")
	public void registrtion_advantage(String SponsorID, String MemFname, String MemMname, String MemLName,
			String FFname, String FMname, String FLname, String NFname,String BillingAddress1, String BillingAdress2,
			String PostalCode, String MEmail, String MMobile, String BankName, String BankBranch, String AccountNum,
			String PanNum, String ifsccode, String GSTCode, String aadharno, String username, String Password,
			String ConfirmPassword) throws IOException {
		
		//Distributor_AvantageRegistration distadvtge = new Distributor_AvantageRegistration(driver);
		Distributor_RegularRegistrationPage distadvtge = new Distributor_RegularRegistrationPage(driver);
		
		distadvtge.registrationprocess(SponsorID);
		distadvtge.memberdetails(MemFname, MemMname, MemLName, FFname, FMname, FLname, NFname);
		String MEmail1 = Utils.getRandomName() + Utils.getRandInt(10000, 99999) + Utils.getRandomEmail();
		String MMobile1 = "44" + Utils.getRandInt(1000, 9999) + Utils.getRandInt(1000, 9999);
		distadvtge.billing_Shippingetails(BillingAddress1, BillingAdress2, PostalCode, MEmail1, MMobile1);

		/*** PAN Number Randomization ***/
		String PanNum1 = "PANQ" + Utils.getRandomAlpha() + Utils.getRandInt(1000, 9999) + Utils.getRandomAlpha();
		/*** GST Number Randomization ***/
		String GSTCode1 = "27" + PanNum1 + "1Z1";
		/*** Account Number Randomization ***/
		String AccountNum1 = "5566" + Utils.getRandInt(1000, 9999) + "" + Utils.getRandInt(1000, 9999);
		/*** Aadhar Number Randomization ***/
		String aadharno1 = "1122" + Utils.getRandInt(1000, 9999) + "" + Utils.getRandInt(1000, 9999);

		distadvtge.bankDetails(BankName, BankBranch, AccountNum1, PanNum1, ifsccode, GSTCode1, aadharno1);

		String username1 = Utils.getRandomName() + Utils.getRandomAlpha() + Utils.getRandomAlpha()
				+ Utils.getRandomAlpha() + Utils.getRandomAlpha() + Utils.getRandomAlpha();
		distadvtge.securtityDetails(username1, Password, ConfirmPassword);

		String success = distadvtge.regConfirmation();
		Assert.assertEquals(success, "Registration Success");

		DriverUtils du = new DriverUtils(driver);
		du.embedScreenShotStep("Registration Successful SS ");
		// tbase.afterMethod();
		try {
			distadvtge.Continue_logout();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//**Save the random data into CSV file**//
		String content = Utils.getTimeStamp() + "," + SponsorID + "," + MemFname + "," + MemMname + "," + MemLName + ","
				+ FFname + "," + FMname + "," + FLname + "," + NFname + "," + BillingAddress1 + "," + BillingAdress2
				+ "," + PostalCode + "," + MEmail1 + "," + MMobile1 + "," + BankName + "," + BankBranch + "," + AccountNum1
				+ "," + PanNum1 + "," + ifsccode + "," + GSTCode1 + "," + aadharno1 + "," + username1 + "," + Password + ","
				+ ConfirmPassword + "\r\n";

		String path = "./target/RegistrationData1.csv";
		//**Write the content in given csv file**//
		Files.write(Paths.get(path), content.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);

		
		distadvtge.registrationprocess(SponsorID);
		
		distadvtge.memberdetails(MemFname, MemMname, MemLName, FFname, FMname, FLname, NFname);
		distadvtge.advfirmname();
		//distadvtge.advantage_regProcess(SponsorID, MemFname, MemMname, MemLName, FFname, FMname, FLname, NFname, BillingAddress1, BillingAdress2, PostalCode, MEmail, MMobile, BankName, BankBranch, AccountNum, PanNum, ifsccode, GSTCode, aadharno, username, Password, ConfirmPassword);
		distadvtge.memberdetails(MemFname, MemMname, MemLName, FFname, FMname, FLname, NFname);
		distadvtge.billing_Shippingetails(BillingAddress1, BillingAdress2, PostalCode, MEmail1, MMobile1);
	
		distadvtge.bankDetails(BankName, BankBranch, AccountNum1, PanNum1, ifsccode, GSTCode1, aadharno1);
		distadvtge.securtityDetails(username1, Password, ConfirmPassword);
		
		
	}
	
	@DataProvider(name = "advregistration")
	public Object[][] getData() throws IOException {
		return ExcelUtil.GetSheetData("./src/test/resources/Registartion_Data.xlsx", "Sheet2");
	}

}

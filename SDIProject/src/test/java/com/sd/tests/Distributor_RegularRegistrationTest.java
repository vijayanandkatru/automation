package com.sd.tests;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sdindia.pages.Distributor_RegularRegistrationPage;
import com.sdindia.utils.DriverUtils;
import com.sdindia.utils.ExcelUtil;
import com.sdindia.utils.Utils;

public class Distributor_RegularRegistrationTest extends TestBase {
	
	@Test(dataProvider = "registration")
	public void distributorregprocess(String SponsorID, String MemFname, String MemMname, String MemLName,
			String FFname, String FMname, String FLname, String NFname, String BillingAddress1, String BillingAdress2,
			String PostalCode, String BankName, String BankBranch, String ifsccode, String Password,
			String ConfirmPassword) throws InterruptedException, IOException {

		Distributor_RegularRegistrationPage distreg = new Distributor_RegularRegistrationPage(driver);

		distreg.registrationprocess(SponsorID);
		distreg.memberdetails(MemFname, MemMname, MemLName, FFname, FMname, FLname, NFname);
		String MEmail = Utils.getRandomName() + Utils.getRandInt(10000, 99999) + Utils.getRandomEmail();
		String MMobile = "44" + Utils.getRandInt(1000, 9999) + Utils.getRandInt(1000, 9999);
		distreg.billing_Shippingetails(BillingAddress1, BillingAdress2, PostalCode, MEmail, MMobile);

		/*** PAN Number Randomization ***/
		String PanNum = "PANQ" + Utils.getRandomAlpha() + Utils.getRandInt(1000, 9999) + Utils.getRandomAlpha();
		/*** GST Number Randomization ***/
		String GSTCode = "27" + PanNum + "1Z1";
		/*** Account Number Randomization ***/
		String AccountNum = "5566" + Utils.getRandInt(1000, 9999) + "" + Utils.getRandInt(1000, 9999);
		/*** Aadhar Number Randomization ***/
		String aadharno = "1122" + Utils.getRandInt(1000, 9999) + "" + Utils.getRandInt(1000, 9999);

		distreg.bankDetails(BankName, BankBranch, AccountNum, PanNum, ifsccode, GSTCode, aadharno);

		String username = Utils.getRandomName() + Utils.getRandomAlpha() + Utils.getRandomAlpha()
				+ Utils.getRandomAlpha() + Utils.getRandomAlpha() + Utils.getRandomAlpha();
		distreg.securtityDetails(username, Password, ConfirmPassword);

		String success = distreg.regConfirmation();
		Assert.assertEquals(success, "Registration Success");

		DriverUtils du = new DriverUtils(driver);
		du.embedScreenShotStep("Registration Successful SS ");
		// tbase.afterMethod();
		distreg.Continue_logout();
		
		//**Save the random data into CSV file**//
		String content = Utils.getTimeStamp() + "," + SponsorID + "," + MemFname + "," + MemMname + "," + MemLName + ","
				+ FFname + "," + FMname + "," + FLname + "," + NFname + "," + BillingAddress1 + "," + BillingAdress2
				+ "," + PostalCode + "," + MEmail + "," + MMobile + "," + BankName + "," + BankBranch + "," + AccountNum
				+ "," + PanNum + "," + ifsccode + "," + GSTCode + "," + aadharno + "," + username + "," + Password + ","
				+ ConfirmPassword + "\r\n";

		String path = "./target/RegistrationData.csv";
		//**Write the content in given csv file**//
		Files.write(Paths.get(path), content.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);

	}

	@DataProvider(name = "registration")
	public Object[][] getData() throws IOException {
		return ExcelUtil.GetSheetData("./src/test/resources/Registartion_Data.xlsx", "Sheet6");
	}

}

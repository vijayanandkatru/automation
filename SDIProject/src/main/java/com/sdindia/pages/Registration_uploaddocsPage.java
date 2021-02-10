package com.sdindia.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Registration_uploaddocsPage {
	
	private WebDriver driver;
	
	By memnamid = By.xpath("//preceding::div[@class='dashboard-content-heading clearfix ng-isolate-scope']");
	
	By uplddoc = By.xpath("//div[@class='col-md-12 search-heading']");
	By bnkdet = By.xpath("//input[@type='checkbox'][@ng-model='isBankEditMode']");
	By brwchk = By.id("fileChequeLeaf");
	By panchk = By.xpath("//input[@ng-model='isPanEditMode']");
	By pnholname = By.xpath("//input[@ng-model='MemberPANDtl.PANName']");
	By pantyp = By.xpath("//select[@ng-model='MemberPANDtl.PANType']");
	By panbrw = By.id("filePanCard");
	By aadhrchk = By.xpath("//input[@ng-model='isAadharEditMode']");
	By adhrnam = By.xpath("//input[@ng-model='MemberAadharDtl.AadharName']");
	By adhrbrw = By.id("fileAADHARCard");
	
	By svedocs = By.xpath("//button[@ng-click=\"saveUpdatedDetails()\"]");
			

}

package com.dreamhost.testcase;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.dreamhost.POMPage.BillingPage;
import com.dreamhost.POMPage.DreamHostPage;
import com.dreamhost.POMPage.SharedDomainPage;
import com.dreamhost.POMPage.SignUpPage;
import com.dreamhost.POMPage.WordPressPage;


public class RegisterDomain extends BaseClass {
	@Test
	public void registerDomain_ShouldFillAllTheInfoAndCardShouldReject() throws InterruptedException, EncryptedDocumentException, FileNotFoundException, IOException {
		DreamHostPage dhpage= new DreamHostPage(driver);
		dhpage.wordPress();
	    Thread.sleep(2000);
		WordPressPage wrdPPage= new WordPressPage(driver);
		wrdPPage.ClickSignup();
		Thread.sleep(2000);
		SignUpPage signuppage= new SignUpPage(driver);
		signuppage.ClickSignup();
		SharedDomainPage sdPage= new SharedDomainPage(driver);
		sdPage.chooseDomainLater();
		Thread.sleep(2000);
		BillingPage billingPage= new BillingPage(driver);
		Thread.sleep(2000);
		String name=readFromExcelSheet("sheet1",0,1);
		String ccNum=readFromExcelSheet("sheet1",1,1);
		String city = readFromExcelSheet("sheet1",2,1);
		billingPage.FillCardInfo(name,ccNum,city);
		Assert.assertTrue(billingPage.isErrorVisible());
	}

}

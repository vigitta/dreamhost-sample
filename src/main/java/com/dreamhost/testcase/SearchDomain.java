package com.dreamhost.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.dreamhost.POMPage.DomainsPage;
import com.dreamhost.POMPage.DreamHostPage;

public class SearchDomain extends BaseClass {
	/*
	 * Test Case 1: search a doamin  name  which is not available.
	 */
	@Test
	public void  serachDomains_GoogleShouldNotShowAvailable() throws InterruptedException {
		DreamHostPage dhpage= new DreamHostPage(driver);
				dhpage.domain();
				Thread.sleep(2000);
				DomainsPage dpage= new DomainsPage(driver);
				dpage.search("Google.com");
				Thread.sleep(2000);
				Assert.assertEquals(dpage.Message.getText(), Message);
		
	}
	
	@Test
	public void  serachDomains_UnregisteredDomainShouldShowAvailable() throws InterruptedException {
		DreamHostPage dhpage= new DreamHostPage(driver);
				dhpage.domain();
				Thread.sleep(2000);
				DomainsPage dpage= new DomainsPage(driver);
				dpage.search("vigittamariasabu.com");
				Thread.sleep(2000);
				Assert.assertEquals(dpage.Message.getText(), Message);
		
	}
	
	

}

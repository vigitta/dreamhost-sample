package com.dreamhost.POMPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SharedDomainPage {
	@FindBy(xpath="//body/div[@id='app-signup']/div[1]/section[1]/div[1]/div[1]/section[1]/div[1]/div[2]")
	WebElement Choose_domain_latter;
	
	
	public SharedDomainPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	public void chooseDomainLater() {
		Choose_domain_latter.click();
	}
}

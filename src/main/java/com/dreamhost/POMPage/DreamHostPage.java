package com.dreamhost.POMPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DreamHostPage {
	@FindBy(xpath="//a[@id='tracking_nav_domains']")
	WebElement Domain;
	@FindBy(xpath="//a[@id='tracking_nav_get-started-/']")
	WebElement GetStart;
	@FindBy (xpath="//a[@id='tracking_nav_wordpress']")
	WebElement WordPress;
	
	
	public DreamHostPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		//this.driver=driver;
	}

	public void domain() {
		Domain.click();
	}
	public void getStart() {
		GetStart.click();
	}
	public void wordPress() {
		WordPress.click();
	}
}

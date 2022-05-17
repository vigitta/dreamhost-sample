package com.dreamhost.POMPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WordPressPage {
	@FindBy(xpath="//body/div[1]/section[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/a[2]")
	WebElement SignUp;
	
	
	public WordPressPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	public void ClickSignup() {
		SignUp.click();
	}
}

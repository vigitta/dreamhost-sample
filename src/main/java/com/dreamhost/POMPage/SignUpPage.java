package com.dreamhost.POMPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/button[1]")
	WebElement SignUp;
	
	
	public SignUpPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	public void ClickSignup() {
		SignUp.click();
	}

}

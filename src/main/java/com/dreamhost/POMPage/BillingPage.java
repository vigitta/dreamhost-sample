package com.dreamhost.POMPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BillingPage {
	
	WebElement Name;
	WebElement CCNumber;
	WebElement City;
	WebElement errorCard;
	@FindBy(xpath="//iframe[@id='chase-payframe']")
	WebElement iFrame;
	
	public BillingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		driver.switchTo().frame(iFrame);
		Name = driver.findElement(By.id("name"));
		CCNumber = driver.findElement(By.id("ccNumber"));
		City = driver.findElement(By.id("city"));
		errorCard = driver.findElement(By.id("errorBelowNumber"));
	}

	public void FillCardInfo(String name,String creditCard,String city) {
		if(Name!=null) {
			Name.sendKeys(name);
		}
		if(CCNumber!=null) {
			CCNumber.sendKeys(creditCard);
		}
		if(City!=null) {
			City.sendKeys(city);
		}
	}
	public boolean isErrorVisible() {
		return errorCard.isDisplayed();
	}
	public String getErrorBelowNumber() {
		return errorCard.getText();
	}

}

package com.dreamhost.POMPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DomainsPage {
	@FindBy(xpath="//input[@id='domain-input']")
	WebElement Search;
	@FindBy(css="div.main-content.supports-fontface.l-pos-relative.u-overflow-hidden.c-c-w100:nth-child(3) section.t-center.section-hero.section-hero--domains.section-domain-navigation.p-bottom-0.u-overflow-hidden.p-top-16:nth-child(1) div.container-l.p-x-1.p-x-4__m.p-x-10__l.m-bottom-10.z-1.l-pos-relative.p-bottom-3.t-bold:nth-child(2) form.form-standard.js-domain-search-init.js-domain-search-redirect.l-pos-relative.z-1 div.input-group.input-group--inline-btn div.input-group__btn button.btn.btn-bright.btn--domain-search.js-domain-search-btn > svg:nth-child(1)")
	WebElement SearchButton;
	@FindBy(css="div.main-content.supports-fontface.l-pos-relative.u-overflow-hidden.c-c-w100:nth-child(3) section.t-center.section-hero.section-hero--domains.section-domain-navigation.p-bottom-0.u-overflow-hidden.p-top-16.blur:nth-child(1) div.container-l.p-x-1.p-x-4__m.p-x-10__l.m-bottom-10.z-1.l-pos-relative.p-bottom-3.t-bold:nth-child(2) form.form-standard.js-domain-search-init.js-domain-search-redirect.l-pos-relative.z-1 div.domain-results div.exact-tlds.tlds-section.slidein div.result-row.exact-result.sale-tld > p:nth-child(2)")
	public
	WebElement Message;
	
	public DomainsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void search(String text) throws InterruptedException {
		Search.sendKeys(text);
		Thread.sleep(2000);
		SearchButton.click();
		
	}

}

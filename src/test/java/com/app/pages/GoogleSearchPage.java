package com.app.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.app.utilities.Driver;


public class GoogleSearchPage {

	private WebDriver driver;
	public GoogleSearchPage() {
	this.driver = Driver.getDriver();
	PageFactory.initElements(driver, this);
}

	@FindBy(xpath="//a[@aria-label=\"Page 2\"]")
	public WebElement page2;
	
	
}	
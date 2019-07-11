package com.app.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.app.utilities.Driver;


public class GoogleMainPage {

	private WebDriver driver;
	public GoogleMainPage() {
	this.driver = Driver.getDriver();
	PageFactory.initElements(driver, this);
}

	@FindBy(name="q")
	public WebElement input;
	
	
	
	
}

package com.app.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.app.utilities.Driver;

public class GoogleTest2Main {

	private WebDriver driver;
	public GoogleTest2Main() {
		this.driver=Driver.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="q")
	public WebElement input;
	
	@FindBy(name="btnK")
	public WebElement searchb;
	
	
	
	
	
	
}

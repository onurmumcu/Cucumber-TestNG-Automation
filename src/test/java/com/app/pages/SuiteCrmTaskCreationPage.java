package com.app.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.app.utilities.Driver;

public class SuiteCrmTaskCreationPage {
private WebDriver driver;
	
	public SuiteCrmTaskCreationPage() {
		this.driver=Driver.getDriver();
		PageFactory.initElements(driver, this);
}
@FindBy(id="name")
public WebElement subject;

public WebElement status;//we have id or name

public WebElement date_start_date;//we have id or name

public WebElement date_due_date;//we have id or name

public WebElement priority;//we have id or name

public WebElement description;//we have id or name

public WebElement SAVE;

}

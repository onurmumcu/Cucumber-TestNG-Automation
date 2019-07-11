package com.app.step_defs;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.app.pages.GoogleMainPage;
import com.app.pages.GoogleSearchPage;
import com.app.utilities.BrowserUtils;
import com.app.utilities.Driver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GoogleTestPageStepDefs {
	private WebDriver driver = Driver.getDriver();
	GoogleMainPage main= new GoogleMainPage();
	GoogleSearchPage search= new GoogleSearchPage();	
	
	@Given("^I am on the Google HomePage$")
	public void i_am_on_the_Google_HomePage() {
	    driver.get("https://www.google.com");
	    assertTrue(driver.getTitle().equalsIgnoreCase("google"));
	   
	}

	@When("^search for \"([^\"]*)\"$")
	public void search_for(String arg1) {
	    main.input.sendKeys("Test Tools"+Keys.ENTER);
	   
	      
	}

	@Then("^I see the results$")
	public void i_see_the_results() {
	    assertTrue(driver.getTitle().toLowerCase().contains("test tools"));
	  
	
}
}
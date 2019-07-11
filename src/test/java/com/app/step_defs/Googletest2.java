package com.app.step_defs;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import com.app.pages.GoogleTest2Main;
import com.app.pages.GoogleTest2Search;
import com.app.utilities.ConfigurationReader;
import com.app.utilities.Driver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class Googletest2 {

	private WebDriver driver=Driver.getDriver();
	GoogleTest2Main gm=new GoogleTest2Main();
	GoogleTest2Search gs= new GoogleTest2Search();
		
	
	@Given("^I go to google main page$")
	public void i_go_to_google_main_page() {
	   driver.get(ConfigurationReader.getProperty("url2"));
	   assertTrue(driver.getTitle().contains("Google"));
	}

	@Given("^I write for \"([^\"]*)\"$")
	public void i_write_for(String good) {
	    gm.input.sendKeys(good);
	  
	}

	@Then("^I click search button$")
	public void i_click_search_button() {
		  gm.searchb.click();
	}

	@Then("^I check the title$")
	public void i_check_the_title() {
	   assertTrue(driver.getTitle().contains("vacuum"));
	}

	@Then("^I click on the second page$")
	public void i_click_on_the_second_page() {
	   gs.page2.click();
	}
}

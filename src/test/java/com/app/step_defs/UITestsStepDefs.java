package com.app.step_defs;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.app.pages.SuiteCrmDashBoardPage;
import com.app.pages.SuiteCrmLoginPage;
import com.app.pages.SuiteCrmSearchResultsPage;
import com.app.utilities.ConfigurationReader;
import com.app.utilities.Driver;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UITestsStepDefs {

	
	private WebDriver driver=Driver.getDriver();
	//String searchTerm="John Doe";
	SuiteCrmLoginPage loginPage = new SuiteCrmLoginPage();
	SuiteCrmDashBoardPage dashboardPage = new SuiteCrmDashBoardPage();
	SuiteCrmSearchResultsPage searchResultPage=new SuiteCrmSearchResultsPage();
	
	@Given("^I logged into suiteCRM$")
	public void i_logged_into_suiteCRM() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().fullscreen();
		driver.get(ConfigurationReader.getProperty("url"));
		loginPage.login(ConfigurationReader.getProperty("username"), ConfigurationReader.getProperty("password"));
	}

	@Then("^CRM name should be SuiteCRM$")
	public void crm_name_should_be_SuiteCRM() {
		assertTrue(driver.getTitle().endsWith("SuiteCRM"));
	}

	@Then("^Modules should be displayed$")
	public void modules_should_be_displayed() {
		assertTrue(dashboardPage.sales.isDisplayed());
		assertTrue(dashboardPage.support.isDisplayed());
		assertTrue(dashboardPage.activities.isDisplayed());
		assertTrue(dashboardPage.marketing.isDisplayed());
		assertTrue(dashboardPage.collaboration.isDisplayed());
		assertTrue(dashboardPage.all.isDisplayed());
	}

	@When("^I search for \"([^\"]*)\"$")
	public void i_search_for(String searchTerm) {
		try {
			assertTrue(dashboardPage.searchInput.isDisplayed());
		} catch (AssertionError e) {
			dashboardPage.searchButton.click();
		}
		dashboardPage.searchInput.sendKeys(searchTerm + Keys.ENTER);
	}

	@Then("^link for user \"([^\"]*)\" should be displayed$")
	public void link_for_user_should_be_displayed(String searchTerm) {
		assertTrue(searchResultPage.resultLink(searchTerm).isDisplayed(), searchTerm + " was not displayed");
	}

	@Then("^there should be (\\d+) result for \"([^\"]*)\"$")
	public void there_should_be_result_for(int count, String searchTerm) {
		int actual = searchResultPage.resultsLink(searchTerm).size();
		assertEquals(actual, count, "number of results did not match");
	}
}
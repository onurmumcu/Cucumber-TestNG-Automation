package com.app.step_defs;

import static org.testng.Assert.assertEquals;


import java.util.List;

import org.openqa.selenium.WebElement;


import com.app.pages.SuiteCrmDashBoardPage;
import com.app.pages.SuiteCrmSummaryPage;
import com.app.pages.SuiteCrmTaskCreationPage;
import com.app.utilities.BrowserUtils;


import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MenuOptionsStepDefs {

	SuiteCrmDashBoardPage dash= new SuiteCrmDashBoardPage();
	SuiteCrmTaskCreationPage task=new SuiteCrmTaskCreationPage();
	SuiteCrmSummaryPage summary=new SuiteCrmSummaryPage();
	
	@When("^I hover over the (Collaboration|Sales|Marketing|Support|All) menu$")
	public void i_hover_over_the_Collaboration_menu(String menu) {
		switch (menu) {
		case "Sales":
			BrowserUtils.hover(dash.sales);
			break;
		case "Marketing":
			BrowserUtils.hover(dash.marketing);
			break;
		case "Support":
			BrowserUtils.hover(dash.support);
			break;
		case "Collaboration":
			BrowserUtils.hover(dash.collaboration);
			break;
		case "All":
			BrowserUtils.hover(dash.all);
			break;
		case "Activities":
			BrowserUtils.hover(dash.activities);
			break;
		}

	}

	@Then("^following menu options should be visible for (Collaboration|Sales|Marketing|Support|All):$")
	public void following_menu_options_should_be_visible_for_Collaboration(String menu, List<String> options) {
		// capture list of webelements
		List<WebElement> topMenuOptions = dash.topMenuOptions(menu);
		// get their text in a list
		List<String> topMenuOptionsString = BrowserUtils.getElementsText(topMenuOptions);
		// compare the list with options
		assertEquals(topMenuOptionsString.size(), options.size(), "Number of expected menu options did not match");
		for (int i = 0; i < options.size(); i++) {
			assertEquals(topMenuOptionsString.get(i), options.get(i));
		}

	}

}
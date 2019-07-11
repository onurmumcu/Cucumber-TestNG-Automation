package com.app.step_defs;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import com.app.pages.SuiteCrmCretaeContactPage;
import com.app.pages.SuiteCrmDashBoardPage;
import com.app.pages.SuiteCrmSummaryPage;
import com.app.pages.SuiteCrmTaskCreationPage;
import com.app.utilities.BrowserUtils;
import com.app.utilities.Driver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ContactCretaionStepDefs {

	SuiteCrmDashBoardPage dash= new SuiteCrmDashBoardPage();
	SuiteCrmTaskCreationPage task=new SuiteCrmTaskCreationPage();
	SuiteCrmSummaryPage summary=new SuiteCrmSummaryPage();
	SuiteCrmCretaeContactPage contact=new SuiteCrmCretaeContactPage();
	
		
	@Given("^I open the create contact page$")
	public void i_open_the_create_contact_page() {
	   BrowserUtils.hover(dash.createLink);
	   dash.createContact.click();
	}

	@Given("^I enter the first name \"([^\"]*)\" and the last name \"([^\"]*)\"$")
	public void i_enter_the_first_name_and_the_last_name(String firstName, String lastName) {
	    contact.firstName.sendKeys(firstName);
	    contact.lastName.sendKeys(lastName);
	}

	@Given("^I enter the phone number \"([^\"]*)\"$")
	public void i_enter_the_phone_number(String phoneNumber) {
		contact.officePhoneNumber.sendKeys(phoneNumber);
			    
	}

	@Given("^I enter the department \"([^\"]*)\"$")
	public void i_enter_the_department(String department) {
	    
	    contact.department.sendKeys(department);
	}

	@When("^I click on the save button$")//here I cannot create the second entry with the same name. SO I say if that happens click on save anyway button
	public void i_click_on_the_save_button() {
	  contact.save.click();
	  try {
		  Driver.getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		  contact.secondSave.click();
	  }catch(Exception e){
		  e.printStackTrace();
	  }
	}

	@Then("^I should see contact information for \"([^\"]*)\"$")
	public void i_should_see_contact_information_for(String fullname) {
	 assertEquals(contact.firstName.getText(), fullname.split(" ")[0]);
	 assertEquals(contact.lastName.getText(), fullname.split(" ")[1]);
	}
}

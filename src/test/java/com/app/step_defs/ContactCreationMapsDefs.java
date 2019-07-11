package com.app.step_defs;

import java.util.Map;

import com.app.pages.SuiteCrmCretaeContactPage;
import com.app.pages.SuiteCrmDashBoardPage;
import com.app.pages.SuiteCrmSummaryPage;
import com.app.pages.SuiteCrmTaskCreationPage;
import com.app.utilities.BrowserUtils;

import cucumber.api.java.en.When;

public class ContactCreationMapsDefs {
	SuiteCrmDashBoardPage dash= new SuiteCrmDashBoardPage();
	SuiteCrmTaskCreationPage task=new SuiteCrmTaskCreationPage();
	SuiteCrmSummaryPage summary=new SuiteCrmSummaryPage();
	SuiteCrmCretaeContactPage createcontact=new SuiteCrmCretaeContactPage();
	
	@When("^I create a new contact:$")
	public void i_create_a_new_contact(Map<String, String> contact) {
		//open the create contact dialoue
		BrowserUtils.hover(dash.createLink);
		dash.createContact.click();
		//enter information
		
		if(contact.get("first_name")!=null){
		createcontact.firstName.sendKeys(contact.get("first_name"));
		}
		if(contact.get("last_name")!=null){
		createcontact.lastName.sendKeys(contact.get("last_name"));
		}
		if(contact.get("office phone")!=null){
		createcontact.officePhoneNumber.sendKeys(contact.get("office_phone"));
		}
		if(contact.get("cell_phone")!=null){
		createcontact.cellPhone.sendKeys(contact.get("cell_phone"));
		}
		BrowserUtils.waitFor(3);
		
		//save
	  createcontact.save();
	}
}

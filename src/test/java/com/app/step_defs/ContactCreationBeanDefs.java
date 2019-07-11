package com.app.step_defs;

import java.util.List;

import com.app.beans.ContactBean;
import com.app.pages.SuiteCrmCretaeContactPage;
import com.app.pages.SuiteCrmDashBoardPage;
import com.app.pages.SuiteCrmSummaryPage;
import com.app.pages.SuiteCrmTaskCreationPage;
import com.app.utilities.BrowserUtils;

import cucumber.api.java.en.When;

public class ContactCreationBeanDefs {

	SuiteCrmDashBoardPage dash= new SuiteCrmDashBoardPage();
	SuiteCrmTaskCreationPage task=new SuiteCrmTaskCreationPage();
	SuiteCrmSummaryPage summary=new SuiteCrmSummaryPage();
	SuiteCrmCretaeContactPage createcontact=new SuiteCrmCretaeContactPage();
	
	@When("^I save a new contact:$")
	public void i_save_a_new_contact(List<ContactBean> contacts) {
	System.out.println(contacts.size());
	ContactBean contactBean=contacts.get(0);
	
	BrowserUtils.hover(dash.createLink);
	dash.createContact.click();
	//enter data
	createcontact.firstName.sendKeys(contactBean.getFirstName());
	createcontact.lastName.sendKeys(contactBean.getLastName());
	createcontact.department.sendKeys(contactBean.getDepartment());
	createcontact.officePhoneNumber.sendKeys(contactBean.getOfficePhone());
	createcontact.cellPhone.sendKeys(contactBean.getCellPhone());
	
	createcontact.save.click();
	BrowserUtils.waitFor(3);
	createcontact.secondSave.click();
	
	
	
	
	}
}

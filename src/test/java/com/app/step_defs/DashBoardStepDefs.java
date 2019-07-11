package com.app.step_defs;

import com.app.pages.SuiteCrmDashBoardPage;


import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DashBoardStepDefs {
	
	SuiteCrmDashBoardPage dash=new SuiteCrmDashBoardPage();

	@When("^I post \"([^\"]*)\"$")
	public void i_post(String note) {
		dash.postNote(note);
	}

	@Then("^Post should be displayed$")
	public void post_should_be_displayed() {
	   
	}
	
	@Then("^I logout from application$")
	public void i_logout_from_application() {
		dash.logout();
	}

}

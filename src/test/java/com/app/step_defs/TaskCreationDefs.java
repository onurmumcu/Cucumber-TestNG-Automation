package com.app.step_defs;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

import com.app.pages.SuiteCrmDashBoardPage;
import com.app.pages.SuiteCrmSummaryPage;
import com.app.pages.SuiteCrmTaskCreationPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TaskCreationDefs {
SuiteCrmDashBoardPage dash= new SuiteCrmDashBoardPage();
SuiteCrmTaskCreationPage task=new SuiteCrmTaskCreationPage();
SuiteCrmSummaryPage summary=new SuiteCrmSummaryPage();
Map<String, String> createTaskMap=new HashMap<>();
Map<String, String> overviewTaskMap=new HashMap<>();

@When("^I click on create task$")
public void i_click_on_create_task() {
	dash.clickCreateTask();
}

@And("^Set subject as \"([^\"]*)\"$")
public void set_subject_as(String taskSubject) {
	task.subject.sendKeys(taskSubject);
	createTaskMap.put("Subject", taskSubject);
}

@And("^Set status as \"([^\"]*)\"$")
public void set_status_as(String status) {
	Select statusSelect = new Select(task.status);
	statusSelect.selectByVisibleText(status);
	createTaskMap.put("Status", status);
}

@And("^Start date is todays date$")
public void start_date_is_todays_date() {
    LocalDate today = LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    String todaysDate = today.format(formatter).toString();
    
    task.date_start_date.sendKeys(todaysDate + Keys.TAB);
    
    createTaskMap.put("Start Date", todaysDate);
    
    //System.out.println(LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")).toString());
    
}

@And("^Due date is (\\d+) days after todays date$")
public void due_date_is_days_after_todays_date(int daysAhead) {
   String dueDate=LocalDate.now().plusDays(daysAhead).format(DateTimeFormatter.ofPattern("MM/dd/yyyy")).toString();
   task.date_due_date.sendKeys(dueDate + Keys.TAB);
   createTaskMap.put("Due Date", dueDate);
}

@And("^Set \"([^\"]*)\" priority$")
public void set_priority(String priorityLevel) {
    Select prioritySelect = new Select(task.priority);
    prioritySelect.selectByVisibleText(priorityLevel);
    
    createTaskMap.put("Priority",priorityLevel);
}

@And("^Set description as \"([^\"]*)\"$")
public void set_description_as(String taskDescription) {
	task.description.sendKeys(taskDescription);
	createTaskMap.put("Description", taskDescription);
}

@And("^Save the task$")
public void save_the_task() {
	task.SAVE.click();
}

@Then("^Task details page should be displayed$")
public void task_details_page_should_be_displayed() {
   assertTrue(summary.taskOverview.isDisplayed());

   overviewTaskMap.put("Subject", summary.subject.getText());
   overviewTaskMap.put("Status", summary.status.getAttribute("value"));
   overviewTaskMap.put("Start Date", summary.date_start.getText().replace(" 12:00am", ""));
   overviewTaskMap.put("Due Date", summary.date_due.getText().replace(" 12:00am", ""));
   overviewTaskMap.put("Priority", summary.priority.getAttribute("value"));
   overviewTaskMap.put("Description", summary.description.getText());
   
   System.out.println(overviewTaskMap);
   System.out.println(createTaskMap);
   
}

@And("^Data should match with created task data$")
public void data_should_match_with_created_task_data() {
    assertEquals(overviewTaskMap, createTaskMap);
}
}

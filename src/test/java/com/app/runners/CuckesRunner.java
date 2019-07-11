package com.app.runners;
//today we wil use test NG yesterday it was JUnit

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

//@CucumberOptions( //yesterday we had to create a file name f which has to be the same with the tests. Now I can store them under 
//any name to anywhere beacuse I show the runner where to find tests and definitons.
//		features="src/test/resources/features/", glue="com.app.step_defs")

@CucumberOptions(
		plugin = {"pretty", 
				"html:target/cucumber-report",
				"json:target/cucumber.json",
				"rerun:target/rerun.txt"
				
		},
		
		features = {"src/test/resources/features","src/test/resources/hrapp_features"},
		tags="@trynewgoog",
		glue = "com/app/step_defs",
		dryRun=false
				)


public class CuckesRunner extends AbstractTestNGCucumberTests{//for this runner, we have to tell it where it is going to find the cucumber files to run.Yesterday it was automatic. 

	
}



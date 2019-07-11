package com.app.step_defs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.app.utilities.Driver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
	
@Before//will run before each scenario from cucumber
public void setUp(Scenario scenario) {
	WebDriver driver=Driver.getDriver();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.manage().window().maximize();//we could also use fullscreen but it is kiling me to use
}


@After//will run after each scenario from cucumber
public void tearDown(Scenario scenario) {
	
	if(scenario.isFailed()) {
	//taking screenshot	
	final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
		//adding the screen shot to the report
		scenario.embed(screenshot, "image/png");
		}	
	
	Driver.closeDriver();//from my depency Garcia
}



}

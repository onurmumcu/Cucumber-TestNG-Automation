package com.app.tests;

import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SauseLabsDemo {

	public static final String USERNAME = "iliyak";//came from saicelab
	public static final String ACCESS_KEY = "a101338f-dcdb-4ee0-bc16-fa5a906f75c7";//came from sauce lab
	public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";	
		
	WebDriver driver;
	
	@BeforeTest
	public void setUp() throws MalformedURLException {
		DesiredCapabilities caps=DesiredCapabilities.chrome();
		caps.setPlatform(Platform.WIN10);
		caps.setCapability("version", "latest");
		 driver=new RemoteWebDriver(new URL(URL), caps);
		
	}

@Test
public void testGoogle() {
	driver.get("https://google.com");
	driver.findElement(By.id("lst-ib")).sendKeys("Java programming"+Keys.ENTER);
assertTrue(driver.getTitle().contains("Java programming"));

}
}

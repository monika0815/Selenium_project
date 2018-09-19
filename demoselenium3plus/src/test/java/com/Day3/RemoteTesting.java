package com.Day3;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RemoteTesting {

	WebDriver driver;
	String nodeURL;
	
	@BeforeTest
	public void openBrowser() throws MalformedURLException
	{
		nodeURL="http://10.250.88.108:5597/wd/hub";
		DesiredCapabilities caps=DesiredCapabilities.chrome();
		caps.setBrowserName("chrome");
		caps.setPlatform(Platform.WIN10);
		driver= new RemoteWebDriver(new URL(nodeURL),caps);
		
	}
	@Test
	public void testcase() {
		driver.get("http://localhost:8083/TestMeApp");
		System.out.println(driver.getTitle());
	}
}

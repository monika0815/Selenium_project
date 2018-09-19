package com.Drivers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RoughTest {
	
	WebDriver driver;
	String browser="ie";
	@BeforeMethod
	public void openbrowser() {
		
		driver=Drivers.getdriver(browser);
		driver.manage().window().maximize();
		//implicit wait
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://www.google.com");
		
	}
	@Test
	public void test() {
		System.out.println("This is my testcase");
	}
	@AfterMethod
	public void closebrowser() {
		driver.close();
	}

}

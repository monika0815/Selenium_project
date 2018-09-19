package com.Day1.TestNg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BasicAnnotations {
	
	@Test
	public void testcase() throws InterruptedException {
		
		//step 1: Set the system property
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\s.wankhede\\Desktop\\SeleniumDrivers\\chromedriver.exe");
		
		//step 2: Launch the browser
		
		WebDriver driver=new ChromeDriver();
		//step 3: Launch google.com
		
		driver.get("http://www.google.com");
		
		Thread.sleep(2000);
		
		driver.close();
		
	}
	

}

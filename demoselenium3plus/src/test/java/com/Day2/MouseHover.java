package com.Day2;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Drivers.Drivers;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class MouseHover {
	
	WebDriver driver;
	String browser="chrome";
	@BeforeMethod
	public void openbrowser() {
		
		driver=Drivers.getdriver(browser);
		driver.manage().window().maximize();
		//implicit wait
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.drikpanchang.com/");
		
	}
	
	//@AfterMethod
	//public void closebrowser() {
		//driver.close();
	//}
	
	@Test
	public void testcase() throws InterruptedException {
		//Clicking on fb link
		//driver.findElement(By.cssSelector("img[src$=\"twitter-logo-618.jpg\"]")).click(); //working css selector 
		//List<WebElement> ls=driver.findElements(By.tagName("img"));
		Set <String> s=driver.getWindowHandles();
		Iterator<String> it= s.iterator();
		String mwid=it.next();
		String t1=it.next();
		Thread.sleep(2000);
		driver.switchTo().window(t1);
		driver.findElement(By.id("email")).sendKeys("Monikagupta");
				driver.switchTo().window(mwid);
				driver.switchTo().window(t1);
				driver.quit();
		

	}

}

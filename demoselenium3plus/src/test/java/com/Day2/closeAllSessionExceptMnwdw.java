package com.Day2;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Drivers.Drivers;

public class closeAllSessionExceptMnwdw {
	
	WebDriver driver;
	String browser="chrome";
	@BeforeMethod
	public void openbrowser() {
		
		driver=Drivers.getdriver(browser);
		driver.manage().window().maximize();
		//implicit wait
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.naukri.com/");
		
	}
	
	//@AfterMethod
	//public void closebrowser() {
		//driver.close();
	//}
	
	@Test
	public void testcase() throws InterruptedException {
		//Clicking on fb link
		String mwid=driver.getWindowHandle();
		//driver.findElement(By.xpath("//*[@id=\"socialThings2\"]/ul/li[1]/a/img")).click();
		Set <String> allwinids=driver.getWindowHandles();
		for(String x:allwinids)
		{
			if(!x.equals(mwid)) {
				driver.switchTo().window(x);
				driver.close();
			}
				
		}
		//driver.switchTo().alert().accept();
		Thread.sleep(100);
		driver.switchTo().window(mwid);
		driver.findElement(By.cssSelector("#allow")).click();
		//driver.switchTo().alert().accept();
		driver.close();
		

	}

}

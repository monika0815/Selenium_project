package com.Day1.TestNg;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Drivers.Drivers;

public class FlipkartExample {
	
	WebDriver driver;
	String browser="chrome";
	@BeforeMethod
	public void openbrowser() {
		
		driver=Drivers.getdriver(browser);
		driver.manage().window().maximize();
		//implicit wait
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://www.flipkart.com");
		
	}
	
	@AfterMethod
	public void closebrowser() {
		driver.close();
	}
	
	@Test
	public void testcase() throws InterruptedException {
		//popup handling

		driver.findElement(By.xpath("/html/body/div[2]/div/div/button")).click();
		Thread.sleep(2000);
	WebElement searchbox=	driver.findElement(By.xpath("//*[@id=\"container\"]/div/header/div[1]/div/div/div/div[2]/form/div/div[1]/div/input"));
		//Thread.sleep(2000);
		WebElement searchbutton=driver.findElement(By.xpath("//*[@id=\"container\"]/div/header/div[1]/div/div/div/div[2]/form/div/div[2]/button"));
		//Thread.sleep(2000);
	
		searchbox.sendKeys("Shoes");
		Thread.sleep(2000);
		searchbutton.click();
		Thread.sleep(2000);
		driver.navigate().back();
		searchbox.clear();
		searchbox.sendKeys("Watches");
		searchbutton.click();
		
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);
		driver.navigate().forward();
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(2000);
	
	}
	
	
	
	
	
	
	

}

package com.Day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Drivers.Drivers;

public class DragnDrop {
	WebDriver driver;
	String browser="chrome";
	@BeforeMethod
	public void openbrowser() {
		
		driver=Drivers.getdriver(browser);
		driver.manage().window().maximize();
		//implicit wait
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://dhtmlx.com/docs/products/dhtmlxTree");
		
	}
	
	//@AfterMethod
	//public void closebrowser() {
		//driver.close();
	//}
	
	@Test
	public void testcase() throws InterruptedException {
		
		WebElement src=driver.findElement(By.xpath("//*[@id=\"treebox1\"]/div/table/tbody/tr[2]/td[2]/table/tbody/tr[4]/td[2]/table/tbody/tr[1]/td[4]/span"));
		WebElement dest= driver.findElement(By.xpath("//*[@id=\"treebox2\"]/div/table/tbody/tr[2]/td[2]/table/tbody/tr[6]/td[2]/table/tbody/tr[1]/td[4]/span"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)");
		Actions mouse=new Actions(driver);
		mouse.dragAndDrop(src, dest).perform();
		Thread.sleep(2000);



	}
	
	
	
	
	
	
	
	
}

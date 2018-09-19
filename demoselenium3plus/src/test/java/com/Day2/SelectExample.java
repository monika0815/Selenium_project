package com.Day2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Drivers.Drivers;

public class SelectExample {
	
	WebDriver driver;
	String browser="chrome";
	@BeforeMethod
	public void openbrowser() {
		
		driver=Drivers.getdriver(browser);
		driver.manage().window().maximize();
		//implicit wait
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://newtours.demoaut.com/mercuryregister.php");
		
	}
	
	@AfterMethod
	public void closebrowser() {
		driver.close();
	}
	
	@Test
	public void testcase() throws InterruptedException {
		
		WebElement dropdown=driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[12]/td[2]/select"));
		
		Select selectbox=new Select(dropdown);
		
		
		
		Thread.sleep(2000);
		
		List<WebElement> options=selectbox.getOptions();
		
		System.out.println("The no. of countries listed here are : "+options.size());
		
		for(int i=0;i<options.size();i++) {
			System.out.println(options.get(i).getText());
		}
		
		
		
		
	}

}

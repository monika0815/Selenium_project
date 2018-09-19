package com.Day2;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Drivers.Drivers;

public class KeyboardControl {
	
	WebDriver driver;
	String browser="chrome";
	@BeforeMethod
	public void openbrowser() {
		
		driver=Drivers.getdriver(browser);
		driver.manage().window().maximize();
		//implicit wait
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//driver.get("https://dhtmlx.com/docs/products/dhtmlxTree");
		
	}
	
	//@AfterMethod
	//public void closebrowser() {
		//driver.close();
	//}
	
	@Test
	public void testcase() throws InterruptedException, AWTException {
driver.get("http://localhost:8083/TestMeApp/login.htm");
Actions mouse=new Actions(driver);
WebElement uname=driver.findElement(By.name("userName"));
mouse.moveToElement(uname).click().keyDown(uname,Keys.SHIFT)
.sendKeys(uname,"Monika")
.keyUp(uname,Keys.SHIFT)
.doubleClick()
.contextClick(uname)
.build().perform();

Robot win=new Robot();
Thread.sleep(2000);
win.keyPress(KeyEvent.VK_DOWN);
win.keyPress(KeyEvent.VK_DOWN);
win.keyPress(KeyEvent.VK_ENTER);
WebElement pwd=driver.findElement(By.name("password"));
mouse.moveToElement(pwd).click().perform();

win.keyPress(KeyEvent.VK_CONTROL);
win.keyPress(KeyEvent.VK_V);



		


}
}
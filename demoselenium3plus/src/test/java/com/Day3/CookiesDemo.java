package com.Day3;

import java.awt.AWTException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Drivers.Drivers;

public class CookiesDemo {
	
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
		driver.manage().deleteAllCookies();
   driver.get("http://localhost:8083/TestMeApp/login.htm");
     Cookie cookie=new Cookie("username","TestMeApp");
     driver.manage().addCookie(cookie);
     Set<Cookie> cookie_set=driver.manage().getCookies();
     
     for(Cookie temp:cookie_set) {
    	 System.out.println("Name of the cookie:"+temp.getName()+"and its value"+temp.getValue()+"get domain:|"+temp.getDomain()+"get path :"+temp.getPath()+"and its expiry date:"+temp.getExpiry()+"cookies is secured:"+temp.isSecure());
     }


}

}

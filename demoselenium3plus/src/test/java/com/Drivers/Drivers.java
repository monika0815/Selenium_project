package com.Drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Drivers {
	
	public static WebDriver getdriver(String browser) {
		
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
			return new ChromeDriver();
		}else if(browser.equalsIgnoreCase("mozilla")) {
			System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
			return new FirefoxDriver();
		}else if(browser.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", "C:\\IEDriverServer.exe");
			return new InternetExplorerDriver();
		}else {
		System.out.println("Browser name invalid");
		return null;
		}
		}

}

package com.Day1.TestNg;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Annotations {
	
	@BeforeSuite
	public void suitestarts() {
		System.out.println("My Suite starts here");
	}
	@AfterSuite
	public void suiteends() {
		System.out.println("My Suite ends here");
	}
	
	
	@BeforeClass
	public void startserver() {
		System.out.println("====================");
		System.out.println("Starting the server");
	}
	
	@AfterClass
	public void closeserver() {
		System.out.println("Closing the server");
		System.out.println("====================");
	}
	
	
	
	@Test(priority=1,enabled=false)
	public void alpha() {
		System.out.println("My First Testcase");
	}
	
	@Test
	public void beta() {
		
		System.out.println("My second testcase");
	}
	@BeforeMethod
	public void openbrowser() {
		System.out.println("====================");
		System.out.println("Opening the browser");
	}
	@AfterMethod
	public void closebrowser() {
		System.out.println("Closing the browser");
		System.out.println("====================");
	}

}

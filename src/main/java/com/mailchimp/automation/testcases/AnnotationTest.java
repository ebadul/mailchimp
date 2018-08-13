package com.mailchimp.automation.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.mailchimp.automation.pages.HomePage;

public class AnnotationTest {

	@BeforeMethod
	public void setUp() {
		System.out.println("Performing BeforeMethod");
	}
	
	
	@Test
	public void f1() {
		System.out.println("Performing Test");
	}
	
	@Test
	public void f2() {
		System.out.println("Performing Test");
	}
	
	@BeforeTest
	public void fas() {
		System.out.println("Performing BeforeTest");
	}
	
	@Test
	public void f3() {
		System.out.println("Performing Test");
	}
	
	
	@Test
	public void f4() {
		System.out.println("Performing Test");
	}
	
	@Test
	public void f5() {
		System.out.println("Performing Test");
	}
	
	
	@AfterTest
	public void fass() {
		System.out.println("Performing AfterTest");
	}
	
	@AfterMethod
	public void cleanUp() {
		System.out.println("Performing AfterMethod");
	}
	
	
	@BeforeSuite
	public void clefaanUp() {
		System.out.println("Performing BeforeSuite");
	}
	
	@AfterSuite
	public void cleaanUp() {
		System.out.println("Performing AfterSuite");
	}
	
}

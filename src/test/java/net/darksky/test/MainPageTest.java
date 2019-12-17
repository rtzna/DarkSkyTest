package net.darksky.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import net.darksky.base.BasePage;


import net.darksky.pages.MainPage;

public class MainPageTest {
	
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	MainPage mainPage;
	
	
	@BeforeMethod
	public void setUp(){
	
	basePage = new BasePage();
	prop = basePage.initialize_properties();
	driver = basePage.initialize_driver(prop);
	mainPage = new MainPage(driver);
		
		
		
	}
	
	
	@Test
	public void getTitle() throws InterruptedException{
		 
		
		System.out.println("The Title is : " + mainPage.getTitle());
		mainPage.gettingTodaysTemp();
		
		
	}
	@AfterMethod
	public void tearDown(){
		basePage.closeBrowser();
	}

}

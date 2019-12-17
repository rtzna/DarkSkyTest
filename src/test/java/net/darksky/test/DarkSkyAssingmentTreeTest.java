package net.darksky.test;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import net.darksky.base.BasePage;
import net.darksky.pages.DarkSkyAssingmentTestThree;
import net.darksky.pages.DarkSkyTest2;
import net.darksky.pages.MainPage;
import net.darksky.util.Constants;

public class DarkSkyAssingmentTreeTest {
	
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	MainPage mainPage;
	DarkSkyTest2 darksyTest2;
	DarkSkyAssingmentTestThree darkSkyAssingmentTestThree;
	By currentCityTime = By.id("currentTime");
	
	
	@BeforeMethod
	public void setUp() throws InterruptedException{
	
	basePage = new BasePage();
	prop = basePage.initialize_properties();
	driver = basePage.initialize_driver(prop);
	mainPage = new MainPage(driver);
	darksyTest2 = new DarkSkyTest2(driver);
	darkSkyAssingmentTestThree = new DarkSkyAssingmentTestThree(driver);
	String time = basePage.currentTime(currentCityTime);
	System.out.println("Time is at "+ Constants.LOCATION +" "+ time);
	

}
	@Test
	public void verifyTimeZone() throws InterruptedException{
		darkSkyAssingmentTestThree.verifyTimeZone();
		
	}
	@AfterMethod
	public void tearDown(){
		basePage.closeBrowser();
	}
}

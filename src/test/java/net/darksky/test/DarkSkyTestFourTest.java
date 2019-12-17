package net.darksky.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import net.darksky.base.BasePage;
import net.darksky.pages.DarkSkyTestFour;
import net.darksky.pages.MainPage;

public class DarkSkyTestFourTest {
	
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	MainPage mainPage;
	DarkSkyTestFour darkSkyTestFour;
	
	
	@BeforeMethod(enabled=false)
	public void setUp(){
	
	basePage = new BasePage();
	prop = basePage.initialize_properties();
	driver = basePage.initialize_driver(prop);
	darkSkyTestFour = new DarkSkyTestFour(driver);
	
	
	}
	@Test(enabled=false)
	public void registerToDarkSky() throws InterruptedException{
		darkSkyTestFour.darkSkyApiClick();
		darkSkyTestFour.darkSkySignUp(prop.getProperty("username"),prop.getProperty("password") );
		
	}
	@Test(enabled=false)
	public void checkEmail() throws InterruptedException{
		basePage.navigateMyEmail();
	}
	@AfterMethod(enabled=false)
	public void tearDown(){
		basePage.closeBrowser();
	}
}

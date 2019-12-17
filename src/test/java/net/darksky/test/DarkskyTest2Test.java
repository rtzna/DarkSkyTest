package net.darksky.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import net.darksky.base.BasePage;
import net.darksky.pages.DarkSkyTest2;
import net.darksky.pages.MainPage;

public class DarkskyTest2Test {
	
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	MainPage mainPage;
	DarkSkyTest2 darksyTest2;
	
	
	@BeforeMethod
	public void setUp(){
	
	basePage = new BasePage();
	prop = basePage.initialize_properties();
	driver = basePage.initialize_driver(prop);
	mainPage = new MainPage(driver);
	darksyTest2 = new DarkSkyTest2(driver);

}
	@Test(description="Getting 4Am temp")
	public void Assingment2() throws InterruptedException{
		darksyTest2.searchSpecificLocation();
		darksyTest2.findTimeMachine();
		darksyTest2.gettingFourAmTemp();
	}
	@AfterMethod
	public void tearDown(){
		basePage.closeBrowser();
	}
}

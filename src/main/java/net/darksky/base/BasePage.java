package net.darksky.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	
	public WebDriver driver;
	public Properties prop;
	public static String flash; //add flash 1
	
	
	public WebDriver initialize_driver(Properties prop){
		
		//String browser = "chrome";
		String browser = prop.getProperty("browser");
		String headless = prop.getProperty("headless");
		flash = prop.getProperty("elementflash");  //add flash 2
		if(browser.equalsIgnoreCase("chrome")){
			WebDriverManager.chromedriver().setup();
			if(headless.equals("yes")){
			ChromeOptions co = new ChromeOptions();
			co.addArguments("--headless");
			driver = new ChromeDriver(co);
		}
		else{
			driver = new ChromeDriver();
			
		}
		}else if(browser.equalsIgnoreCase("firefox")){
			WebDriverManager.firefoxdriver().setup();
			if(headless.equals("yes")){
				FirefoxOptions fo = new FirefoxOptions();
				fo.addArguments("--headless");
				driver = new FirefoxDriver(fo);
			}else{
				driver = new FirefoxDriver();
			}
		}
		driver.manage().window().fullscreen();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return driver;
	
	}
	
	public Properties initialize_properties(){
		
		prop = new Properties();
		
		try {
			FileInputStream ip = new FileInputStream("/Users/can/Documents/workspace/DarkSky/src/main/java/config/darksky/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return prop;
	
	}
	public String currentTime(By locator) throws InterruptedException{
		driver.navigate().to("https://24timezones.com/usa_time/nj_atlantic/hammonton.php");
		Thread.sleep(3000);
		String currentTime = driver.findElement(locator).getText();
		driver.navigate().back();
		Thread.sleep(4000);
		return currentTime;
	}
	public void  navigateMyEmail() throws InterruptedException{
		driver.get("https://outlook.live.com/owa/");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//a[@data-task='signin'][1]")).click();
		driver.findElement(By.id("i0116")).sendKeys("mrty_58@hotmail.com");
		driver.findElement(By.id("idSIButton9")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("i0118")).sendKeys("14561985,Rty");
		Thread.sleep(3000);
		driver.findElement(By.id("idSIButton9")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@title='developer@darksky.net']")).click();;
		Thread.sleep(5000);
		driver.findElement(By.id("LPlnk819273")).click();
		Thread.sleep(5000);
		driver.findElement(By.cssSelector(".title.stand-alone"));
	}
	
	public void quitBrowser(){
		try {
			driver.quit();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void closeBrowser(){
		try {
			driver.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	
	

}

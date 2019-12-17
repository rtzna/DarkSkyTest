package net.darksky.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import net.darksky.base.BasePage;
import net.darksky.util.ElementUtil;
import net.darksky.util.JavaScriptUtil;

public class MainPage extends BasePage {

	WebDriver driver;
	ElementUtil elementUtil;
	By currentLocation = By.cssSelector(".currentLocationButton");
	By today = By.cssSelector("a:nth-child(2) span.name");
	By todaysTemp = By.cssSelector(".timeline-container-scroll .temps span");

	public MainPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

	public String getTitle() throws InterruptedException {

		elementUtil.doClick(currentLocation);
		Thread.sleep(8000);
		String title = driver.getTitle();
		elementUtil.waitForGetPageTitle(title);

		return title;
	}

	public void gettingTodaysTemp() throws InterruptedException {
		WebElement element = driver.findElement(today);
		JavaScriptUtil.scrollIntoView(element, driver);
		JavaScriptUtil.clickElementByJS(element, driver);
		Thread.sleep(3000);
		String currentTemp = driver.findElement(todaysTemp).getText();
		List<WebElement> tempsInTimeLine = driver.findElements(todaysTemp);
		int temp = Integer.parseInt(currentTemp.substring(0, 2));
		int highestInTimeLine = temp;
		int lowestInTimeLine = temp;
		for (WebElement tempInTime: tempsInTimeLine) {
		    String sLIneTemp = tempInTime.getText();
		    int lineTemp = Integer.parseInt(sLIneTemp.substring(0, 2));
		    
		    if (lineTemp > highestInTimeLine){
		        highestInTimeLine  = lineTemp;
		    }
		    if (lineTemp < lowestInTimeLine ){
		        lowestInTimeLine = lineTemp;
		    }

		}

		System.out.println("Highest Temp:" + Integer.toString(highestInTimeLine));
		System.out.println("Lowest Temp:" + Integer.toString(lowestInTimeLine ));

		}

	}



package net.darksky.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import net.darksky.base.BasePage;
import net.darksky.util.Constants;
import net.darksky.util.ElementUtil;
import net.darksky.util.JavaScriptUtil;

public class DarkSkyTest2 extends BasePage {
	
	WebDriver driver;
	ElementUtil elementUtil;
	By searchBox = By.cssSelector("#searchForm>[type]");
	By searchBtn = By.cssSelector(".searchButton");
	By timeMachine = By.cssSelector(".buttonContainer .button");
	By december27 = By.cssSelector("button[data-pika-day='27']");
	By findFourAm = By.cssSelector(".highTemp.swip .time");
	By fourAmTemp = By.cssSelector(".highTemp.swip .temp");
	
	public DarkSkyTest2(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	
	public void searchSpecificLocation() throws InterruptedException{
		
		elementUtil.doSendKeys(searchBox, Constants.LOCATION);
		elementUtil.doClick(searchBtn);
		Thread.sleep(5000);
	}
	public void findTimeMachine() throws InterruptedException{
		JavaScriptUtil.scrollIntoView(driver.findElement(timeMachine), driver);
		JavaScriptUtil.clickElementByJS(driver.findElement(timeMachine), driver);
		Thread.sleep(3000);
		elementUtil.doClick(december27);
	}
	public void gettingFourAmTemp(){
		elementUtil.doGetText(findFourAm);
		String temp = elementUtil.doGetText(fourAmTemp);
		System.out.println("Dec 27 Temp  at 4 am is :" +temp);
	}

}



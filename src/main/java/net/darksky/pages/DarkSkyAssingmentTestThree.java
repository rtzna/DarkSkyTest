package net.darksky.pages;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

import org.openqa.selenium.WebDriver;

import net.darksky.base.BasePage;
import net.darksky.util.Constants;
import net.darksky.util.ElementUtil;

public class DarkSkyAssingmentTestThree extends BasePage {
	
	WebDriver driver;
	ElementUtil elementUtil;
	DarkSkyTest2 darksyTest2;
	static SimpleDateFormat esternTimeDateFormat = new SimpleDateFormat(Constants.Time_Format);
	

	
	
	public DarkSkyAssingmentTestThree(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	public void verifyTimeZone() throws InterruptedException{
		darksyTest2 = new DarkSkyTest2(driver);
		darksyTest2.searchSpecificLocation();
		
		TimeZone tz = TimeZone.getTimeZone(Constants.EASTERN_TIME_ZONE);
		esternTimeDateFormat.setTimeZone(tz);
		Calendar currentTime = Calendar.getInstance();
		System.out.println(esternTimeDateFormat.format(currentTime.getTime()));
		System.out.println(tz.getDisplayName());

}
}

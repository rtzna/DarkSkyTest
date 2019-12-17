package net.darksky.pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import net.darksky.base.BasePage;
import net.darksky.util.ElementUtil;

public class DarkSkyTestFour extends BasePage {
	
	WebDriver driver;
	ElementUtil elementUtil;
	BasePage basePage;
	Properties properties;
	By darkSkyApiBtn = By.cssSelector("body > nav a:nth-child(4)");
	By signUp = By.cssSelector("a.button.filled");
	By userName = By.name("email");
	By pwd = By.name("password");
	By confirm = By.name("confirmation");
	By register = By.cssSelector("button[type='submit']");
	By confirmationEmail = By.cssSelector(".confirmation-sent-container>h1");
	
	
	
		
		
	public DarkSkyTestFour(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	
	
	public void darkSkyApiClick(){
		elementUtil.doClick(darkSkyApiBtn);
	}
	public void darkSkySignUp(String user, String password){
		
		elementUtil.doClick(signUp);
		elementUtil.doSendKeys(userName, user);
		elementUtil.doSendKeys(pwd, password);
		elementUtil.doSendKeys(confirm, password);
		elementUtil.doClick(register);
		elementUtil.doGetText(confirmationEmail);
		
		
	}
	

}

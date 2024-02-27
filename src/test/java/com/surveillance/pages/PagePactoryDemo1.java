package com.surveillance.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.surveillance.utilitiy.GenericKeywordsWithPage;

public class PagePactoryDemo1 
{
	public PagePactoryDemo1(WebDriver driver)
	{
		PageFactory.initElements(driver, this);    
	}

	@FindBy(xpath="//input[@name='txtUsername']")
	WebElement username;
	@FindBy(xpath="//input[@name='txtPassword']")
	WebElement password;
	@FindBy(xpath="//input[@type='submit']")
	WebElement button;

	public GenericKeywordsWithPage keywords = new GenericKeywordsWithPage("LoginPage");

	public void enter(String value) throws Exception 
	{
		keywords.enterData(username, value);	
	}
	public void enterPassword(String value) throws Exception 
	{
		keywords.enterData(password, value);		
	}
	public void ClickButton(String value) throws Exception 
	{
		keywords.enterData(button, value);		
	}	
	public void clickFunCtion()
	{
		keywords.click(button);
	}	
	public void  OpenAntherBrowser()
	{
		keywords.openBrowser("chrome");
		keywords.openURL("https://www.softwaretestinghelp.com/difference-between-test-plan-test-strategy-test-case-test-script-test-scenario-and-test-condition/");
	}
}
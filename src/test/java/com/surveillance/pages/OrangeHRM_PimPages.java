package com.surveillance.pages;

import com.surveillance.utilitiy.GenericKeywords;
import com.surveillance.utilitiy.PropertySingleton;

public class OrangeHRM_PimPages 
{
	PropertySingleton _instance = null;

	public OrangeHRM_PimPages() 
	{
		_instance = PropertySingleton.getInstance();
	}

	public GenericKeywords keywords = new GenericKeywords("OrangeHRM_PimPages");
	
		
	public void enterUsername(String userName)
	{
		keywords.enterData("xpath", _instance.getValue("LoginPage.Text_UserName"), userName);
	}

	
	public void enterPassword(String password)
	{
		keywords.enterData("xpath", _instance.getValue("LoginPage.Text_Password"), password);
	}
	
	public OrangeHRM_PimPages clickOnLogin()
	{
		keywords.jsClick("xpath", _instance.getValue("LoginPage.Button_Login"));
		return this;
	}

	public OrangeHRM_PimPages clickOnPIM()
	{
		keywords.jsClick("xpath", _instance.getValue("PIM"));
		return this;
	}
	
	public OrangeHRM_PimPages clickOnAddEmployee()
	{
		keywords.jsClick("xpath", _instance.getValue("Add_Employee"));
		return this;
	}
	
	public void enterFirstName(String firstName)
	{
		keywords.enterData("xpath", _instance.getValue("First_Name"), firstName);
	}
	
	public void enterLastName(String lastName)
	{
		keywords.enterData("xpath", _instance.getValue("Last_Name"), lastName);
	}
	
	public OrangeHRM_PimPages clickOnSave()
	{
		keywords.jsClick("xpath", _instance.getValue("Save_Button"));
		return this;
	}
	
	
}

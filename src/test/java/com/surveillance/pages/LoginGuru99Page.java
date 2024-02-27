package com.surveillance.pages;

import com.surveillance.utilitiy.GenericKeywords;
import com.surveillance.utilitiy.PropertySingleton;

public class LoginGuru99Page 
{ 
	PropertySingleton _instance = null;

	public LoginGuru99Page() 
	{
		_instance = PropertySingleton.getInstance();
	}

	public GenericKeywords keywords = new GenericKeywords("LoginGuru99Page");
	
//	public boolean isUsernametxtboxDisplay() throws Throwable
//	{
//		boolean flag=keywords.isdisplay("xpath", _instance.getValue("LoginPage.Text_UserName"),"display");
//		return flag;
//	}
	
	public void enterUsername(String userName)
	{
		keywords.enterData("xpath", _instance.getValue("LoginPage.Text_UserName"), userName);
	}

//	public boolean isPasswordtextboxDisplay() throws Throwable
//	{
//		boolean flag=keywords.isdisplay("xpath", _instance.getValue("LoginPage.Text_Password"),"display");
//		return flag;
//	}
	
	public void enterPassword(String password)
	{
		keywords.enterData("xpath", _instance.getValue("LoginPage.Text_Password"), password);
	}
	
	public LoginGuru99Page clickOnLogin()
	{
		keywords.jsClick("xpath", _instance.getValue("LoginPage.Button_Login"));
		return this;
	}
	



}

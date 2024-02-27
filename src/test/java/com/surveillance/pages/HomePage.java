package com.surveillance.pages;

import com.surveillance.utilitiy.GenericKeywords;
import com.surveillance.utilitiy.PropertySingleton;

public class HomePage 
{
	PropertySingleton _instance = null;

	public HomePage() 
	{
		_instance = PropertySingleton.getInstance();
	}

	public GenericKeywords keywords = new GenericKeywords("HomePage");
	
	public HomePage clickOnUserAdmin()
	{
		keywords.jsClick("xpath", _instance.getValue("Homepae.LNK_UserAdminLink"));
		return this;
	}
	
	public HomePage clickOnCommandCenter()
	{
		keywords.jsClick("xpath", _instance.getValue("Homepae.LNK_CommandCenter"));
		keywords.waitForPageLoad();
		return this;
	}
	
	public HomePage clickOnArchives()
	{
		keywords.jsClick("xpath", _instance.getValue("Homepae.Archives"));
		keywords.waitForPageLoad();
		return this;
	}
	
	public HomePage clickOnCameras()
	{
		keywords.jsClick("xpath", _instance.getValue("Homepae.Cameras"));
		keywords.waitForPageLoad();
		return this;
	}
	public HomePage clickOnHamburgerIcon()
	{
		keywords.jsClick("xpath", _instance.getValue("Homepae.HamburgerIcon"));
		keywords.waitForPageLoad();
		return this;
	}

	public HomePage clickOnHamburgerIconAdmin()
	{
		keywords.jsClick("xpath", _instance.getValue("Homepae.HamburgerIconAdmin"));
		keywords.waitForPageLoad();
		return this;
	}
}

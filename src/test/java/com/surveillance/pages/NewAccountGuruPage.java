package com.surveillance.pages;



import com.surveillance.utilitiy.GenericKeywords;
import com.surveillance.utilitiy.PropertySingleton;

public class NewAccountGuruPage {

	PropertySingleton _instance = null;

	public NewAccountGuruPage() 
	{
		_instance = PropertySingleton.getInstance();
	}

	public GenericKeywords keywords = new GenericKeywords("NewAccountGuru");
	
	public NewAccountGuruPage clickOnNewAccount()
	{
	keywords.jsClick("xpath", _instance.getValue("New_Account"));
		
		return this;
	}
	
	public void alertclick()
	{
		keywords.alertclick("xpath", _instance.getValue("New_Alert"));
	}
	
	public void enterCustomerName(String customerName)
	{
		keywords.enterData("xpath", _instance.getValue("New_CustomerName"), customerName);
	}
	
	public NewAccountGuruPage clickOnRadio()
	{
		keywords.jsClick("xpath", _instance.getValue("New_Gender"));
		return this;
	}
	
	public void enterDOB(String DateOfBirth)
	{
		keywords.enterData("xpath", _instance.getValue("New_DateOfBirth"), DateOfBirth);
	}
	
	public void enterAddress(String Address)
	{
		keywords.enterData("xpath", _instance.getValue("New_Address"), Address);
	}
	
	public void entercity(String City)
	{
		keywords.enterData("xpath", _instance.getValue("New_City"), City);
	}
	
	public void enterState(String State)
	{
		keywords.enterData("xpath", _instance.getValue("New_State"), State);
	}
	
	public void enterPin(String Pin)
	{
		keywords.enterData("xpath", _instance.getValue("New_Pin"), Pin);
	}
	
	public void enterMobileNumber(String Mobile_Number)
	{
		keywords.enterData("xpath", _instance.getValue("New_Mobile_Number"), Mobile_Number);
	}
	
	public void enterEmail(String Email)
	{
		keywords.enterData("xpath", _instance.getValue("New_Email"), Email);
	}
	
	public void enterPassword(String Password)
	{
		keywords.enterData("xpath", _instance.getValue("New_Password"), Password);
	}
	
	public NewAccountGuruPage clickOnSubmit()
	{
		keywords.jsClick("xpath", _instance.getValue("New_Submit"));
		return this;
	}

}

package com.surveillance.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.surveillance.utilitiy.GenericKeywords;
import com.surveillance.utilitiy.PropertySingleton;

public class LoginPage 
{
	PropertySingleton _instance = null;
	
@FindBy(xpath="")
WebElement test;
	
	public LoginPage() 
	{
		_instance = PropertySingleton.getInstance();
	}

	public GenericKeywords keywords = new GenericKeywords("LoginPage");
	
	
	
	public LoginPage enterLoginEmail(String value) throws Exception {
		keywords.clearEnter("xpath", _instance.getValue("loginPage.Edit_userName"), value);
		test.sendKeys("");
		return this;
	}
	
	public LoginPage clickOnLogin() throws Exception {
		keywords.jsClick("xpath", _instance.getValue("loginPage.BTN_Login"));
		keywords.waitForPageLoad();
		return this;
	}
	
	public LoginPage enterPassword(String value) throws Exception {
		keywords.enterData("xpath", _instance.getValue("loginPage.Edit_Password"), value);
		return this;
	}
	
	public String verifyInvalidCredentialsText() throws Exception {
		String Data= keywords.getText("xpath", _instance.getValue("loginPage.Lbl_InvalidCredentials"));
		return Data;
	}

	public String verifyLoginViaGoogleLable() throws Exception {
		String Data= keywords.getText("xpath", _instance.getValue("loginPage.Lbl_LoginViaGoogle"));
		return Data;
	}

	public String verifyEmailLable() throws Exception {
		String Data= keywords.getText("xpath", _instance.getValue("loginPage.Lbl_Email"));
		return Data;
	}
	public boolean verifyuserName() throws Exception {
	
	boolean IsEnabled=keywords.isEnabled("xpath",  _instance.getValue("loginPage.Edit_userName"));
	return IsEnabled;
	}
	public boolean verifyBTNLogin() throws Exception {
		
		boolean IsEnabled=keywords.isEnabled("xpath",  _instance.getValue("loginPage.BTN_Login"));
		return IsEnabled;
		}
	public String verifyForgetYourPassword() throws Exception {
		String Data= keywords.getText("xpath", _instance.getValue("loginPage.LBL_ForgetYourPassword"));
		return Data;
	}

public String verifyNOTYOU() throws Exception {
	String Data= keywords.getText("xpath", _instance.getValue("loginPage.LBL_NOTYOU"));
	return Data;
}
public String verifyPassword() throws Exception {
	String Data= keywords.getText("xpath", _instance.getValue("loginPage.LBL_Password"));
	return Data;
}
public boolean verifyInputPassword() throws Exception {
	
	boolean IsEnabled=keywords.isEnabled("xpath",  _instance.getValue("loginPage.Edit_Password"));
	return IsEnabled;
	}
	
}

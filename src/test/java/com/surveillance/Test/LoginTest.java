package com.surveillance.Test;

import java.util.Hashtable;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.surveillance.pages.LoginPage;
import com.surveillance.pages.PagePactoryDemo1;
import com.surveillance.utilitiy.GenericKeywords;
import com.surveillance.utilitiy.PropertySingleton;
import com.surveillance.utilitiy.ReadData;
import com.surveillance.utilitiy.Xls_Reader;

public class LoginTest extends BaseTest
{
	LoginPage login=new LoginPage();
	PagePactoryDemo1 p1 ;
	PropertySingleton _instance = null;
	SoftAssert s_assert = new SoftAssert();

	public LoginTest() throws Throwable
	{
		_instance = PropertySingleton.getInstance();
		p1 = new PagePactoryDemo1(GenericKeywords.driver);
	}

	@BeforeClass
	public void startReport()
	{
		beforeClassForChild(this);
	}

	public void logintest(Hashtable<String, String> h2) throws Exception 
	{		
		System.out.println("userEmail "+h2.get("Email"));
		login.enterLoginEmail(h2.get("Email"));
		login.clickOnLogin();
		login.enterPassword(h2.get("Password"));
		login.clickOnLogin();
		System.out.println("dONE");	
	}

	@Test
	public void funA() throws Exception
	{
		extentLoggerECP = parentExtentLogger.createNode("login With Valid Credentials");
		p1.enterPassword("Test");
	}

	@Test(priority = 0, dataProvider = "setData1")
	public void loginWithValidCredentials(Hashtable<String, String> h2) throws Exception 
	{
		extentLoggerECP = parentExtentLogger.createNode("login With Valid Credentials");
		s_assert = new SoftAssert();
		System.out.println("userEmail "+h2.get("Email"));
		login.enterLoginEmail(h2.get("Email"));
		login.clickOnLogin();
		login.enterPassword(h2.get("Password"));
		login.clickOnLogin();		
	}

	@Test(priority = 0)
	public void loginWithInvalidCredentials() throws Exception 
	{
		extentLoggerECP = parentExtentLogger.createNode("login With Invalid Credentials");
		s_assert = new SoftAssert();
		System.out.println("userEmail "+"Email");
		login.enterLoginEmail("Email@tetii1.com");
		System.out.println();
		login.clickOnLogin();
		passLog();
		login.enterPassword("Password");
		passLog();
		login.clickOnLogin();
		String actualData=login.verifyInvalidCredentialsText();
		s_assert.assertEquals(actualData, "Invalid email/password combination");
		passLog();
		s_assert.assertAll();
	}

	@Test(priority = 0)
	public void loginPage() throws Exception 
	{
		extentLoggerECP = parentExtentLogger.createNode("Login Page fields validation");
		s_assert = new SoftAssert();
		String actualLoginViaGoogleLable=login.verifyLoginViaGoogleLable();
		s_assert.assertEquals(actualLoginViaGoogleLable, "LOGIN VIA GOOGLE");
		passLog();
		String actualEmailLable=login.verifyEmailLable();
		s_assert.assertEquals(actualEmailLable, "Email");
		passLog();
		boolean actualuserName=login.verifyuserName();
		s_assert.assertEquals(actualuserName, true);
		passLog();
		boolean actualBTNLogin=login.verifyuserName();
		s_assert.assertEquals(actualBTNLogin, true);
		passLog();
		String actualForgetYourPassword=login.verifyForgetYourPassword();
		s_assert.assertEquals(actualForgetYourPassword, "FORGOT YOUR PASSWORD?");
		passLog();
		login.enterLoginEmail("kalyan.babu@contractor.liveviewtech.com");
		passLog();
		login.clickOnLogin();
		passLog();
		Thread.sleep(5000);
		//	String actualNOTYOU=login.verifyNOTYOU();
		//	System.out.println("actualNOTYOU "+actualNOTYOU);
		//	s_assert.assertEquals(actualNOTYOU, "NOT YOU?");
		//	passLog();
		//	String actualPassword=login.verifyPassword();
		//	s_assert.assertEquals(actualPassword, "Password");
		//	passLog();
		//	boolean actualInputPassword=login.verifyInputPassword();
		//	s_assert.assertEquals(actualInputPassword, true);
		//	passLog();
		//	s_assert.assertAll();
	}
	@DataProvider
	public Object[][] setData1() 
	{
		Xls_Reader xls = new Xls_Reader(System.getProperty("user.dir") + "/TestData/testdata.xlsx");
		return ReadData.getData("Logintest", "LoginTC", xls);
	}	
}
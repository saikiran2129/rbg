package com.surveillance.Test;

import java.util.Hashtable;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.surveillance.pages.LoginGuru99Page;
import com.surveillance.pages.NewAccountGuruPage;
import com.surveillance.utilitiy.PropertySingleton;
import com.surveillance.utilitiy.ReadData;
import com.surveillance.utilitiy.Xls_Reader;

public class NewAccountGuruTest extends BaseTest
{
	PropertySingleton _instance = null;//
	SoftAssert s_assert = new SoftAssert();//TestNg class
	
	LoginGuru99Page login =new LoginGuru99Page();
	NewAccountGuruPage newAcnt=new NewAccountGuruPage();

	public NewAccountGuruTest() throws Throwable 
	{
		_instance = PropertySingleton.getInstance();
	}

	@BeforeClass
	public void startReport()
	{
		beforeClassForChild(this);//doubt
	
	}
	
	@Test(priority = 0,dataProvider = "setData1")
	public void loginWithValidCredentials(Hashtable<String , String> h1) throws Exception 

	{
		extentLoggerECP = parentExtentLogger.createNode("login With Valid Credentials");
		s_assert = new SoftAssert();
		
		login.enterUsername(h1.get("userName"));
		passLog();
		login.enterPassword(h1.get("password"));
		passLog();
		login.clickOnLogin();
		passLog();
		
		newAcnt.clickOnNewAccount();
		passLog();
		
		newAcnt.alertclick();
		passLog();
		
		
		Thread.sleep(15000);
		newAcnt.enterCustomerName(h1.get("customerName"));
		passLog();
		newAcnt.clickOnRadio();
		passLog();
		newAcnt.enterDOB(h1.get("DateOfBirth"));
		passLog();
		newAcnt.enterAddress(h1.get("Address"));
		passLog();
		newAcnt.entercity(h1.get("City"));
		passLog();
		newAcnt.enterState(h1.get("State"));
		passLog();
		newAcnt.enterPin(h1.get("Pin"));
		passLog();
		newAcnt.enterMobileNumber(h1.get("Mobile_Number"));
		passLog();
		Thread.sleep(2000);
		newAcnt.enterEmail(h1.get("Email"));
		passLog();
		newAcnt.enterPassword(h1.get("Password"));
		passLog();
		newAcnt.clickOnSubmit();
		passLog();
		
		s_assert.assertAll();
	
	}
	
	@DataProvider
	
	public Object[][] setData1() 
	{
		Xls_Reader xls = new Xls_Reader(System.getProperty("user.dir") + "/TestData/testdata.xlsx");
		return ReadData.getData("Guru99Bank", "Guru99Bank_TESTCASES", xls);
	}
	

}

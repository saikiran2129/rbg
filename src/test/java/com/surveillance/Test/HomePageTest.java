package com.surveillance.Test;

import java.util.Hashtable;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.surveillance.Test.BaseTest;
import com.surveillance.Test.LoginTest;
import com.surveillance.pages.HomePageTestPage;
import com.surveillance.utilitiy.PropertySingleton;
import com.surveillance.utilitiy.ReadData;
import com.surveillance.utilitiy.Xls_Reader;

public class HomePageTest  extends BaseTest
{
	SoftAssert s_assert = new SoftAssert();
	PropertySingleton _instance = null;

	LoginTest loginTest=new LoginTest();
	HomePageTestPage homePagetestpage =new HomePageTestPage();
	public HomePageTest() throws Throwable 
	{
		_instance = PropertySingleton.getInstance();
	}
	@BeforeClass
	public void startReport()
	{
		beforeClassForChild(this);

	}


	//@Test(priority = 0, dataProvider = "setData1")
	public void Menutest(Hashtable<String, String> h2) throws Throwable 
	{
		extentLoggerECP = parentExtentLogger.createNode("Home Page Test");

		loginTest.logintest(h2);
		passLog();
		homePagetestpage.clickOnCAMERAS();
		passLog();
		homePagetestpage.clickOnARCHIVES();
		passLog();
		homePagetestpage.clickOnUSERADMIN();
		passLog();
		homePagetestpage.clickOnSYSTEMADMIN();
		passLog();
		homePagetestpage.clickOnCOMMANDCENTER();
		passLog();
		homePagetestpage.clickOnTICKETS();
		passLog();
		String expecteddata=homePagetestpage.getWelcome();
		s_assert.assertTrue(expecteddata.equals("Welcome"));
		s_assert.assertAll();
		passLog();
		String expecteddata1=homePagetestpage.getUserName();
		s_assert.assertTrue(expecteddata1.equals(h2.get("UserName")));
		s_assert.assertAll();
		passLog();
	}

	@Test(priority = 0, dataProvider = "setData1")
	public void Menutest1(Hashtable<String, String> h2) throws Throwable 
	{
		extentLoggerECP = parentExtentLogger.createNode("Home Page Test");
		loginTest.logintest(h2);
		passLog();
		s_assert.assertTrue(homePagetestpage.isCAMERASDisplay()==true);
		s_assert.assertTrue(homePagetestpage.isARCHIVESDisplay()==true);
		s_assert.assertTrue(homePagetestpage.isUSERADMINDisplay()==true);
		s_assert.assertTrue(homePagetestpage.isSYSTEMADMINDisplay()==true);
		s_assert.assertTrue(homePagetestpage.isCOMMANDCENTERDisplay()==true);
		s_assert.assertTrue(homePagetestpage. isTICKETSDisplay()==true);
		s_assert.assertTrue(homePagetestpage. isLogoutDisplay()==true);
		s_assert.assertTrue(homePagetestpage. isViewProfileDisplay()==true);

		//	String expecteddata=homePagetestpage.getWelcome();
		//s_assert.assertTrue(expecteddata.equals("Welcome"));

		//passLog();
		//String expecteddata1=homePagetestpage.getUserName();
		//s_assert.assertTrue(expecteddata1.equals(h2.get("UserName")));
		s_assert.assertAll();


	}

	@DataProvider
	public Object[][] setData1() {
		Xls_Reader xls = new Xls_Reader(System.getProperty("user.dir") + "/TestData/testdata.xlsx");
		return ReadData.getData("HomePageTest", "HomePageTest", xls);
	}
}



package com.surveillance.Test;

import java.util.Hashtable;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.surveillance.pages.OrangeHRM_PimPages;
import com.surveillance.utilitiy.PropertySingleton;
import com.surveillance.utilitiy.ReadData;
import com.surveillance.utilitiy.Xls_Reader;

public class OrangeHRM_PimTest extends BaseTest
{
	PropertySingleton _instance = null;
	SoftAssert s_assert = new SoftAssert();

	OrangeHRM_PimPages pim = new OrangeHRM_PimPages();

	public OrangeHRM_PimTest() throws Throwable 
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

		pim.enterUsername(h1.get("userName"));
		passLog();
		pim.enterPassword(h1.get("password"));
		passLog();
		pim.clickOnLogin();
		passLog();

		pim.clickOnPIM();
		passLog();
		pim.clickOnAddEmployee();
		passLog();
		pim.enterFirstName(h1.get("firstName"));
		passLog();
		pim.enterLastName(h1.get("lastName"));
		passLog();
		pim.clickOnSave();
		passLog();

		s_assert.assertAll();
	}

	@DataProvider
	public Object[][] setData1() 
	{
		Xls_Reader xls = new Xls_Reader(System.getProperty("user.dir") + "/TestData/testdata.xlsx");
		return ReadData.getData("OrangeHRM_PIM", "OrangeHRM_PIM_TESTCASES", xls);
	}	
}
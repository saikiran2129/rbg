package com.surveillance.Test;

import java.util.Hashtable;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.surveillance.pages.LoginPage;
import com.surveillance.pages.PagePactoryDemo1;
import com.surveillance.utilitiy.GenericKeywords;
import com.surveillance.utilitiy.GenericKeywordsWithPage;
import com.surveillance.utilitiy.PropertySingleton;
import com.surveillance.utilitiy.ReadData;
import com.surveillance.utilitiy.Xls_Reader;

public class PageFactoryTest1 extends BaseTest
{
//		LoginPage login=new LoginPage();
	PagePactoryDemo1 p1 ;
	PropertySingleton _instance = null;
	SoftAssert s_assert = new SoftAssert();

	public PageFactoryTest1() throws Throwable
	{
		_instance = PropertySingleton.getInstance();
		p1 = new PagePactoryDemo1(GenericKeywordsWithPage.driver);
	}
	@BeforeClass
	public void startReport()
	{
		beforeClassForChild(this);
	}	
	@Test
	public void loginWithValidCredentials() throws Exception 
	{
		extentLoggerECP = parentExtentLogger.createNode("login With Valid Credentials");
		s_assert = new SoftAssert();
		p1 = new PagePactoryDemo1(GenericKeywordsWithPage.driver);
		//		System.out.println("userEmail "+h2.get("Email"));
		//		p1.enter("Admin");
		//		p1.enterPassword("Admin@123");
		//	p1.ClickButton("data");
		//		s_assert.assertAll();
		p1.OpenAntherBrowser();
	}
}
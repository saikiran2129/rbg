package Testpackage;

import java.util.Hashtable;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.surveillance.Test.BaseTest;
import com.surveillance.utilitiy.GenericKeywordsWithPage;
import com.surveillance.utilitiy.PropertySingleton;

import Pagepackage.Guru99loginpage; 

public class  Guru99logintest extends BaseTest
{
	PropertySingleton _instance = null;//
	SoftAssert s_assert = new SoftAssert();//TestNg class

	Guru99loginpage p1; 

	public   Guru99logintest() throws Throwable 
	{
		_instance = PropertySingleton.getInstance();
		p1= new Guru99loginpage(GenericKeywordsWithPage.driver);
	}

	@BeforeClass
	public void startReport()
	{
		beforeClassForChild(this);

	}

	@Test(dataProvider="setData1")
	public void loginWithValidCredentials(Hashtable< String, String>h1) throws Exception 

	{
		extentLoggerECP = parentExtentLogger.createNode("login With Valid Credentials");
		s_assert = new SoftAssert();
		p1= new Guru99loginpage(GenericKeywordsWithPage.driver);
		Thread.sleep(5000);

		p1.Guru99userName("mngr546841");
		Thread.sleep(5000);
		p1.Guru99userpassword("dAbUdUd ");
		Thread.sleep(5000);
		p1.Guru99loginButton();

					p1.Guru99userName( h1.get("username"));
					p1.Guru99userpassword( h1.get("password"));
					p1.Guru99loginButton();

		s_assert.assertAll();


	}
}
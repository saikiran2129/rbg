package Testpackage;

import java.util.Hashtable;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.surveillance.Test.BaseTest;
import com.surveillance.utilitiy.GenericKeywordsWithPage;
import com.surveillance.utilitiy.PropertySingleton;
import com.surveillance.utilitiy.ReadData;
import com.surveillance.utilitiy.Xls_Reader;

import Pagepackage.Fbloginpage;

public class Fblogintest extends BaseTest
{
	PropertySingleton _instance = null;//
	SoftAssert s_assert = new SoftAssert();//TestNg class

	Fbloginpage p1; 

	public  Fblogintest() throws Throwable 
	{
		_instance = PropertySingleton.getInstance();
		p1= new Fbloginpage(GenericKeywordsWithPage.driver);
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
		p1= new Fbloginpage(GenericKeywordsWithPage.driver);
		Thread.sleep(5000);

		//		p1.fbuserName("sai");
		//		Thread.sleep(5000);
		//		p1.fbuserpassword("rbg");
		//		Thread.sleep(5000);
		//		p1.fbloginButton();

		p1.fbuserName( h1.get("username"));
		p1.fbuserpassword( h1.get("password"));
		p1.fbloginButton();

		s_assert.assertAll();

	}
	@DataProvider

	public Object[][] setData1() 
	{
		Xls_Reader xls = new Xls_Reader(System.getProperty("user.dir") + "/TestData/testdata.xlsx");
		return ReadData.getData("Fblogin", "Fb_login", xls);
	}
}

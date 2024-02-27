package com.surveillance.pages;
import com.surveillance.utilitiy.GenericKeywords;
import com.surveillance.utilitiy.PropertySingleton;

	public class HomePageTestPage {
		PropertySingleton _instance = null;

		public HomePageTestPage() 
		{
			_instance = PropertySingleton.getInstance();
		}

		public GenericKeywords keywords = new GenericKeywords("HomePageTest");
		
		public HomePageTestPage clickOnCAMERAS()
		{
			keywords.jsClick("xpath", _instance.getValue("HomePageTest.BTN_CAMERAS"));
			return this;
		}
		
		public boolean isCAMERASDisplay() throws Throwable
		{
			boolean flag=keywords.isdisplay("xpath", _instance.getValue("HomePageTest.BTN_CAMERAS"),"display");
			return flag;
		}
		
		public HomePageTestPage clickOnARCHIVES()
		{
			keywords.jsClick("xpath", _instance.getValue("HomePageTest.BTN_ARCHIVES"));
			return this;
		}
		public boolean isARCHIVESDisplay() throws Throwable
		{
			boolean flag=keywords.isdisplay("xpath", _instance.getValue("HomePageTest.BTN_ARCHIVES"),"display");
			return flag;
		}
		
		public HomePageTestPage clickOnUSERADMIN()
		{
			keywords.jsClick("xpath", _instance.getValue("HomePageTest.BTN_USERADMIN"));
			return this;
		}
		public boolean isUSERADMINDisplay() throws Throwable
		{
			boolean flag=keywords.isdisplay("xpath", _instance.getValue("HomePageTest.BTN_USERADMIN"),"display");
			return flag;
		}
		public HomePageTestPage clickOnSYSTEMADMIN()
		{
			keywords.jsClick("xpath", _instance.getValue("HomePageTest.BTN_SYSTEMADMIN"));
			return this;
		}
		public boolean isSYSTEMADMINDisplay() throws Throwable
		{
			boolean flag=keywords.isdisplay("xpath", _instance.getValue("HomePageTest.BTN_SYSTEMADMIN"),"display");
			return flag;
		}
		public HomePageTestPage clickOnCOMMANDCENTER()
		{
			keywords.jsClick("xpath", _instance.getValue("HomePageTest.BTN_COMMANDCENTER"));
			return this;
		}
		public boolean isCOMMANDCENTERDisplay() throws Throwable
		{
			boolean flag=keywords.isdisplay("xpath", _instance.getValue("HomePageTest.BTN_COMMANDCENTER"),"display");
			return flag;
		}
		
		public HomePageTestPage clickOnTICKETS()
		{
			keywords.jsClick("xpath", _instance.getValue("HomePageTest.BTN_TICKETS"));
			return this;
		}
		public boolean isTICKETSDisplay() throws Throwable
		{
			boolean flag=keywords.isdisplay("xpath", _instance.getValue("HomePageTest.BTN_TICKETS"),"display");
			return flag;
		}
		public HomePageTestPage clickOnLogout()
		{
			keywords.jsClick("xpath", _instance.getValue("HomePageTest.BTN_Logout"));
			return this;
		}
		public boolean isLogoutDisplay() throws Throwable
		{
			boolean flag=keywords.isdisplay("xpath", _instance.getValue("HomePageTest.BTN_Logout"),"display");
			return flag;
		}
		public HomePageTestPage clickOnViewProfile()
		{
			keywords.jsClick("xpath", _instance.getValue("HomePageTest.BTN_ViewProfile"));
			return this;
		}
		public boolean isViewProfileDisplay() throws Throwable
		{
			boolean flag=keywords.isdisplay("xpath", _instance.getValue("HomePageTest.BTN_ViewProfile"),"display");
			return flag;
		}
		public String getWelcome() throws Throwable 
		{	
			String text=keywords.getText("xpath", _instance.getValue("HomePageTest.LBL_Welcome"));
			return text;
		}
		public String getUserName() throws Throwable 
		{	
			String text=keywords.getText("xpath", _instance.getValue("HomePageTest.LBL_UserName"));
			return text;

		}

	}



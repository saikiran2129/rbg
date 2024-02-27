package Pagepackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.surveillance.utilitiy.GenericKeywordsWithPage;

public class Fbloginpage 
{
	public  Fbloginpage(WebDriver driver)
	{
		PageFactory.initElements( driver,  this);
		//current class Non static variable will be called by cons


	}
	@FindBy(xpath="//input[@name='email']")
	WebElement userName;


	@FindBy(xpath="//input[@name='pass']")
	WebElement  passWord;	

	@FindBy(xpath="// butto[@name='btnLogin']")
	WebElement  loginbutton;

	GenericKeywordsWithPage test=new GenericKeywordsWithPage("Fbloginpage");

	public void fbuserName(String enteruser)
	{
		test.enterData(userName ,enteruser);
	}
	public void fbuserpassword(String enterpassword)
	{
		test.enterData(passWord ,enterpassword);
	}

	public void fbloginButton()
	{
		test.click(loginbutton);
	}

}

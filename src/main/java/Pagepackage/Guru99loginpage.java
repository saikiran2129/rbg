package Pagepackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.surveillance.utilitiy.GenericKeywordsWithPage;

public class Guru99loginpage 
{
	public   Guru99loginpage (WebDriver driver)
	{
		PageFactory.initElements( driver,  this);
		//current class Non static variable will be called by cons


	}
	@FindBy(xpath="//input[@name='uid']")
	WebElement userName;


	@FindBy(xpath="//input[@name='password']")
	WebElement  passWord;	

	@FindBy(xpath="//input[@name='btnLogin']")
	WebElement  loginbutton;

	GenericKeywordsWithPage test=new GenericKeywordsWithPage("Guru99loginpage");

	public void Guru99userName(String enteruser)
	{
		test.enterData(userName ,enteruser);
	}
	public void Guru99userpassword(String enterpassword)
	{
		test.enterData(passWord ,enterpassword);
	}

	public void Guru99loginButton()
	{
		test.click(loginbutton);
	}

}



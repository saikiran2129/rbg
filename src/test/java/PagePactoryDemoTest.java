import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.surveillance.utilitiy.GenericKeywordsWithPage;

public class PagePactoryDemoTest 
{
	public PagePactoryDemoTest(WebDriver driver)
	{
		this.driver = driver;
		//This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//input[@name='txtUsername']")
	WebElement username;
	@FindBy(xpath="//input[@name='txtPassword']")
	WebElement password;
	@FindBy(xpath="//input[@type='submit']")
	WebElement button;
	@FindBy(xpath="(//span[@class='dropdown-nav-toggle'])[1]")WebElement Testing ;
	WebDriver driver;

	public GenericKeywordsWithPage keywords = new GenericKeywordsWithPage("LoginPage");

	public void enter(String value) throws Exception
	{
		//		keywords.enterData(username, value);
		System.out.println("This  method is executed under the pagefactory class");	
	}

	public void login_Orange_Hrm(String value) throws Exception 
	{
		keywords .enterData(username, value);
		keywords.enterData(password, value);
		keywords.submitButton(button);	
	}
	public void enterUs(String logUsname)
	{
		keywords.enterData(username, "");	
	}

	public void ClickButton() throws Exception
	{
		keywords.click(Testing);
		keywords.closeWindow();	
	}

	public void OpenBrowser(String Browsername,String url) 
	{
		System.out.println( "function working");
		keywords.openBrowser(Browsername);
		keywords.openURL(url);
		//	keywords.elementFind()
		keywords.quitWindow();
		System.out.println( "function working2d time");
		keywords.openBrowser(Browsername);
		keywords.openURL(url);
		//		keywords.quitWindow();
	}
}
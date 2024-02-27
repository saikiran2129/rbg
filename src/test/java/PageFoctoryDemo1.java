import org.openqa.selenium.WebDriver;

import com.surveillance.pages.PagePactoryDemo1;

public class PageFoctoryDemo1 extends PagePactoryDemoTest
{
	public PageFoctoryDemo1(WebDriver driver)
	{
		super(driver);	
	}

	public static void main(String[] args) throws Exception
	{
		PagePactoryDemoTest p1=new PagePactoryDemoTest(null);		
		p1.OpenBrowser("chrome","https://opensource-demo.orangehrmlive.com/");
		p1.enterUs(null);
	}
} 
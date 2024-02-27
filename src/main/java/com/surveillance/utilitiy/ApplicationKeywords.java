package com.surveillance.utilitiy;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import javax.mail.Message;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.util.Properties;

public class ApplicationKeywords 
{
	public static WebDriver driver; 
	public String parentWindowID;
	public String exceptionData="";
	public Hashtable<String, String> hashtable=new Hashtable<String, String>();
	public Logger logger;
	public Properties dynamicElements=new Properties();
	public  String className;
	public static long PAGE_LOAD_TIMEOUT=5000;
	public ApplicationKeywords()
	{
		
	}
	
	
	public void selectCalendarDate(String DisplayDate,String PreviousDate,String NextDate,String date) throws ParseException, Throwable {
		SimpleDateFormat df= new SimpleDateFormat("M/d/yyyy");
		System.out.println("date: "+date);
		Date dateTobeSelected= df.parse(date);
		
		Date currentDate=new Date();
	
		String monthYeardisplayed=driver.findElement(By.xpath(DisplayDate)).getText();
		 
		System.out.println("monthYeardisplayed "+monthYeardisplayed);
		//df= new SimpleDateFormat("M");
		/*String month=df.format(d);
		System.out.println(month);*/

		String day=new SimpleDateFormat("d").format(dateTobeSelected);
		//((JavascriptExecutor)driver).executeScript("arguments[0].checked = true;", driver);
		String month=new SimpleDateFormat("MMM").format(dateTobeSelected);
		
		String year=new SimpleDateFormat("yyyy").format(dateTobeSelected);
		//JavascriptExecutor js = (JavascriptExecutor)driver;
		//js.executeScript("document.getElementById('start_date_sec').style.display='block';");
		String monthtobeSelected=month+" "+year;
		System.out.println("monthtobeSelected "+monthtobeSelected);
		System.out.println("Selected date"+" "+driver.findElement(By.xpath(DisplayDate)).getText());
		
		while(true){
		if(monthtobeSelected.equals(monthYeardisplayed)){
			//driver.findElement(By.xpath("//a[text()='"+day+"']")).click();
			driver.findElement(By.xpath("//table[1]//td[not(@class='datetime-selector--dimmed') and not(@class='datetime-selector--disabled') and text()='"+day+"']")).click();
			System.out.println("date selected");
			break;
		}
		else{
			if(dateTobeSelected.after(currentDate)){
				System.out.println("Befor date selecting");
				driver.findElement(By.xpath(NextDate)).click();
				
			}
			else{
				System.out.println("after date selecting");
				driver.findElement(By.xpath(PreviousDate)).click();
			}                                    
			
		}
		Thread.sleep(4000);
		monthYeardisplayed=driver.findElement(By.xpath(DisplayDate)).getText();
	}

	}
	
	public void selectDate(String date) throws ParseException {
		SimpleDateFormat df= new SimpleDateFormat("d/M/yyyy");
		System.out.println("date: "+date);
		Date dateTobeSelected= df.parse(date);
		
		Date currentDate=new Date();
	
		String monthYeardisplayed=driver.findElement(By.xpath("//*[@id='report']//h3")).getText();
		 
		System.out.println("monthYeardisplayed "+monthYeardisplayed);
		//df= new SimpleDateFormat("M");
		/*String month=df.format(d); 
		System.out.println(month);*/

		String day=new SimpleDateFormat("d").format(dateTobeSelected);
		//((JavascriptExecutor)driver).executeScript("arguments[0].checked = true;", driver);
		String month=new SimpleDateFormat("MMM").format(dateTobeSelected);
		
		String year=new SimpleDateFormat("yyyy").format(dateTobeSelected);
		//JavascriptExecutor js = (JavascriptExecutor)driver;
		//js.executeScript("document.getElementById('start_date_sec').style.display='block';");
		String monthtobeSelected=month+", "+year;
		System.out.println("monthtobeSelected "+monthtobeSelected);
		System.out.println("Selected date"+" "+driver.findElement(By.xpath("//*[@id='report']//h3")).getText());
		
		while(true){
		if(monthtobeSelected.equals(monthYeardisplayed)){
			//driver.findElement(By.xpath("//a[text()='"+day+"']")).click();
			driver.findElement(By.xpath("(//*[@id='report']//table)[1]//td[not(@class='datetime-selector--dimmed') and not(@class='datetime-selector--disabled') and text()='"+day+"']")).click();
			System.out.println("date selected");
			break;
		}
		else{
			if(dateTobeSelected.after(currentDate)){
				System.out.println("Befor date selecting");
				driver.findElement(By.xpath("//*[@id='report']/div/div[1]/div/div[1]/div[1]/div[3]/div/div[1]/div/div[3]")).click();
				
			}
			else{
				System.out.println("after date selecting");
				driver.findElement(By.xpath("//*[@id='report']/div/div[1]/div/div[1]/div[1]/div[3]/div/div[1]/div/div[2]")).click();
			}
			
		}
		monthYeardisplayed=driver.findElement(By.xpath("//*[@id='report']//h3")).getText();
	}

	}
	
//	public void selectDateNew(String dispalyLocator,String previuosDateLocator,String nextDateLocator,String date) throws ParseException {
	public void selectDateNew(String date) throws ParseException	
	{
	SimpleDateFormat df= new SimpleDateFormat("d/M/yyyy");
		System.out.println("date: "+date);
		Date dateTobeSelected= df.parse(date);
		
		Date currentDate=new Date();

		String monthYeardisplayed=driver.findElement(By.xpath("//*[@id='report']//h3")).getText();
		 
		System.out.println("monthYeardisplayed "+monthYeardisplayed);
		//df= new SimpleDateFormat("M");
		/*String month=df.format(d);
		System.out.println(month);*/

		String day=new SimpleDateFormat("d").format(dateTobeSelected);
		//((JavascriptExecutor)driver).executeScript("arguments[0].checked = true;", driver);
		String month=new SimpleDateFormat("MMM").format(dateTobeSelected);
		
		String year=new SimpleDateFormat("yyyy").format(dateTobeSelected);
		//JavascriptExecutor js = (JavascriptExecutor)driver;
		//js.executeScript("document.getElementById('start_date_sec').style.display='block';");
		String monthtobeSelected=month+", "+year;
		System.out.println("monthtobeSelected "+monthtobeSelected);
		System.out.println("Selected date"+" "+driver.findElement(By.xpath("//*[@id='report']//h3")).getText());
		
		while(true){
		if(monthtobeSelected.equals(monthYeardisplayed)){
			//driver.findElement(By.xpath("//a[text()='"+day+"']")).click();
			driver.findElement(By.xpath("(//*[@id='report']//table)[1]//td[not(@class='datetime-selector--dimmed') and not(@class='datetime-selector--disabled') and text()='"+day+"']")).click();
			System.out.println("date selected");
			break;
		}
		else{
			if(dateTobeSelected.after(currentDate)){
				
				driver.findElement(By.xpath("//*[@id='report']/div/div[1]/div/div[1]/div[2]/div[3]/div/div[1]/div/div[3]")).click();
			}
			else{
				driver.findElement(By.xpath("//*[@id='report']/div/div[1]/div/div[1]/div[2]/div[3]/div/div[1]/div/div[2]")).click();
			}//*[@id="app_container"]/div/div[2]/div[1]/div/div/div/h3
			
		}
		monthYeardisplayed=driver.findElement(By.xpath("//*[@id='report']//h3")).getText();
	}

	}
	
	
	public void selectSetDemoDate() throws ParseException	
	{
	SimpleDateFormat df= new SimpleDateFormat("d/M/yyyy");
		
		String date=df.format(new Date());
		System.out.println("date: "+date);
		Date dateTobeSelected= df.parse(date);
		
		Date currentDate=new Date();
		String displayDate="//*[@id='app_container']//h3";

		String monthYeardisplayed=driver.findElement(By.xpath(displayDate)).getText();
		 
		System.out.println("monthYeardisplayed "+monthYeardisplayed);
		//df= new SimpleDateFormat("M");
		/*String month=df.format(d);
		System.out.println(month);*/

		String day=new SimpleDateFormat("d").format(dateTobeSelected);
		//((JavascriptExecutor)driver).executeScript("arguments[0].checked = true;", driver);
		String month=new SimpleDateFormat("MMM").format(dateTobeSelected);
		
		String year=new SimpleDateFormat("yyyy").format(dateTobeSelected);
		//JavascriptExecutor js = (JavascriptExecutor)driver;
		//js.executeScript("document.getElementById('start_date_sec').style.display='block';");
		String monthtobeSelected=month+", "+year;
		System.out.println("monthtobeSelected "+monthtobeSelected);
		System.out.println("Selected date"+" "+driver.findElement(By.xpath(displayDate)).getText());
		
		while(true){
		if(monthtobeSelected.equals(monthYeardisplayed)){
			//driver.findElement(By.xpath("//a[text()='"+day+"']")).click();
			driver.findElement(By.xpath("(//*[@id='app_container']//table)[1]//td[not(@class='datetime-selector--dimmed') and not(@class='datetime-selector--disabled') and text()='"+day+"']")).click();
			System.out.println("date selected");
			break;
		}
		else{
			if(dateTobeSelected.after(currentDate)){
				
				driver.findElement(By.xpath("//*[@id='app_container']/div/div/div[1]/div/div/div[2]/div/div[1]/div/div/div[3]")).click();
			}
			else{
				driver.findElement(By.xpath("//*[@id='app_container']/div/div/div[1]/div/div/div[2]/div/div[1]/div/div/div[2]")).click();
			}//*[@id="app_container"]/div/div[2]/div[1]/div/div/div/h3
			
		}
		monthYeardisplayed=driver.findElement(By.xpath(displayDate)).getText();
	}

	}
	
//	 public static void emailValidation(WebDriver driver,String subjectAndLinkName) {
			public void emailValidation() {    
				    //TODO: apply for a loan using criteria that will result in the application being rejected
				    
				    try{
//				    String mailDetails[]=	subjectAndLinkName.split("::");
//				    String subject=mailDetails[0];
//				    String linkName=mailDetails[1];
				    String subject="New LiveView Technologies User Account";
				    String linkName="Activate Your Account";
				     	EmailUtils emailUtils = new EmailUtils("LVTTestAutomation@gmail.com", "Password@123", "smtp.gmail.com", EmailUtils.EmailFolder.INBOX);
//				      if(emailUtils.getMessagesBySubject("Welcome to Daton", true, 5).length<1);{
//				    	  emailUtils = new EmailUtils("rbgtechnologies@gmail.com", "Kb100684@", "smtp.gmail.com", EmailUtils.EmailFolder.SPAM); 
//				      }
				      Message email = emailUtils.getMessagesBySubject(subject, true, 5)[emailUtils.getMessagesBySubject("New LiveView Technologies User Account", true, 5).length-1];
				      String link = emailUtils.getUrlsFromMessage(email, linkName).get(0);
				      
				      driver.get(link);
				      // driver.findElement(By.xpath("//*[@id='mat-dialog-0']/app-common-dialog/div/mat-dialog-actions/div/button")).click();
//				      if(succesfullMail.)
				      
				      //TODO: continue testing
				    } catch (Exception e) {
				      e.printStackTrace();
				      Assert.fail(e.getMessage());
				    }
				  }
}

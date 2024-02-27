package com.surveillance.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.surveillance.utilitiy.DateAndTimeFormate;
import com.surveillance.utilitiy.GenericKeywords;
import com.surveillance.utilitiy.HtmlReportFile;
import com.surveillance.utilitiy.MailTest;
import com.surveillance.utilitiy.PropertySingleton;

import cucumber.api.testng.TestNGCucumberRunner;


public class BaseTest 
{
	 
		public static ExtentHtmlReporter htmlReporter;
		public static ExtentReports extent;
		public static ExtentTest extentLoggerECP;
		public ExtentTest parentExtentLogger;
		PropertySingleton _propertySingleton = null;
		
		
		public GenericKeywords keywords;
		

		  static int testScenarioTotal=0;
		  static int totalScenarioPassCount=0;
		  static int totaltScenarioFailCount=0;
		  static int totalScenarioSkipCount=0;
		  static int serialNo=1;
		  
		   int testScenarioClassTotal=0;
		   int totalScenarioClassPassCount=0;
		   int totaltScenarioClassFailCount=0;
		   int totalScenarioClassSkipCount=0;
		   
		static  String fileName;
		  static String testFolder;
		  static String AWSS3FolderName;
		 static  String extentAWSS3HTMLName;
		  String className;
		  Date date1;
		  
//		public static TestNGCucumberRunner testNGCucumberRunner;
		public BaseTest() {

		}

		@BeforeSuite
		public void setUp() throws Throwable {
			String reportFolderName=GenericKeywords.TimeStampFolder();
			
			testFolder=(System.getProperty("user.dir") + "/testReports/"+reportFolderName+GenericKeywords.TimeStamp());
			File ConsReportFolder=new File(testFolder);
			ConsReportFolder.mkdirs();
			AWSS3FolderName = ConsReportFolder.getName();
			extentAWSS3HTMLName="liveviewtech"+GenericKeywords.TimeStamp()+".html";
			htmlReporter = new ExtentHtmlReporter(testFolder+"/" +extentAWSS3HTMLName);
			extent = new ExtentReports();
			extent.attachReporter(htmlReporter);
			extent.setSystemInfo("Host Name", "SURV");
			extent.setSystemInfo("Environment", "QA");
			extent.setSystemInfo("User Name", "kalyan");
			htmlReporter.config().setChartVisibilityOnOpen(true);
			htmlReporter.config().setDocumentTitle("Searching functinalFlow"); 
			               // Name of the report
			htmlReporter.config().setReportName("FTECS Search "); 
			               // Dark Theme
			htmlReporter.config().setTheme(Theme.STANDARD);
			 fileName=testFolder+"/"+"MailsummaryReport.html";
			HtmlReportFile.createHtmlReport(fileName);
			/*reportsFolderWithTime=DateAndTimeFormate.dateFormate("-dd-MM-yyyy-HH-mm-ss-z");
			LocalReportsFolderPath=System.getProperty("user.dir")+"/tempResults/"+"TestReports"+reportsFolderWithTime;
			File reportspath=new File(LocalReportsFolderPath);
			reportspath.mkdirs();
			MasterPieChart=LocalReportsFolderPath+"/MasterPieChart.png";
			tcsummaryPieChart=LocalReportsFolderPath+"/tcsummaryPieChart.png";
			String HtmlReports=LocalReportsFolderPath+"/ConsolidatedReport"+".html";*/
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/M/yyyy hh:mm:ss");

			  
			String startDate= new SimpleDateFormat("dd/M/yyyy hh:mm:ss").format(new Date());
		     date1 = simpleDateFormat.parse(startDate);
		}

		// This method is to capture the screenshot and return the path of the
		// screenshot.
		public static String getScreenShot(WebDriver driver, String screenshotName) throws IOException {
			String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			// after execution, you could see a folder "FailedTestsScreenshots" under src
			// folder
			String destination = testFolder+ "/Screenshots/" + screenshotName + dateName + ".png";
			File finalDestination = new File(destination);
			FileUtils.copyFile(source, finalDestination);
			return destination;
//			return "https://qa-reports.lvt-service-webtools-dev.aws.lvt.cloud/"+new File(testFolder).getName()+"/Screenshots/" + screenshotName + dateName + ".png";
		}

		public void beforeClassForChild(Object o1) {

			 className = o1.getClass().getSimpleName();
			System.out.println("class Name: " + className);
			keywords = new GenericKeywords(className);
			htmlReporter.config().setChartVisibilityOnOpen(true);
			htmlReporter.config().setDocumentTitle("Searching functinalFlow");
			htmlReporter.config().setReportName("Automation Report ");
			// Dark Theme
			htmlReporter.config().setTheme(Theme.STANDARD);
//		  keywords.className=className;
			parentExtentLogger = extent.createTest(className);

		}

		@BeforeMethod
		public void setup() throws Throwable {
		//	extentLoggerECP=parentExtentLogger.createNode("TestCase - : "+i);
			_propertySingleton = PropertySingleton.getInstance();
			keywords.openBrowser(_propertySingleton.getValue("browser"));
			keywords.openURL(_propertySingleton.getValue("URL"));
			//i++;
		}

		@AfterMethod
		public void getResult(ITestResult result) throws Exception 
		{
			try
			{
			if (result.getStatus() == ITestResult.FAILURE) {
				// MarkupHelper is used to display the output in different colors
				System.out.println("Failed log Start");
				extentLoggerECP.log(Status.FAIL,
						MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
				System.out.println("Failed log Start2");
				extentLoggerECP.log(Status.FAIL,
						MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
				System.out.println("Failed log Start3");
				// To capture screenshot path and store the path of the screenshot in the string
				// "screenshotPath"
				// We do pass the path captured by this method in to the extent reports using
				// "logger.addScreenCapture" method.
				// String Scrnshot=TakeScreenshot.captuerScreenshot(driver,"TestCaseFailed");
				String screenshotPath = getScreenShot(GenericKeywords.driver, result.getName());
				System.out.println("Failed log done");
				// To add it in the extent report
				extentLoggerECP.fail(
						"Test Case Failed Snapshot is below " + extentLoggerECP.addScreenCaptureFromPath(screenshotPath));
				 totaltScenarioClassFailCount=totaltScenarioClassFailCount+1;
				
			} else if (result.getStatus() == ITestResult.SKIP) {
				extentLoggerECP.log(Status.SKIP,
						MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
				extentLoggerECP.log(Status.SKIP,
						MarkupHelper.createLabel(result.getThrowable() + " - Test Case Skipped", ExtentColor.ORANGE));
			} else if (result.getStatus() == ITestResult.SUCCESS) {
				extentLoggerECP.log(Status.PASS,
						MarkupHelper.createLabel(result.getName() + " - Test Case PASSED", ExtentColor.GREEN));
				String screenshotPath = getScreenShot(GenericKeywords.driver, result.getName());
				System.out.println("Passed log done");
				// To add it in the extent report
				extentLoggerECP.pass(
						"Test Case Passed Snapshot is below " + extentLoggerECP.addScreenCaptureFromPath(screenshotPath));
				totalScenarioClassPassCount=totalScenarioClassPassCount+1;
			}
			}
			catch(Throwable t1)
			{
				extentLoggerECP.log(Status.SKIP,
						MarkupHelper.createLabel(" - Test Case Skipped", ExtentColor.ORANGE));
				extentLoggerECP.log(Status.SKIP,
						MarkupHelper.createLabel(result.getThrowable() + " - Test Case Skipped", ExtentColor.ORANGE));
				System.out.println(t1);
				 totalScenarioClassSkipCount=totalScenarioClassSkipCount+1;;
			}
			keywords.quitWindow();
			
		}
	 
		public void passLog() throws Exception
		{
			
			extentLoggerECP.log(Status.PASS,
					MarkupHelper.createLabel("" + " Test step PASSED", ExtentColor.GREEN));
			String screenshotPath = getScreenShot(GenericKeywords.driver, "passlog");
			System.out.println("Passed log done :"+screenshotPath);
			// To add it in the extent report
//			extentLoggerECP.pass(
//					"Test step Passed Snapshot is below " + extentLoggerECP.addScreenCaptureFromPath(screenshotPath));
			extentLoggerECP.pass("",MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
//			MediaEntityBuilder.createScreenCaptureFromBase64String(screenshotPath).build();
			
			
		}
		
		public void stepPassLog(Method callingMethod) throws Exception
		{
			
		
			
			extentLoggerECP.log(Status.PASS,
					MarkupHelper.createLabel(getstepName(callingMethod), ExtentColor.GREEN));
			String screenshotPath = getScreenShot(GenericKeywords.driver, "passlog");
			System.out.println("Passed log done :"+screenshotPath);
			// To add it in the extent report
//			extentLoggerECP.pass(
//					"Test step Passed Snapshot is below " + extentLoggerECP.addScreenCaptureFromPath(screenshotPath));
			extentLoggerECP.pass("",MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
//			MediaEntityBuilder.createScreenCaptureFromBase64String(screenshotPath).build();
			
			
		}
		private String getstepName(Method callingMethod) {
			Annotation  myAnnotation = callingMethod.getAnnotations()[0];   
		 String steps=    myAnnotation+"";
		 String step=steps.split("value=")[1].replace(")", "");
			return step;
		}
		
		public void passLog(String stepName) throws Exception
		{
			extentLoggerECP.log(Status.PASS,
					MarkupHelper.createLabel("" + stepName, ExtentColor.GREEN));
			String screenshotPath = getScreenShot(GenericKeywords.driver, "passlog");
			System.out.println("Passed log done :"+screenshotPath);
			
			// To add it in the extent report
//			extentLoggerECP.pass(
//					"Test step Passed Snapshot is below " + extentLoggerECP.addScreenCaptureFromPath(screenshotPath));
			extentLoggerECP.pass("",MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
//			MediaEntityBuilder.createScreenCaptureFromBase64String(screenshotPath).build();
			
			
		}
		
		public Object[][] getScenario(String featureFileTitle,TestNGCucumberRunner testNGCucumberRunner) throws IOException {
		   	 
	    	
	    	System.out.println("Scenario length :"+testNGCucumberRunner.provideScenarios().length);
	    	Object[][] o1= 	testNGCucumberRunner.provideScenarios();
	    	
	    	Object[][] o2;
	    	ArrayList<ArrayList> list=new ArrayList<>();
	    	for(int i=0;i<o1.length;i++)
	    	{
	    		
	        	System.out.println("Size : "+o1[0].length);
	        		
	        		if(o1[i][1].toString().replace("\"", "").equals(featureFileTitle))
	        		{
	        			System.out.println("Matching");
	        		ArrayList list1=new ArrayList<>();	
	        		list1.add(o1[i][0]);
	        		list1.add(o1[i][1]);
	        		
	        		list.add(list1);
	        		} 
	        		else{
	        			System.out.println("not matching");
	        		}
	              	
	    	}
	    	o2=new Object[list.size()][2];
	    	for(int i=0;i<list.size();i++)
	    	{
	    		o2[i][0]=list.get(i).get(0);
	    		o2[i][1]=list.get(i).get(1);
	    	}
	    	
	    	System.out.println("Updated list size : "+o2.length);
	    	 return o2;
	    }	
		
		@AfterSuite
		public void endReport() throws Throwable {
			extent.flush();
			 String endDate= new SimpleDateFormat("dd/M/yyyy hh:mm:ss").format(new Date());
			 SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/M/yyyy hh:mm:ss");

			 int totalResultsDetails[]={0};
			 int tcSummaryDetails[]={testScenarioTotal,totalScenarioPassCount,totaltScenarioFailCount,totalScenarioSkipCount};
	         Date date2 = simpleDateFormat.parse(endDate);
			 HtmlReportFile.finalReportUpdate(fileName,DateAndTimeFormate.printDifference(date1, date2),totalResultsDetails,tcSummaryDetails);
		        
		        
		        
		        MailTest.emailSummaryReport(fileName,DateAndTimeFormate.printDifference(date1, date2),totalResultsDetails,tcSummaryDetails);
		        System.out.println("testFolder : "+testFolder);
		        

		}
		
		@AfterClass
		public void AfterClass() throws Throwable
		{
			try{
			  totalScenarioPassCount=totalScenarioPassCount+totalScenarioClassPassCount;
			  totaltScenarioFailCount=totaltScenarioFailCount+totaltScenarioClassFailCount;
			  totalScenarioSkipCount=totalScenarioSkipCount+totaltScenarioClassFailCount;
			  testScenarioTotal=testScenarioTotal+(totalScenarioPassCount+totaltScenarioFailCount+totalScenarioSkipCount);
			  
			  int sheetResultsDetails[]={serialNo,(totalScenarioClassPassCount+totaltScenarioClassFailCount+totalScenarioSkipCount),totalScenarioClassPassCount,totaltScenarioClassFailCount,totalScenarioSkipCount};
			  HtmlReportFile.testDetails(fileName,"https://qa-reports.lvt-service-webtools-dev.aws.lvt.cloud/"+new File(testFolder).getName()+"/"+extentAWSS3HTMLName, className,sheetResultsDetails); //extentAWSS3HTMLName
			}catch(Throwable t1)
			{
				t1.printStackTrace();
			}
			serialNo=serialNo++;
			   System.out.println("After class completed");
		}

		
		
		
}

package com.surveillance.db.test;

import java.io.File;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.surveillance.utilitiy.GenericKeywords;
import com.surveillance.utilitiy.PropertySingleton;

public class DBBaseTest {

	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public ExtentTest extentLoggerECP;
	public ExtentTest parentExtentLogger;
	PropertySingleton _propertySingleton = null;
//	static int i=1;
	public GenericKeywords keywords;

	public DBBaseTest() {

	}

	@BeforeSuite
	public void setUp() {
		String testFolder=(System.getProperty("user.dir") + "/testReports/"+GenericKeywords.TimeStampFolder());
		File ConsReportFolder=new File(testFolder);
		ConsReportFolder.mkdirs();
		htmlReporter = new ExtentHtmlReporter(testFolder +"FRKECP"+GenericKeywords.TimeStamp()+".html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Name", "FRK ECS");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("User Name", "Swathi");
	}


	public void beforeClassForChild(Object o1) {

		String className = o1.getClass().getSimpleName();
		System.out.println("class Name: " + className);
		keywords = new GenericKeywords(className);
		htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.config().setDocumentTitle("DB Testing");
		htmlReporter.config().setReportName("Automation Report ");
		// Dark Theme
		htmlReporter.config().setTheme(Theme.STANDARD);
		parentExtentLogger = extent.createTest(className);

	}

	@AfterMethod
	public void getResult(ITestResult result) throws Exception {
		if (result.getStatus() == ITestResult.FAILURE) {
			// MarkupHelper is used to display the output in different colors
			System.out.println("Failed log Start");
			extentLoggerECP.log(Status.FAIL,
					MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
			System.out.println("Failed log Start2");
			extentLoggerECP.log(Status.FAIL,
					MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
			System.out.println("Failed log Start3");
		} else if (result.getStatus() == ITestResult.SKIP) {
			extentLoggerECP.log(Status.SKIP,
					MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
			extentLoggerECP.log(Status.SKIP,
					MarkupHelper.createLabel(result.getThrowable() + " - Test Case Skipped", ExtentColor.ORANGE));
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			extentLoggerECP.log(Status.PASS,
					MarkupHelper.createLabel(result.getName() + " - Test Case PASSED", ExtentColor.GREEN));
			System.out.println("Passed log done");
			// To add it in the extent report
		}
		
	}

	@AfterSuite
	public void endReport() {
		extent.flush();

	}

}

package com.surveillance.utilitiy;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;





public class HtmlReportFile {
	static BufferedWriter bw;
	static String color=""
	;
	public static void main(String[] args) throws Throwable
	{
//		File f1=new File("C:\\Users\\vgardula\\Desktop\\Reports\\Test1.html");
//		f1.createNewFile();
		int testCaseDeatisl[]={1,100,70,20,10};
		int testCaseDeatisl2[]={2,100,100,0,0};
		int testCaseDeatisl3[]={3,100,60,10,30};

		
		String report="C:/Users/lenovo/Desktop/testReports/Index2.html";
		createHtmlReport(report);
		testDetails(report, "‪C:/Users/lenovo/Desktop/testReports", "CameraLiveUnit", testCaseDeatisl);
		testDetails(report, "‪C:/Users/lenovo/Desktop/testReports", "Add New User", testCaseDeatisl2);
		testDetails(report, "‪C:/Users/lenovo/Desktop/testReports", "Add New Cleint", testCaseDeatisl3);
		
	}






	/**
	 * Method Name	: createHtmlReport
	 * purpose		: creates a file and copies the mainContent and reportTemplate into it.
	 * parameters 	: fileName 
	 * Example		: 
	 */
		public static void createHtmlReport(String fileName) throws Throwable
		{	
			System.out.println("HTML report path :"+fileName);
			File f1=new File(fileName);
			f1.createNewFile();
			BufferedWriter bw = new BufferedWriter(new FileWriter(f1));
			bw.write(MainContent()+reportTemplate());
			bw.close();
		}
		
	//
		/**
		 * Method Name	: MainContent
		 * purpose		: creates the Html report based on the testcases executed, time taken for execution, host name of the system where testcases are executed and so on...
		 * parameters 	: excelpath 
		 * Example		: <>, <>
		 */
		public static String MainContent()
		{
		
			
			
			 color="#9933FF";
//			String AppName=Mains.configfile.getCellData("Config", "Application Name ", 2);
			 String AppName="LiveView Technologies";
			String content="<div class='header'><img src='"+"https://lvt.co/wp-content/uploads/2019/07/pasted-svg-303101x59.svg"+"' alt='Mountain View' overflow:'auto'  float:'left' align='center'style='width:150px;height:150px;'><h1 style='color:blue' overflow:'auto'  float:'left' align='center';><center></center>LVT - Automation Report</h1></div>"
					//+"<h2 style='color:blue' align='center';><center>Automation Report</center></h2>"
			+"<table height='10%' width='70%' border='1' bgcolor='"+color+"' style='font-family:tahoma; font-size:12'><font face='Verdana'>"
			+"<tr bgcolor='"+color+"'><td height='1' width='20%'><font face='Verdana' size='2' color='white' weight='200'> Application Name </font></td><td align='center'><font id='appname' face='Verdana' size='2' color='white' weight='200'>"+AppName+"</font></td>"
//			+"<td rowspan='11' align='center' bgcolor='"+color+"' width='10%'><div style='float: right;'><img src='data:image/png;base64,"+MainSuiteRunner.MasterPieChart+"' alt='Not coonnected to sharing path' align='middle'style='width:504px;height:500px;'></div></td>"
//			+"<td rowspan='11' align='center' bgcolor='"+color+"' width='10%'><div style='float: right;'><img src='data:image/png;base64,"+MainSuiteRunner.tcsummaryPieChart+"' alt=Not coonnected to sharing path' align='middle'style='width:504px;height:500px;'></div></td>"
			+"</tr>"
			+"<tr bgcolor='"+color+"'><td height='1'><font face='Verdana' size='2' color='white' weight='200'> Version </font></td><td align='center'><font id='Version' face='Verdana' size='2' color='white' weight='200'>"+"version"+"</font></td></tr>"
			+"<tr bgcolor='"+color+"'><td height='1'><font face='Verdana' size='2' color='white' weight='200'> Executed On </font></td><td align='center'><font id='ExecutedOn' face='Verdana' size='2' color='white' weight='200'>"+DateAndTimeFormate.dateFormate("dd/M/yyyy hh:mm:ss")+"</font></td></tr>"
			+"<tr bgcolor='"+color+"'><td height='1'><font face='Verdana' size='2' color='white' weight='200'> Host Name </font></td><td align='center'><font id='HostName' face='Verdana' size='2' color='white' weight='200'>"+getHostName()+"</font></td></tr>"
			+"<tr bgcolor='"+color+"'><td height='1'><font face='Verdana' size='2' color='white' weight='200'> Results Location </font></td><td align='center'><font id='ResultsLocation' face='Verdana' size='2' color='white' weight='200'>"+"MainSuiteRunner.RemotetResultsPath"+"</font></td></tr>"
			+"<tr bgcolor='"+color+"'><td height='1'><font face='Verdana' size='2' color='white' weight='200'> Total Docs </font></td><td align='center'><font id='TotalDocs' face='Verdana' size='2' color='white' weight='200'>"+"totalfiles"+"</font></td></tr>"
			+"<tr bgcolor='"+color+"'><td height='1'><font face='Verdana' size='2' color='white' weight='200'> Total Testcases & Steps Executed </font></td><td align='center'><font id='TotalExecuted' face='Verdana' size='2' color='white' weight='200'>"+"totalexecutedcount"+"</font></td></tr>"
			+"<tr bgcolor='"+color+"'><td height='1'><font face='Verdana' size='2' color='white' weight='200'> Total Testcases & Steps Pass </font></td><td align='center'><font id='TotalPass' face='Verdana' size='2' color='white' weight='200'>"+"totalpasscount"+"</font></td></tr>"
			+"<tr bgcolor='"+color+"'><td height='1'><font face='Verdana' size='2' color='white' weight='200'> Total Testcases & Steps Fail </font></td><td align='center'><font id='TotalFail'face='Verdana' size='2' color='white' weight='200'>"+"totalfailedcount"+"</font></td></tr>"
			+"<tr bgcolor='"+color+"'><td height='1'><font face='Verdana' size='2' color='white' weight='200'> Total Testcases & Steps Skip </font></td><td align='center'><font id='TotalSkip'face='Verdana' size='2' color='white' weight='200'>"+"totalskippedcount"+"</font></td></tr>"
			+"<tr bgcolor='"+color+"'><td height='1'><font face='Verdana' size='2' color='white' weight='200'> Total Elapsed Time </font></td><td align='center'><font class='special' id='TotalElapsedTime'face='Verdana' size='2' color='white' weight='200'>"+"totalelapced"+"</font></td></font></tr>"
			+"</table>"
			+"<br>";
			return content;
		}
		
		
		
		
		
		/**
		 * Method Name	: createxcelReport
		 * purpose		: creates the html report based on the No. of test cases passed, failed and skiped.
		 * parameters 	: -
		 * Example		: -
		 */
		public static String reportTemplate(){
//			 color="#9933FF";
			color="#0000cc";
			String template="<HTML><BODY>"
					+ "<table height='2%' width='70%' style='font-family:Verdana; font-size:15'><tbody><tr bgcolor='"+color+"'>"
		+"<th><font color='white'>S NO</font></th>"
		+"<th><font color='white'>Test Name</font></th>"
		+"<th><font color='white'>Total Executed</font></th>"
		+"<th><font color='white'>Total Pass</font></th>"
		+"<th><font color='white'>Total Fail</font></th>"
		+"<th><font color='white'>Total Skip</font></th></tr>";
			return template;
		}

		/**
		 * Method Name	: testDetails
		 * purpose		: 
		 * parameters 	: 
		 * Example		: 
		 */
		public static String  testDetails(String fileName,String htmlReportpath,String htmlReportName,int results[]) throws Throwable
		{
			String withFail=null;
			String bgclor="#80ffff";//#9933FF
			if(results[3]>0){
				 withFail="<td bgcolor='"+bgclor+"' style='background-color:#FF0000'>"+results[3]+"</td>";
			}
			else
			{
				withFail="<td bgcolor='"+bgclor+"'>"+results[3]+"</td>";	
			}
			
			String withskip=null;
			if(results[4]>0){
				withskip="<td bgcolor='#BEBEBE' style='background-color:#778899'>"+results[4]+"</td>";
			}
			else
			{
				withskip="<td bgcolor='"+bgclor+"'>"+results[4]+"</td>";	
			}
			
			
			String data="<tr>"
			+"<td bgcolor='"+bgclor+"'>"+results[0]+"</td>"  //#A52A2A '#BEBEBE
			+"<td bgcolor='#BEBEBE' style='background-color:"+bgclor+"'><a href='"+htmlReportpath+"'>"+htmlReportName+"</a>"
			+"</td><td bgcolor='"+bgclor+"'>"+results[1]+"</td>"
			+"<td bgcolor='#BEBEBE' style='background-color:#009b00'>"+results[2]+"</td>"// #A6D785 previous color #32CD32
			
			+ withFail /*total fail column*/
			
//			+"<td bgcolor='#BEBEBE' style='background-color:#778899'>"+results[4]+"</td>"//total skip column
			+withskip
			+"</tr>";
					
			File f1=new File(fileName);
			FileWriter write = new FileWriter(f1,true);
			write.write(data);
			write.close();
			return data;
			
		}
		
		
		
//		public void endDetailReport(String report) throws IOException
//		{
//			FileWriter writer = new FileWriter(report,true);
//			writer.write("</TABLE>");
//			writer.close();
//			writer = new FileWriter(Driver.reportFileNm,true);
//			writer.write("</TABLE>");
//			writer.close();
//		}
		
		/**
		 * Method Name	: finalReportUpadte
		 * purpose		: creates the final report of app version,Total No.of test cases and steps, No. of test cases passed, failed and skipped and time taken.
		 * parameters 	: filename, elapsedTime, resultDetails, testcasesDetails
		 * Example		: 
		 */
		public static void finalReportUpdate(String filene,String elapcedTime,int resultsDetaisl[],int TestCaseDetaisl[]) throws IOException
		{
			File f1=new File(filene);
			FileWriter write = new FileWriter(f1,true);
			/*String totalCasesAndSteps=TestCaseDetaisl[0]+" &"+resultsDetaisl[1];
			String toatlPass=TestCaseDetaisl[1]+" &"+resultsDetaisl[2];
			String totalFail=TestCaseDetaisl[2]+" &"+resultsDetaisl[3];
			String totalSkips=TestCaseDetaisl[3]+" &"+resultsDetaisl[4];*/
			String totalCasesAndSteps=TestCaseDetaisl[0]+"";
			String toatlPass=TestCaseDetaisl[1]+"";
			String totalFail=TestCaseDetaisl[2]+"";
			String totalSkips=TestCaseDetaisl[3]+"";
			String data="<script>document.getElementById('Version').innerHTML = "+1+";</script>"
					+"<script>document.getElementById('TotalDocs').innerHTML = '"+resultsDetaisl[0]+"';</script>"
					+"<script>document.getElementById('TotalExecuted').innerHTML = '"+totalCasesAndSteps+"';</script>"
					+"<script>document.getElementById('TotalPass').innerHTML = ' "+toatlPass+"';</script>"
					+"<script>document.getElementById('TotalFail').innerHTML = '"+totalFail+"';</script>"
					+"<script>document.getElementById('TotalSkip').innerHTML = '"+totalSkips+"';</script>"
					+"<script>document.getElementById('TotalElapsedTime').innerHTML =' "+elapcedTime+"';</script>"
					;
			write.write(data);
			write.close();
		}
		
		/**
		 * Method Name	: getHostName
		 * purpose		: returns the hostname of the system where the testcases are executed.
		 * parameters 	: - 
		 * Example		: -
		 */
		public static String getHostName()
		{
			

			String hostname = "Unknown";

			try
			{
			    InetAddress addr;
			    addr = InetAddress.getLocalHost();
			    hostname = addr.getHostName();
			}
			catch (UnknownHostException ex)
			{
			    System.out.println("Hostname can not be resolved");
			}
			return hostname;
		}
		
		
		
		
}

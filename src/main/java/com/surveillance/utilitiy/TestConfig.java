package com.surveillance.utilitiy;
public class TestConfig{
	public static String server="smtp.gmail.com";
	public static String from = "swathisree.98@gmail.com";
	public static String password = "************";
	public static String[] to ={"swathisree.98@gmail.com","swathisree.98@gmail.com"};
	public static String subject = "Consolidated Report";
	public static String messageBody ="TestMessage";
	public static String attachmentPath=System.getProperty("user.dir") + "/test-output/ConsolidatedReport.html";
	public static String attachmentName="ConsolidatedReport.html";
	
		
	//SQL DATABASE DETAILS	
	public static String driver="net.sourceforge.jtds.jdbc.Driver"; 
	public static String dbConnectionUrl="jdbc:jtds:sqlserver://192.101.44.22;DatabaseName=monitor_eval"; 
	public static String dbUserName="sa"; 
	public static String dbPassword="$ql$!!1"; 
	
	
	//MYSQL DATABASE DETAILS
	public static String mysqldriver="com.mysql.jdbc.Driver";
	public static String mysqluserName = "root";
	public static String mysqlpassword = "selenium";
	public static String mysqlurl = "jdbc:mysql://localhost:3306/acs";
	
	//Oracle DATABASE DETAILS
	public static String oracledriver="oracle.jdbc.driver.OracleDriver";  
	public static String oracleuserName = "system";
	public static String oraclepassword = "password";
	public static String oracleurl = "jdbc:oracle:thin:@localhost:1521:xe";
	

	
	
	
	
	
	
}

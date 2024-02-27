package com.surveillance.utilitiy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;





public class MailTest {
 
	
	/**
	 * Method Name	: sendPDFReportByGMail
	 * purpose		: sends the test cases report to the given mail Id's.
	 * parameters 	: fromMailId, Password, ToMailId, Subject, Body
	 * Example		: 
	 */
	private static void sendPDFReportByGMail(String from, String pass, String to, String subject, String body) {

		Properties props = System.getProperties();

		String host = "smtp.gmail.com";

		props.put("mail.smtp.starttls.enable", "true");

		props.put("mail.smtp.host", host);

		props.put("mail.smtp.user", from);

		props.put("mail.smtp.password", pass);

		props.put("mail.smtp.port", "587");

		props.put("mail.smtp.auth", "true");

		Session session = Session.getDefaultInstance(props);

		MimeMessage message = new MimeMessage(session);

		try {

		    //Set from address

		message.setFrom(new InternetAddress(from));

		message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

		//Set subject

		message.setSubject(subject);

		message.setText(body);

		BodyPart objMessageBodyPart = new MimeBodyPart();

		objMessageBodyPart.setText("Please Find The Attached Report File!");

		Multipart multipart = new MimeMultipart();

		multipart.addBodyPart(objMessageBodyPart);

		objMessageBodyPart = new MimeBodyPart();

		//Set path to the pdf report file

//		String filename = "C:\\Users\\vgardula\\workspace3\\WSOTAC\\Reports\\MasterReport.html";
		String filename = "C:/Users/vgardula/Desktop/Test HTML file/writer2.html";
		//C:\\Users\\vgardula\\Desktop\\Test HTML file\\writer2.html

		//Create data source to attach the file in mail

		DataSource source = new FileDataSource(filename);

		objMessageBodyPart.setDataHandler(new DataHandler(source));

		objMessageBodyPart.setFileName(filename);

		multipart.addBodyPart(objMessageBodyPart);

		message.setContent(multipart);

		Transport transport = session.getTransport("smtp");

		transport.connect(host, from, pass);

		transport.sendMessage(message, message.getAllRecipients());

		transport.close();

		}

		catch (AddressException ae) {

		ae.printStackTrace();

		}

		catch (MessagingException me) {

		me.printStackTrace();

		}
		System.out.println("Done");

		}
	
public static void main(String[] args) throws Throwable {
		
		int resultsDetaisl[]={300,130,40,60,70};
		int testCaseDeatisl[]={200,30,40,60,70};
		emailSummaryReport("C:\\Users\\USER\\Documents\\NewGitUpdatedCode\\Agile367\\testReports\\2020_11_17\\MailsummaryReport.html", "23", resultsDetaisl, testCaseDeatisl);
	}

	/**
	 * Method Name	: emailSummaryReport
	 * purpose		: Reads an Html file and generate report of version, totalFiles, totalExecutedcount, totalPasscount, totalFailcount, totalSkipCount, totaltimeElapsed.
	 * parameters 	: excelpath 
	 * Example		: <>, <>
	 */
	public static void emailSummaryReport(String reportFile2,String elapcedTime,int resultsDetaisl[],int testCaseDeatisl[]) throws IOException{
		System.out.println("Html file reading from :"+reportFile2);
		 Properties props = new Properties();    
       props.put("mail.smtp.host", "smtp.gmail.com");    
       props.put("mail.smtp.socketFactory.port", "465");    
       props.put("mail.smtp.socketFactory.class",    
                 "javax.net.ssl.SSLSocketFactory");    
       props.put("mail.smtp.auth", "true");    
       props.put("mail.smtp.port", "465");
       props.put("mail.smtp.starttls.enable", "true");
       props.put("mail.smtp.auth", "true");

		props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
       Xls_Reader emailDetails=new Xls_Reader(System.getProperty("user.dir")+"/ConfigProperties/ConfigurationDetails.xlsx");
       final String userName=emailDetails.getCellData("Config", "Mail ID",2);
       final String password=emailDetails.getCellData("Config", "Password", 2);
       String recipients=emailDetails.getCellData("Config", "Recipients", 2);
       
       String SNO=emailDetails.getCellData("Config", "SNO", 2);
       
       //get Session   
//       Session session = Session.getDefaultInstance(props,    
       Session session =Session.getInstance(props, 
        new javax.mail.Authenticator() {    
        protected PasswordAuthentication getPasswordAuthentication() {    
        return new PasswordAuthentication(userName,password);  
        }    
       });    
       //compose message    
       try {   
      	 FileReader reportF = new FileReader(reportFile2);
      	 BufferedReader br = new BufferedReader(reportF);
        MimeMessage message = new MimeMessage(session);    
        message.setFrom(new InternetAddress(userName,"LVT Automation"));
       //message.addRecipient(Message.RecipientType.TO,new InternetAddress("imgqahyd@opentext.com")); 
       //message.addRecipient(Message.RecipientType.TO,new InternetAddress("vkakunur@opentext.com"));
//        message.addRecipients(Message.RecipientType.TO,InternetAddress.parse("kalyan.babugv@gmail.com"));
        message.addRecipients(Message.RecipientType.TO,InternetAddress.parse(recipients));
        
      //  message.addRecipient(Message.RecipientType.TO,new InternetAddress("vpasupul@opentext.com"));
        message.setSubject("LVT Automation Report");
//        		+ "_"+"Keywordtest.SuitetestType" + "-" + "Keywordtest.testingOnThisBrowser"); 
         
        
       /* String totalCasesAndSteps=testCaseDeatisl[0]+" & "+resultsDetaisl[1];
		String toatlPass=testCaseDeatisl[1]+" & "+resultsDetaisl[2];
		String totalFail=testCaseDeatisl[2]+" & "+resultsDetaisl[3];
		String totalSkips=testCaseDeatisl[3]+" & "+resultsDetaisl[4];*/
        
        String totalCasesAndSteps=testCaseDeatisl[0]+"";
		String toatlPass=testCaseDeatisl[1]+"";
		String totalFail=testCaseDeatisl[2]+"";
		String totalSkips=testCaseDeatisl[3]+"";
		
        String content = br.readLine();
        content = content.replace("version", "GenericKeywords.AppVersion");
        content = content.replace("totalfiles", Integer.toString(resultsDetaisl[0]));
        content = content.replace("totalexecutedcount", totalCasesAndSteps);
        content = content.replace("totalpasscount", toatlPass);
        content = content.replace("totalfailedcount", totalFail);
        content = content.replace("totalskippedcount", totalSkips);
        content = content.replace("totalelapced", elapcedTime);
        
       
        message.setContent(content,"text/html");
        Transport.send(message);  
        
        System.out.println("message sent successfully");    
       } catch (MessagingException e) {throw new RuntimeException(e);}    
          
  
	}
	 	
}

package com.craftsvilla.framework;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.craftsvilla.dataobjects.TestCaseResult;

public class MailSending {
	static PropertyReader configReader = new PropertyReader();
	static String emailTo = configReader.getPropertyValue("emailIDForMail");
	static String emailfrom = "QA.Automation@craftsvilla.com";
	static String host = "localhost";
	static StringBuffer htmlbody = new StringBuffer(
			"<h3>This is automation testcases result for</h3>");
	static int  critical,high,medium,low;
	static TestCaseResult caseResult;
	static List<TestCaseResult> passedTestCases = new ArrayList<>();
	static List<TestCaseResult> failedTestCases = new ArrayList<>();

	public static void mailTestcasesResult(
			ArrayList<TestCaseResult> testcasesResult, int passcount,
			int failCount) {

		htmlbody.append(
				"<h4>" + configReader.getPropertyValue("url") + "</h4>");

	
				//);

		Properties properties = System.getProperties();
		properties.setProperty("mail.smtp.host", host);
		Session session = Session.getDefaultInstance(properties);
		MimeMessage message = new MimeMessage(session);
		passedTestCases.addAll(getStatusWiseList(testcasesResult, "Passed"));
		failedTestCases.addAll(getStatusWiseList(testcasesResult, "Failed"));
		htmlbody.append("<h3>Total Passed testcases = "+passcount);
		htmlbody.append("<br>");
		htmlbody.append("Total Failed testcases = "+failCount+"</h3>");
		if (failedTestCases.size() > 0) {
			
			htmlbody.append("<table width='100%' cellpadding='0'  style='border:1px solid #000000;' >");
			htmlbody.append("<thead style=' padding:10px 0;font-weight:bold; font-size:16px; background-color:#B5B0AF; color:#000000;'>");
			htmlbody.append("<th style='width:60%; padding:5px 0;'>TestCase Failed = " + failCount  +"</th>");
			htmlbody.append("<th style='width:20%; padding:5px 0;'>Status</th> ");
			htmlbody.append("<th style='width:20%;padding:5px 0;'>Severity</th> ");
			htmlbody.append("</thead>");
			for (int i = 0; i < failedTestCases.size(); i++) {
				caseResult = new TestCaseResult(
						failedTestCases.get(i).getTestCaseName(),
						failedTestCases.get(i).getStatus(),
						failedTestCases.get(i).getSeverity());
				htmlbody.append(
						"<tr style='background-color:#C91909; padding:10px 0;font-size:16px; color:#000000;'>");
				htmlbody.append("<td style='padding:5px;'>" + caseResult.getTestCaseName()
						+ "</td>");
				htmlbody.append("<td style='padding:5px;'>Failed</td> ");
				htmlbody.append(
						"<td style='padding:5px'>" + caseResult.getSeverity() + "</td> ");
				htmlbody.append("</tr>");
			}
			htmlbody.append("</table>");
			htmlbody.append("\n");
		}

		if (passedTestCases.size() > 0) {
			htmlbody.append("\n");
			htmlbody.append("<br>");
			htmlbody.append("<table width='100%' cellpadding='0'  style='border:1px solid #000000;' >");
			htmlbody.append("<thead style=' padding:10px 0;font-weight:bold; font-size:16px; background-color:#B5B0AF; color:#000000;'>");
			htmlbody.append("<th style='width:60%; padding:5px 0;'>TestCase  Passed = " + passcount  +"</th>");
			htmlbody.append("<th style='width:20%; padding:5px 0;'>Status</th> ");
			htmlbody.append("<th style='width:20%;padding:5px 0;'>Severity</th> ");
			htmlbody.append("</thead>");
			for (int i = 0; i < passedTestCases.size(); i++) {
				caseResult = new TestCaseResult(
						passedTestCases.get(i).getTestCaseName(),
						passedTestCases.get(i).getStatus(),
						passedTestCases.get(i).getSeverity());

				htmlbody.append(
						"<tr style='background-color:#599953; padding:10px 0;font-size:16px; color:#000000;'>");
				htmlbody.append("<td style='padding:5px;'>" + caseResult.getTestCaseName()
						+ "</td>");
				htmlbody.append("<td style='padding:5px;'>Passed</td> ");
				htmlbody.append(
						"<td style='padding:5px'>" + caseResult.getSeverity() + "</td> ");
				htmlbody.append("</tr>");

			}
			htmlbody.append("</table>");
		}
	try

	{
	message.setFrom(new InternetAddress(emailfrom));
	message.addRecipients(Message.RecipientType.TO,InternetAddress.parse(emailTo));
	if(failCount==0){message.setSubject("All testcases are passed");

	}else{message.setSubject(severityWiseCount(failedTestCases));

	}

	BodyPart messageTextBodyPart = new MimeBodyPart();
	Multipart multipart = new MimeMultipart();messageTextBodyPart.setContent(htmlbody.toString(),"text/html");multipart.addBodyPart(messageTextBodyPart);

	// attaching screenshot
	File screenshotfile = new File("test-output");
	File[] listfile = screenshotfile.listFiles();for(
	int i = 0;i<listfile.length;i++)

	{
		String str = listfile[i].getName();
		if (str.endsWith(".jpg")
				|| str.equalsIgnoreCase("FailedTestcasesUrl.txt")) {
			MimeBodyPart attachmentmessageBodyPart = new MimeBodyPart();
			System.out.println(listfile[i].getName());
			DataSource source = new FileDataSource(
					new File("test-output/" + listfile[i].getName()));
			attachmentmessageBodyPart.setDataHandler(new DataHandler(source));
			attachmentmessageBodyPart.setFileName(listfile[i].getName());
			multipart.addBodyPart(attachmentmessageBodyPart);
		}
		File performancereport = new File("src/main/resources/Input/PerformanceReport.csv");
		MimeBodyPart attachmentmessageBodyPart = new MimeBodyPart();
		System.out.println(performancereport.getName());
		DataSource source = new FileDataSource(
				new File(performancereport.getName()));
		attachmentmessageBodyPart.setDataHandler(new DataHandler(source));
		attachmentmessageBodyPart.setFileName(performancereport.getName());
		multipart.addBodyPart(attachmentmessageBodyPart);

		message.setContent(multipart);Transport.send(message);System.out.println("message sent successfully....");

	}
	
	}catch(

	AddressException e)

	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch(

	MessagingException e)

	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	}

	public static ArrayList<TestCaseResult> getStatusWiseList(ArrayList<TestCaseResult> result, String status) {
		ArrayList<TestCaseResult> testcaseResult = new ArrayList<>();
		for (int j = 0; j < result.size(); j++) {

			if (result.get(j).getStatus().equalsIgnoreCase(status)) {
				TestCaseResult caseResult = new TestCaseResult(result.get(j).getTestCaseName(),
						result.get(j).getStatus(), result.get(j).getSeverity());
				testcaseResult.add(caseResult);
			}
		}
		return testcaseResult;
	}

	public static String severityWiseCount(List<TestCaseResult> failedTestCaseslist) {
		String result;
		for (int i = 0; i < failedTestCaseslist.size(); i++) {
			System.out.println("INSIDE COUNT----------------");
			System.out.println(failedTestCaseslist.get(i).getSeverity()+failedTestCaseslist.get(i).getTestCaseName());
			if ((failedTestCaseslist.get(i).getSeverity()).equalsIgnoreCase("Medium")) {
				medium++;
			}
			if ((failedTestCaseslist.get(i).getSeverity()).equalsIgnoreCase("Critical")) {
				critical++;
			}
			if ((failedTestCaseslist.get(i).getSeverity()).equalsIgnoreCase("high")) {
				high++;
			}
			if ((failedTestCaseslist.get(i).getSeverity()).equalsIgnoreCase("low")) {
				low++;
			}
		}
		if (critical != 0) {
			result = critical + " Critical testcases are failing";
			return result;
		} else {
			if (high > 0) {
				result = high + " Major testcases are failing";
				return result;
			} else {
				if(medium>0)
				{
				result = medium + "  Medium testcases are failing";
				return result;
				}
				else
				{
				result= low + "  Minor testcases are failing";
				return result;
				}
			}
			
	}

	}
}
package com.craftsvilla.framework;

import java.io.File;
import java.util.ArrayList;
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
	static String emailfrom = "shukranibille@craftsvilla.com";
	static String host = "localhost";
	static StringBuffer htmlbody = new StringBuffer("<h3>This is automation testcases result for</h3>");

	public static void mailTestcasesResult(ArrayList<TestCaseResult> testcasesResult, int passcount, int failCount) {
		System.out.println("Inside Mailing");
		htmlbody.append("<h4>" + configReader.getPropertyValue("url") + "</h4>");
		htmlbody.append("<table style='width:100%' border='1' >");
		htmlbody.append("<tr style='font-weight:bold'>");
		htmlbody.append("<th><h2>TestCase</h2></th>");
		htmlbody.append("<th><h2>Status</h2></th> ");
		htmlbody.append("</tr>");
		TestCaseResult caseResult;
		Properties properties = System.getProperties();
		properties.setProperty("mail.smtp.host", host);
		Session session = Session.getDefaultInstance(properties);
		MimeMessage message = new MimeMessage(session);

		for (int i = 0; i < testcasesResult.size(); i++) {
			caseResult = new TestCaseResult(testcasesResult.get(i).getTestCaseName(),
					testcasesResult.get(i).getStatus());
			if (caseResult.getStatus().equalsIgnoreCase("Passed")) {
				htmlbody.append("<tr bgcolor='green' style='font-weight:bold'>");
				htmlbody.append("<td><h4>" + caseResult.getTestCaseName() + "</h4></td>");
				htmlbody.append("<td><h4>Passed</h4></td> ");
				htmlbody.append("</tr>");
			}
			if (caseResult.getStatus().equalsIgnoreCase("Failed")) {
				htmlbody.append("<tr bgcolor='red' style='font-weight:bold'>");
				htmlbody.append("<td><h4>" + caseResult.getTestCaseName() + "</h4></td>");
				htmlbody.append(" <td><h4>Failed</h4></td> ");
				htmlbody.append(" </tr>");

			}

		}
		htmlbody.append("</table>");
		/*
		 * htmlbody.append("<tr bgcolor='green' style='font-weight:bold'>");
		 * htmlbody.append("<td><h4>" + testcasesResult.get(i) + "</h4></td>");
		 * htmlbody.append("<td><h4>Passed</h4></td> ");
		 * htmlbody.append("</tr>");
		 */
		try {
			message.setFrom(new InternetAddress(emailfrom));
			message.addRecipients(Message.RecipientType.TO, InternetAddress.parse(emailTo));
			if (failCount == 0) {
				message.setSubject("Automation testcases result. Passed= " + passcount);
			} else {
				message.setSubject("Automation testcases result. Passed= " + passcount + " " + " Failed=" + failCount);
			}
			// Setting Content
			// MimeBodyPart attachmentmessageBodyPart = new MimeBodyPart();
			BodyPart messageTextBodyPart = new MimeBodyPart();
			Multipart multipart = new MimeMultipart();
			messageTextBodyPart.setContent(htmlbody.toString(), "text/html");
			multipart.addBodyPart(messageTextBodyPart);

			// attaching screenshot
			File screenshotfile = new File("test-output");
			File[] listfile = screenshotfile.listFiles();
			for (int i = 0; i < listfile.length; i++) {
				String str = listfile[i].getName();
				if (str.endsWith(".jpg") || str.equalsIgnoreCase("FailedTestcasesUrl.txt")) {
					MimeBodyPart attachmentmessageBodyPart = new MimeBodyPart();
					System.out.println(listfile[i].getName());
					DataSource source = new FileDataSource(new File("test-output/" + listfile[i].getName()));
					attachmentmessageBodyPart.setDataHandler(new DataHandler(source));
					attachmentmessageBodyPart.setFileName(listfile[i].getName());
					multipart.addBodyPart(attachmentmessageBodyPart);
				}

			}

			message.setContent(multipart);
			Transport.send(message);
			System.out.println("message sent successfully....");

		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
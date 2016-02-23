package com.craftsvilla.framework;

import java.io.File;
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

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomReportGenerator implements ITestListener {
	PropertyReader configReader = new PropertyReader();
	static int failCount = 0;
	static int passcount = 0;
	String emailTo = configReader.getPropertyValue("emailIDForMail");
	String emailfrom = "shukranibille@craftsvilla.com";
	String host = "localhost";

	static public StringBuffer htmlbody = new StringBuffer("<h3>This is automation testcases result for</h3>");

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Excuting  " + result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub

		passcount = passcount + 1;
		System.out.println("Passed");
		htmlbody.append("<tr bgcolor='green' style='font-weight:bold'>");
		htmlbody.append("<td><h4>" + result.getName() + "</h4></td>");
		htmlbody.append("<td><h4>Passed</h4></td> ");
		htmlbody.append("</tr>");

	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		// Screenshot.takeScreenshot(driver, result.getName());
		System.out.println("Failed");
		htmlbody.append("<tr bgcolor='red' style='font-weight:bold'>");
		htmlbody.append("<td><h4>" + result.getName() + "</h4></td>");
		htmlbody.append(" <td><h4>Failed</h4></td> ");
		htmlbody.append(" </tr>");

		failCount = failCount + 1;

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

		htmlbody.append("<h4>" + configReader.getPropertyValue("url") + "</h4>");
		htmlbody.append("<table style='width:100%' border='1' >");
		htmlbody.append("<tr style='font-weight:bold'>");
		htmlbody.append("<th><h2>TestCase</h2></th>");
		htmlbody.append("<th><h2>Status</h2></th> ");
		htmlbody.append("</tr>");

	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

		htmlbody.append("</table>");
		// Sending mail
		Properties properties = System.getProperties();
		properties.setProperty("mail.smtp.host", host);
		Session session = Session.getDefaultInstance(properties);
		MimeMessage message = new MimeMessage(session);
		// DataSource source;
		// Setting subject
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
				if (str.endsWith(".jpg")) {
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

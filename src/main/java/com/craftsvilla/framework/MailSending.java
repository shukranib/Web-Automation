package com.craftsvilla.framework;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.StringTokenizer;

import com.craftsvilla.dataobjects.BrowserResult;
import com.craftsvilla.dataobjects.EnvironmentBo;
import com.craftsvilla.dataobjects.TestCaseResult;

public class MailSending {
	static PropertyReader configReader = new PropertyReader();
	static String emailTo = configReader.getPropertyValue("emailIDForMail");
	static String emailfrom = "QA.Automation@craftsvilla.com";
	static String host = "localhost";
	static StringBuffer htmlbody = new StringBuffer("<h3>This is automation testcases result for</h3>");
	static int critical, high, medium, low, totalexcuted;
	static TestCaseResult caseResult;
	static BrowserResult result;
	static List<TestCaseResult> passedTestCases = new ArrayList<>();
	static List<TestCaseResult> failedTestCases = new ArrayList<>();
	static List<BrowserResult> browserlist = new ArrayList<>();
	static StringBuffer htmlbody_browserstack = new StringBuffer("<h3>This is automation testcases result for</h3>");

	public static void mailTestcasesResult(ArrayList<TestCaseResult> testcasesResult, int passcount, int failCount) {

		htmlbody.append("<h4>" + configReader.getPropertyValue("url") + "</h4>");

		//);

		Properties properties = System.getProperties();

		properties.setProperty("mail.smtp.host", host);

		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");

		com.craftsvilla.framework.Message emailMessagenew = new com.craftsvilla.framework.Message();
		//  Session session = Session.getDefaultInstance(properties, new SMTPAuthenticator());
		//Session session = Session.getDefaultInstance(properties);
		//MimeMessage message = new MimeMessage(session);
		passedTestCases.addAll(getStatusWiseList(testcasesResult, "Passed"));
		failedTestCases.addAll(getStatusWiseList(testcasesResult, "Failed"));
		htmlbody.append("<h3>Total Passed testcases = " + passcount);
		htmlbody.append("<br>");
		htmlbody.append("Total Failed testcases = " + failCount + "</h3>");
		String browserName = EnvironmentBo.getBrowsersName();
		String osName = EnvironmentBo.getOs();

		if (failedTestCases.size() > 0) {
			System.out.println("FAILED TESTCASES ARE");
			htmlbody.append("<table width='100%' cellpadding='0'  style='border:1px solid #000000;' >");
			htmlbody.append(
					"<thead style=' padding:10px 0;font-weight:bold; font-size:16px; background-color:#B5B0AF; color:#000000;'>");
			htmlbody.append("<th style='width:60%; padding:5px 0;'>TestCase Failed = " + failCount + "</th>");
			htmlbody.append("<th style='width:20%; padding:5px 0;'>Status</th> ");
			htmlbody.append("<th style='width:20%;padding:5px 0;'>Severity</th> ");
			htmlbody.append("</thead>");
			for (int i = 0; i < failedTestCases.size(); i++) {
				System.out.println(failedTestCases.get(i).toString());
				caseResult = new TestCaseResult(failedTestCases.get(i).getTestCaseName(),
						failedTestCases.get(i).getStatus(), failedTestCases.get(i).getSeverity());
				htmlbody.append("<tr style='background-color:#C91909; padding:10px 0;font-size:16px; color:#000000;'>");
				htmlbody.append("<td style='padding:5px;'>" + caseResult.getTestCaseName() + "</td>");
				htmlbody.append("<td style='padding:5px;'>Failed</td> ");
				htmlbody.append("<td style='padding:5px'>" + caseResult.getSeverity() + "</td> ");
				htmlbody.append("<td style='padding:5px;'>" + osName + "</td> ");
				htmlbody.append("<td style='padding:5px'>" + browserName + "</td> ");
				htmlbody.append("</tr>");
			}
			htmlbody.append("</table>");
			htmlbody.append("\n");
		}

		if (passedTestCases.size() > 0) {
			htmlbody.append("\n");
			htmlbody.append("<br>");
			htmlbody.append("<table width='100%' cellpadding='0'  style='border:1px solid #000000;' >");
			htmlbody.append(
					"<thead style=' padding:10px 0;font-weight:bold; font-size:16px; background-color:#B5B0AF; color:#000000;'>");
			htmlbody.append("<th style='width:60%; padding:5px 0;'>TestCase  Passed = " + passcount + "</th>");
			htmlbody.append("<th style='width:20%; padding:5px 0;'>Status</th> ");
			htmlbody.append("<th style='width:20%;padding:5px 0;'>Severity</th> ");
			htmlbody.append("<th style='width:20%; padding:5px 0;'>OS Name</th> ");
			htmlbody.append("<th style='width:20%;padding:5px 0;'>Browser</th> ");
			htmlbody.append("</thead>");
			for (int i = 0; i < passedTestCases.size(); i++) {
				caseResult = new TestCaseResult(passedTestCases.get(i).getTestCaseName(),
						passedTestCases.get(i).getStatus(), passedTestCases.get(i).getSeverity());

				htmlbody.append("<tr style='background-color:#599953; padding:10px 0;font-size:16px; color:#000000;'>");
				htmlbody.append("<td style='padding:5px;'>" + caseResult.getTestCaseName() + "</td>");
				htmlbody.append("<td style='padding:5px;'>Passed</td> ");
				htmlbody.append("<td style='padding:5px'>" + caseResult.getSeverity() + "</td> ");
				htmlbody.append("<td style='padding:5px'>" + osName + "</td> ");
				htmlbody.append("<td style='padding:5px'>" + browserName + "</td> ");
				htmlbody.append("</tr>");

			}
			htmlbody.append("</table>");
		}
		emailMessagenew.setSender("shukrani.bille@craftsvilla.com");
		//message.setFrom(new InternetAddress(emailfrom));
		//message.addRecipients(Message.RecipientType.TO,InternetAddress.parse(emailTo));
		StringTokenizer st = new StringTokenizer(emailTo, ",");
		if (st.countTokens() > 0) {
			while (st.hasMoreElements()) {
				String receiver = (String) st.nextElement();

				if (receiver != null && !receiver.isEmpty())
					emailMessagenew.addReceiver(receiver.trim());
			}
		}
		//emailMessagenew.addReceiver("shukrani.bill@craftsvilla.com");

		if (failCount == 0) {
			//message.setSubject("All testcases are passed");
			emailMessagenew.setSubject("All testcases are passed passed");
		} else {
			emailMessagenew.setSubject(severityWiseCount(failedTestCases));
			//message.setSubject(severityWiseCount(failedTestCases));
		}

		//BodyPart messageTextBodyPart = new MimeBodyPart();
		//Multipart multipart = new MimeMultipart();messageTextBodyPart.setContent(htmlbody.toString(),"text/html");multipart.addBodyPart(messageTextBodyPart);
		emailMessagenew.setBody(htmlbody.toString());

		// attaching screenshot
		File screenshotfile = new File("test-output");
		File[] listfile = screenshotfile.listFiles();
		for (int i = 0; i < listfile.length; i++)

		{
			String str = listfile[i].getName();
			if (str.endsWith(".jpg") || str.equalsIgnoreCase("FailedTestcasesUrl.txt")) {
				//MimeBodyPart attachmentmessageBodyPart = new MimeBodyPart();
				System.out.println(listfile[i].getName());
				//DataSource source = new FileDataSource(
				//        new File("test-output/" + listfile[i].getName()));
				//attachmentmessageBodyPart.setDataHandler(new DataHandler(source));
				//attachmentmessageBodyPart.setFileName(listfile[i].getName());
				//multipart.addBodyPart(attachmentmessageBodyPart);
				emailMessagenew.addAttachment(listfile[i]);
			}

		}

		//message.setContent(multipart);Transport.send(message);System.out.println("message sent successfully....");
		Mailer mailer = new Mailer(properties, "shukrani.bille@craftsvilla.com", "Raani@2400245");

		try {
			mailer.sendMessage(emailMessagenew);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			totalexcuted = passcount + failCount;
			result = new BrowserResult(EnvironmentBo.getOs(), EnvironmentBo.getBrowsersName(),
					EnvironmentBo.getBrowserversion(), passcount, failCount, totalexcuted);
			browserlist.add(result);
			passedTestCases.clear();
			passcount = 0;
			failCount = 0;
			totalexcuted = 0;
			failedTestCases.clear();
			htmlbody.setLength(0);
			critical = 0;
			medium = 0;
			low = 0;
			high = 0;

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
			System.out.println(failedTestCaseslist.get(i).getSeverity() + failedTestCaseslist.get(i).getTestCaseName());
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
			result = critical + "Critical testcases are failing";
			return result;
		} else {
			if (high > 0) {
				result = high + " Major testcases are failing";
				return result;
			} else {
				if (medium > 0) {
					result = medium + "  Medium testcases are failing";
					return result;
				} else {
					result = low + "  Minor testcases are failing";
					return result;
				}
			}

		}

	}

}
/*public static void mailingBrowserStackResult() {

	htmlbody_browserstack.append("<h4>" + configReader.getPropertyValue("url") + "</h4>");

	//);

	Properties properties = System.getProperties();

	properties.setProperty("mail.smtp.host", host);

	properties.put("mail.smtp.auth", "true");
	properties.put("mail.smtp.starttls.enable", "true");
	properties.put("mail.smtp.host", "smtp.gmail.com");
	properties.put("mail.smtp.port", "587");

	com.craftsvilla.framework.Message emailMessage = new com.craftsvilla.framework.Message();
	//com.craftsvilla.framework.Message emailMessageforfailed = new com.craftsvilla.framework.Message();

	if (browserlist.size() > 0) {

		htmlbody_browserstack.append("\n");
		htmlbody_browserstack.append("<br>");
		htmlbody_browserstack.append("<table width='100%' cellpadding='0' style='border-color:#000000;border:1' >");
		htmlbody_browserstack.append(
				"<thead style='padding:10px 0;font-weight:bold;font-size:16px;background-color: rgba(56, 35, 31, 0.04);color:#000000;'>");
		htmlbody_browserstack.append("<th style='width:20%; padding:5px 0;'> OS Name </th> ");
		htmlbody_browserstack.append("<th style='width:20%;padding:5px 0;'> Browser </th> ");
		htmlbody_browserstack.append("<th style='width:20%; padding:5px 0;'> Version </th> ");
		htmlbody_browserstack.append("<th style='width:20%;padding:5px 0;'> Total </th> ");
		htmlbody_browserstack.append("<th style='width:60%; padding:5px 0;'> Passed </th>");
		htmlbody_browserstack.append("<th style='width:60%; padding:5px 0'> Failed </th>");

		htmlbody_browserstack.append("</thead>");
		for (int i = 1; i < browserlist.size(); i++) {

			htmlbody_browserstack.append(
					"<tr style='background-color: rgba(153, 83, 83, 0.04);padding:10px 0;font-size: 14px;color:#000000;font-weight: bold;'>");
			htmlbody_browserstack.append("<td style='padding:5px;'>" + browserlist.get(i).getOSVersion() + "</td>");
			htmlbody_browserstack
					.append("<td style='padding:5px;'>" + browserlist.get(i).getBrowserName() + "</td> ");
			htmlbody_browserstack
					.append("<td style='padding:5px'>" + browserlist.get(i).getBrowserVersion() + "</td> ");
			htmlbody_browserstack
					.append("<td style='padding:5px'>" + browserlist.get(i).getTotalexcuted() + "</td> ");
			htmlbody_browserstack
					.append("<td style='padding:5px;color: #fff;font-weight: bold;font-size: 14px;background-color: rgba(89, 153, 83, 0.62);'> "
							+ browserlist.get(i).getTotalpass() + "</td> ");

			htmlbody_browserstack
					.append("<td style='padding:5px;background-color: rgba(255, 0, 0, 0.78);font-size: 14px;font-weight: bold;'>"
							+ browserlist.get(i).getTotalfailed() + "</td> ");
			htmlbody_browserstack.append("</tr>");

		}
		htmlbody_browserstack.append("</table>");
	}
	emailMessage.setSender("shukrani.bille@craftsvilla.com");
	//message.setFrom(new InternetAddress(emailfrom));
	//message.addRecipients(Message.RecipientType.TO,InternetAddress.parse(emailTo));
	StringTokenizer st = new StringTokenizer(emailTo, ",");
	if (st.countTokens() > 0) {
		while (st.hasMoreElements()) {
			String receiver = (String) st.nextElement();

			if (receiver != null && !receiver.isEmpty())
				emailMessage.addReceiver(receiver.trim());
		}
	}
	System.out.println("EMAIL BODY IS " + htmlbody_browserstack);
	//message.setSubject("All testcases are passed");
	emailMessage.setSubject("Results for Browserstack Suits");

	//BodyPart messageTextBodyPart = new MimeBodyPart();
	//Multipart multipart = new MimeMultipart();messageTextBodyPart.setContent(htmlbody.toString(),"text/html");multipart.addBodyPart(messageTextBodyPart);
	emailMessage.setBody(htmlbody_browserstack.toString());

	//message.setContent(multipart);Transport.send(message);System.out.println("message sent successfully....");
	Mailer mailer = new Mailer(properties, "shukrani.bille@craftsvilla.com", "Raani@2400245");

	try {
		mailer.sendMessage(emailMessagenew);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}*/
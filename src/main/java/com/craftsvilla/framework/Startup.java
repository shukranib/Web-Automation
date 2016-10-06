package com.craftsvilla.framework;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.reflections.Reflections;
import org.reflections.scanners.ResourcesScanner;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.reflections.util.FilterBuilder;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlInclude;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import com.craftsvilla.dataobjects.Environment;
import com.craftsvilla.dataobjects.EnvironmentBo;

public class Startup {
	public static void main(String[] args) {
		PropertyReader read = new PropertyReader();
		System.out.println("this is new testsuits");
		String DEFAULT_URL = System.getenv("URL");
		System.out.println("RUN time PArameter" + DEFAULT_URL);
		FileOutputStream out = null;
		try {
			String URL = read.getPropertyValue("url");
			System.out.println("URL IS +++++++++++" + URL);

			FileInputStream in = new FileInputStream("src/main/resources/Input/Config.properties");
			Properties props = new Properties();
			props.load(in);
			in.close();

			out = new FileOutputStream("src/main/resources/Input/Config.properties");
			props.setProperty("url", DEFAULT_URL);
			props.store(out, null);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		PropertyReader read1 = new PropertyReader();
		String URL = read1.getPropertyValue("url");
		System.out.println("UPDATEDURL IS +++++++++++" + URL);
		//System.out.println("URL IS+" + DEFAULT_FILTER);
		List<String> includetestcaseNames = TestCase.getTestCasesNames("Y");
		List<String> excludetestcaseName = TestCase.getTestCasesNames("N");
		List<Environment> environmentlist = ExclFileRead.readElx_envirnment();
		TestsuitEnvironment.setenvirnment();
		for (int i = 1; i < environmentlist.size(); i++) {
			System.out.println("os is++++++++" + environmentlist.get(i).getOsName());
			EnvironmentBo.setOs(environmentlist.get(i).getOsName());
			EnvironmentBo.setBrowsersName(environmentlist.get(i).getBrowsername());
			EnvironmentBo.setBrowserversion(environmentlist.get(i).getVersion());

			List<XmlSuite> listXmlSuit = new ArrayList<>();
			List<XmlClass> listxmlclasses = new ArrayList<>();

			XmlSuite xmlSuite = new XmlSuite();
			XmlClass xmlclass;
			XmlTest test = new XmlTest(xmlSuite);
			List<Class> listnerclass = new ArrayList<>();
			List<ClassLoader> classLoadersList = new LinkedList<ClassLoader>();
			classLoadersList.add(ClasspathHelper.contextClassLoader());
			classLoadersList.add(ClasspathHelper.staticClassLoader());

			Reflections reflections = new Reflections(new ConfigurationBuilder()
					.setScanners(new SubTypesScanner(false), new ResourcesScanner())
					.setUrls(ClasspathHelper.forClassLoader(classLoadersList.toArray(new ClassLoader[0])))
					.filterInputsBy(new FilterBuilder().include(FilterBuilder.prefix("com.craftsvilla.testcase"))));
			Set<Class<?>> classesset = reflections.getSubTypesOf(Object.class);
			List<XmlInclude> includel = new ArrayList<>();
			for (String names : includetestcaseNames) {
				Log4jLogger.writeErrorLog("Executing testcase" + names.toString());

				includel.add(new XmlInclude(names.toString()));
				//System.out.println("include"+includel);

			}

			for (Class classlist : classesset) {

				xmlclass = new XmlClass(classlist.getName());
				xmlclass.setIncludedMethods(includel);

				xmlclass.setExcludedMethods(excludetestcaseName);
				listxmlclasses.add(xmlclass);

			}

			test.setXmlClasses(listxmlclasses);

			listXmlSuit.add(xmlSuite);

			test.setXmlClasses(listxmlclasses);
			TestNG testNG;
			testNG = new TestNG();

			testNG.setXmlSuites(listXmlSuit);
			testNG.addListener(new CustomReportGenerator());
			testNG.run();

		}
		//MailSending.mailingBrowserStackResult();
	}
}

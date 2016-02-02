package com.craftsvilla.framework;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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

public class Startup {
	public static void main(String[] args) {
	
		List<XmlSuite> listXmlSuit = new ArrayList<>();
		List<XmlClass> listxmlclasses = new ArrayList<>();
		List<XmlInclude> includelist = new ArrayList<>();

		List<String> includetestcaseNames = TestCase.getTestCasesNames("Y");
		List<String> excludetestcaseName = TestCase.getTestCasesNames("N");
		XmlInclude include;

		XmlSuite xmlSuite = new XmlSuite();
		XmlClass xmlclass;
		XmlTest test = new XmlTest(xmlSuite);
		List<ClassLoader> classLoadersList = new LinkedList<ClassLoader>();
		classLoadersList.add(ClasspathHelper.contextClassLoader());
		classLoadersList.add(ClasspathHelper.staticClassLoader());

		Reflections reflections = new Reflections(
				new ConfigurationBuilder().setScanners(new SubTypesScanner(false), new ResourcesScanner())
						.setUrls(ClasspathHelper.forClassLoader(classLoadersList.toArray(new ClassLoader[0])))
						.filterInputsBy(new FilterBuilder().include(FilterBuilder.prefix("testcase"))));
		Set<Class<?>> classesset = reflections.getSubTypesOf(Object.class);
		List<XmlInclude> includel = new ArrayList<>();
		for (String names : includetestcaseNames) {
			Log4jLogger.writeErrorLog("Executing testcase" + names.toString());

			includel.add(new XmlInclude(names.toString()));

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
		TestNG testNG = new TestNG();
		testNG.setXmlSuites(listXmlSuit);
		testNG.run();

	}

}

package com.craftsvilla.framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import com.craftsvilla.dataobjects.MultitabBo;
import com.craftsvilla.dataobjects.TestCaseBo;
import com.craftsvilla.dataobjects.TestDataBO;
import com.craftsvilla.dataobjects.UIElementsBo;


public class ExclFileRead {
	public String filelocation;
	public static FileInputStream ipstr = null;
	public FileOutputStream opstr = null;
	private static HSSFWorkbook wb = null;
	private static HSSFSheet ws = null;
	public static List<UIElementsBo> list = new ArrayList<>();
	public static UIElementsBo elementsBo;
	public static TestDataBO testDataBO;
	public static List<TestDataBO> listTestData = new ArrayList<>();
	public static List<MultitabBo> listmultilab=new  ArrayList<>();
	public static List<TestCaseBo> testCasesList = new ArrayList<>();
	public static MultitabBo multitabobj;
	
	public static List<MultitabBo> readMultiTabXls()
	{
		try {
			ipstr = new FileInputStream(new File("src/main/resources/Multitab.xls"));
		
			wb = new HSSFWorkbook(ipstr);
			ws = wb.getSheetAt(0);

			Iterator<Row> rowiterator = ws.iterator();
			while (rowiterator.hasNext()) {
				Row row = rowiterator.next();

				Cell mainCategory = row.getCell(0);

				Cell subCategory = row.getCell(1);
				Cell link = row.getCell(2);
				multitabobj=new MultitabBo(mainCategory.getStringCellValue(),subCategory.getStringCellValue(),link.getStringCellValue());
				listmultilab.add(multitabobj);
				//return listmultilab;
				
			}
		} catch (FileNotFoundException e)
		{


		} catch (IOException e) {
			
		} finally {
			try {
				ipstr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		
		return listmultilab;
	}


	public static List<UIElementsBo> exclFileRead() {

		try {
			ipstr = new FileInputStream(new File("src/main/resources/Input/UiElement.xls"));

			wb = new HSSFWorkbook(ipstr);
			ws = wb.getSheetAt(0);

			Iterator<Row> rowiterator = ws.iterator();
			while (rowiterator.hasNext()) {
				Row row = rowiterator.next();

				Cell elementName = row.getCell(0);

				Cell by = row.getCell(1);
				Cell locator = row.getCell(2);

				elementsBo = new UIElementsBo(elementName.getStringCellValue(), by.getStringCellValue(),
						locator.getStringCellValue());
				list.add(elementsBo);
			}
		} catch (FileNotFoundException e)

		{
			Log4jLogger.writeErrorLog(e.getMessage());

		} catch (IOException e) {
			Log4jLogger.writeErrorLog(e.getMessage());
		} finally {
			try {
				ipstr.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;

	}

	public static List<TestDataBO> readTestDataxls() {
		try {
			ipstr = new FileInputStream(new File("src/main/resources/Input/TestData.xls"));

			wb = new HSSFWorkbook(ipstr);
			ws = wb.getSheetAt(0);

			Iterator<Row> rowiterator = ws.iterator();
			while (rowiterator.hasNext()) {
				Row row = rowiterator.next();
				Cell elementName = row.getCell(0);

				Cell testData = row.getCell(1);
				testDataBO = new TestDataBO(elementName.getStringCellValue(), testData.getStringCellValue());
				listTestData.add(testDataBO);
			}
		} catch (FileNotFoundException e)

		{
			Log4jLogger.writeErrorLog(e.getMessage());

		} catch (IOException e) {
			Log4jLogger.writeErrorLog(e.getMessage());
		} finally {
			try {
				ipstr.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return listTestData;
	}

	public static List<TestCaseBo> readTestCasexls() {
		try {

			ipstr = new FileInputStream(new File("src/main/resources/Input/TestCase.xls"));

			wb = new HSSFWorkbook(ipstr);
			ws = wb.getSheetAt(0);

			Iterator<Row> rowiterator = ws.iterator();
			while (rowiterator.hasNext()) {
				Row row = rowiterator.next();
				Cell testCase = row.getCell(0);
				Cell status = row.getCell(1);
				Cell module = row.getCell(2);
				Cell severity = row.getCell(3);

				TestCaseBo testCaseBo = new TestCaseBo(testCase.getStringCellValue(), status.getStringCellValue(),
						module.getStringCellValue(), severity.getStringCellValue());
				testCasesList.add(testCaseBo);
			}
		} catch (FileNotFoundException e)

		{
			Log4jLogger.writeErrorLog(e.getMessage());

		} catch (IOException e) {
			Log4jLogger.writeErrorLog(e.getMessage());
		} finally {
			try {
				ipstr.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return testCasesList;
	}

	// Testing purpose for data

	 public static void main(String[] args) {
	List<UIElementsBo> elements = ExclFileRead.exclFileRead();
	 for (int i = 0; i < elements.size(); i++) {
		 if(elements.get(i).getElemetName().equals("textBox_MobileNo"))
		 {
	 System.out.println(elements.get(i));
	 
	 //System.out.println(elements);
	 }
	 }
	 }
}

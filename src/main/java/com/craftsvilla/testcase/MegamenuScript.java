package com.craftsvilla.testcase;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import com.craftsvilla.framework.ExclFileRead;
import com.craftsvilla.dataobjects.MultitabBo;

public class MegamenuScript {
	
	static File urlForFailedCategory = new File("FailedTestcasesUrl1.txt");
	static FileOutputStream output;
	static BufferedWriter bufferedWriter;
	static FileWriter fileWriter;
	private void sendMail() {
		// TODO Auto-generated method stub
		
	}
public void writeDataToTextFile(String categoryName, String categoryUrl)
{
	if (!urlForFailedCategory.exists()) {
		try {
			urlForFailedCategory.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	try {
		fileWriter = new FileWriter(urlForFailedCategory, true);
		bufferedWriter = new BufferedWriter(fileWriter);
		bufferedWriter.write("URL for failed category  " + categoryName  + "\tis\t" + categoryUrl+ "\n");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
		try {
			// fileWriter.close();
			bufferedWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}	

	@Test
	public static void megamenuScript()
	{
		 boolean  mailsend=false;
		MegamenuScript requestSender=new MegamenuScript();
		ExclFileRead read=new ExclFileRead();
		List<MultitabBo> listmultilab=ExclFileRead.readMultiTabXls();
		URL obj = null;
		HttpURLConnection con;
	
		for(int i=1;i<listmultilab.size();i++)
		{
			try {
				obj = new URL(listmultilab.get(i).getLinks());
				con = (HttpURLConnection) obj.openConnection();
				con.setRequestMethod("GET");
				System.out.print(listmultilab.get(i).getSubCategory());
				int responseCode = con.getResponseCode();
				if(responseCode==200)
				{
					System.out.println("Success");
					
				}
				else
				{
					System.out.print(listmultilab.get(i).getSubCategory());
					System.out.print("\t");
					//System.out.print(listmultilab.get(i).getLinks());
					System.out.print(responseCode);
					System.out.println();
					requestSender.writeDataToTextFile(listmultilab.get(i).getSubCategory(),listmultilab.get(i).getLinks());
					mailsend=true;
					
			}
				
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		Assert.assertTrue(!mailsend);
		if(mailsend==true)
		{
			requestSender.sendMail();
			
		}

}


	
}
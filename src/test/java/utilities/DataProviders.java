package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders
{
	
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException
	{
		
		String path="C:\\Users\\user\\eclipse-workspace\\DemoProject\\testData\\OrangeHRM_LoginData.xlsx.xlsx";
		ExcelUtility xlutil=new ExcelUtility(path);
		int totalrows=xlutil.getrowCount("sheet1");
		int totalcol=xlutil.getcellCount("sheet1", 1);
		
		System.out.println("Total Rows="+totalrows);
		System.out.println("Total coloums="+totalcol);
		
		
		String logindata[][]=new String[totalrows][totalcol];
		
		for(int i=1;i<=totalrows;i++)
		{
			
			for(int j=0;j<totalcol;j++)
			{
				logindata[i-1][j]=xlutil.getcellData("sheet1", i, j);
			}
		
		}
		
              return logindata;

	
	
          
	}
}

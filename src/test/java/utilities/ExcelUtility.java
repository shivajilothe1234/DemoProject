package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility 
{
	public FileInputStream fi;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFCell cell;
	public XSSFRow row;
	String path;
	
	public ExcelUtility(String path)
	{
		this.path=path;
	}
	
	public int getrowCount(String sheetName) throws IOException
	{
		fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheet(sheetName);
		int rowcount=sheet.getLastRowNum();
		workbook.close();
		return rowcount;
		
	}
	public int getcellCount(String sheetName,int rownum) throws IOException
	{
		fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(fi);
        sheet=workbook.getSheet(sheetName);
        row=sheet.getRow(rownum);
        int cellcount=row.getLastCellNum();
        workbook.close();
        return cellcount;
	   
    
	}
        public String getcellData(String sheetName,int rownum,int colnum ) throws IOException
        {
        	fi=new FileInputStream(path);
    		workbook=new XSSFWorkbook(fi);
            sheet=workbook.getSheet(sheetName);
            row=sheet.getRow(rownum);
            cell=row.getCell(colnum);
            		
            DataFormatter dt=new DataFormatter();	
            String data;
            try {
            	data=dt.formatCellValue(cell);
            }
            catch(Exception e)
            {
            	data="";
            }
            workbook.close();
            fi.close();
            return data;
        }
	
	

}

package utilities;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.math3.analysis.function.Constant;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import constants.constant;

public class ExcelUtility {
	
	
		static FileInputStream f;//Inbuilt class - FlieInputStream ,fetching the file
		static XSSFWorkbook w;//Fetching Workbook from the excel
		static XSSFSheet s;//Accessing sheet from the excel
		
		public static String getStringData(int a,int b,String sheet) throws IOException 
		{
			//int a is row and int b is cell in the excel
			f=new FileInputStream(constant.TESTDATAFILE);
			w=new XSSFWorkbook(f);
			s=w.getSheet(sheet);
			XSSFRow r=s.getRow(a);
			XSSFCell c=r.getCell(b);
			return c.getStringCellValue();
		}
		public static String getIntegerdata(int a,int b,String sheet) throws IOException
		{
			f=new FileInputStream(constant.TESTDATAFILE);
			w=new XSSFWorkbook(f);
			s=w.getSheet(sheet);
			XSSFRow r=s.getRow(a);
			XSSFCell c=r.getCell(b);
			int y=(int) c.getNumericCellValue();
			return String.valueOf(y);
		}
		/*public static void main(String[] args) throws IOException  {
			// TODO Auto-generated method stub
			System.out.println(ExcelUtilities.getStringData(1, 0));
			System.out.println(ExcelUtilities.getIntegerdata(1, 1));

		}*/
	}
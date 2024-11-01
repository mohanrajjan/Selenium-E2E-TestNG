package org.utility;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class JavaUtilities {

	public static String openURL(String key) {
	String value=null;
	String path=System.getProperty("user.dir") + "/config.properties";
	try {
		Properties prop = new Properties();
		FileInputStream istream =new  FileInputStream(path);
		prop.load(istream);
		value = prop.getProperty(key);
	}
	catch(Exception e){
		e.printStackTrace();
	}
	return value;	
	}
	
	public static String readingExcel(String sheet, int row, int col) {
		String result=null;
		try {
			String filepath=System.getProperty("user.dir")+"//info.xlsx";
			DataFormatter format= new DataFormatter();
			FileInputStream instream = new FileInputStream(filepath);
			XSSFWorkbook book= new XSSFWorkbook(instream);
			XSSFCell cell = book.getSheet(sheet).getRow(row).getCell(col);
			result = format.formatCellValue(cell);
			book.close();
			instream.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
}

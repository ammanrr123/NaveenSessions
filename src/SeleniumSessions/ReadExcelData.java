package SeleniumSessions;



//import org.apache.poi.sl.usermodel.Sheet;

import Lib.ExcelDataConfig;

public class ReadExcelData {

	public static void main(String[] args)  {

		ExcelDataConfig excel=new ExcelDataConfig("C:\\Users\\ammanrr.CORP\\eclipse-workspace\\UploadCommentary1.xlsx");
		 
		
		System.out.println(excel.getData(0, 0, 3));
		
		
		System.out.println(excel.getData(0, 1, 3));
	}
}

package SeleniumSessions;

import java.io.File;
import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CommentaryUpLoad {

	public static void main(String[] args) throws IOException {

		File src=new File("C://Users//ammanrr.CORP//eclipse-workspace//UploadCommentary.xlsx");
		
		FileInputStream fis=new FileInputStream(src);
		
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		
		
		XSSFSheet sheet1=wb.getSheetAt(0);
		
		String data0=sheet1.getRow(0).getCell(0).getStringCellValue();
		System.out.println(""+data0);
		
		String data1=sheet1.getRow(0).getCell(1).getStringCellValue();
		System.out.println(""+data1);
		
		int count =sheet1.getLastRowNum();
		System.out.println(+count);
		for(int i=1;i<count;i++) {
			
		String data2=	sheet1.getRow(i).getCell(0).getStringCellValue();
			System.out.println("Data from "+i+ "is "+data2);
		}
		wb.close();
	}

}

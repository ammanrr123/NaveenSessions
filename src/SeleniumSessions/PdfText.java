package SeleniumSessions;

import java.io.IOException;

import Lib.Utility5;

//import java.util.logging.Level;
//import java.util.logging.Logger;
//import org.apache.log4j.Logger;

//import com.google.j2objc.annotations.ReflectionSupport.Level;

public class PdfText {

	public static void main(String[] args) throws Exception {
		
		PDFManager pdfManager=new PDFManager();
		try {
			Utility5.setExcelFile("C://Users//ammanrr.CORP//eclipse-workspace//Pdfextract.xlsx", "Sheet1");
		} catch (Exception e) {
			System.out.println("Given Updated user input file is not availble in specified location");
		}
		
		String s1=Utility5.getCellData(0, 0);
		System.out.println(s1);
		pdfManager.setFilePath(s1);
		 
		try {
			String text=pdfManager.toText();
			java.io.FileWriter writer=new java.io.FileWriter(new java.io.File("C:\\Users\\ammanrr.CORP\\eclipse-workspace\\Extracted.txt"));
			writer.write(text);
			//System.out.println(text);
			
			//Utility5.setCellData(text, 1, 0); 
		}catch(IOException ex) {
			//Logger.getLogger(PDFBoxReadFromFile.class.getName()).log(Level.SEVERE,null,ex);
			System.err.println(ex.getMessage());
		}
		
	}
}

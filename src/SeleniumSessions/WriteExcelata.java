package SeleniumSessions;



import Lib.Utility;

public class WriteExcelata {

	public static void main(String[] args) throws Exception {
		//Utility excel=new Utility("C:\\Users\\ammanrr.CORP\\eclipse-workspace\\UploadCommentary2p.xlsx");
//ExcelDataConfig excel=new ExcelDataConfig("C:\\Users\\ammanrr.CORP\\eclipse-workspace\\UploadCommentary.xlsx");
		Utility.setExcelFile("C:\\Users\\ammanrr.CORP\\eclipse-workspace\\UploadCommentary2p.xlsx","Sheet1");
		Utility.setCellData("Pass", 1, 3); 
//excel.setData(0,1, 3, "Pass");
		
	}

	
	

}

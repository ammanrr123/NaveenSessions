package SeleniumSessions;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.io.RandomAccessFile;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;

import Lib.Utility;

public class PDFManager {

	private PDFParser parser;
	private PDFTextStripper pdfStripper;
	private PDDocument pdDoc;
	private COSDocument cosDoc;
	
	
	private String Text;
	private String filepath;
	private File file;
	
	public PDFManager() {
		
	}
	
	public String toText() throws IOException{
		this.pdfStripper=null;
		this.pdDoc=null;
		this.cosDoc=null;
		
		file=new File(filepath);
		parser=new PDFParser(new RandomAccessFile(file,"r"));
		parser.parse();
		cosDoc=parser.getDocument();
		pdfStripper=new PDFTextStripper();
		
		pdDoc=new PDDocument(cosDoc);
		pdDoc.getNumberOfPages();
		pdfStripper.setStartPage(0);
		pdfStripper.setEndPage(pdDoc.getNumberOfPages());
		
		Text=pdfStripper.getText(pdDoc);
		//pdfStripper.writeText(pdDoc, outputStream);
		
		BufferedWriter wr;
	File	output=new File("C:\\Users\\ammanrr.CORP\\eclipse-workspace\\Extracted.txt");
		wr=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(output)));
		pdfStripper.writeText(pdDoc, wr);
		
		if(pdDoc!=null) {
			pdDoc.close();
		}
		wr.close();
		//String lines[]=Text.split("\\r?\\n");
		//for(String line:lines) {
			//System.out.println(line);
		return Text;
			
		}
		//return Text;
		
		
	
	public void setFilePath(String filepath) {
		this.filepath=filepath;
	}
	
	public PDDocument getpdDoc() {
		return pdDoc;
	}
}

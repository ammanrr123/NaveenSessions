package SeleniumSessions;

import java.io.*;
import org.apache.pdfbox.pdmodel.*;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.util.*;

public class Extract {

 public static void main(String[] args){
 PDDocument pd;
 BufferedWriter wr;
 try {
         File input = new File("C:\\Users\\ammanrr.CORP\\Downloads\\LU0102737144_DE_CH.pdf");  // The PDF file from where you would like to extract
         File output = new File("C:\\Users\\ammanrr.CORP\\eclipse-workspace\\Extracted.txt"); // The text file where you are going to store the extracted data
         pd = PDDocument.load(input);
         System.out.println(pd.getNumberOfPages());
         System.out.println(pd.isEncrypted());
         pd.save("LU0102737144_DE_CH.pdf"); // Creates a copy called "CopyOfInvoice.pdf"
         PDFTextStripper stripper = new PDFTextStripper();
         wr = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(output)));
         stripper.writeText(pd, wr);
         if (pd != null) {
             pd.close();
         }
        // I use close() to flush the stream.
        wr.close();
 } catch (Exception e){
         e.printStackTrace();
        } 
     }
}
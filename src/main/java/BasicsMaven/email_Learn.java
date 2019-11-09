package BasicsMaven;

import com.itextpdf.text.*;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class email_Learn {
	 private static final String FILE_NAME = "/Users/venkatabalasumalisetty/Desktop/learning_email.pdf";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 writeUsingIText();
	}
	
	
	 private static void writeUsingIText() {

	        Document document = new Document();

	        try {

	            PdfWriter.getInstance(document, new FileOutputStream(new File(FILE_NAME)));

	            //open
	            document.open();
	            Font f1 = new Font(FontFamily.TIMES_ROMAN);
	            f1.setSize(18);
	            Paragraph p = new Paragraph("This is my paragraph 1||" + "email||"+"phone||"+"quantity"+"----unit price---"+"total",f1);
	            p.setAlignment(Element.ALIGN_CENTER);
                document.add(p);

	            Paragraph p2 = new Paragraph();
	            p2.add("This is my paragraph 2"); //no alignment

	            document.add(p2);

	            Font f = new Font();
	            f.setStyle(Font.BOLD);
	            f.setSize(8);
         Paragraph p_la = new Paragraph("This is my paragraph 3", f);
	            document.add(p_la);

	            //close
	            document.close();

	            System.out.println("Done");
	         
	        } catch (FileNotFoundException | DocumentException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	    }
	

}



   

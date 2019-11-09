package BasicsMaven;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.swing.border.Border;

import com.itextpdf.awt.geom.Rectangle;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class pdf_ceation {
//	private static final String FILE_NAME = "/Users/venkatabalasumalisetty/Desktop/learning_email.pdf";
	public void pdf_insert_data(HashMap<Integer, ArrayList<customerModel>> hashmap_with_keyas_bill_number ){

		Document document = new Document();
	

     try {
    	 SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    	 Date date = null;
		
    	 ArrayList< customerModel>eachValueForTheKey = new ArrayList<>();
    	 for(Integer bill :hashmap_with_keyas_bill_number.keySet()){
    		 
    		 String strDate ="/Users/venkatabalasumalisetty/Documents/pdf_folder/abc"+".pdf";
     		PdfWriter.getInstance(document, new FileOutputStream(new File(strDate)));
              document.open();
              Font boldFont = new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.BOLD);  
              Font regularFont = new Font(Font.FontFamily.TIMES_ROMAN, 10); 
              Font illaticfont = new Font (Font.FontFamily.TIMES_ROMAN,10, Font.ITALIC);
    		int eachTransactionValue=0;
    		int sum=0;
    		 eachValueForTheKey=hashmap_with_keyas_bill_number.get(bill);
    		System.out.println(eachValueForTheKey); 
    		for (int i = 0; i < eachValueForTheKey.size(); i++) {
          
             eachTransactionValue=eachValueForTheKey.get(i).getEach_billing_time_purchase_amount_id();
             sum=sum+eachTransactionValue;
        String date1 = (String.valueOf(eachValueForTheKey.get(i).getUpdated_date()));
             ///////////////////// bill number  and bill date///////////////
             
             PdfPTable table = new PdfPTable(2);
             float[] columnWidths = new float[]{15f, 40f};
             table.setWidths(columnWidths);

             Style style = new Style()
            		    .setBorder(Border.NO_BORDER)
            		    .setFont(tfont);
             PdfPCell cell;            
             cell = new PdfPCell(new Phrase("Bill Number: "+bill));
             cell.setHorizontalAlignment(Element.ALIGN_LEFT);
             cell.setBorder(Border.NO_BORDER);
        
             table.addCell(cell);
             
             
            cell = new PdfPCell(new Phrase("Bill Date: "+date1));
             cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
             cell.setBorder(Rectangle.OUT_BOTTOM);
     
             table.addCell(cell);
         
             document.add(table);
//////////////////////actual table//////////////
             
             
             table.setSpacingBefore(15f);
             table.setSpacingAfter(12.5f);

             
             
             PdfPTable table1 = new PdfPTable(7);
             
             table1.setSpacingBefore(15f);
             table1.setSpacingAfter(12.5f);
             float[] columnWidths1 = new float[]{10f, 25f, 40f, 25f,13f,10f,10f};
             table1.setWidths(columnWidths1);
             
             
             cell = new PdfPCell(new Phrase("Sr.No",boldFont));
             cell.setHorizontalAlignment(Element.ALIGN_CENTER);
             cell.setBackgroundColor(BaseColor.GREEN);
             table1.addCell(cell);
             
             cell = new PdfPCell(new Phrase("Customer Detials",boldFont));
             cell.setHorizontalAlignment(Element.ALIGN_CENTER);
             cell.setBackgroundColor(BaseColor.GREEN);
             table1.addCell(cell);
             
             cell = new PdfPCell(new Phrase("Email",boldFont));
             cell.setHorizontalAlignment(Element.ALIGN_CENTER);
             cell.setBackgroundColor(BaseColor.GREEN);
            table1.addCell(cell);
             
             cell = new PdfPCell(new Phrase("Phone",boldFont));
             cell.setHorizontalAlignment(Element.ALIGN_CENTER);         
             cell.setBackgroundColor(BaseColor.GREEN);
             table1.addCell(cell);
             
             cell = new PdfPCell(new Phrase("Quantity",boldFont));
             cell.setHorizontalAlignment(Element.ALIGN_CENTER);
             cell.setBackgroundColor(BaseColor.GREEN);
             table1.addCell(cell);
             
             cell = new PdfPCell(new Phrase("Unit Price",boldFont));
             cell.setHorizontalAlignment(Element.ALIGN_CENTER);
             cell.setBackgroundColor(BaseColor.GREEN);
             table1.addCell(cell);
             
             cell = new PdfPCell(new Phrase("Unit Total",boldFont));
             cell.setHorizontalAlignment(Element.ALIGN_CENTER);
             cell.setBackgroundColor(BaseColor.GREEN);
             table1.addCell(cell);
             
             cell = new PdfPCell(new Phrase(String.valueOf(i+1),regularFont));
             cell.setHorizontalAlignment(Element.ALIGN_CENTER);
             table1.addCell(cell);
             
             
             cell = new PdfPCell(new Phrase(eachValueForTheKey.get(i).getFirst_name()+" "+eachValueForTheKey.get(i).getLast_name(),regularFont));
             cell.setHorizontalAlignment(Element.ALIGN_CENTER);
             table1.addCell(cell);
             
             
             cell = new PdfPCell(new Phrase(eachValueForTheKey.get(i).getEmaile(),illaticfont));
             cell.setHorizontalAlignment(Element.ALIGN_CENTER);
             table1.addCell(cell);
             
             cell = new PdfPCell(new Phrase(eachValueForTheKey.get(i).getPhone(),regularFont));
             cell.setHorizontalAlignment(Element.ALIGN_CENTER);
             table1.addCell(cell);
             
             cell = new PdfPCell(new Phrase(String.valueOf(eachValueForTheKey.get(i).getQuantity()),regularFont));
             cell.setHorizontalAlignment(Element.ALIGN_CENTER);
             table1.addCell(cell);
             
             cell = new PdfPCell(new Phrase(String.valueOf(eachValueForTheKey.get(i).getUnit_price()),regularFont));
             cell.setHorizontalAlignment(Element.ALIGN_CENTER);
             table1.addCell(cell);
             
             cell = new PdfPCell(new Phrase(String.valueOf(eachValueForTheKey.get(i).getEach_billing_time_purchase_amount_id()),regularFont));
             cell.setHorizontalAlignment(Element.ALIGN_CENTER);
             table1.addCell(cell);
             
             document.add(table1);
             
             //////////////////////sum table///////////////
             
             PdfPTable table2 = new PdfPTable(2);
             table2.setHorizontalAlignment(Element.ALIGN_LEFT);
             table2.setWidthPercentage(160 / 5.23f);
             
             cell = new PdfPCell(new Phrase("Sum"));
             table2.addCell(cell);
             
             cell = new PdfPCell(new Phrase(String.valueOf(sum)));
             table2.addCell(cell);
             document.add(table2);
             
             
            //////////thank you ///////////////////////// 
             
             
             Paragraph p = new Paragraph();
	         p.add("************************    Thank you Visit Again********************************");
	         p.setAlignment(Element.ALIGN_CENTER);
             document.add(p);
             document.close();
             //////////////image///////////

    		}

             
             
    		
    	 }
    	 
        
         //open
        

         System.out.println("Done");
      
     } catch (FileNotFoundException | DocumentException e) {
         e.printStackTrace();
     } catch (IOException e) {
         e.printStackTrace();
     }
	}
}
//HashMap<Integer, ArrayList<customerModel>> hashmap_with_keyas_bill_number = new HashMap<Integer, ArrayList<customerModel>>();
package BasicsMaven;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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

//public class pdf_ceation implements Runnable {
	public class pdf_ceation extends Thread {
	//Thread Place holder variables
	public HashMap<Integer, ArrayList<customerModel>> hashmap_with_keyas_bill_number;
	public int billNumber;
	
	//Constructor
	public pdf_ceation(HashMap<Integer, ArrayList<customerModel>> hashmap_with_keyas_bill_number,int billNumber) {
		this.billNumber = billNumber;
		this.hashmap_with_keyas_bill_number = hashmap_with_keyas_bill_number;
	}
    
	
	public void run() {
		System.out.println(Thread.currentThread().getId());
	    threadImplementation(this.billNumber);
		
	}

	public void threadImplementation(int billNumber) {
try {
		ArrayList<customerModel> eachValueForTheKey = new ArrayList<customerModel>();
		int j = hashmap_with_keyas_bill_number.keySet().size();
		int sum = 0;
		Document document = new Document();
		String strname_location = "/Users/viswanathanakkinti/Desktop/PDF-files_learning/testData_" + String.valueOf(billNumber)
				+ ".pdf";
		PdfWriter.getInstance(document, new FileOutputStream(new File(strname_location)));
		document.open();
		Font boldFont = new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.BOLD);
		Font regularFont = new Font(Font.FontFamily.TIMES_ROMAN, 10);
		Font illaticfont = new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.ITALIC);
		int eachTransactionValue = 0;

		eachValueForTheKey = hashmap_with_keyas_bill_number.get(billNumber);
		System.out.println("currently processing    " + billNumber + "    out of   " + j);
		j--;

		///////////////////// bill number and bill date///////////////

		PdfPTable table = new PdfPTable(2);
		float[] columnWidths = new float[] { 15f, 40f };
		table.setWidths(columnWidths);

		PdfPCell cell1;
		cell1 = new PdfPCell(new Phrase("Bill Number: " + billNumber));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);

		cell1.setBorderColor(BaseColor.WHITE);
		table.addCell(cell1);
		
//   cell.setBorder(Rectangle.OUT_BOTTOM);

		table.setSpacingBefore(15f);
		table.setSpacingAfter(0f);

		PdfPTable table1 = new PdfPTable(7);
		PdfPCell cell;

		table1.setSpacingBefore(15f);
		table1.setSpacingAfter(15f);
		float[] columnWidths1 = new float[] { 10f, 25f, 40f, 25f, 13f, 10f, 10f };
		table1.setWidths(columnWidths1);

		cell = new PdfPCell(new Phrase("Sr.No", boldFont));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setBackgroundColor(BaseColor.PINK);
		table1.addCell(cell);

		cell = new PdfPCell(new Phrase("Customer Detials", boldFont));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setBackgroundColor(BaseColor.PINK);
		table1.addCell(cell);

		cell = new PdfPCell(new Phrase("Email", boldFont));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setBackgroundColor(BaseColor.PINK);
		table1.addCell(cell);

		cell = new PdfPCell(new Phrase("Phone", boldFont));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setBackgroundColor(BaseColor.PINK);
		table1.addCell(cell);

		cell = new PdfPCell(new Phrase("Quantity", boldFont));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setBackgroundColor(BaseColor.PINK);
		table1.addCell(cell);

		cell = new PdfPCell(new Phrase("Unit Price", boldFont));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setBackgroundColor(BaseColor.PINK);
		table1.addCell(cell);

		cell = new PdfPCell(new Phrase("Unit Total", boldFont));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setBackgroundColor(BaseColor.PINK);
		table1.addCell(cell);

		for (int i = 0; i < eachValueForTheKey.size(); i++) {
			if (i == 0) {

				cell1 = new PdfPCell(new Phrase("Bill Date: " + new SimpleDateFormat("MM/dd/yyyy HH:mm:ss")
						.format(eachValueForTheKey.get(i).getUpdated_date())));
				cell1.setHorizontalAlignment(Element.ALIGN_RIGHT);
				cell1.setBorderColor(BaseColor.WHITE);
				table.addCell(cell1);
				document.add(table);
			}
			
		
			eachTransactionValue = eachValueForTheKey.get(i).getEach_billing_time_purchase_amount_id();
			sum = sum + eachTransactionValue;

			cell = new PdfPCell(new Phrase(String.valueOf(i + 1), regularFont));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell);

			cell = new PdfPCell(new Phrase(
					eachValueForTheKey.get(i).getFirst_name() + " " + eachValueForTheKey.get(i).getLast_name(),
					regularFont));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell);

			cell = new PdfPCell(new Phrase(eachValueForTheKey.get(i).getEmaile(), illaticfont));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell);

			cell = new PdfPCell(new Phrase(eachValueForTheKey.get(i).getPhone(), regularFont));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell);

			cell = new PdfPCell(new Phrase(String.valueOf(eachValueForTheKey.get(i).getQuantity()), regularFont));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell);

			cell = new PdfPCell(new Phrase(String.valueOf(eachValueForTheKey.get(i).getUnit_price()), regularFont));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell);

			cell = new PdfPCell(new Phrase(
					String.valueOf(eachValueForTheKey.get(i).getEach_billing_time_purchase_amount_id()), regularFont));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell);

		}
		

		document.add(table1);
		
		////////////////////// sum table///////////////
		PdfPCell cell2;
		PdfPTable table2 = new PdfPTable(7);
		table2.setSpacingAfter(60f);
		// table2.setHorizontalAlignment(Element.ALIGN_RIGHT);
		float[] columnWidths2 = new float[] { 10f, 25f, 40f, 25f, 13f, 10f, 10f };
		table2.setWidths(columnWidths2);

		cell2 = new PdfPCell(new Phrase(""));
		cell2.setBorderColor(BaseColor.WHITE);
		table2.addCell(cell2);

		cell2 = new PdfPCell(new Phrase(""));
		cell2.setBorderColor(BaseColor.WHITE);
		table2.addCell(cell2);

		cell2 = new PdfPCell(new Phrase(""));
		cell2.setBorderColor(BaseColor.WHITE);
		table2.addCell(cell2);

		cell2 = new PdfPCell(new Phrase(""));
		cell2.setBorderColor(BaseColor.WHITE);
		table2.addCell(cell2);

		cell2 = new PdfPCell(new Phrase(""));
		cell2.setBorderColor(BaseColor.WHITE);
		table2.addCell(cell2);

		cell2 = new PdfPCell(new Phrase("Sum"));
		table2.addCell(cell2);

		cell2 = new PdfPCell(new Phrase(String.valueOf(sum)));
		table2.addCell(cell2);
		document.add(table2);

		////////// thank you /////////////////////////

		Paragraph p = new Paragraph();
		p.setSpacingAfter(50f);
		p.add("************************    Thank you Visit Again********************************");
		p.setAlignment(Element.ALIGN_CENTER);
		document.add(p);

		////////////// image///////////

		Image image = Image.getInstance("father-teresa.png");
		image.scaleAbsolute(70f, 70f);
		image.setAlignment(Element.ALIGN_CENTER);

		document.add(image);
//   
		document.close();
} catch (FileNotFoundException | DocumentException e) {
	e.printStackTrace();
} catch (IOException e) {
	System.out.println(e);
}
	}


	

	public void pdf_insert_data() {
		HashMap<Integer, ArrayList<customerModel>>  inc = this.hashmap_with_keyas_bill_number;
		List<Thread> threads = new ArrayList<Thread>();
		ExecutorService executor = Executors.newFixedThreadPool(10);
		for (Integer bill : inc.keySet()) {

			int bill_details = bill;

			/////// here thread will start//////
		
			//Runnable runnable = new pdf_ceation(hashmap_with_keyas_bill_number,bill_details);
			//executor.execute(runnable);
		
			
			//t1.start();
			Thread t1 =new pdf_ceation(inc,bill_details);
			threads.add(t1);
            t1.start();

		}
		for(Thread t: threads) {
			try {
			t.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}
		System.out.println("Done");
	}

}

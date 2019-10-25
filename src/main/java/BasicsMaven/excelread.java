package BasicsMaven;
import java.io.File; 
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook; 


public class excelread {
	public static void main(String[] args) {

		       String file_address ="/Users/venkatabalasumalisetty/Desktop/name.xlsx"; 
		    ArrayList<HashMap<String, String>> dataArrayList = new ArrayList<HashMap<String, String>>();
		    HashMap<String,String> map_colums=new HashMap<String,String>();
		       try{
		       File excelFile = new File(file_address);
		       FileInputStream fis = new FileInputStream(excelFile);

		       // we create an XSSF Workbook object for our XLSX Excel File
		       XSSFWorkbook workbook = new XSSFWorkbook(fis);
		       // we get first sheet
		       XSSFSheet sheet = workbook.getSheetAt(0);

		       // we iterate on rows
		       Iterator<Row> rowIt = sheet.iterator();

		       while(rowIt.hasNext()) {
		         Row row = rowIt.next();
		        
		         // iterate on cells for the current row
		         Iterator<Cell> cellIterator = row.cellIterator();
		        
		         while (cellIterator.hasNext()) {
		           Cell cell = cellIterator.next();
		           System.out.print(cell.toString() + "  ");
		         }

		         System.out.println();
		       }

		       workbook.close();
		       fis.close();
		     }
		       catch (Exception e){
		    	   System.out.println(e);
		       }
		   	
		   }
}
	

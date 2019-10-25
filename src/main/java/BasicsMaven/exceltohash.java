package BasicsMaven;
import java.io.File; 
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook; 


public class exceltohash{
public static int row_count=0;
  public static int colums_count = 0;
//public static void main(String[] args) {
	public static ArrayList<ArrayList<String>> exceltoarray (String file_location)
	{
		      // String file_address1 ="/Users/venkatabalasumalisetty/Desktop/name.xlsx"; 
		       ArrayList<ArrayList<String>> row_list=new ArrayList<ArrayList<String>>();
		       
		    //HashMap<Integer,HashMap<Integer, String>> map_colums=new HashMap<Integer,HashMap <Integer,String>>();
		
		       try{
		       File excelFile = new File(file_location);
		       FileInputStream fis = new FileInputStream(excelFile);

		       // we create an XSSF Workbook object for our XLSX Excel File
		       XSSFWorkbook workbook = new XSSFWorkbook(fis);
		       // we get first sheet
		       XSSFSheet sheet = workbook.getSheetAt(0);

		       // we iterate on rows
		       Iterator<Row> rowIt = sheet.iterator();
             
		       while(rowIt.hasNext()) {
		         Row row = rowIt.next();
		         row_count++;
		      colums_count= row.getPhysicalNumberOfCells();// coulmns in a row count
		       
		         // iterate on cells for the current row
		         Iterator<Cell> cellIterator = row.cellIterator();
		        
		        // HashMap<Integer, String> data = new HashMap<Integer,String>();
		         ArrayList<String> columlist_for_eachrow=new ArrayList<String>();
		         while (cellIterator.hasNext()) {
		         
		           Cell cell = cellIterator.next();
		           String data_cell=cell.toString();
		           //data.put(cell_count, data_cell);
		          // System.out.print(data + "  ");
		           columlist_for_eachrow.add(data_cell);
		           
		         }
		         //map_colums.put(row_count, data);
		       
		         row_list.add(columlist_for_eachrow);
		        
		         
		       }

		       workbook.close();
//		       for (ArrayList<String> k:row_list){
//		       System.out.println(k);
//		      //return k;
//		       }
		       fis.close();
		     }
		       catch (Exception e){
		    	   System.out.println(e);
		       }
		  
			return row_list;
		   	
		   }
	
	public int row_value_transfer(){
		return row_count;
	}
	
	public int cell_value_transfer(){
		return colums_count;
	}
}
	


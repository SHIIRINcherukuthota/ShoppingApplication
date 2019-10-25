package BasicsMaven;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MAIN {
   // JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost/learning";

   //  Database credentials
   static final String USER = "root";
   static final String PASS = "password";
   
   public static void main(String[] args) {
   Connection conn = null;
   Statement stmt = null;
   try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      System.out.println("Connecting to a selected database...");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      System.out.println("Connected database successfully...");
      
      //STEP 4: Execute a query
     
      stmt = conn.createStatement();
      
      
      ArrayList<ArrayList<String>> row_excel=new ArrayList<ArrayList<String>>();
	  
      String sql;
     row_excel= exceltohash.exceltoarray("/Users/venkatabalasumalisetty/Downloads/customers.xlsx");
     String cell1 = null;
     String cell2=null;
  int counter=0;
  int row_count=exceltohash.row_count;
  int column_count=exceltohash.colums_count;
  
    String Field_List = "";  
    Boolean is_table_created = false;
    ArrayList <String>first_row_data=new ArrayList<String>();
     for (ArrayList<String> row_data:row_excel){

       if(counter==0){
    	   first_row_data=row_data;
    	   Field_List=new sql_Statement_Generator().first_halft_insert_sql(row_data);
  
    	     counter++;
    	     continue;
    	     
       }
       
       if (counter==1){
    	   String table_creation= new sql_Statement_Generator().columns_declarations(first_row_data,row_data,"customers");                           
    	   try{
    		   System.out.println(table_creation);
       	    stmt.executeUpdate(table_creation);
       	    }catch (Exception e) {
       	    	System.out.println("unable to create table +"+ e);
   			}
       }
      // System.out.println(Field_List);

       sql= "INSERT INTO `learning`.`customers` ($_fields) VALUES ($_VALUES);";

 String LIST_OF_VALUES= new sql_Statement_Generator().second_half_insert_sql(row_data);

//      System.out.print(LIST_OF_VALUES);
//      System.out.println(Field_List);
      sql = sql.replace("$_fields", Field_List);
     // System.out.println(sql);
       sql = sql.replace("$_VALUES",LIST_OF_VALUES);
       
  System.out.println(sql);
       stmt.executeUpdate(sql);
       counter++;
	       }
     
      
      }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            conn.close();
      }catch(SQLException se){
      }// do nothing
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try

}//end main
}//end JDBCExample


//INSERT INTO `learning`.`test` (`first name`, `last name`, `gender`) VALUES ('a', 'b', 'c');



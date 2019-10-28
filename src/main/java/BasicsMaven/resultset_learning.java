package BasicsMaven;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
public class resultset_learning {
	   private static final String Static = null;


 static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://remotemysql.com/4sgeFlzuqF";

	   //  Database credentials
	   static final String USER = "4sgeFlzuqF";
	   static final String PASS = "j5h4ZV0cyS";
	   
	   
	   public void testDB_controller() {
		
		 String dbController =   MAIN.args_inputs[0];
		 
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
 
            // Create a query to use.
            String query = "SELECT * FROM 4sgeFlzuqF.customers";
 
            // Execute the query and get the result set, which contains
            // all the results returned from the database.
            ResultSet resultSet = stmt.executeQuery(query);
 
            // We loop through the rows that were returned, and we can access the information
            // depending on the type of each column. In this case:
            //      Album: Varchar, so we use getString().
            //      Artist: Also Varchar, so getString() again.
            //      Year: Int, so we use getInt().
            // For other types of columns, such as boolean or Date, we use the appropriate methods.
            while (resultSet.next()) {
                System.out.println("Printing result...");
 
                // Now we can fetch the data by column name, save and use them!
                int ID = resultSet.getInt("id");
                int Integer_coulmn = resultSet.getInt("integer");
                double double_coulmn = resultSet.getDouble("double");
                String String_coulmn = resultSet.getString("string");
                int year = resultSet.getInt("date");
 
                System.out.println("id: " + ID + 
                		 ",integer: " +  Integer_coulmn+
                		 ",double: "+double_coulmn+
                		 ",string: "+String_coulmn +
                		 ",date: "+year );
            }
 
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // We have to close the connection and release the resources used.
            // Closing the statement results in closing the resultSet as well.
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

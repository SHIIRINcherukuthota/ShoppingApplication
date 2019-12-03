package BasicsMaven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class db_controllerForApi {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://remotemysql.com/4sgeFlzuqF";

	// Database credentials
	static final String USER = "4sgeFlzuqF";
	static final String PASS = "j5h4ZV0cyS";

	public  HashMap<Integer, ArrayList<customerModel>> APIDB_read_controller(String query2 ) {
			
	
			 
		   Connection conn = null;
		   Statement stmt = null;
		   HashMap<Integer, ArrayList<customerModel>> hashmap_with_keyas_bill_number = null;
		   try{
		      //STEP 2: Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");

		      //STEP 3: Open a connection
		    //  System.out.println("Connecting to a selected database...");
		      conn = DriverManager.getConnection(DB_URL, USER, PASS);
		     // System.out.println("Connected database successfully...");
		      
		      //STEP 4: Execute a query
		     
		      stmt = conn.createStatement();
	 
	            // Create a query to use.
		   String query=query2;

   	            ResultSet resultSet = stmt.executeQuery(query);
	 
	            
	            ArrayList<customerModel> customer_table_to_db = new ArrayList<customerModel> ();
	           // System.out.println(resultSet);
	            int bill_number = 0;
	            int  customer_ID=0;
	            String address ="";
	            String emaile="";
	            String last_name="";
	            String phone = "";
	            String first_name ="";
	            int item_id=0;
	            int quantity=0;
	            int  each_billing_time_purchase_amount=0;
	            int unit_price=0;
	            while (resultSet.next()) {
	            	
	            	
	            customer_ID  = resultSet.getInt("customer_ID");
                address = resultSet.getString("address");
	             emaile = resultSet.getString("email");
           		last_name = resultSet.getString("last_name");
           		 phone = resultSet.getString("phone");
           		 first_name = resultSet.getString("first_name");
//           		String gender = resultSet.getString("gender");
          		java.sql.Date created_date = resultSet.getDate("created_date");
           		java.util.Date cust_created_date = new java.util.Date(created_date.getTime());
         		java.sql.Date updated_date = resultSet.getDate("updated_date");
          		java.util.Date cust_updated_date = new java.util.Date(updated_date.getTime());
           		item_id=resultSet.getInt("item_id");
           		 quantity=resultSet.getInt("quantity");
           		 each_billing_time_purchase_amount=resultSet.getInt("each billing time purchase amount");
           		 unit_price=resultSet.getInt("unit_price");
           		 bill_number=resultSet.getInt("bill_number");
           		 
           		
           		customerModel each_customer_details = new customerModel();
           		
           		each_customer_details.setCustomer_ID(customer_ID);
           		each_customer_details.setAddress(address);
           		each_customer_details.setEmaile(emaile);
           		each_customer_details.setFirst_name(first_name);
           		each_customer_details.setLast_name(last_name);
           		each_customer_details.setItem_id(item_id);
           		each_customer_details.setQuantity(quantity);
           		each_customer_details.setEach_billing_time_purchase_amount_id(each_billing_time_purchase_amount);
           		each_customer_details.setPhone(phone);
           		each_customer_details.setUnit_price(unit_price);
           		each_customer_details.setBill_number(bill_number);
//           		each_customer_details.setGender(gender);
          		each_customer_details.setCreated_date(cust_created_date);
           		//forgot add
           		each_customer_details.setUpdated_date(cust_updated_date);
           		
           		customer_table_to_db.add(each_customer_details);
           		
	            }

		        		//  Collections.sort(customer_table_to_db);
		        		    arrayTohashmap obj  =   new arrayTohashmap();
		        		    hashmap_with_keyas_bill_number = new HashMap<Integer, ArrayList<customerModel>>();
		        		//hashmap_with_keyas_bill_number= obj.identical_billnumber_find(customer_table_to_db);
		        		    hashmap_with_keyas_bill_number.put(bill_number, customer_table_to_db); 
		        		return hashmap_with_keyas_bill_number;
		        		 	
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	            System.out.println(e);
	        } catch (SQLException e) {
	            e.printStackTrace();
	            System.out.println(e);
	        } finally {
	            // We have to close the connection and release the resources used.
	            // Closing the statement results in closing the resultSet as well.
	        	 try{
	                 if(stmt!=null)
	                    conn.close();
	              }catch(SQLException se){
	            	  System.err.println(se);
	              }// do nothing
	              try{
	                 if(conn!=null)
	                    conn.close();
	              }catch(SQLException se){
	                 se.printStackTrace();
	              }//end finally try
	           }//end try
		return hashmap_with_keyas_bill_number;
		
	       
		   
	        }//end main
	
	
	public String DBstring(Map<String, String> quryParamsasMap) {
		
		String valueMetaData =  "";
		
		for (String queryMetaData : quryParamsasMap.keySet()) {
			String keyMetaData = queryMetaData.toString();
             valueMetaData = quryParamsasMap.get(queryMetaData).toString();  
            
           
		}
		return valueMetaData;
	}
}
	
	
	



package BasicsMaven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

import javafx.print.Collation;

public class sqltable_read {
	
//test

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://remotemysql.com/4sgeFlzuqF";

	// Database credentials
	static final String USER = "4sgeFlzuqF";
	static final String PASS = "j5h4ZV0cyS";

	public void DB_read_controller() {
			
			 String dbController =   MAIN.args_inputs[0];
			 String query_arg = MAIN.args_inputs[1];
			 
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
	            String query =  "SELECT item_id,quantity,unit_price, Customer_ID,first_name,last_name, address,created_date,updated_date, "
	            		+"email,phone,  quantity * unit_price as ' each billing time purchase amount' FROM 4sgeFlzuqF.Database_learning_purchase_list "
	            +"INNER JOIN customers ON Database_learning_purchase_list.Customer_ID = customers.cvustomer_ID "+
	            		" ORDER BY Customer_ID";
	            System.out.println(query);

	            // Execute the query and get the result set, which contains
	            // all the results returned from the database.
	            ResultSet resultSet = stmt.executeQuery(query);
	 
	            // We loop through the rows that were returned, and we can access the information
	            // depending on the type of each column. In this case:
	            //      Album: Varchar, so we use getString().
	            //      Artist: Also Varchar, so getString() again.
	            //      Year: Int, so we use getInt().
	            // For other types of columns, such as boolean or Date, we use the appropriate methods.
	            
	            ArrayList<customerModel> customer_table_to_db = new ArrayList<customerModel> ();
	            
	            
	            while (resultSet.next()) {
	            	
	            	
	     int  customer_ID  = resultSet.getInt("customer_ID");
                String address = resultSet.getString("address");
	            String emaile = resultSet.getString("email");
           		String last_name = resultSet.getString("last_name");
           		String phone = resultSet.getString("phone");
           		String first_name = resultSet.getString("first_name");
//           		String gender = resultSet.getString("gender");
          		java.sql.Date created_date = resultSet.getDate("created_date");
           		java.util.Date cust_created_date = new java.util.Date(created_date.getTime());
         		java.sql.Date updated_date = resultSet.getDate("updated_date");
          		java.util.Date cust_updated_date = new java.util.Date(updated_date.getTime());
           		int item_id=resultSet.getInt("item_id");
           		int quantity=resultSet.getInt("quantity");
           		int  each_billing_time_purchase_amount=resultSet.getInt("each billing time purchase amount");
           		int unit_price=resultSet.getInt("unit_price");
           		 
           		
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
//           		each_customer_details.setGender(gender);
          		each_customer_details.setCreated_date(cust_created_date);
           		//forgot add
           		each_customer_details.setUpdated_date(cust_updated_date);
           		
           		customer_table_to_db.add(each_customer_details);
           		
	            }


	            Comparator<customerModel> custom_compaator =  new Comparator<customerModel>(){
		             public int compare(customerModel one, customerModel two) {
                          ///////////////////////////////////////////
                          if(MAIN.args_inputs[1].equals("created_date")) {
                        	  if (one.getCreated_date() == null || two.getCreated_date() == null) {
  		            	        return 0;
                        	  }
		            	      return one.getCreated_date().compareTo(two.getCreated_date());
		            	      }
                          ///////////////////////////////////////////////////////////
                          if(MAIN.args_inputs[1].equals("updated_date")) {
                        	  if (one.getUpdated_date() == null || two.getUpdated_date() == null) {
    		            	        return 0;
                          	  }
		            	      return one.getUpdated_date().compareTo(two.getUpdated_date());
		            	      }
                          ///////////////////////////////////////////////////////////////
                          if(MAIN.args_inputs[1].equals("Customer_ID")) {
		            	      return new Integer(one.getCustomer_ID()).compareTo(new Integer(two.getCustomer_ID()));
		            	      }
                          if(MAIN.args_inputs[1].equals("created_date")) {
		            	      return one.getAddress().compareTo(two.getAddress());
		            	      }
                          if(MAIN.args_inputs[1].equals("created_date")) {
		            	      return one.getAddress().compareTo(two.getAddress());
		            	      }
                          if(MAIN.args_inputs[1].equals("created_date")) {
		            	      return one.getAddress().compareTo(two.getAddress());
		            	      }
                          if(MAIN.args_inputs[1].equals("created_date")) {
		            	      return one.getAddress().compareTo(two.getAddress());
		            	      }
                          
                          return 0;
		        	
	            }};

	            
	            //To Sorty by First name
	            //https://stackoverflow.com/a/47907804/4491572
	            Collections.sort(customer_table_to_db,custom_compaator);
	            
	            
	            
	         for(customerModel customer_obj :customer_table_to_db ) {
	            System.out.println(customer_obj);
	          }
	         
	         

		        		  Collections.sort(customer_table_to_db,custom_compaator);
		        	      for(customerModel customer_obj :customer_table_to_db ) {
		               System.out.println(customer_obj);
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
	        }// end JDBCExample

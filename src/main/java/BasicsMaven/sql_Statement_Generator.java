package BasicsMaven;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class sql_Statement_Generator {
	
	String display_coulmn_name;


	public void get_table_creation_statement(ArrayList<String> first_row){	
		for(String each_element : first_row){
			//System.out.println(each_element.getClass().getName());
			coulmn_name(each_element);
		}
	}
	
	
	
		   public static boolean isValidDate(String each_element) {
		        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
		        dateFormat.setLenient(false);
		        try {
		            dateFormat.parse(each_element.trim());
		        } catch (ParseException pe) {
		            return false;
		        }
		        return true;

		   }

 
	public  void coulmn_name(String name){
	 this.display_coulmn_name =name;
	}
	  public  String columns_declarations(ArrayList<String> row_data_data_at_1,ArrayList<String> row_data_at_row_2,String table_name){
			 int integer_value;
			double double_value;
			 String sql = "CREATE TABLE 4sgeFlzuqF."+ table_name+ "(`id` INT NOT NULL AUTO_INCREMENT,";
		   for( int i = 0;i<row_data_at_row_2.size();i++){
           String each_element = row_data_at_row_2.get(i); 
           System.out.println(each_element+"   from first  print  ");
			   int int_value;
				double dob_value;
			 	
				//Parsing Integer***************
				try{
			 		int_value=	Integer.parseInt(each_element);
			 		sql = sql + "`"+   row_data_data_at_1.get(i)   +"` INT NULL,";  
						System.out.println("its from int....");
						continue;
			 	//INSERT INTO `learning`.`purchase_list` (`customer_ID`, `item_id`, `bill_number`, `quantity`, `unit_price`, `item_description`, `category`, `purchasedate`) VALUES ('12', '20', '123', '1', '12', 'veabshr', 'hwbRHW', '10-01-12');
			 	}
			 	catch( Exception e){
			 		int_value=0;	
			 	}
			
				///Parsing Double*****************
			 	try{
			 		dob_value=	Double.parseDouble(each_element);
			 		sql = sql + "`"+ row_data_data_at_1.get(i) +"` DECIMAL(10,0) NULL, ";
			 		continue;
			 	}
			 	catch( Exception e){
			 		dob_value=-0.0;
			 	}
			 	
			 	if(isValidDate(each_element)==true){
					sql= sql+"`"+ row_data_data_at_1.get(i) +"` DATE NULL,";
					continue;
					}
			 	
				
				else{
					sql = sql + "`"+row_data_data_at_1.get(i)  +"` VARCHAR(45) NULL, ";
					System.out.println(row_data_data_at_1.get(i));

				}
		System.out.println(sql);
		   }
		   sql=sql+" PRIMARY KEY (`id`));";                       
		
		 return sql;
		      
}
	  
	  public String first_halft_insert_sql(ArrayList<String> row_data){
		  String  Field_List1="";
 	     for (int i=0;i<row_data.size();i++){
 	    	 if(i == row_data.size()-1){
 	    		 Field_List1 = Field_List1 + "`"+row_data.get(i)+"`"; 
 	    		 continue;
     	     }
 	    	
 	    	 Field_List1 = Field_List1+ "`"+row_data.get(i)+"`,"; 
 	     }  return Field_List1;
	  }
	  
	  
	  public String second_half_insert_sql(ArrayList<String> row_data){
		
		   String LIST_OF_VALUES1 = ""; 
		  for (int i = 0;i< row_data.size();i++){

			 if (isValidDate(row_data.get(i))==true){
				 //covert date to accepted String
				 String str_date = row_data.get(i);
				 System.out.println(str_date);
				 DateFormat formatter;
				 java.util.Date date = null;
				 formatter = new SimpleDateFormat("dd-MMM-yyyy");
				 try {
					date = formatter.parse(str_date);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 
				 //12-12-19
				 SimpleDateFormat formatter_new = new SimpleDateFormat("YYYY-MM-dd");
				 String s = formatter_new.format(date);
				 
				 LIST_OF_VALUES1 = LIST_OF_VALUES1 +"'"+s+"',";//(STR_TO_DATE('"+row_data.get(i)+"','%d-%mm-%yy'))
				
				 continue;
			 }
			 	
			  
	    	  if(i == row_data.size()-1){
	    		  LIST_OF_VALUES1 = LIST_OF_VALUES1 + "'"+row_data.get(i)+"'";
	    		  continue;
	    	  }
	    	 
	    	  LIST_OF_VALUES1 = LIST_OF_VALUES1 + "'"+row_data.get(i)+"',";       
		  } 
		  return LIST_OF_VALUES1;
	  }
	
	 
}








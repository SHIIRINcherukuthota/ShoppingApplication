package BasicsMaven;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//added
public class MAIN {
   // JDBC driver name and database URL
  
   static public String[] args_inputs;
   
   //  Database credentials
  
   public static void main(String[] args) {
	   
	   //Understand Args a Sring arry
	   if(args.length == 0){
		   System.exit(2);
	   }
	   else {
		   args_inputs = args;
	   }
	   
	   if(args_inputs[0].equals("read_from_database")){
		   
		   long lStartTime = System.nanoTime();
		   
		   /////////
		   
		   new sqltable_read().DB_read_controller(); 
		   
		   ///////////////
		   long lEndTime = System.nanoTime();
		    
		    System.out.println("Total time taken to complete read process: "+((double)(lEndTime - lStartTime) / 1_000_000_000));
		   
	   }
	   if(args_inputs[0].equals("write_from_database")){
		   new WriteController().Write(args_inputs[0]);
		  // new WriteController.Write(args[2]);
	   }
	   else{
		   System.exit(-1);
	   }
   }
}
	   
	   







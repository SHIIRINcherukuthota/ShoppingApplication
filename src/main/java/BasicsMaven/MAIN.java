package BasicsMaven;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
		   new sqltable_read().DB_read_controller();
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
	   
	   







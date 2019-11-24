package BasicsMaven;

import java.text.SimpleDateFormat;
import java.util.Date;

public class utility extends Thread {
	private String to;
	
	public utility(String to) {
		// TODO Auto-generated constructor stub
	 
        this.to = to;
    }
	
public String dateConversion_from_dateObject_to_ofSstringformat(Date inDate,String formatOfDate) {

	return  new SimpleDateFormat(formatOfDate).format(inDate);
}

@Override
public void run() {
    System.out.println("hello " + to);
}
   
} 
  

     

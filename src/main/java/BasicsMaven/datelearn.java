package BasicsMaven;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class datelearn {
	 public static boolean isValidDate(String inDate) {
	        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	        dateFormat.setLenient(false);
	        try {
	            dateFormat.parse(inDate.trim());
	        } catch (ParseException pe) {
	            return false;
	        }
	        return true;
	    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 System.out.println(isValidDate("20-01-2014"));
	        System.out.println(isValidDate("11-04-2015 "));
String abc="246";
System.out.println(Integer.parseInt(abc));
	        System.out.println(isValidDate("32476347656435"));
	       	}

}


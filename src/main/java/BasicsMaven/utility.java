package BasicsMaven;

import java.text.SimpleDateFormat;
import java.util.Date;

public class utility {

public String dateConversion_from_dateObject_to_ofSstringformat(Date inDate,String formatOfDate) {

	return  new SimpleDateFormat(formatOfDate).format(inDate);
}
	
	
}

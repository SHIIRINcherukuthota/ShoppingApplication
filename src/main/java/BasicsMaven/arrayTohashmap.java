package BasicsMaven;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.SortedSet;
import java.util.TreeSet;

public class arrayTohashmap {
	HashMap<Integer, ArrayList<customerModel>> hashmap_with_keyas_bill_number = new HashMap<Integer, ArrayList<customerModel>>();

	public HashMap<Integer, ArrayList<customerModel>> identical_billnumber_find(ArrayList<customerModel> customer_table_to_db) {
		int startIndex = 0;
		int endIndex = 0;
		int sizeOfhashmap=0;
		for (int i = 0; i < customer_table_to_db.size(); i++) {

			if (i == 0) {
				startIndex = 0;
				endIndex = 0;
				continue;
			}
			if (customer_table_to_db.get(i - 1).getBill_number() == customer_table_to_db.get(i).getBill_number()) {

				continue;
			}

			if (customer_table_to_db.get(i - 1).getBill_number() != customer_table_to_db.get(i).getBill_number()) {
				endIndex = i - 1;

				ArrayList<customerModel> each_purchase_list_of_each_bill = new ArrayList<customerModel>();

				for (int j = startIndex; j <= endIndex; j++) {
					each_purchase_list_of_each_bill.add(customer_table_to_db.get(j));
				}

				hashmap_with_keyas_bill_number.put(customer_table_to_db.get(i - 1).getBill_number(),
						each_purchase_list_of_each_bill);

				startIndex = i;

			}

		}
		//new pdf_ceation(hashmap_with_keyas_bill_number,0).pdf_insert_data();	
		return 	hashmap_with_keyas_bill_number;
	}

}

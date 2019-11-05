package BasicsMaven;

import java.util.ArrayList;


public class pdf_logic {
public ArrayList<pojp_for_totalSum> billing_details( ArrayList<customerModel> billing_details){
ArrayList<pojp_for_totalSum> abc = new ArrayList<pojp_for_totalSum>();	
pojp_for_totalSum total_details = new pojp_for_totalSum();
int startIndex = 0;
int endIndex = 0;
int sumForsame=0;
for (int i=0;i<=billing_details.size();i++){
	if ((i==0) &&(billing_details.get(i).getBill_number() != billing_details.get(i+1).getBill_number())){
		total_details.setBill_number(billing_details.get(i).getBill_number());
		total_details.setTotal_sum(billing_details.get(i).getEach_billing_time_purchase_amount_id());

		abc.add(total_details);
	}
	
	if ((billing_details.get(i).getBill_number() != billing_details.get(i+1).getBill_number())&&(billing_details.get(i-1).getBill_number() != billing_details.get(i).getBill_number())){
		total_details.setBill_number(billing_details.get(i).getBill_number());
		total_details.setTotal_sum(billing_details.get(i).getEach_billing_time_purchase_amount_id());	
		abc.add(total_details);
	}
	
if ((billing_details.get(i).getBill_number() != billing_details.get(i+1).getBill_number())&&(billing_details.get(i-1).getBill_number() == billing_details.get(i).getBill_number())) {
		total_details.setBill_number(billing_details.get(i).getBill_number());
		total_details.setTotal_sum(sumForsame);	
		endIndex = i;

		
		for (int j = startIndex; j <= endIndex; j++) {
			abc.add(total_details);
		}

		startIndex = i+1;
		sumForsame=0;
		continue;
	}
if (billing_details.get(i).getBill_number() == billing_details.get(i+1).getBill_number()) {
	sumForsame=billing_details.get(i).getEach_billing_time_purchase_amount_id()+billing_details.get(i+1).getEach_billing_time_purchase_amount_id();
    continue;
}

}

return abc;
}

}

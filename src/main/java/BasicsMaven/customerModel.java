package BasicsMaven;
//Test

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class customerModel implements Comparable<customerModel>{
    /* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		//add Java Date Util to String of your foramt..
		//https://stackoverflow.com/questions/5683728/convert-java-util-date-to-string
		DateFormat format_date = new SimpleDateFormat("MM dd, yyyy", Locale.ENGLISH);
		return "customerModel [customer_ID=" + customer_ID +"   bill_number=  "+bill_number+ ", address=" + address + ", emaile=" + emaile
				+ ", last_name=" + last_name + ", phone=" + phone + ", first_name=" + first_name + 
			"created_date=" +format_date.format(this.created_date)
				+" updated_date= " +format_date.format(this.updated_date)+
				"quantity= "+quantity+
				"each billing time purchase amount_id= "+each_billing_time_purchase_amount_id+
				"unit price= "+unit_price+
				"]";
	}
	int  customer_ID  ;

private   String address ;
private String emaile ;
private String last_name ;
private String phone ;
private	String first_name ;
private	String gender ;
private Date created_date;
private Date updated_date;
private int quantity;
private int each_billing_time_purchase_amount_id;
private int unit_price;
private int Item_id;
private int bill_number;

public int getBill_number() {
	return bill_number;
}
public void setBill_number(int bill_number) {
	this.bill_number = bill_number;
}
public int getItem_id() {
	return Item_id;
}
public void setItem_id(int item_id) {
	Item_id = item_id;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public int getEach_billing_time_purchase_amount_id() {
	return each_billing_time_purchase_amount_id;
}
public void setEach_billing_time_purchase_amount_id(int each_billing_time_purchase_amount_id) {
	this.each_billing_time_purchase_amount_id = each_billing_time_purchase_amount_id;
}
public int getUnit_price() {
	return unit_price;
}
public void setUnit_price(int unit_price) {
	this.unit_price = unit_price;
}
/**
 * @return the updated_date
 */
public Date getUpdated_date() {
	return updated_date;
}
/**
 * @param updated_date the updated_date to set
 */
public void setUpdated_date(Date updated_date) {
	this.updated_date = updated_date;
}
public Date getCreated_date() {
	return created_date;
}
/**
 * @param created_date the created_date to set
 */
public void setCreated_date(Date created_date) {
	this.created_date = created_date;
}
/**
 * @return the customer_ID
 */
public int getCustomer_ID() {
	return customer_ID;
}
/**
 * @param customer_ID the customer_ID to set
 */
public void setCustomer_ID(int customer_ID) {
	this.customer_ID = customer_ID;
}
/**
 * @return the address
 */
public String getAddress() {
	return address;
}
/**
 * @param address the address to set
 */
public void setAddress(String address) {
	this.address = address;
}
/**
 * @return the emaile
 */
public String getEmaile() {
	return emaile;
}
/**
 * @param emaile the emaile to set
 */
public void setEmaile(String emaile) {
	this.emaile = emaile;
}
/**
 * @return the last_name
 */
public String getLast_name() {
	return last_name;
}
/**
 * @param last_name the last_name to set
 */
public void setLast_name(String last_name) {
	this.last_name = last_name;
}
/**
 * @return the phone
 */
public String getPhone() {
	return phone;
}
/**
 * @param phone the phone to set
 */
public void setPhone(String phone) {
	this.phone = phone;
}
/**
 * @return the first_name
 */
public String getFirst_name() {
	return first_name;
}
/**
 * @param first_name the first_name to set
 */
public void setFirst_name(String first_name) {
	this.first_name = first_name;
}
/**
 * @return the gender
 */
public String getGender() {
	return gender;
}
/**
 * @param gender the gender to set
 */
public void setGender(String gender) {
	this.gender = gender;
}

public int compareTo(customerModel o) {
	 if(MAIN.args_inputs[1].equals("created_date")) {
   	  if (this.created_date == null || o.created_date == null) {
 	        return 0;
   	  }
	      return this.created_date.compareTo(o.created_date);
	      }
     ///////////////////////////////////////////////////////////
     if(MAIN.args_inputs[1].equals("updated_date")) {
   	  if (this.updated_date == null || o.updated_date == null) {
   	        return 0;
     	  }
	      return this.updated_date.compareTo(o.updated_date);
	      }
     ///////////////////////////////////////////////////////////////
     if(MAIN.args_inputs[1].equals("customer_ID")) {
	      return new Integer(this.customer_ID).compareTo(new Integer(customer_ID));   
     }
     if(MAIN.args_inputs[1].equals("address")) {
	      return  this.address.compareTo(o.address);
	      }
     ///////////////////////////////////////////////////
     if(MAIN.args_inputs[1].equals("first_name")) {
	      return  this.first_name.compareTo(o.first_name);
	      }
     /////////////////////////////////////////////////
     if(MAIN.args_inputs[1].equals("last_name")) {
	      return this.last_name. compareTo(o.last_name);
	      }
     //////////////////////////////////////////////
     if(MAIN.args_inputs[1].equals("emaile")) {
	      return this.emaile.compareTo(o.emaile); 
	      }
     ///////////////////////////////////////
     if(MAIN.args_inputs[1].equals("item_id")) {
	      return new Integer(this.Item_id).compareTo(new Integer(o.Item_id));
	      }
     if(MAIN.args_inputs[1].equals("bill_number")) {
    	// System.out.println(new Integer(this.bill_number).compareTo(new Integer(o.bill_number)));
	      return new Integer(this.bill_number).compareTo(new Integer(o.bill_number));
	      }
     if(MAIN.args_inputs[1].equals("unit_price")) {
	      return new Integer(this.unit_price).compareTo(new Integer(o.unit_price));
	      }
     if(MAIN.args_inputs[1].equals("each_billing_time_purchase_amount_id")) {
	      return new Integer(this.each_billing_time_purchase_amount_id).compareTo(new Integer(o.each_billing_time_purchase_amount_id));
	      }
     
     if(MAIN.args_inputs[1].equals("phone")) {
	      return this.phone.compareTo( o.phone);
	      }
     if(MAIN.args_inputs[1].equals("quantity")) {
	      return new Integer(this.quantity).compareTo(new Integer(o.quantity));
	      }
     else{
     return 0;
     }
}
	


}

package BasicsMaven;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class customerModel {
    /* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		//add Java Date Util to String of your foramt..
		//https://stackoverflow.com/questions/5683728/convert-java-util-date-to-string
		DateFormat format_date = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
		return "customerModel [customer_ID=" + customer_ID + ", address=" + address + ", emaile=" + emaile
				+ ", last_name=" + last_name + ", phone=" + phone + ", first_name=" + first_name + ", gender=" + gender
				+ " created_date= " +format_date.format(this.created_date)
				+" updated_date= " +format_date.format(this.updated_date)+
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
	


}

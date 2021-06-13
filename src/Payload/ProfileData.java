package Payload;

import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProfileData {
	
	@JsonProperty(value="Name")
    String name;
	
	@JsonProperty(value="Email")
    String email;
	
	@JsonProperty(value="Phone")
    String phone;
	
	@JsonProperty(value="Gender")
    String gender;
    
    @JsonProperty(value="MSG-sms")
    boolean msgSMS;
    
    @JsonProperty(value="MSG-email")
    boolean msgEmail;
    
    @JsonProperty(value="MSG-whatsapp")
    boolean msgWhatsapp;
    
    @JsonProperty(value="MSG-dndPhone")
    boolean msgDndPhone;
    
    @JsonProperty(value="MSG-dndEmail")
    boolean msgDndEmail;
    
    @JsonProperty(value="category-unsubscribe")
    CategoryUnsubscribe categoryUnsubscribe;
    
    @JsonProperty(value="category-resubscribe")
    CategoryResubscribe categoryResubscribe;
   
    @JsonProperty(value="DOB")
    String dob;  
    
    @JsonProperty(value="Customer Type")
	String customerType;
    
    HashMap<String, Object> userInfo;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public boolean isMsgSMS() {
		return msgSMS;
	}

	public void setMsgSMS(boolean msgSMS) {
		this.msgSMS = msgSMS;
	}

	public boolean isMsgEmail() {
		return msgEmail;
	}

	public void setMsgEmail(boolean msgEmail) {
		this.msgEmail = msgEmail;
	}

	public boolean isMsgWhatsapp() {
		return msgWhatsapp;
	}

	public void setMsgWhatsapp(boolean msgWhatsapp) {
		this.msgWhatsapp = msgWhatsapp;
	}

	public boolean isMsgDndPhone() {
		return msgDndPhone;
	}

	public void setMsgDndPhone(boolean msgDndPhone) {
		this.msgDndPhone = msgDndPhone;
	}

	public boolean isMsgDndEmail() {
		return msgDndEmail;
	}

	public void setMsgDndEmail(boolean msgDndEmail) {
		this.msgDndEmail = msgDndEmail;
	}

	public CategoryUnsubscribe getCategoryUnsubscribe() {
		return categoryUnsubscribe;
	}

	public void setCategoryUnsubscribe(CategoryUnsubscribe categoryUnsubscribe) {
		this.categoryUnsubscribe = categoryUnsubscribe;
	}

	public CategoryResubscribe getCategoryResubscribe() {
		return categoryResubscribe;
	}

	public void setCategoryResubscribe(CategoryResubscribe categoryResubscribe) {
		this.categoryResubscribe = categoryResubscribe;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	public HashMap<String, Object> getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(HashMap<String, Object> userInfo) {
		this.userInfo = userInfo;
	}
    
    
}

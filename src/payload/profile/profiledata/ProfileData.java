package payload.profile.profiledata;

import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonProperty;

// TODO: Auto-generated Javadoc
/**
 * The Class ProfileData.
 */
public class ProfileData {
	
	/** The name. */
	@JsonProperty(value="Name")
	private String name;
	
	/** The email. */
	@JsonProperty(value="Email")
	private  String email;
	
	/** The phone. */
	@JsonProperty(value="Phone")
	private String phone;
	
	/** The gender. */
	@JsonProperty(value="Gender")
	private String gender;
    
    /** The msg SMS. */
    @JsonProperty(value="MSG-sms")
    private boolean msgSMS;
    
    /** The msg email. */
    @JsonProperty(value="MSG-email")
    private boolean msgEmail;
    
    /** The msg whatsapp. */
    @JsonProperty(value="MSG-whatsapp")
    private boolean msgWhatsapp;
    
    /** The msg dnd phone. */
    @JsonProperty(value="MSG-dndPhone")
    private boolean msgDndPhone;
    
    /** The msg dnd email. */
    @JsonProperty(value="MSG-dndEmail")
    private boolean msgDndEmail;
    
    /** The category unsubscribe. */
    @JsonProperty(value="category-unsubscribe")
    private CategoryUnsubscribe categoryUnsubscribe;
    
    /** The category resubscribe. */
    @JsonProperty(value="category-resubscribe")
    private CategoryResubscribe categoryResubscribe;
   
    /** The dob. */
    @JsonProperty(value="DOB")
    private String dob;  
    
    /** The customer type. */
    @JsonProperty(value="Customer Type")
    private String customerType;
    
    /** The user info. */
    private HashMap<String, Object> userInfo;

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the phone.
	 *
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * Sets the phone.
	 *
	 * @param phone the new phone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * Gets the gender.
	 *
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * Sets the gender.
	 *
	 * @param gender the new gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * Checks if is msg SMS.
	 *
	 * @return true, if is msg SMS
	 */
	public boolean isMsgSMS() {
		return msgSMS;
	}

	/**
	 * Sets the msg SMS.
	 *
	 * @param msgSMS the new msg SMS
	 */
	public void setMsgSMS(boolean msgSMS) {
		this.msgSMS = msgSMS;
	}

	/**
	 * Checks if is msg email.
	 *
	 * @return true, if is msg email
	 */
	public boolean isMsgEmail() {
		return msgEmail;
	}

	/**
	 * Sets the msg email.
	 *
	 * @param msgEmail the new msg email
	 */
	public void setMsgEmail(boolean msgEmail) {
		this.msgEmail = msgEmail;
	}

	/**
	 * Checks if is msg whatsapp.
	 *
	 * @return true, if is msg whatsapp
	 */
	public boolean isMsgWhatsapp() {
		return msgWhatsapp;
	}

	/**
	 * Sets the msg whatsapp.
	 *
	 * @param msgWhatsapp the new msg whatsapp
	 */
	public void setMsgWhatsapp(boolean msgWhatsapp) {
		this.msgWhatsapp = msgWhatsapp;
	}

	/**
	 * Checks if is msg dnd phone.
	 *
	 * @return true, if is msg dnd phone
	 */
	public boolean isMsgDndPhone() {
		return msgDndPhone;
	}

	/**
	 * Sets the msg dnd phone.
	 *
	 * @param msgDndPhone the new msg dnd phone
	 */
	public void setMsgDndPhone(boolean msgDndPhone) {
		this.msgDndPhone = msgDndPhone;
	}

	/**
	 * Checks if is msg dnd email.
	 *
	 * @return true, if is msg dnd email
	 */
	public boolean isMsgDndEmail() {
		return msgDndEmail;
	}

	/**
	 * Sets the msg dnd email.
	 *
	 * @param msgDndEmail the new msg dnd email
	 */
	public void setMsgDndEmail(boolean msgDndEmail) {
		this.msgDndEmail = msgDndEmail;
	}

	/**
	 * Gets the category unsubscribe.
	 *
	 * @return the category unsubscribe
	 */
	public CategoryUnsubscribe getCategoryUnsubscribe() {
		return categoryUnsubscribe;
	}

	/**
	 * Sets the category unsubscribe.
	 *
	 * @param categoryUnsubscribe the new category unsubscribe
	 */
	public void setCategoryUnsubscribe(CategoryUnsubscribe categoryUnsubscribe) {
		this.categoryUnsubscribe = categoryUnsubscribe;
	}

	/**
	 * Gets the category resubscribe.
	 *
	 * @return the category resubscribe
	 */
	public CategoryResubscribe getCategoryResubscribe() {
		return categoryResubscribe;
	}

	/**
	 * Sets the category resubscribe.
	 *
	 * @param categoryResubscribe the new category resubscribe
	 */
	public void setCategoryResubscribe(CategoryResubscribe categoryResubscribe) {
		this.categoryResubscribe = categoryResubscribe;
	}

	/**
	 * Gets the dob.
	 *
	 * @return the dob
	 */
	public String getDob() {
		return dob;
	}

	/**
	 * Sets the dob.
	 *
	 * @param dob the new dob
	 */
	public void setDob(String dob) {
		this.dob = dob;
	}

	/**
	 * Gets the customer type.
	 *
	 * @return the customer type
	 */
	public String getCustomerType() {
		return customerType;
	}

	/**
	 * Sets the customer type.
	 *
	 * @param customerType the new customer type
	 */
	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	/**
	 * Gets the user info.
	 *
	 * @return the user info
	 */
	public HashMap<String, Object> getUserInfo() {
		return userInfo;
	}

	/**
	 * Sets the user info.
	 *
	 * @param userInfo the user info
	 */
	public void setUserInfo(HashMap<String, Object> userInfo) {
		this.userInfo = userInfo;
	}
    
    
}

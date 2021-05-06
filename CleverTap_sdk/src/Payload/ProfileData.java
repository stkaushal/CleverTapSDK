package Payload;

public class ProfileData {
	
    String Name;
    String Email;
    String Phone;
    String Gender;
    boolean MSG_sms;
    boolean MSG_email;
    boolean MSG_whatsapp;
    boolean MSG_dndPhone;
    boolean MSG_dndEmail;
    CategoryUnsubscribe category_unsubscribe;
    CategoryResubscribe category_resubscribe;
    String DOB;   
    String Customer_Type;
    CustomMultiValue custom_multi_value;
    IncreDecre incre_decre;
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public boolean isMSG_sms() {
		return MSG_sms;
	}
	public void setMSG_sms(boolean mSG_sms) {
		MSG_sms = mSG_sms;
	}
	public boolean isMSG_email() {
		return MSG_email;
	}
	public void setMSG_email(boolean mSG_email) {
		MSG_email = mSG_email;
	}
	public boolean isMSG_whatsapp() {
		return MSG_whatsapp;
	}
	public void setMSG_whatsapp(boolean mSG_whatsapp) {
		MSG_whatsapp = mSG_whatsapp;
	}
	public boolean isMSG_dndPhone() {
		return MSG_dndPhone;
	}
	public void setMSG_dndPhone(boolean mSG_dndPhone) {
		MSG_dndPhone = mSG_dndPhone;
	}
	public boolean isMSG_dndEmail() {
		return MSG_dndEmail;
	}
	public void setMSG_dndEmail(boolean mSG_dndEmail) {
		MSG_dndEmail = mSG_dndEmail;
	}
	public CategoryUnsubscribe getCategory_unsubscribe() {
		return category_unsubscribe;
	}
	public void setCategory_unsubscribe(CategoryUnsubscribe category_unsubscribe) {
		this.category_unsubscribe = category_unsubscribe;
	}
	public CategoryResubscribe getCategory_resubscribe() {
		return category_resubscribe;
	}
	public void setCategory_resubscribe(CategoryResubscribe category_resubscribe) {
		this.category_resubscribe = category_resubscribe;
	}
	public String getDOB() {
		return DOB;
	}
	public void setDOB(String dOB) {
		DOB = dOB;
	}
	public String getCustomer_Type() {
		return Customer_Type;
	}
	public void setCustomer_Type(String customer_Type) {
		Customer_Type = customer_Type;
	}
	public CustomMultiValue getCustom_multi_value() {
		return custom_multi_value;
	}
	public void setCustom_multi_value(CustomMultiValue custom_multi_value) {
		this.custom_multi_value = custom_multi_value;
	}
	public IncreDecre getIncre_decre() {
		return incre_decre;
	}
	public void setIncre_decre(IncreDecre incre_decre) {
		this.incre_decre = incre_decre;
	}
  
}

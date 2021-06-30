package Payload.Report;

import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_DEFAULT)
public class ReportPayload {
	@JsonProperty(value="user_type")
	boolean userType;
	
	@JsonProperty(value="from")
	int fromDate;
	
	@JsonProperty(value="to")
	int toDate;
	
	String[] channel;
	String[] delivery;
	boolean daily;
	String[] status;
	String[] message_type;
	String[] lable;
	
	@JsonProperty(value="event_name")
	String eventName; 
	
	HashMap<String, Group> groups;
	
	@JsonProperty(value="unique")
	boolean isUnique;
	
	@JsonProperty(value="sum_event_prop")
	String sumEventProp;

	public boolean isUserType() {
		return userType;
	}

	public void setUserType(boolean userType) {
		this.userType = userType;
	}

	public int getFromDate() {
		return fromDate;
	}

	public void setFromDate(int fromDate) {
		this.fromDate = fromDate;
	}

	public int getToDate() {
		return toDate;
	}

	public void setToDate(int toDate) {
		this.toDate = toDate;
	}

	public String[] getChannel() {
		return channel;
	}

	public void setChannel(String[] channel) {
		this.channel = channel;
	}

	public String[] getDelivery() {
		return delivery;
	}

	public void setDelivery(String[] delivery) {
		this.delivery = delivery;
	}

	public boolean isDaily() {
		return daily;
	}

	public void setDaily(boolean daily) {
		this.daily = daily;
	}

	public String[] getStatus() {
		return status;
	}

	public void setStatus(String[] status) {
		this.status = status;
	}

	public String[] getMessage_type() {
		return message_type;
	}

	public void setMessage_type(String[] message_type) {
		this.message_type = message_type;
	}

	public String[] getLable() {
		return lable;
	}

	public void setLable(String[] lable) {
		this.lable = lable;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public HashMap<String, Group> getGroups() {
		return groups;
	}

	public void setGroups(HashMap<String, Group> groups) {
		this.groups = groups;
	}

	public boolean isUnique() {
		return isUnique;
	}

	public void setUnique(boolean isUnique) {
		this.isUnique = isUnique;
	}

	public String getSumEventProp() {
		return sumEventProp;
	}

	public void setSumEventProp(String sumEventProp) {
		this.sumEventProp = sumEventProp;
	}
	
	
	
	
}

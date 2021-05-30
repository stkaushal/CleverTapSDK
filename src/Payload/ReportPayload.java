package Payload;

import java.util.HashMap;

public class ReportPayload {
	boolean user_type;
	int from;
	int to;
	String[] channel;
	String[] delivery;
	boolean daily;
	String[] status;
	String[] message_type;
	String[] lable;
	String event_name; 
	HashMap<String, Group> groups;
	boolean unique;
	int sum_event_prop;
	
	public int getFrom() {
		return from;
	}
	public void setFrom(int from) {
		this.from = from;
	}
	public int getTo() {
		return to;
	}
	public void setTo(int to) {
		this.to = to;
	}
	public String[] getDelivery() {
		return delivery;
	}
	public void setDelivery(String[] delivery) {
		this.delivery = delivery;
	}
	public HashMap<String, Group> getGroups() {
		return groups;
	}
	public void setGroups(HashMap<String, Group> groups) {
		this.groups = groups;
	}
	public boolean isUser_type() {
		return user_type;
	}
	public void setUser_type(boolean user_type) {
		this.user_type = user_type;
	}
	public String[] getChannel() {
		return channel;
	}
	public void setChannel(String[] channel) {
		this.channel = channel;
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
	public String getEvent_name() {
		return event_name;
	}
	public void setEvent_name(String event_name) {
		this.event_name = event_name;
	}
	public boolean isUnique() {
		return unique;
	}
	public void setUnique(boolean unique) {
		this.unique = unique;
	}
	public int getSum_event_prop() {
		return sum_event_prop;
	}
	public void setSum_event_prop(int sum_event_prop) {
		this.sum_event_prop = sum_event_prop;
	}
	
}

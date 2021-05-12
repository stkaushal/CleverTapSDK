package Response;

import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Message {
	
	@JsonProperty(value="message id")
	long message_id;
	
	HashMap<String, String>[] data;
	String start_date;
	String[] device;
	String conversion_event;
	String[] labels;
	String channel;
	String message_name;
	String delivery;
	public long getMessage_id() {
		return message_id;
	}
	public void setMessage_id(long message_id) {
		this.message_id = message_id;
	}

	public HashMap<String, String>[] getData() {
		return data;
	}
	public void setData(HashMap<String, String>[] data) {
		this.data = data;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String[] getDevice() {
		return device;
	}
	public void setDevice(String[] device) {
		this.device = device;
	}
	public String getConversion_event() {
		return conversion_event;
	}
	public void setConversion_event(String conversion_event) {
		this.conversion_event = conversion_event;
	}
	public String[] getLabels() {
		return labels;
	}
	public void setLabels(String[] labels) {
		this.labels = labels;
	}
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	public String getMessage_name() {
		return message_name;
	}
	public void setMessage_name(String message_name) {
		this.message_name = message_name;
	}
	public String getDelivery() {
		return delivery;
	}
	public void setDelivery(String delivery) {
		this.delivery = delivery;
	}
}

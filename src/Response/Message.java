package Response;

import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Message {
	
	@JsonProperty(value="message id")
	long message_id;
	
	List<HashMap<String, String>> data;
	String start_date;
	List<String> device;
	Object conversion_event;
	List<String> lables;
	String channel;
	String message_name;
	String delivery;
	public long getMessage_id() {
		return message_id;
	}
	public void setMessage_id(long message_id) {
		this.message_id = message_id;
	}

	public List<HashMap<String, String>> getData() {
		return data;
	}
	public void setData(List<HashMap<String, String>> data) {
		this.data = data;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public List<String> getDevice() {
		return device;
	}
	public void setDevice(List<String> device) {
		this.device = device;
	}
	public Object getConversion_event() {
		return conversion_event;
	}
	public void setConversion_event(Object conversion_event) {
		this.conversion_event = conversion_event;
	}
	public List<String> getLables() {
		return lables;
	}
	public void setLables(List<String> lables) {
		this.lables = lables;
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

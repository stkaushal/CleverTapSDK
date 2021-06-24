package Response;

import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Message {
	
	@JsonProperty(value="message id")
	long messageId;
	
	List<HashMap<String, String>> data;
	
	@JsonProperty(value="start_date")
	String startDate;
	List<String> device;
	
	@JsonProperty(value="conversion_event")
	Object conversionEvent;
	
	List<String> lables;
	String channel;
	
	@JsonProperty(value="message_name")
	String messageName;
	
	String delivery;


	public long getMessageId() {
		return messageId;
	}

	public void setMessageId(long messageId) {
		this.messageId = messageId;
	}

	public List<HashMap<String, String>> getData() {
		return data;
	}

	public void setData(List<HashMap<String, String>> data) {
		this.data = data;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public List<String> getDevice() {
		return device;
	}

	public void setDevice(List<String> device) {
		this.device = device;
	}

	public Object getConversionEvent() {
		return conversionEvent;
	}

	public void setConversionEvent(Object conversionEvent) {
		this.conversionEvent = conversionEvent;
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

	public String getMessageName() {
		return messageName;
	}

	public void setMessageName(String messageName) {
		this.messageName = messageName;
	}

	public String getDelivery() {
		return delivery;
	}

	public void setDelivery(String delivery) {
		this.delivery = delivery;
	}
	
}

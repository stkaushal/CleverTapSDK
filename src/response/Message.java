package response;

import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

// TODO: Auto-generated Javadoc
/**
 * The Class Message.
 */
public class Message {
	
	/** The message id. */
	@JsonProperty(value="message id")
	long messageId;
	
	/** The data. */
	List<HashMap<String, String>> data;
	
	/** The start date. */
	@JsonProperty(value="start_date")
	String startDate;
	
	/** The device. */
	List<String> device;
	
	/** The conversion event. */
	@JsonProperty(value="conversion_event")
	Object conversionEvent;
	
	/** The lables. */
	List<String> lables;
	
	/** The channel. */
	String channel;
	
	/** The message name. */
	@JsonProperty(value="message_name")
	String messageName;
	
	/** The delivery. */
	String delivery;


	/**
	 * Gets the message id.
	 *
	 * @return the message id
	 */
	public long getMessageId() {
		return messageId;
	}

	/**
	 * Sets the message id.
	 *
	 * @param messageId the new message id
	 */
	public void setMessageId(long messageId) {
		this.messageId = messageId;
	}

	/**
	 * Gets the data.
	 *
	 * @return the data
	 */
	public List<HashMap<String, String>> getData() {
		return data;
	}

	/**
	 * Sets the data.
	 *
	 * @param data the data
	 */
	public void setData(List<HashMap<String, String>> data) {
		this.data = data;
	}

	/**
	 * Gets the start date.
	 *
	 * @return the start date
	 */
	public String getStartDate() {
		return startDate;
	}

	/**
	 * Sets the start date.
	 *
	 * @param startDate the new start date
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	/**
	 * Gets the device.
	 *
	 * @return the device
	 */
	public List<String> getDevice() {
		return device;
	}

	/**
	 * Sets the device.
	 *
	 * @param device the new device
	 */
	public void setDevice(List<String> device) {
		this.device = device;
	}

	/**
	 * Gets the conversion event.
	 *
	 * @return the conversion event
	 */
	public Object getConversionEvent() {
		return conversionEvent;
	}

	/**
	 * Sets the conversion event.
	 *
	 * @param conversionEvent the new conversion event
	 */
	public void setConversionEvent(Object conversionEvent) {
		this.conversionEvent = conversionEvent;
	}

	/**
	 * Gets the lables.
	 *
	 * @return the lables
	 */
	public List<String> getLables() {
		return lables;
	}

	/**
	 * Sets the lables.
	 *
	 * @param lables the new lables
	 */
	public void setLables(List<String> lables) {
		this.lables = lables;
	}

	/**
	 * Gets the channel.
	 *
	 * @return the channel
	 */
	public String getChannel() {
		return channel;
	}

	/**
	 * Sets the channel.
	 *
	 * @param channel the new channel
	 */
	public void setChannel(String channel) {
		this.channel = channel;
	}

	/**
	 * Gets the message name.
	 *
	 * @return the message name
	 */
	public String getMessageName() {
		return messageName;
	}

	/**
	 * Sets the message name.
	 *
	 * @param messageName the new message name
	 */
	public void setMessageName(String messageName) {
		this.messageName = messageName;
	}

	/**
	 * Gets the delivery.
	 *
	 * @return the delivery
	 */
	public String getDelivery() {
		return delivery;
	}

	/**
	 * Sets the delivery.
	 *
	 * @param delivery the new delivery
	 */
	public void setDelivery(String delivery) {
		this.delivery = delivery;
	}
	
}

package payload.report;

import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

// TODO: Auto-generated Javadoc
/**
 * The Class ReportPayload.
 */
@JsonInclude(Include.NON_DEFAULT)
public class ReportPayload {
	
	/** The user type. */
	@JsonProperty(value="user_type")
	private boolean userType;
	
	/** The from date. */
	@JsonProperty(value="from")
	private Object fromDate;
	
	/** The to date. */
	@JsonProperty(value="to")
	private Object toDate;
	
	/** The channel. */
	private String[] channel;
	
	/** The delivery. */
	private String[] delivery;
	
	/** The daily. */
	private boolean daily;
	
	/** The status. */
	private String[] status;
	
	/** The message type. */
	private String[] message_type;
	
	/** The lable. */
	private String[] lable;
	
	/** The event name. */
	@JsonProperty(value="event_name")
	private String eventName; 
	
	/** The groups. */
	private HashMap<String, Group> groups;
	
	/** The is unique. */
	@JsonProperty(value="unique")
	private boolean isUnique;
	
	/** The sum event prop. */
	@JsonProperty(value="sum_event_prop")
	private String sumEventProp;

	/**
	 * Checks if is user type.
	 *
	 * @return true, if is user type
	 */
	public boolean isUserType() {
		return userType;
	}

	/**
	 * Sets the user type.
	 *
	 * @param userType the new user type
	 */
	public void setUserType(boolean userType) {
		this.userType = userType;
	}

	/**
	 * Gets the from date.
	 *
	 * @return the from date
	 */
	public Object getFromDate() {
		return fromDate;
	}

	/**
	 * Sets the from date (date is int type).
	 *
	 * @param fromDate the new from date
	 */
	public void setFromDate(int fromDate) {
		this.fromDate = fromDate;
	}
	/**
	 * Sets the from date (date is string type).
	 *
	 * @param fromDate the new from date
	 */
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	/**
	 * Gets the to date.
	 *
	 * @return the to date
	 */
	public Object getToDate() {
		return toDate;
	}

	/**
	 * Sets the to date (date is int type).
	 *
	 * @param toDate the new to date
	 */
	public void setToDate(int toDate) {
		this.toDate = toDate;
	}
	
	/**
	 * Sets the to date (date is string type).
	 *
	 * @param toDate the new to date
	 */
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	/**
	 * Gets the channel.
	 *
	 * @return the channel
	 */
	public String[] getChannel() {
		return channel;
	}

	/**
	 * Sets the channel.
	 *
	 * @param channel the new channel
	 */
	public void setChannel(String[] channel) {
		this.channel = channel;
	}

	/**
	 * Gets the delivery.
	 *
	 * @return the delivery
	 */
	public String[] getDelivery() {
		return delivery;
	}

	/**
	 * Sets the delivery.
	 *
	 * @param delivery the new delivery
	 */
	public void setDelivery(String[] delivery) {
		this.delivery = delivery;
	}

	/**
	 * Checks if is daily.
	 *
	 * @return true, if is daily
	 */
	public boolean isDaily() {
		return daily;
	}

	/**
	 * Sets the daily.
	 *
	 * @param daily the new daily
	 */
	public void setDaily(boolean daily) {
		this.daily = daily;
	}

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public String[] getStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(String[] status) {
		this.status = status;
	}

	/**
	 * Gets the message type.
	 *
	 * @return the message type
	 */
	public String[] getMessage_type() {
		return message_type;
	}

	/**
	 * Sets the message type.
	 *
	 * @param message_type the new message type
	 */
	public void setMessage_type(String[] message_type) {
		this.message_type = message_type;
	}

	/**
	 * Gets the lable.
	 *
	 * @return the lable
	 */
	public String[] getLable() {
		return lable;
	}

	/**
	 * Sets the lable.
	 *
	 * @param lable the new lable
	 */
	public void setLable(String[] lable) {
		this.lable = lable;
	}

	/**
	 * Gets the event name.
	 *
	 * @return the event name
	 */
	public String getEventName() {
		return eventName;
	}

	/**
	 * Sets the event name.
	 *
	 * @param eventName the new event name
	 */
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	/**
	 * Gets the groups.
	 *
	 * @return the groups
	 */
	public HashMap<String, Group> getGroups() {
		return groups;
	}

	/**
	 * Sets the groups.
	 *
	 * @param groups the groups
	 */
	public void setGroups(HashMap<String, Group> groups) {
		this.groups = groups;
	}

	/**
	 * Checks if is unique.
	 *
	 * @return true, if is unique
	 */
	public boolean isUnique() {
		return isUnique;
	}

	/**
	 * Sets the unique.
	 *
	 * @param isUnique the new unique
	 */
	public void setUnique(boolean isUnique) {
		this.isUnique = isUnique;
	}

	/**
	 * Gets the sum event prop.
	 *
	 * @return the sum event prop
	 */
	public String getSumEventProp() {
		return sumEventProp;
	}

	/**
	 * Sets the sum event prop.
	 *
	 * @param sumEventProp the new sum event prop
	 */
	public void setSumEventProp(String sumEventProp) {
		this.sumEventProp = sumEventProp;
	}
	
	
	
	
}

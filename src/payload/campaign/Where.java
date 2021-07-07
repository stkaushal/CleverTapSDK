package payload.campaign;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

// TODO: Auto-generated Javadoc
/**
 * The Class Where.
 */
@JsonInclude(Include.NON_DEFAULT)
public class Where {
	
	/** The event name. */
	@JsonProperty(value="event_name")
	String eventName;
	
	/** The from date. */
	@JsonProperty(value="from")
	int fromDate;
	
	/** The to date. */
	@JsonProperty(value="to")
	int toDate;
	
	/** The common profile properties. */
	@JsonProperty(value="common_profile_properties")
	CommonProfileProperties commonProfileProperties;

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
	 * Gets the from date.
	 *
	 * @return the from date
	 */
	public int getFromDate() {
		return fromDate;
	}

	/**
	 * Sets the from date.
	 *
	 * @param fromDate the new from date
	 */
	public void setFromDate(int fromDate) {
		this.fromDate = fromDate;
	}

	/**
	 * Gets the to date.
	 *
	 * @return the to date
	 */
	public int getToDate() {
		return toDate;
	}

	/**
	 * Sets the to date.
	 *
	 * @param toDate the new to date
	 */
	public void setToDate(int toDate) {
		this.toDate = toDate;
	}

	/**
	 * Gets the common profile properties.
	 *
	 * @return the common profile properties
	 */
	public CommonProfileProperties getCommonProfileProperties() {
		return commonProfileProperties;
	}

	/**
	 * Sets the common profile properties.
	 *
	 * @param commonProfileProperties the new common profile properties
	 */
	public void setCommonProfileProperties(CommonProfileProperties commonProfileProperties) {
		this.commonProfileProperties = commonProfileProperties;
	}
	
}

package payload.event;

import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

// TODO: Auto-generated Javadoc
/**
 * The Class EventPayload.
 */
@JsonInclude(Include.NON_DEFAULT)
public class EventPayload {
	
	/** The from date. */
	@JsonProperty(value="from")
	private int fromDate;
	
	/** The to date. */
	@JsonProperty(value="to")
	private int toDate; 
	
	/** The type. */
	private String type;
	
	/** The event name upload. */
	@JsonProperty(value="evtName")
	private String eventNameUpload;
	
	/** The timestamp. */
	private String timestamp;
	
	/** The event data. */
	@JsonProperty(value="evtData")
	private HashMap<String, Object> eventData;
	
	/** The event name download. */
	@JsonProperty(value="event_name")
	private String eventNameDownload;
	
	/** The event properties. */
	@JsonProperty(value="event_properties")
	private List<EventPropertyFilter> eventProperties;
	
	/** The ts. */
	private long ts;
	
	/** The identity. */
	private String identity;
	
	/** The fbid. */
	@JsonProperty(value="FBID")
	private String fbid;
	
	/** The gpid. */
	@JsonProperty(value="GPID")
	private String gpid;
	
	/** The object id. */
	private String objectId;

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
	 * Gets the type.
	 *
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * Sets the type.
	 *
	 * @param type the new type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Gets the event name upload.
	 *
	 * @return the event name upload
	 */
	public String getEventNameUpload() {
		return eventNameUpload;
	}

	/**
	 * Sets the event name upload.
	 *
	 * @param eventNameUpload the new event name upload
	 */
	public void setEventNameUpload(String eventNameUpload) {
		this.eventNameUpload = eventNameUpload;
	}

	/**
	 * Gets the timestamp.
	 *
	 * @return the timestamp
	 */
	public String getTimestamp() {
		return timestamp;
	}

	/**
	 * Sets the timestamp.
	 *
	 * @param timestamp the new timestamp
	 */
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	/**
	 * Gets the event data.
	 *
	 * @return the event data
	 */
	public HashMap<String, Object> getEventData() {
		return eventData;
	}

	/**
	 * Sets the event data.
	 *
	 * @param eventData the event data
	 */
	public void setEventData(HashMap<String, Object> eventData) {
		this.eventData = eventData;
	}

	/**
	 * Gets the event name download.
	 *
	 * @return the event name download
	 */
	public String getEventNameDownload() {
		return eventNameDownload;
	}

	/**
	 * Sets the event name download.
	 *
	 * @param eventNameDownload the new event name download
	 */
	public void setEventNameDownload(String eventNameDownload) {
		this.eventNameDownload = eventNameDownload;
	}

	/**
	 * Gets the event properties.
	 *
	 * @return the event properties
	 */
	public List<EventPropertyFilter> getEventProperties() {
		return eventProperties;
	}

	/**
	 * Sets the event properties.
	 *
	 * @param eventProperties the new event properties
	 */
	public void setEventProperties(List<EventPropertyFilter> eventProperties) {
		this.eventProperties = eventProperties;
	}

	/**
	 * Gets the ts.
	 *
	 * @return the ts
	 */
	public long getTs() {
		return ts;
	}

	/**
	 * Sets the ts.
	 *
	 * @param ts the new ts
	 */
	public void setTs(long ts) {
		this.ts = ts;
	}

	/**
	 * Gets the identity.
	 *
	 * @return the identity
	 */
	public String getIdentity() {
		return identity;
	}

	/**
	 * Sets the identity.
	 *
	 * @param identity the new identity
	 */
	public void setIdentity(String identity) {
		this.identity = identity;
	}

	/**
	 * Gets the fbid.
	 *
	 * @return the fbid
	 */
	public String getFbid() {
		return fbid;
	}

	/**
	 * Sets the fbid.
	 *
	 * @param fbid the new fbid
	 */
	public void setFbid(String fbid) {
		this.fbid = fbid;
	}

	/**
	 * Gets the gpid.
	 *
	 * @return the gpid
	 */
	public String getGpid() {
		return gpid;
	}

	/**
	 * Sets the gpid.
	 *
	 * @param gpid the new gpid
	 */
	public void setGpid(String gpid) {
		this.gpid = gpid;
	}

	/**
	 * Gets the object id.
	 *
	 * @return the object id
	 */
	public String getObjectId() {
		return objectId;
	}

	/**
	 * Sets the object id.
	 *
	 * @param objectId the new object id
	 */
	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}
	
	
}

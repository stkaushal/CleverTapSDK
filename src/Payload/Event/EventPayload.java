package Payload.Event;

import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_DEFAULT)
public class EventPayload {
	
	@JsonProperty(value="from")
	int fromDate;
	
	@JsonProperty(value="to")
	int toDate; 
	
	String type;
	
	@JsonProperty(value="evtName")
	String eventNameUpload;
	
	String timestamp;
	
	@JsonProperty(value="evtData")
	HashMap<String, Object> eventData;
	
	@JsonProperty(value="event_name")
	String eventNameDownload;
	
	@JsonProperty(value="event_properties")
	List<EventPropertyFilter> eventProperties;
	
	long ts;
	String identity;
	
	@JsonProperty(value="FBID")
	String fbid;
	
	@JsonProperty(value="GPID")
	String gpid;
	
	String objectId;

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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getEventNameUpload() {
		return eventNameUpload;
	}

	public void setEventNameUpload(String eventNameUpload) {
		this.eventNameUpload = eventNameUpload;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public HashMap<String, Object> getEventData() {
		return eventData;
	}

	public void setEventData(HashMap<String, Object> eventData) {
		this.eventData = eventData;
	}

	public String getEventNameDownload() {
		return eventNameDownload;
	}

	public void setEventNameDownload(String eventNameDownload) {
		this.eventNameDownload = eventNameDownload;
	}

	public List<EventPropertyFilter> getEventProperties() {
		return eventProperties;
	}

	public void setEventProperties(List<EventPropertyFilter> eventProperties) {
		this.eventProperties = eventProperties;
	}

	public long getTs() {
		return ts;
	}

	public void setTs(long ts) {
		this.ts = ts;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public String getFbid() {
		return fbid;
	}

	public void setFbid(String fbid) {
		this.fbid = fbid;
	}

	public String getGpid() {
		return gpid;
	}

	public void setGpid(String gpid) {
		this.gpid = gpid;
	}

	public String getObjectId() {
		return objectId;
	}

	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}
	
	
}

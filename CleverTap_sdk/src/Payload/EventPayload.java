package Payload;

import java.util.HashMap;

public class EventPayload {
	String event_name;
	int from;
	int to; 
	String type;
	String evtName;
	String timestamp;
	HashMap<String, String> evtData;
	HashMap<String, String> event_properties;
	long ts;
	String identity;
	String FBID;
	String GPID;
	String objectId;
	
	
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
	public String getEvtName() {
		return evtName;
	}
	public void setEvtName(String evtName) {
		this.evtName = evtName;
	}
	public HashMap<String, String> getEvtData() {
		return evtData;
	}
	public void setEvtData(HashMap<String, String> evtData) {
		this.evtData = evtData;
	}
	public long getTs() {
		return ts;
	}
	public void setTs(long ts) {
		this.ts = ts;
	}
	public String getFBID() {
		return FBID;
	}
	public void setFBID(String fBID) {
		FBID = fBID;
	}
	public String getGPID() {
		return GPID;
	}
	public void setGPID(String gPID) {
		GPID = gPID;
	}
	public String getEvent_name() {
		return event_name;
	}
	public void setEvent_name(String event_name) {
		this.event_name = event_name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getIdentity() {
		return identity;
	}
	public void setIdentity(String identity) {
		this.identity = identity;
	}
	public String getObjectId() {
		return objectId;
	}
	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}
	public HashMap<String, String> getEvent_properties() {
		return event_properties;
	}
	public void setEvent_properties(HashMap<String, String> event_properties) {
		this.event_properties = event_properties;
	}

}

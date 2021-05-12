package Payload;

import java.util.HashMap;

public class ProfilePayload {
	String[] identity;
	String[] indentities; 
	String objectId;
	String[] guid;
	String FBID;
	String event_name; 
	TokenData tokenData;
	int from;
	int to;
	String ts;
	ProfileData profileData;
	HashMap<String, String> event_properties;
	String status; 
	String type;
	String value;
	
	public String[] getIdentity() {
		return identity;
	}
	public void setIdentity(String[] identity) {
		this.identity = identity;
	}
	public String[] getGuid() {
		return guid;
	}
	public void setGuid(String[] guid) {
		this.guid = guid;
	}
	public HashMap<String, String> getEvent_properties() {
		return event_properties;
	}
	public void setEvent_properties(HashMap<String, String> event_properties) {
		this.event_properties = event_properties;
	}
	public String getFBID() {
		return FBID;
	}
	public void setFBID(String fBID) {
		FBID = fBID;
	}
	public String getTs() {
		return ts;
	}
	public void setTs(String ts) {
		this.ts = ts;
	}
	
	public String[] getIndentities() {
		return indentities;
	}
	public void setIndentities(String[] indentities) {
		this.indentities = indentities;
	}
	public String getObjectId() {
		return objectId;
	}
	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}
	
	public String getEvent_name() {
		return event_name;
	}
	public void setEvent_name(String event_name) {
		this.event_name = event_name;
	}
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
	public TokenData getTokenData() {
		return tokenData;
	}
	public void setTokenData(TokenData tokenData) {
		this.tokenData = tokenData;
	}
	
	public ProfileData getProfileData() {
		return profileData;
	}
	public void setProfileData(ProfileData profileData) {
		this.profileData = profileData;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	
}

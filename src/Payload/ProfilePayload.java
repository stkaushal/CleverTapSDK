package Payload;

import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_DEFAULT)
public class ProfilePayload {
	
	@JsonProperty(value="identity")
	Object userIdentity;
	
	@JsonProperty(value="ts")
	String timestamp;
	
	String type;
	ProfileData profileData;
	
	TokenData tokenData;
	
	@JsonProperty(value="FBID")
	String fbId;
	
	String[] identities; 
	String objectId;
	String[] guid;
	
	@JsonProperty(value="event_name")
	String eventName; 
	
	@JsonProperty(value="from")
	int fromDate;
	
	@JsonProperty(value="to")
	int toDate;
	
	@JsonProperty(value="event_properties")
	HashMap<String, String> eventProperties;
	String status; 
	
	String value;

	public Object getUserIdentity() {
		return userIdentity;
	}

	public void setUserIdentity(String userIdentity) {
		this.userIdentity = userIdentity;
	}
	
	public void setUserIdentity(String[] userIdentity) {
		this.userIdentity = userIdentity;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public ProfileData getProfileData() {
		return profileData;
	}

	public void setProfileData(ProfileData profileData) {
		this.profileData = profileData;
	}


	public String[] getIdentities() {
		return identities;
	}

	public void setIdentities(String[] identities) {
		this.identities = identities;
	}

	public String getObjectId() {
		return objectId;
	}

	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}

	public String[] getGuid() {
		return guid;
	}

	public void setGuid(String[] guid) {
		this.guid = guid;
	}

	public String getFbId() {
		return fbId;
	}

	public void setFbId(String fbId) {
		this.fbId = fbId;
	}

	
	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public TokenData getTokenData() {
		return tokenData;
	}

	public void setTokenData(TokenData tokenData) {
		this.tokenData = tokenData;
	}

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

	public HashMap<String, String> getEventProperties() {
		return eventProperties;
	}

	public void setEventProperties(HashMap<String, String> eventProperties) {
		this.eventProperties = eventProperties;
	}

	public void setUserIdentity(Object userIdentity) {
		this.userIdentity = userIdentity;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	
	
}

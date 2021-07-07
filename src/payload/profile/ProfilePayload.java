package payload.profile;

import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import payload.profile.profiledata.ProfileData;

import com.fasterxml.jackson.annotation.JsonProperty;

// TODO: Auto-generated Javadoc
/**
 * The Class ProfilePayload.
 */
@JsonInclude(Include.NON_DEFAULT)
public class ProfilePayload {
	
	/** The user identity. */
	@JsonProperty(value="identity")
	Object userIdentity;
	
	/** The timestamp. */
	@JsonProperty(value="ts")
	String timestamp;
	
	/** The type. */
	String type;
	
	/** The profile data. */
	ProfileData profileData;
	
	/** The token data. */
	TokenData tokenData;
	
	/** The fb id. */
	@JsonProperty(value="FBID")
	String fbId;
	
	/** The identities. */
	String[] identities; 
	
	/** The object id. */
	String objectId;
	
	/** The guid. */
	String[] guid;
	
	/** The event name. */
	@JsonProperty(value="event_name")
	String eventName; 
	
	/** The from date. */
	@JsonProperty(value="from")
	int fromDate;
	
	/** The to date. */
	@JsonProperty(value="to")
	int toDate;
	
	/** The event properties. */
	@JsonProperty(value="event_properties")
	HashMap<String, String> eventProperties;
	
	/** The status. */
	String status; 
	
	/** The value. */
	String value;

	/**
	 * Gets the user identity.
	 *
	 * @return the user identity
	 */
	public Object getUserIdentity() {
		return userIdentity;
	}

	/**
	 * Sets the user identity.
	 *
	 * @param userIdentity the new user identity
	 */
	public void setUserIdentity(String userIdentity) {
		this.userIdentity = userIdentity;
	}
	
	/**
	 * Sets the user identity.
	 *
	 * @param userIdentity the new user identity
	 */
	public void setUserIdentity(String[] userIdentity) {
		this.userIdentity = userIdentity;
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
	 * Gets the profile data.
	 *
	 * @return the profile data
	 */
	public ProfileData getProfileData() {
		return profileData;
	}

	/**
	 * Sets the profile data.
	 *
	 * @param profileData the new profile data
	 */
	public void setProfileData(ProfileData profileData) {
		this.profileData = profileData;
	}


	/**
	 * Gets the identities.
	 *
	 * @return the identities
	 */
	public String[] getIdentities() {
		return identities;
	}

	/**
	 * Sets the identities.
	 *
	 * @param identities the new identities
	 */
	public void setIdentities(String[] identities) {
		this.identities = identities;
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

	/**
	 * Gets the guid.
	 *
	 * @return the guid
	 */
	public String[] getGuid() {
		return guid;
	}

	/**
	 * Sets the guid.
	 *
	 * @param guid the new guid
	 */
	public void setGuid(String[] guid) {
		this.guid = guid;
	}

	/**
	 * Gets the fb id.
	 *
	 * @return the fb id
	 */
	public String getFbId() {
		return fbId;
	}

	/**
	 * Sets the fb id.
	 *
	 * @param fbId the new fb id
	 */
	public void setFbId(String fbId) {
		this.fbId = fbId;
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
	 * Gets the token data.
	 *
	 * @return the token data
	 */
	public TokenData getTokenData() {
		return tokenData;
	}

	/**
	 * Sets the token data.
	 *
	 * @param tokenData the new token data
	 */
	public void setTokenData(TokenData tokenData) {
		this.tokenData = tokenData;
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
	 * Gets the event properties.
	 *
	 * @return the event properties
	 */
	public HashMap<String, String> getEventProperties() {
		return eventProperties;
	}

	/**
	 * Sets the event properties.
	 *
	 * @param eventProperties the event properties
	 */
	public void setEventProperties(HashMap<String, String> eventProperties) {
		this.eventProperties = eventProperties;
	}

	/**
	 * Sets the user identity.
	 *
	 * @param userIdentity the new user identity
	 */
	public void setUserIdentity(Object userIdentity) {
		this.userIdentity = userIdentity;
	}

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * Sets the value.
	 *
	 * @param value the new value
	 */
	public void setValue(String value) {
		this.value = value;
	}

	
	
}

package response;

import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;

// TODO: Auto-generated Javadoc
/**
 * The Class RecordsProfile.
 */
public class RecordsProfile {
	
	/** The email. */
	private String email;
	
	/** The name. */
	private String name;
	
	/** The identity. */
	private String identity;
	
	/** The profile data. */
	private HashMap<String, Object> profileData;
	
	/** The events. */
	private HashMap<String, Object> events;
	
	/** The platform info. */
	private List<HashMap<String, Object>> platformInfo;
	
	/** The other info. */
	private HashMap<String, Object> otherInfo;
	
	/**
	 * Gets the other info.
	 *
	 * @return the other info
	 */
	@JsonAnyGetter
	public HashMap<String, Object> getOtherInfo() {
		return otherInfo;
	}
	
	/**
	 * Sets the other info.
	 *
	 * @param key the key
	 * @param value the value
	 */
	@JsonAnySetter
	public void setOtherInfo(String key, Object value) {
		if(this.otherInfo == null) {
			this.otherInfo = new HashMap<String,Object>();
		}
		this.otherInfo.put(key,value);
	}
	
	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
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
	 * Gets the profile data.
	 *
	 * @return the profile data
	 */
	public HashMap<String, Object> getProfileData() {
		return profileData;
	}
	
	/**
	 * Sets the profile data.
	 *
	 * @param profileData the profile data
	 */
	public void setProfileData(HashMap<String, Object> profileData) {
		this.profileData = profileData;
	}
	
	/**
	 * Gets the events.
	 *
	 * @return the events
	 */
	public HashMap<String, Object> getEvents() {
		return events;
	}
	
	/**
	 * Sets the events.
	 *
	 * @param events the events
	 */
	public void setEvents(HashMap<String, Object> events) {
		this.events = events;
	}
	
	/**
	 * Gets the platform info.
	 *
	 * @return the platform info
	 */
	public List<HashMap<String, Object>> getPlatformInfo() {
		return platformInfo;
	}
	
	/**
	 * Sets the platform info.
	 *
	 * @param platformInfo the platform info
	 */
	public void setPlatformInfo(List<HashMap<String, Object>> platformInfo) {
		this.platformInfo = platformInfo;
	}
	
}

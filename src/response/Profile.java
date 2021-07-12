package response;

import java.util.HashMap;

// TODO: Auto-generated Javadoc
/**
 * The Class Profile.
 */
public class Profile {
	
	/** The object id. */
	private String objectId;
	
	/** The platform. */
	private String platform;
	
	/** The email. */
	private String email;
	
	/** The profile data. */
	private HashMap<String, Object> profileData;
	
	/** The identity. */
	private Object identity;
	
	/** The id. */
	private int id;
	
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
	 * Gets the platform.
	 *
	 * @return the platform
	 */
	public String getPlatform() {
		return platform;
	}
	
	/**
	 * Sets the platform.
	 *
	 * @param platform the new platform
	 */
	public void setPlatform(String platform) {
		this.platform = platform;
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
	 * Gets the identity.
	 *
	 * @return the identity
	 */
	public Object getIdentity() {
		return identity;
	}
	
	/**
	 * Sets the identity.
	 *
	 * @param identity the new identity
	 */
	public void setIdentity(Object identity) {
		this.identity = identity;
	}
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(int id) {
		this.id = id;
	}
}

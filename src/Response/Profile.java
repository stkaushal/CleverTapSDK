package Response;

import java.util.HashMap;

public class Profile {
	String objectId;
	String platform;
	String email;
	HashMap<String, String> profileData;
	long identity;
	int id;
	
	public String getObjectId() {
		return objectId;
	}
	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}
	public String getPlatform() {
		return platform;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public HashMap<String, String> getProfileData() {
		return profileData;
	}
	public void setProfileData(HashMap<String, String> profileData) {
		this.profileData = profileData;
	}
	public long getIdentity() {
		return identity;
	}
	public void setIdentity(long identity) {
		this.identity = identity;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}

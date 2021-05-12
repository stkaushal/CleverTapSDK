package Response;

import java.util.HashMap;

public class RecordsProfile {
	String email;
	String name;
	String identity;
	HashMap<String, String> profileData;
	HashMap<String, Object> events;
	HashMap<String, Object> platformInfo;
	
	
	public HashMap<String, String> getProfileData() {
		return profileData;
	}
	public void setProfileData(HashMap<String, String> profileData) {
		this.profileData = profileData;
	}
	public HashMap<String, Object> getEvents() {
		return events;
	}
	public void setEvents(HashMap<String, Object> events) {
		this.events = events;
	}
	public HashMap<String, Object> getPlatformInfo() {
		return platformInfo;
	}
	public void setPlatformInfo(HashMap<String, Object> platformInfo) {
		this.platformInfo = platformInfo;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIdentity() {
		return identity;
	}
	public void setIdentity(String identity) {
		this.identity = identity;
	}
	
}

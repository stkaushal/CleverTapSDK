package Response;

import java.util.HashMap;
import java.util.List;

public class RecordsProfile {
	String email;
	String name;
	String identity;
	HashMap<String, Object> profileData;
	HashMap<String, Object> events;
	List<HashMap<String, Object>> platformInfo;
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
	public HashMap<String, Object> getProfileData() {
		return profileData;
	}
	public void setProfileData(HashMap<String, Object> profileData) {
		this.profileData = profileData;
	}
	public HashMap<String, Object> getEvents() {
		return events;
	}
	public void setEvents(HashMap<String, Object> events) {
		this.events = events;
	}
	public List<HashMap<String, Object>> getPlatformInfo() {
		return platformInfo;
	}
	public void setPlatformInfo(List<HashMap<String, Object>> platformInfo) {
		this.platformInfo = platformInfo;
	}
	
}

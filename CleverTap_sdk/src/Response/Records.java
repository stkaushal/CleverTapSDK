package Response;

public class Records {
	String email;
	String name;
	String identity;
	String profileData;
	String[] platformInfo;
	String events;
	String event_props;
	String session_props;
	String session_source;
	
	public String getEvent_props() {
		return event_props;
	}
	public void setEvent_props(String event_props) {
		this.event_props = event_props;
	}
	public String getSession_props() {
		return session_props;
	}
	public void setSession_props(String session_props) {
		this.session_props = session_props;
	}
	public String getSession_source() {
		return session_source;
	}
	public void setSession_source(String session_source) {
		this.session_source = session_source;
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
	public String getProfileData() {
		return profileData;
	}
	public void setProfileData(String profileData) {
		this.profileData = profileData;
	}
	public String[] getPlatformInfo() {
		return platformInfo;
	}
	public void setPlatformInfo(String[] platformInfo) {
		this.platformInfo = platformInfo;
	}
	public String getEvents() {
		return events;
	}
	public void setEvents(String events) {
		this.events = events;
	}
}

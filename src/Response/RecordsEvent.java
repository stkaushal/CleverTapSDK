package Response;

import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RecordsEvent {
	
	Profile profile;
	
	@JsonProperty(value="ts")
	long timestamp;
	
	@JsonProperty(value="event_props")
	HashMap<String, String> eventProps;
	
	@JsonProperty(value="session_props")
	HashMap<String, String> sessionProps;

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public HashMap<String, String> getEventProps() {
		return eventProps;
	}

	public void setEventProps(HashMap<String, String> eventProps) {
		this.eventProps = eventProps;
	}

	public HashMap<String, String> getSessionProps() {
		return sessionProps;
	}

	public void setSessionProps(HashMap<String, String> sessionProps) {
		this.sessionProps = sessionProps;
	}
	
	
}

package response;

import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonProperty;

// TODO: Auto-generated Javadoc
/**
 * The Class RecordsEvent.
 */
public class RecordsEvent {
	
	/** The profile. */
	Profile profile;
	
	/** The timestamp. */
	@JsonProperty(value="ts")
	long timestamp;
	
	/** The event props. */
	@JsonProperty(value="event_props")
	HashMap<String, String> eventProps;
	
	/** The session props. */
	@JsonProperty(value="session_props")
	HashMap<String, String> sessionProps;

	/**
	 * Gets the profile.
	 *
	 * @return the profile
	 */
	public Profile getProfile() {
		return profile;
	}

	/**
	 * Sets the profile.
	 *
	 * @param profile the new profile
	 */
	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	/**
	 * Gets the timestamp.
	 *
	 * @return the timestamp
	 */
	public long getTimestamp() {
		return timestamp;
	}

	/**
	 * Sets the timestamp.
	 *
	 * @param timestamp the new timestamp
	 */
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	/**
	 * Gets the event props.
	 *
	 * @return the event props
	 */
	public HashMap<String, String> getEventProps() {
		return eventProps;
	}

	/**
	 * Sets the event props.
	 *
	 * @param eventProps the event props
	 */
	public void setEventProps(HashMap<String, String> eventProps) {
		this.eventProps = eventProps;
	}

	/**
	 * Gets the session props.
	 *
	 * @return the session props
	 */
	public HashMap<String, String> getSessionProps() {
		return sessionProps;
	}

	/**
	 * Sets the session props.
	 *
	 * @param sessionProps the session props
	 */
	public void setSessionProps(HashMap<String, String> sessionProps) {
		this.sessionProps = sessionProps;
	}
	
	
}

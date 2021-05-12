package Response;

import java.util.HashMap;

public class RecordsEvent {
	Profile profile;
	long ts;
	HashMap<String, String> event_props;
	HashMap<String, String> session_props;
	public Profile getProfile() {
		return profile;
	}
	public void setProfile(Profile profile) {
		this.profile = profile;
	}
	public long getTs() {
		return ts;
	}
	public void setTs(long ts) {
		this.ts = ts;
	}
	public HashMap<String, String> getEvent_props() {
		return event_props;
	}
	public void setEvent_props(HashMap<String, String> event_props) {
		this.event_props = event_props;
	}
	public HashMap<String, String> getSession_props() {
		return session_props;
	}
	public void setSession_props(HashMap<String, String> session_props) {
		this.session_props = session_props;
	}
}

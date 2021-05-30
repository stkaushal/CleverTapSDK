package Payload;

public class Where {
	String event_name;
	int from;
	int to;
	String profile_fields;
	public int getFrom() {
		return from;
	}
	public void setFrom(int from) {
		this.from = from;
	}
	public int getTo() {
		return to;
	}
	public void setTo(int to) {
		this.to = to;
	}
	public String getEvent_name() {
		return event_name;
	}
	public void setEvent_name(String event_name) {
		this.event_name = event_name;
	}
	public String getProfile_fields() {
		return profile_fields;
	}
	public void setProfile_fields(String profile_fields) {
		this.profile_fields = profile_fields;
	}
	
}

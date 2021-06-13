package Response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Target {
	long id;
	String name;
	
	@JsonProperty(value="scheduled_on")
	long scheduledOn;
	
	String status;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public long getScheduledOn() {
		return scheduledOn;
	}
	public void setScheduledOn(long scheduledOn) {
		this.scheduledOn = scheduledOn;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}

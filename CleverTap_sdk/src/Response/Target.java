package Response;

public class Target {
	long id;
	String name;
	long scheduled_on;
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
	public long getScheduled_on() {
		return scheduled_on;
	}
	public void setScheduled_on(long scheduled_on) {
		this.scheduled_on = scheduled_on;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}

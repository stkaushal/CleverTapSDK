package response;

import com.fasterxml.jackson.annotation.JsonProperty;

// TODO: Auto-generated Javadoc
/**
 * The Class Target.
 */
public class Target {
	
	/** The id. */
	private long id;
	
	/** The name. */
	private String name;
	
	/** The scheduled on. */
	@JsonProperty(value="scheduled_on")
	private long scheduledOn;
	
	/** The status. */
	private String status;
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	
	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(long id) {
		this.id = id;
	}
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the scheduled on.
	 *
	 * @return the scheduled on
	 */
	public long getScheduledOn() {
		return scheduledOn;
	}
	
	/**
	 * Sets the scheduled on.
	 *
	 * @param scheduledOn the new scheduled on
	 */
	public void setScheduledOn(long scheduledOn) {
		this.scheduledOn = scheduledOn;
	}
	
	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	
	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(String status) {
		this.status = status;
	}
}

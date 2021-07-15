package response;

import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;

// TODO: Auto-generated Javadoc
/**
 * The Class Response.
 */
public class Response {
	
	/** The status response from server for the request. */
	private String status;
	
	/** The processed objects. */
	private int processed;
	
	/** The unprocessed objects. */
	private List<Object> unprocessed;
	
	/** The error message received from server. */
	private String error;
	
	/** The server code. */
	private int code;  // rename
	
	/** The count(real time users, profiles, events count). */
	private int count;
	
	/** The key with a long int value that we will use to poll for the result in case partial status is received for counts api. */
	@JsonProperty(value="req_id")
	private long reqId;
	
	/** The boolean flag for split of users by type. */
	@JsonProperty(value="user_type")
	private HashMap<String, Object> userType;
	
	/** The total results in message report. */
	@JsonProperty(value="total_results")
	private int totalResults;
	
	/** The messages report. */
	private List<Message> messages;
	
	/** The estimate reach of campaign. */
	private HashMap<String, String> estimates;
	
	/** The result for campaign report. */
	private Result result;
	
	/** The campaigns data. */
	private List<Target> targets;
	
	/** The message from server. */
	private String message;
	
	/** Stores the data received from server which is not defined in out response class. */
	private HashMap<String, Object> otherInfo;
	
	/**
	 * Gets the other info.
	 *
	 * @return the other info
	 */
	@JsonAnyGetter
	public HashMap<String, Object> getOtherInfo() {
		return otherInfo;
	}
	
	/**
	 * Sets the other info.
	 *
	 * @param key the key
	 * @param value the value
	 */
	@JsonAnySetter
	public void setOtherInfo(String key, Object value) {
		if(this.otherInfo == null) {
			this.otherInfo = new HashMap<String,Object>();
		}
		this.otherInfo.put(key,value);
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
	
	/**
	 * Gets the processed.
	 *
	 * @return the processed
	 */
	public int getProcessed() {
		return processed;
	}
	
	/**
	 * Sets the processed.
	 *
	 * @param processed the new processed
	 */
	public void setProcessed(int processed) {
		this.processed = processed;
	}
	
	/**
	 * Gets the unprocessed.
	 *
	 * @return the unprocessed
	 */
	public List<Object> getUnprocessed() {
		return unprocessed;
	}
	
	/**
	 * Sets the unprocessed.
	 *
	 * @param unprocessed the new unprocessed
	 */
	public void setUnprocessed(List<Object> unprocessed) {
		this.unprocessed = unprocessed;
	}
	
	/**
	 * Gets the error.
	 *
	 * @return the error
	 */
	public String getError() {
		return error;
	}
	
	/**
	 * Sets the error.
	 *
	 * @param error the new error
	 */
	public void setError(String error) {
		this.error = error;
	}
	
	/**
	 * Gets the code.
	 *
	 * @return the code
	 */
	public int getCode() {
		return code;
	}
	
	/**
	 * Sets the code.
	 *
	 * @param code the new code
	 */
	public void setCode(int code) {
		this.code = code;
	}
	
	/**
	 * Gets the count.
	 *
	 * @return the count
	 */
	public int getCount() {
		return count;
	}
	
	/**
	 * Sets the count.
	 *
	 * @param count the new count
	 */
	public void setCount(int count) {
		this.count = count;
	}
	
	/**
	 * Gets the req id.
	 *
	 * @return the req id
	 */
	public long getReqId() {
		return reqId;
	}
	
	/**
	 * Sets the req id.
	 *
	 * @param reqId the new req id
	 */
	public void setReqId(long reqId) {
		this.reqId = reqId;
	}
	
	/**
	 * Gets the user type.
	 *
	 * @return the user type
	 */
	public HashMap<String, Object> getUserType() {
		return userType;
	}
	
	/**
	 * Sets the user type.
	 *
	 * @param userType the user type
	 */
	public void setUserType(HashMap<String, Object> userType) {
		this.userType = userType;
	}
	
	/**
	 * Gets the total results.
	 *
	 * @return the total results
	 */
	public int getTotalResults() {
		return totalResults;
	}
	
	/**
	 * Sets the total results.
	 *
	 * @param totalResults the new total results
	 */
	public void setTotalResults(int totalResults) {
		this.totalResults = totalResults;
	}
	
	/**
	 * Sets the other info.
	 *
	 * @param otherInfo the other info
	 */
	public void setOtherInfo(HashMap<String, Object> otherInfo) {
		this.otherInfo = otherInfo;
	}
	
	/**
	 * Gets the messages.
	 *
	 * @return the messages
	 */
	public List<Message> getMessages() {
		return messages;
	}
	
	/**
	 * Sets the messages.
	 *
	 * @param messages the new messages
	 */
	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
	
	/**
	 * Gets the estimates.
	 *
	 * @return the estimates
	 */
	public HashMap<String, String> getEstimates() {
		return estimates;
	}
	
	/**
	 * Sets the estimates.
	 *
	 * @param estimates the estimates
	 */
	public void setEstimates(HashMap<String, String> estimates) {
		this.estimates = estimates;
	}
	
	/**
	 * Gets the result.
	 *
	 * @return the result
	 */
	public Result getResult() {
		return result;
	}
	
	/**
	 * Sets the result.
	 *
	 * @param result the new result
	 */
	public void setResult(Result result) {
		this.result = result;
	}
	
	/**
	 * Gets the targets.
	 *
	 * @return the targets
	 */
	public List<Target> getTargets() {
		return targets;
	}
	
	/**
	 * Sets the targets.
	 *
	 * @param targets the new targets
	 */
	public void setTargets(List<Target> targets) {
		this.targets = targets;
	}
	
	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	
	/**
	 * Sets the message.
	 *
	 * @param message the new message
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
package Response;

import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Response {
	
	String status;
	int processed;
	List<Object> unprocessed;
	String error;
	int code;
	int count;
	
	@JsonProperty(value="req_id")
	long reqId;
	
	@JsonProperty(value="user_type")
	HashMap<String, Object> userType;
	
	@JsonProperty(value="total_results")
	int totalResults;
	
	List<Message> messages;
	
	HashMap<String, String> estimates;
	Result result;
	List<Target> targets;
	String message;
	
	HashMap<String, Object> otherInfo;
	
	@JsonAnyGetter
	public HashMap<String, Object> getOtherInfo() {
		return otherInfo;
	}
	@JsonAnySetter
	public void setOtherInfo(String key, Object value) {
		if(this.otherInfo == null) {
			this.otherInfo = new HashMap<String,Object>();
		}
		this.otherInfo.put(key,value);
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getProcessed() {
		return processed;
	}
	public void setProcessed(int processed) {
		this.processed = processed;
	}
	public List<Object> getUnprocessed() {
		return unprocessed;
	}
	public void setUnprocessed(List<Object> unprocessed) {
		this.unprocessed = unprocessed;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	public long getReqId() {
		return reqId;
	}
	public void setReqId(long reqId) {
		this.reqId = reqId;
	}
	public HashMap<String, Object> getUserType() {
		return userType;
	}
	public void setUserType(HashMap<String, Object> userType) {
		this.userType = userType;
	}
	public int getTotalResults() {
		return totalResults;
	}
	public void setTotalResults(int totalResults) {
		this.totalResults = totalResults;
	}
	public void setOtherInfo(HashMap<String, Object> otherInfo) {
		this.otherInfo = otherInfo;
	}
	public List<Message> getMessages() {
		return messages;
	}
	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
	public HashMap<String, String> getEstimates() {
		return estimates;
	}
	public void setEstimates(HashMap<String, String> estimates) {
		this.estimates = estimates;
	}
	public Result getResult() {
		return result;
	}
	public void setResult(Result result) {
		this.result = result;
	}
	public List<Target> getTargets() {
		return targets;
	}
	public void setTargets(List<Target> targets) {
		this.targets = targets;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
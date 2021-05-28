package Response;

import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;

public class Response {
	
	String status;
	int processed;
	Object[] unprocessed;
	String error;
	int code;
	int count;
	long req_id;
	String user_type;
	int total_results;
	Message messages;
	
	String foo;
	
	HashMap<String, String> estimates;
	Result result;
	Target[] targets;
	String message;
	
	HashMap<String, String> extra_data;
	
	@JsonAnyGetter
	public HashMap<String, String> getExtra_data() {
		return extra_data;
	}
	@JsonAnySetter
	public void setExtra_data(HashMap<String, String> extra_data) {
		this.extra_data = extra_data;
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
	public Object[] getUnprocessed() {
		return unprocessed;
	}
	public void setUnprocessed(Object[] unprocessed) {
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
	public long getReq_id() {
		return req_id;
	}
	public void setReq_id(long req_id) {
		this.req_id = req_id;
	}
	public String getUser_type() {
		return user_type;
	}
	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}
	public int getTotal_results() {
		return total_results;
	}
	public void setTotal_results(int total_results) {
		this.total_results = total_results;
	}
	public Message getMessages() {
		return messages;
	}
	public void setMessages(Message messages) {
		this.messages = messages;
	}
	public String getFoo() {
		return foo;
	}
	public void setFoo(String foo) {
		this.foo = foo;
	}
	
	public Result getResult() {
		return result;
	}
	public void setResult(Result result) {
		this.result = result;
	}
	public Target[] getTargets() {
		return targets;
	}
	public void setTargets(Target[] targets) {
		this.targets = targets;
	}
	public HashMap<String, String> getEstimates() {
		return estimates;
	}
	public void setEstimates(HashMap<String, String> estimates) {
		this.estimates = estimates;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
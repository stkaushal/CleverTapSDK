package Response;

import org.json.JSONObject;

public class Response {
	
	String status = null;
	String error = null;
	int code = -1;
	int processed = -1;
	String unprocessed = null;
	int count = -1;
	long req_id = -1;
	JSONObject user_type;
	JSONObject message;
	JSONObject foo;
	JSONObject bar;
	JSONObject foobar;
	JSONObject targets;
	JSONObject result;
	JSONObject estimates;
	String campaign_message = null;
	
	public String getCampaign_message() {
		return campaign_message;
	}

	public void setCampaign_message(String campaign_message) {
		this.campaign_message = campaign_message;
	}

	public JSONObject getEstimates() {
		return estimates;
	}

	public void setEstimates(JSONObject estimates) {
		this.estimates = estimates;
	}

	public JSONObject getTargets() {
		return targets;
	}

	public void setTargets(JSONObject targets) {
		this.targets = targets;
	}

	public JSONObject getResult() {
		return result;
	}

	public void setResult(JSONObject result) {
		this.result = result;
	}

	public JSONObject getFoobar() {
		return foobar;
	}

	public void setFoobar(JSONObject foobar) {
		this.foobar = foobar;
	}

	public JSONObject getFoo() {
		return foo;
	}

	public void setFoo(JSONObject foo) {
		this.foo = foo;
	}

	public JSONObject getBar() {
		return bar;
	}

	public void setBar(JSONObject bar) {
		this.bar = bar;
	}

	
	
	public JSONObject getUser_type() {
		return user_type;
	}
	
	public void setUser_type(JSONObject user_type) {
		this.user_type = user_type;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public int getProcessed() {
		return processed;
	}

	public void setProcessed(int processed) {
		this.processed = processed;
	}

	public String getUnprocessed() {
		return unprocessed;
	}

	public void setUnprocessed(String unprocessed) {
		this.unprocessed = unprocessed;
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

	public JSONObject getMessage() {
		return message;
	}

	public void setMessage(JSONObject message) {
		this.message = message;
	}
	
}


//object mapper convert json to object

package Response;

public class Response {
	
	String status = null;
	int processed;
	String unprocessed = null;
	String error = null;
	int code;
	int count;
	long req_id;
	String user_type;
	int total_results;
	Message messages;
	String foo;
	String bar;
	String foobar;
	Result result;
	Target[] targets;
	String estimates;
	String message = null;
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
	public String getUnprocessed() {
		return unprocessed;
	}
	public void setUnprocessed(String unprocessed) {
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
	public String getBar() {
		return bar;
	}
	public void setBar(String bar) {
		this.bar = bar;
	}
	public String getFoobar() {
		return foobar;
	}
	public void setFoobar(String foobar) {
		this.foobar = foobar;
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
	public String getEstimates() {
		return estimates;
	}
	public void setEstimates(String estimates) {
		this.estimates = estimates;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
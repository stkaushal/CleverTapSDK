package Response;

import org.json.JSONObject;

public class GetEventsResponse extends Response{
	String nextCursor = null;
	JSONObject records;
	
	public JSONObject getRecords() {
		return records;
	}
	public void setRecords(JSONObject records) {
		this.records = records;
	}
	public String getNextCursor() {
		return nextCursor;
	}
	public void setNextCursor(String nextCursor) {
		this.nextCursor = nextCursor;
	}
}

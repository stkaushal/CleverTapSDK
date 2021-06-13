package Response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetEventsResponse extends Response{
	
	@JsonProperty(value="next_cursor")
	String nextCursor;
	
	List<RecordsEvent> records;
	
	
	public List<RecordsEvent> getRecords() {
		return records;
	}
	public void setRecords(List<RecordsEvent> records) {
		this.records = records;
	}
	public String getNextCursor() {
		return nextCursor;
	}
	public void setNextCursor(String nextCursor) {
		this.nextCursor = nextCursor;
	}
	
}

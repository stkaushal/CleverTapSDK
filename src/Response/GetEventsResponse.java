package Response;

import java.util.List;

public class GetEventsResponse extends Response{
	String next_cursor = null;
	List<RecordsEvent> records;
	
	
	public List<RecordsEvent> getRecords() {
		return records;
	}
	public void setRecords(List<RecordsEvent> records) {
		this.records = records;
	}
	public String getNext_cursor() {
		return next_cursor;
	}
	public void setNext_cursor(String next_cursor) {
		this.next_cursor = next_cursor;
	}
}

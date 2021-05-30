package Response;


public class GetUserProfileResponse extends Response{
	String next_cursor = null;
	RecordsProfile records;
	public String getNext_cursor() {
		return next_cursor;
	}
	public void setNext_cursor(String next_cursor) {
		this.next_cursor = next_cursor;
	}
	public RecordsProfile getRecords() {
		return records;
	}
	public void setRecords(RecordsProfile records) {
		this.records = records;
	}
	
	
}

package Response;


public class GetEventsResponse extends Response{
	String nextCursor = null;
	RecordsProfile records;
	
	
	public RecordsProfile getRecords() {
		return records;
	}
	public void setRecords(RecordsProfile records) {
		this.records = records;
	}
	public String getNextCursor() {
		return nextCursor;
	}
	public void setNextCursor(String nextCursor) {
		this.nextCursor = nextCursor;
	}
}

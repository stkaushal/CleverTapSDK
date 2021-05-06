package Response;


public class GetUserProfileResponse extends Response{
	String nextCursor = null;
	String records;
	
	public String getRecords() {
		return records;
	}
	public void setRecords(String records) {
		this.records = records;
	}
	public String getNextCursor() {
		return nextCursor;
	}
	public void setNextCursor(String nextCursor) {
		this.nextCursor = nextCursor;
	}
	
}

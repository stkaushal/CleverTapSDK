package Response;

import java.util.List;

public class GetUserProfileResponse extends Response{
	String next_cursor = null;
	List<RecordsProfile> records;
	public String getNext_cursor() {
		return next_cursor;
	}
	public void setNext_cursor(String next_cursor) {
		this.next_cursor = next_cursor;
	}
	public List<RecordsProfile> getRecords() {
		return records;
	}
	public void setRecords(List<RecordsProfile>  records) {
		this.records = records;
	}
	
	
}

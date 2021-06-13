package Response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetUserProfileResponse extends Response{
	
	@JsonProperty(value="next_cursor")
	String nextCursor;
	
	List<RecordsProfile> records;
	RecordsProfile record;
	
	public RecordsProfile getRecord() {
		return record;
	}
	public void setRecord(RecordsProfile record) {
		this.record = record;
	}
	
	public String getNextCursor() {
		return nextCursor;
	}
	public void setNextCursor(String nextCursor) {
		this.nextCursor = nextCursor;
	}
	public List<RecordsProfile> getRecords() {
		return records;
	}
	public void setRecords(List<RecordsProfile>  records) {
		this.records = records;
	}
	
	
}

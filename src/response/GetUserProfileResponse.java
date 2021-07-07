package response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

// TODO: Auto-generated Javadoc
/**
 * The Class GetUserProfileResponse.
 */
public class GetUserProfileResponse extends Response{
	
	/** The next cursor. */
	@JsonProperty(value="next_cursor")
	String nextCursor;
	
	/** The records. */
	List<RecordsProfile> records;
	
	/** The record. */
	RecordsProfile record;
	
	/**
	 * Gets the record.
	 *
	 * @return the record
	 */
	public RecordsProfile getRecord() {
		return record;
	}
	
	/**
	 * Sets the record.
	 *
	 * @param record the new record
	 */
	public void setRecord(RecordsProfile record) {
		this.record = record;
	}
	
	/**
	 * Gets the next cursor.
	 *
	 * @return the next cursor
	 */
	public String getNextCursor() {
		return nextCursor;
	}
	
	/**
	 * Sets the next cursor.
	 *
	 * @param nextCursor the new next cursor
	 */
	public void setNextCursor(String nextCursor) {
		this.nextCursor = nextCursor;
	}
	
	/**
	 * Gets the records.
	 *
	 * @return the records
	 */
	public List<RecordsProfile> getRecords() {
		return records;
	}
	
	/**
	 * Sets the records.
	 *
	 * @param records the new records
	 */
	public void setRecords(List<RecordsProfile>  records) {
		this.records = records;
	}
	
	
}

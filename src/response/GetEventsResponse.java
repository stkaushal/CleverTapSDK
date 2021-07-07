package response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

// TODO: Auto-generated Javadoc
/**
 * The Class GetEventsResponse.
 */
public class GetEventsResponse extends Response{
	
	/** The next cursor. */
	@JsonProperty(value="next_cursor")
	String nextCursor;
	
	/** The records. */
	List<RecordsEvent> records;
	
	
	/**
	 * Gets the records.
	 *
	 * @return the records
	 */
	public List<RecordsEvent> getRecords() {
		return records;
	}
	
	/**
	 * Sets the records.
	 *
	 * @param records the new records
	 */
	public void setRecords(List<RecordsEvent> records) {
		this.records = records;
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
	
}

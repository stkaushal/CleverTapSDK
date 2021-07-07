package payload.campaign;

import com.fasterxml.jackson.annotation.JsonProperty;

// TODO: Auto-generated Javadoc
/**
 * The Class DateRangePayload.
 */
public class DateRangePayload {
	
	/** The from date. */
	@JsonProperty(value="from")
	int fromDate;
	
	/** The to date. */
	@JsonProperty(value="to")
	int toDate;

	/**
	 * Gets the from date.
	 *
	 * @return the from date
	 */
	public int getFromDate() {
		return fromDate;
	}

	/**
	 * Sets the from date.
	 *
	 * @param fromDate the new from date
	 */
	public void setFromDate(int fromDate) {
		this.fromDate = fromDate;
	}

	/**
	 * Gets the to date.
	 *
	 * @return the to date
	 */
	public int getToDate() {
		return toDate;
	}

	/**
	 * Sets the to date.
	 *
	 * @param toDate the new to date
	 */
	public void setToDate(int toDate) {
		this.toDate = toDate;
	}
	
}

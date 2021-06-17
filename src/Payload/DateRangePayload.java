package Payload;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DateRangePayload {
	@JsonProperty(value="from")
	int fromDate;
	
	@JsonProperty(value="to")
	int toDate;

	public int getFromDate() {
		return fromDate;
	}

	public void setFromDate(int fromDate) {
		this.fromDate = fromDate;
	}

	public int getToDate() {
		return toDate;
	}

	public void setToDate(int toDate) {
		this.toDate = toDate;
	}
	
}

package Payload.Campaign;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_DEFAULT)
public class Where {
	
	@JsonProperty(value="event_name")
	String eventName;
	
	@JsonProperty(value="from")
	int fromDate;
	
	@JsonProperty(value="to")
	int toDate;
	
	@JsonProperty(value="common_profile_properties")
	CommonProfileProperties commonProfileProperties;

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

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

	public CommonProfileProperties getCommonProfileProperties() {
		return commonProfileProperties;
	}

	public void setCommonProfileProperties(CommonProfileProperties commonProfileProperties) {
		this.commonProfileProperties = commonProfileProperties;
	}
	
}

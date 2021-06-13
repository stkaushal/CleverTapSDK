package Payload;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_DEFAULT)
public class Group {
	
	@JsonProperty(value="property_type")
	String propertyType;
	
	@JsonProperty(value="name")
	String propertyName;
	
	@JsonProperty(value="top_n")
	int topNValues;
	
	String order;
	
	@JsonProperty(value="trend_type")
	String trendType;

	public String getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public int getTopNValues() {
		return topNValues;
	}

	public void setTopNValues(int topNValues) {
		this.topNValues = topNValues;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public String getTrendType() {
		return trendType;
	}

	public void setTrendType(String trendType) {
		this.trendType = trendType;
	}
	
	
}

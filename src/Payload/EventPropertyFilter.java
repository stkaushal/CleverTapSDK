package Payload;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EventPropertyFilter {
	
	@JsonProperty(value="name")
	String propertName;
	
	String operator;
	
	@JsonProperty(value="value")
	Object propertValue;

	public String getPropertName() {
		return propertName;
	}

	public void setPropertName(String propertName) {
		this.propertName = propertName;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public Object getPropertValue() {
		return propertValue;
	}

	public void setPropertValue(Object propertValue) {
		this.propertValue = propertValue;
	}
	
	
}

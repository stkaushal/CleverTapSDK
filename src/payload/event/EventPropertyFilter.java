package payload.event;

import com.fasterxml.jackson.annotation.JsonProperty;

// TODO: Auto-generated Javadoc
/**
 * The Class EventPropertyFilter.
 */
public class EventPropertyFilter {
	
	/** The propert name. */
	@JsonProperty(value="name")
	private String propertName;
	
	/** The operator. */
	private String operator;
	
	/** The propert value. */
	@JsonProperty(value="value")
	private Object propertValue;

	/**
	 * Gets the propert name.
	 *
	 * @return the propert name
	 */
	public String getPropertName() {
		return propertName;
	}

	/**
	 * Sets the propert name.
	 *
	 * @param propertName the new propert name
	 */
	public void setPropertName(String propertName) {
		this.propertName = propertName;
	}

	/**
	 * Gets the operator.
	 *
	 * @return the operator
	 */
	public String getOperator() {
		return operator;
	}

	/**
	 * Sets the operator.
	 *
	 * @param operator the new operator
	 */
	public void setOperator(String operator) {
		this.operator = operator;
	}

	/**
	 * Gets the propert value.
	 *
	 * @return the propert value
	 */
	public Object getPropertValue() {
		return propertValue;
	}

	/**
	 * Sets the propert value.
	 *
	 * @param propertValue the new propert value
	 */
	public void setPropertValue(Object propertValue) {
		this.propertValue = propertValue;
	}
	
	
}

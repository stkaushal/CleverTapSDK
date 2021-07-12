package payload.report;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

// TODO: Auto-generated Javadoc
/**
 * The Class Group.
 */
@JsonInclude(Include.NON_DEFAULT)
public class Group {
	
	/** The property type. */
	@JsonProperty(value="property_type")
	private String propertyType;
	
	/** The property name. */
	@JsonProperty(value="name")
	private String propertyName;
	
	/** The top N values. */
	@JsonProperty(value="top_n")
	private int topNValues;
	
	/** The order. */
	private String order;
	
	/** The trend type. */
	@JsonProperty(value="trend_type")
	private String trendType;

	/**
	 * Gets the property type.
	 *
	 * @return the property type
	 */
	public String getPropertyType() {
		return propertyType;
	}

	/**
	 * Sets the property type.
	 *
	 * @param propertyType the new property type
	 */
	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}

	/**
	 * Gets the property name.
	 *
	 * @return the property name
	 */
	public String getPropertyName() {
		return propertyName;
	}

	/**
	 * Sets the property name.
	 *
	 * @param propertyName the new property name
	 */
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	/**
	 * Gets the top N values.
	 *
	 * @return the top N values
	 */
	public int getTopNValues() {
		return topNValues;
	}

	/**
	 * Sets the top N values.
	 *
	 * @param topNValues the new top N values
	 */
	public void setTopNValues(int topNValues) {
		this.topNValues = topNValues;
	}

	/**
	 * Gets the order.
	 *
	 * @return the order
	 */
	public String getOrder() {
		return order;
	}

	/**
	 * Sets the order.
	 *
	 * @param order the new order
	 */
	public void setOrder(String order) {
		this.order = order;
	}

	/**
	 * Gets the trend type.
	 *
	 * @return the trend type
	 */
	public String getTrendType() {
		return trendType;
	}

	/**
	 * Sets the trend type.
	 *
	 * @param trendType the new trend type
	 */
	public void setTrendType(String trendType) {
		this.trendType = trendType;
	}
	
	
}

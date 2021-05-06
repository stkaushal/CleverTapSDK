package Payload;

public class Group {
	String property_type;
	String name;
	int top_n;
	String order;
	String trend_type;
	public String getTrend_type() {
		return trend_type;
	}
	public void setTrend_type(String trend_type) {
		this.trend_type = trend_type;
	}
	public String getProperty_type() {
		return property_type;
	}
	public void setProperty_type(String property_type) {
		this.property_type = property_type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTop_n() {
		return top_n;
	}
	public void setTop_n(int top_n) {
		this.top_n = top_n;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
}

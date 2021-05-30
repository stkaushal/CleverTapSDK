package Payload;

public class TokenData {
	String id;
	String type;
	Keys keys;
	public String getId() {
		return id;
	}
	public Keys getKeys() {
		return keys;
	}
	public void setKeys(Keys keys) {
		this.keys = keys;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}

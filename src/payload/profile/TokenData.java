package payload.profile;

// TODO: Auto-generated Javadoc
/**
 * The Class TokenData.
 */
public class TokenData {
	
	/** The id. */
	private String id;
	
	/** The type. */
	private String type;
	
	/** The keys. */
	private Keys keys;
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * Gets the keys.
	 *
	 * @return the keys
	 */
	public Keys getKeys() {
		return keys;
	}
	
	/**
	 * Sets the keys.
	 *
	 * @param keys the new keys
	 */
	public void setKeys(Keys keys) {
		this.keys = keys;
	}
	
	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * Sets the type.
	 *
	 * @param type the new type
	 */
	public void setType(String type) {
		this.type = type;
	}
}

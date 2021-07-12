package payload.campaign;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

// TODO: Auto-generated Javadoc
/**
 * The Class To.
 */
@JsonInclude(Include.NON_DEFAULT)
public class To {
	
	/** The fbid. */
	@JsonProperty(value="FBID")
	private List<String> fbid;
	
	/** The email. */
	@JsonProperty(value="Email")
	private List<String> email;
	
	/** The gpid. */
	@JsonProperty(value="GPID")
	private List<String> gpid;
	
	/** The identity. */
	@JsonProperty(value="Identity")
	private List<String> identity;
	
	/** The object id. */
	@JsonProperty(value="objectId")
	private List<String> objectId;

	/**
	 * Gets the fbid.
	 *
	 * @return the fbid
	 */
	public List<String> getFbid() {
		return fbid;
	}

	/**
	 * Sets the fbid.
	 *
	 * @param fbid the new fbid
	 */
	public void setFbid(List<String> fbid) {
		this.fbid = fbid;
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public List<String> getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(List<String> email) {
		this.email = email;
	}

	/**
	 * Gets the gpid.
	 *
	 * @return the gpid
	 */
	public List<String> getGpid() {
		return gpid;
	}

	/**
	 * Sets the gpid.
	 *
	 * @param gpid the new gpid
	 */
	public void setGpid(List<String> gpid) {
		this.gpid = gpid;
	}

	/**
	 * Gets the identity.
	 *
	 * @return the identity
	 */
	public List<String> getIdentity() {
		return identity;
	}

	/**
	 * Sets the identity.
	 *
	 * @param identity the new identity
	 */
	public void setIdentity(List<String> identity) {
		this.identity = identity;
	}

	/**
	 * Gets the object id.
	 *
	 * @return the object id
	 */
	public List<String> getObjectId() {
		return objectId;
	}

	/**
	 * Sets the object id.
	 *
	 * @param objectId the new object id
	 */
	public void setObjectId(List<String> objectId) {
		this.objectId = objectId;
	}

	
	
}

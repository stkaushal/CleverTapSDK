package Payload;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_DEFAULT)
public class To {
	
	@JsonProperty(value="FBID")
	List<String> fbid;
	
	@JsonProperty(value="Email")
	List<String> email;
	
	@JsonProperty(value="GPID")
	List<String> gpid;
	
	@JsonProperty(value="Identity")
	List<String> identity;
	
	@JsonProperty(value="objectId")
	List<String> objectId;

	public List<String> getFbid() {
		return fbid;
	}

	public void setFbid(List<String> fbid) {
		this.fbid = fbid;
	}

	public List<String> getEmail() {
		return email;
	}

	public void setEmail(List<String> email) {
		this.email = email;
	}

	public List<String> getGpid() {
		return gpid;
	}

	public void setGpid(List<String> gpid) {
		this.gpid = gpid;
	}

	public List<String> getIdentity() {
		return identity;
	}

	public void setIdentity(List<String> identity) {
		this.identity = identity;
	}

	public List<String> getObjectId() {
		return objectId;
	}

	public void setObjectId(List<String> objectId) {
		this.objectId = objectId;
	}

	
	
}

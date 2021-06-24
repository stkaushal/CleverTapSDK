package Payload;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_DEFAULT)
public class PlatformTypeFirefox {

	@JsonProperty(value="image")
	String imageURL;
	
	@JsonProperty(value="icon")
	String iconURL;
	
	@JsonProperty(value="deep_link")
	String deepLink;
	
	@JsonProperty(value="ttl")
	String timeToLive;
	
	@JsonProperty(value="require_interaction")
	String requireInteraction;

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public String getIconURL() {
		return iconURL;
	}

	public void setIconURL(String iconURL) {
		this.iconURL = iconURL;
	}

	public String getDeepLink() {
		return deepLink;
	}

	public void setDeepLink(String deepLink) {
		this.deepLink = deepLink;
	}

	public String getTimeToLive() {
		return timeToLive;
	}

	public void setTimeToLive(String timeToLive) {
		this.timeToLive = timeToLive;
	}

	public String getRequireInteraction() {
		return requireInteraction;
	}

	public void setRequireInteraction(String requireInteraction) {
		this.requireInteraction = requireInteraction;
	}
}

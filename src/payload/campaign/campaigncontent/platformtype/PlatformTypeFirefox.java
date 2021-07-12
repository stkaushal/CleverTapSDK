package payload.campaign.campaigncontent.platformtype;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

// TODO: Auto-generated Javadoc
/**
 * The Class PlatformTypeFirefox.
 */
@JsonInclude(Include.NON_DEFAULT)
public class PlatformTypeFirefox {

	/** The image URL. */
	@JsonProperty(value="image")
	private String imageURL;
	
	/** The icon URL. */
	@JsonProperty(value="icon")
	private String iconURL;
	
	/** The deep link. */
	@JsonProperty(value="deep_link")
	private String deepLink;
	
	/** The time to live. */
	@JsonProperty(value="ttl")
	private String timeToLive;
	
	/** The require interaction. */
	@JsonProperty(value="require_interaction")
	private String requireInteraction;

	/**
	 * Gets the image URL.
	 *
	 * @return the image URL
	 */
	public String getImageURL() {
		return imageURL;
	}

	/**
	 * Sets the image URL.
	 *
	 * @param imageURL the new image URL
	 */
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	/**
	 * Gets the icon URL.
	 *
	 * @return the icon URL
	 */
	public String getIconURL() {
		return iconURL;
	}

	/**
	 * Sets the icon URL.
	 *
	 * @param iconURL the new icon URL
	 */
	public void setIconURL(String iconURL) {
		this.iconURL = iconURL;
	}

	/**
	 * Gets the deep link.
	 *
	 * @return the deep link
	 */
	public String getDeepLink() {
		return deepLink;
	}

	/**
	 * Sets the deep link.
	 *
	 * @param deepLink the new deep link
	 */
	public void setDeepLink(String deepLink) {
		this.deepLink = deepLink;
	}

	/**
	 * Gets the time to live.
	 *
	 * @return the time to live
	 */
	public String getTimeToLive() {
		return timeToLive;
	}

	/**
	 * Sets the time to live.
	 *
	 * @param timeToLive the new time to live
	 */
	public void setTimeToLive(String timeToLive) {
		this.timeToLive = timeToLive;
	}

	/**
	 * Gets the require interaction.
	 *
	 * @return the require interaction
	 */
	public String getRequireInteraction() {
		return requireInteraction;
	}

	/**
	 * Sets the require interaction.
	 *
	 * @param requireInteraction the new require interaction
	 */
	public void setRequireInteraction(String requireInteraction) {
		this.requireInteraction = requireInteraction;
	}
}

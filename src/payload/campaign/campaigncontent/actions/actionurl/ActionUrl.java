package payload.campaign.campaigncontent.actions.actionurl;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

// TODO: Auto-generated Javadoc
/**
 * The Class ActionUrl.
 */
@JsonInclude(Include.NON_DEFAULT)
public class ActionUrl {
	
	/** The android action url. */
	@JsonProperty(value="android")
	private MobileActionUrl androidActionUrl;
	
	/** The ios action url. */
	@JsonProperty(value="ios")
	private MobileActionUrl iosActionUrl;

	/**
	 * Gets the android action url.
	 *
	 * @return the android action url
	 */
	public MobileActionUrl getAndroidActionUrl() {
		return androidActionUrl;
	}

	/**
	 * Sets the android action url.
	 *
	 * @param androidActionUrl the new android action url
	 */
	public void setAndroidActionUrl(MobileActionUrl androidActionUrl) {
		this.androidActionUrl = androidActionUrl;
	}

	/**
	 * Gets the ios action url.
	 *
	 * @return the ios action url
	 */
	public MobileActionUrl getIosActionUrl() {
		return iosActionUrl;
	}

	/**
	 * Sets the ios action url.
	 *
	 * @param mobileActionUrl the new ios action url
	 */
	public void setIosActionUrl(MobileActionUrl mobileActionUrl) {
		this.iosActionUrl = mobileActionUrl;
	} 
	
	
}

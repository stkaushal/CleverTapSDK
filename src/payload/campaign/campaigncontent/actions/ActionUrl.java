package payload.campaign.campaigncontent.actions;

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
	AndroidActionUrl androidActionUrl;
	
	/** The ios action url. */
	@JsonProperty(value="ios")
	IosActionUrl iosActionUrl;

	/**
	 * Gets the android action url.
	 *
	 * @return the android action url
	 */
	public AndroidActionUrl getAndroidActionUrl() {
		return androidActionUrl;
	}

	/**
	 * Sets the android action url.
	 *
	 * @param androidActionUrl the new android action url
	 */
	public void setAndroidActionUrl(AndroidActionUrl androidActionUrl) {
		this.androidActionUrl = androidActionUrl;
	}

	/**
	 * Gets the ios action url.
	 *
	 * @return the ios action url
	 */
	public IosActionUrl getIosActionUrl() {
		return iosActionUrl;
	}

	/**
	 * Sets the ios action url.
	 *
	 * @param iosActionUrl the new ios action url
	 */
	public void setIosActionUrl(IosActionUrl iosActionUrl) {
		this.iosActionUrl = iosActionUrl;
	} 
	
	
}

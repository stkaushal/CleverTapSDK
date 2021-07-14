package payload.campaign.campaigncontent;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import payload.campaign.campaigncontent.platformtype.PlatformTypeMobile;
import payload.campaign.campaigncontent.platformtype.PlatformTypeWeb;

// TODO: Auto-generated Javadoc
/**
 * The Class PlatformSpecificContent.
 */
@JsonInclude(Include.NON_DEFAULT)
public class PlatformSpecificContent {
	
	/** The platform type chrome. */
	@JsonProperty(value="chrome")
	private PlatformTypeWeb platformTypeChrome; 
	
	/** The platform type firefox. */
	@JsonProperty(value="firefox")
	private PlatformTypeWeb platformTypeFirefox; 
	
	/** The platform type safari. */
	@JsonProperty(value="safari")
	private PlatformTypeWeb platformTypeSafari; 
	
	/** The platform type ios. */
	@JsonProperty(value="ios")
	private PlatformTypeMobile platformTypeIos; 
	
	/** The platform type android. */
	@JsonProperty(value="android")
	private PlatformTypeMobile platformTypeAndroid;

	/**
	 * Gets the platform type chrome.
	 *
	 * @return the platform type chrome
	 */
	public PlatformTypeWeb getplatformTypeChrome() {
		return platformTypeChrome;
	}

	/**
	 * Sets the platform type chrome.
	 *
	 * @param platformTypeWeb the new platform type chrome
	 */
	public void setPlatformTypeChrome(PlatformTypeWeb platformTypeChrome) {
		this.platformTypeChrome = platformTypeChrome;
	}

	/**
	 * Gets the platform type firefox.
	 *
	 * @return the platform type firefox
	 */
	public PlatformTypeWeb getPlatformTypeFirefox() {
		return platformTypeFirefox;
	}

	/**
	 * Sets the platform type firefox.
	 *
	 * @param platformTypeFirefox the new platform type firefox
	 */
	public void setPlatformTypeFirefox(PlatformTypeWeb platformTypeFirefox) {
		this.platformTypeFirefox = platformTypeFirefox;
	}

	/**
	 * Gets the platform type safari.
	 *
	 * @return the platform type safari
	 */
	public PlatformTypeWeb getPlatformTypeSafari() {
		return platformTypeSafari;
	}

	/**
	 * Sets the platform type safari.
	 *
	 * @param platformTypeSafari the new platform type safari
	 */
	public void setPlatformTypeSafari(PlatformTypeWeb platformTypeSafari) {
		this.platformTypeSafari = platformTypeSafari;
	}

	/**
	 * Gets the platform type ios.
	 *
	 * @return the platform type ios
	 */
	public PlatformTypeMobile getPlatformTypeIos() {
		return platformTypeIos;
	}

	/**
	 * Sets the platform type ios.
	 *
	 * @param platformTypeIos the new platform type ios
	 */
	public void setPlatformTypeIos(PlatformTypeMobile platformTypeIos) {
		this.platformTypeIos = platformTypeIos;
	}

	/**
	 * Gets the platform type android.
	 *
	 * @return the platform type android
	 */
	public PlatformTypeMobile getPlatformTypeAndroid() {
		return platformTypeAndroid;
	}

	/**
	 * Sets the platform type android.
	 *
	 * @param platformTypeMobile the new platform type android
	 */
	public void setPlatformTypeAndroid(PlatformTypeMobile platformTypeMobile) {
		this.platformTypeAndroid = platformTypeMobile;
	} 
	
	
}

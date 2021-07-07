package payload.campaign.campaigncontent;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import payload.campaign.campaigncontent.platformtype.PlatformTypeAndroid;
import payload.campaign.campaigncontent.platformtype.PlatformTypeChrome;
import payload.campaign.campaigncontent.platformtype.PlatformTypeFirefox;
import payload.campaign.campaigncontent.platformtype.PlatformTypeIos;
import payload.campaign.campaigncontent.platformtype.PlatformTypeSafari;

// TODO: Auto-generated Javadoc
/**
 * The Class PlatformSpecificContent.
 */
@JsonInclude(Include.NON_DEFAULT)
public class PlatformSpecificContent {
	
	/** The platform type chrome. */
	@JsonProperty(value="chrome")
	PlatformTypeChrome platformTypeChrome; 
	
	/** The platform type firefox. */
	@JsonProperty(value="firefox")
	PlatformTypeFirefox platformTypeFirefox; 
	
	/** The platform type safari. */
	@JsonProperty(value="safari")
	PlatformTypeSafari platformTypeSafari; 
	
	/** The platform type ios. */
	@JsonProperty(value="ios")
	PlatformTypeIos platformTypeIos; 
	
	/** The platform type android. */
	@JsonProperty(value="android")
	PlatformTypeAndroid platformTypeAndroid;

	/**
	 * Gets the platform type chrome.
	 *
	 * @return the platform type chrome
	 */
	public PlatformTypeChrome getplatformTypeChrome() {
		return platformTypeChrome;
	}

	/**
	 * Sets the platform type chrome.
	 *
	 * @param platformTypeChrome the new platform type chrome
	 */
	public void setPlatformTypeChrome(PlatformTypeChrome platformTypeChrome) {
		this.platformTypeChrome = platformTypeChrome;
	}

	/**
	 * Gets the platform type firefox.
	 *
	 * @return the platform type firefox
	 */
	public PlatformTypeFirefox getPlatformTypeFirefox() {
		return platformTypeFirefox;
	}

	/**
	 * Sets the platform type firefox.
	 *
	 * @param platformTypeFirefox the new platform type firefox
	 */
	public void setPlatformTypeFirefox(PlatformTypeFirefox platformTypeFirefox) {
		this.platformTypeFirefox = platformTypeFirefox;
	}

	/**
	 * Gets the platform type safari.
	 *
	 * @return the platform type safari
	 */
	public PlatformTypeSafari getPlatformTypeSafari() {
		return platformTypeSafari;
	}

	/**
	 * Sets the platform type safari.
	 *
	 * @param platformTypeSafari the new platform type safari
	 */
	public void setPlatformTypeSafari(PlatformTypeSafari platformTypeSafari) {
		this.platformTypeSafari = platformTypeSafari;
	}

	/**
	 * Gets the platform type ios.
	 *
	 * @return the platform type ios
	 */
	public PlatformTypeIos getPlatformTypeIos() {
		return platformTypeIos;
	}

	/**
	 * Sets the platform type ios.
	 *
	 * @param platformTypeIos the new platform type ios
	 */
	public void setPlatformTypeIos(PlatformTypeIos platformTypeIos) {
		this.platformTypeIos = platformTypeIos;
	}

	/**
	 * Gets the platform type android.
	 *
	 * @return the platform type android
	 */
	public PlatformTypeAndroid getPlatformTypeAndroid() {
		return platformTypeAndroid;
	}

	/**
	 * Sets the platform type android.
	 *
	 * @param platformTypeAndroid the new platform type android
	 */
	public void setPlatformTypeAndroid(PlatformTypeAndroid platformTypeAndroid) {
		this.platformTypeAndroid = platformTypeAndroid;
	} 
	
	
}

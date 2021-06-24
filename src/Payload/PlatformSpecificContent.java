package Payload;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_DEFAULT)
public class PlatformSpecificContent {
	
	@JsonProperty(value="chrome")
	PlatformTypeChrome platformTypeChrome; 
	
	@JsonProperty(value="firefox")
	PlatformTypeFirefox platformTypeFirefox; 
	
	@JsonProperty(value="safari")
	PlatformTypeSafari platformTypeSafari; 
	
	@JsonProperty(value="ios")
	PlatformTypeIos platformTypeIos; 
	
	@JsonProperty(value="android")
	PlatformTypeAndroid platformTypeAndroid;

	public PlatformTypeChrome getplatformTypeChrome() {
		return platformTypeChrome;
	}

	public void setPlatformTypeChrome(PlatformTypeChrome platformTypeChrome) {
		this.platformTypeChrome = platformTypeChrome;
	}

	public PlatformTypeFirefox getPlatformTypeFirefox() {
		return platformTypeFirefox;
	}

	public void setPlatformTypeFirefox(PlatformTypeFirefox platformTypeFirefox) {
		this.platformTypeFirefox = platformTypeFirefox;
	}

	public PlatformTypeSafari getPlatformTypeSafari() {
		return platformTypeSafari;
	}

	public void setPlatformTypeSafari(PlatformTypeSafari platformTypeSafari) {
		this.platformTypeSafari = platformTypeSafari;
	}

	public PlatformTypeIos getPlatformTypeIos() {
		return platformTypeIos;
	}

	public void setPlatformTypeIos(PlatformTypeIos platformTypeIos) {
		this.platformTypeIos = platformTypeIos;
	}

	public PlatformTypeAndroid getPlatformTypeAndroid() {
		return platformTypeAndroid;
	}

	public void setPlatformTypeAndroid(PlatformTypeAndroid platformTypeAndroid) {
		this.platformTypeAndroid = platformTypeAndroid;
	} 
	
	
}

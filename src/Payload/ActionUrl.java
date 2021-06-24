package Payload;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_DEFAULT)
public class ActionUrl {
	
	@JsonProperty(value="android")
	AndroidActionUrl androidActionUrl;
	
	@JsonProperty(value="ios")
	IosActionUrl iosActionUrl;

	public AndroidActionUrl getAndroidActionUrl() {
		return androidActionUrl;
	}

	public void setAndroidActionUrl(AndroidActionUrl androidActionUrl) {
		this.androidActionUrl = androidActionUrl;
	}

	public IosActionUrl getIosActionUrl() {
		return iosActionUrl;
	}

	public void setIosActionUrl(IosActionUrl iosActionUrl) {
		this.iosActionUrl = iosActionUrl;
	} 
	
	
}

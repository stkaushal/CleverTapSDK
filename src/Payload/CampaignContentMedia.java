package Payload;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CampaignContentMedia {
	
	@JsonProperty(value="content_type")
	String contentType;
	
	@JsonProperty(value="url")
	String mediaUrl;

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getMediaUrl() {
		return mediaUrl;
	}

	public void setMediaUrl(String mediaUrl) {
		this.mediaUrl = mediaUrl;
	}
	
	
}

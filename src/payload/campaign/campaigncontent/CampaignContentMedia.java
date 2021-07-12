package payload.campaign.campaigncontent;

import com.fasterxml.jackson.annotation.JsonProperty;

// TODO: Auto-generated Javadoc
/**
 * The Class CampaignContentMedia.
 */
public class CampaignContentMedia {
	
	/** The content type. */
	@JsonProperty(value="content_type")
	private String contentType;
	
	/** The media url. */
	@JsonProperty(value="url")
	private String mediaUrl;

	/**
	 * Gets the content type.
	 *
	 * @return the content type
	 */
	public String getContentType() {
		return contentType;
	}

	/**
	 * Sets the content type.
	 *
	 * @param contentType the new content type
	 */
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	/**
	 * Gets the media url.
	 *
	 * @return the media url
	 */
	public String getMediaUrl() {
		return mediaUrl;
	}

	/**
	 * Sets the media url.
	 *
	 * @param mediaUrl the new media url
	 */
	public void setMediaUrl(String mediaUrl) {
		this.mediaUrl = mediaUrl;
	}
	
	
}

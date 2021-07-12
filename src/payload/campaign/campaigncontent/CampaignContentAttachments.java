package payload.campaign.campaigncontent;

import com.fasterxml.jackson.annotation.JsonProperty;

// TODO: Auto-generated Javadoc
/**
 * The Class CampaignContentAttachments.
 */
public class CampaignContentAttachments {
	
	/** The attachment type. */
	@JsonProperty(value="type")
	private String attachmentType;
	
	/** The attachment value. */
	@JsonProperty(value="value")
	private String attachmentValue;

	/**
	 * Gets the attachment type.
	 *
	 * @return the attachment type
	 */
	public String getAttachmentType() {
		return attachmentType;
	}

	/**
	 * Sets the attachment type.
	 *
	 * @param attachmentType the new attachment type
	 */
	public void setAttachmentType(String attachmentType) {
		this.attachmentType = attachmentType;
	}

	/**
	 * Gets the attachment value.
	 *
	 * @return the attachment value
	 */
	public String getAttachmentValue() {
		return attachmentValue;
	}

	/**
	 * Sets the attachment value.
	 *
	 * @param attachmentValue the new attachment value
	 */
	public void setAttachmentValue(String attachmentValue) {
		this.attachmentValue = attachmentValue;
	}
	
	
}

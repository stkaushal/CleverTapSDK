package Payload;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CampaignContentAttachments {
	
	@JsonProperty(value="type")
	String attachmentType;
	
	@JsonProperty(value="value")
	String attachmentValue;

	public String getAttachmentType() {
		return attachmentType;
	}

	public void setAttachmentType(String attachmentType) {
		this.attachmentType = attachmentType;
	}

	public String getAttachmentValue() {
		return attachmentValue;
	}

	public void setAttachmentValue(String attachmentValue) {
		this.attachmentValue = attachmentValue;
	}
	
	
}

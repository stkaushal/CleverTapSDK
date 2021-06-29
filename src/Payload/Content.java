package Payload;

import Payload.CampaignContent.*;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


@JsonInclude(Include.NON_DEFAULT)
public class Content {
	Object title;
	String body;
	String subject;
	
	@JsonProperty(value="sender_name")
	String senderName;
	
	@JsonProperty(value="template_name")
	String templateName;
	
	Object replacements;
	
	@JsonProperty(value="attachments")
	CampaignContentAttachments campaignContentAttachments;
	
	@JsonProperty(value="template_id")
	String templateId;
	
	CampaignContentMessage message;
	
	Action action;
	
	CampaignContentMedia media;

	CampaignContentIcon icon;
	
	@JsonProperty(value="platform_specific")
	PlatformSpecificContent platformSpecificContent;

	public Object getTitle() {
		return title;
	}

	public void setTitle(Object title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	public Object getReplacements() {
		return replacements;
	}

	public void setReplacements(Object replacements) {
		this.replacements = replacements;
	}

	
	public CampaignContentAttachments getCampaignContentAttachments() {
		return campaignContentAttachments;
	}

	public void setCampaignContentAttachments(CampaignContentAttachments campaignContentAttachments) {
		this.campaignContentAttachments = campaignContentAttachments;
	}

	public String getTemplateId() {
		return templateId;
	}

	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}

	public CampaignContentMessage getMessage() {
		return message;
	}

	public void setMessage(CampaignContentMessage message) {
		this.message = message;
	}

	public Action getAction() {
		return action;
	}

	public void setAction(Action action) {
		this.action = action;
	}

	public CampaignContentMedia getMedia() {
		return media;
	}

	public void setMedia(CampaignContentMedia media) {
		this.media = media;
	}

	public CampaignContentIcon getIcon() {
		return icon;
	}

	public void setIcon(CampaignContentIcon icon) {
		this.icon = icon;
	}

	public PlatformSpecificContent getPlatformSpecificContent() {
		return platformSpecificContent;
	}

	public void setPlatformSpecificContent(PlatformSpecificContent platformSpecificContent) {
		this.platformSpecificContent = platformSpecificContent;
	}

}

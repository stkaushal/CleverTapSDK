package Payload;

import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_DEFAULT)
public class Content {
	String title;
	String body;
	String subject;
	
	@JsonProperty(value="sender_name")
	String senderName;
	
	@JsonProperty(value="template_name")
	String templateName;
	
	String replacements;
	String attachments;
	
	@JsonProperty(value="template_id")
	String templateId;
	
	@JsonProperty(value="platform_specific")
	HashMap<String, Object> platformSpecific;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
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

	public String getReplacements() {
		return replacements;
	}

	public void setReplacements(String replacements) {
		this.replacements = replacements;
	}

	public String getAttachments() {
		return attachments;
	}

	public void setAttachments(String attachments) {
		this.attachments = attachments;
	}

	public String getTemplateId() {
		return templateId;
	}

	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}

	public HashMap<String, Object> getPlatformSpecific() {
		return platformSpecific;
	}

	public void setPlatformSpecific(HashMap<String, Object> platformSpecific) {
		this.platformSpecific = platformSpecific;
	}
	
	
}

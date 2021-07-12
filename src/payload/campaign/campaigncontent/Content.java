package payload.campaign.campaigncontent;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import payload.campaign.campaigncontent.actions.Action;


// TODO: Auto-generated Javadoc
/**
 * The Class Content.
 */
@JsonInclude(Include.NON_DEFAULT)
public class Content {
	
	/** The title. */
	private Object title;
	
	/** The body. */
	private String body;
	
	/** The subject. */
	private String subject;
	
	/** The sender name. */
	@JsonProperty(value="sender_name")
	private String senderName;
	
	/** The template name. */
	@JsonProperty(value="template_name")
	private String templateName;
	
	/** The replacements. */
	private Object replacements;
	
	/** The campaign content attachments. */
	@JsonProperty(value="attachments")
	private CampaignContentAttachments campaignContentAttachments;
	
	/** The template id. */
	@JsonProperty(value="template_id")
	private String templateId;
	
	/** The message. */
	private CampaignContentMessage message;
	
	/** The action. */
	private Action action;
	
	/** The media. */
	private CampaignContentMedia media;

	/** The icon. */
	private CampaignContentIcon icon;
	
	/** The platform specific content. */
	@JsonProperty(value="platform_specific")
	private PlatformSpecificContent platformSpecificContent;

	/**
	 * Gets the title.
	 *
	 * @return the title
	 */
	public Object getTitle() {
		return title;
	}

	/**
	 * Sets the title.
	 *
	 * @param title the new title
	 */
	public void setTitle(Object title) {
		this.title = title;
	}

	/**
	 * Gets the body.
	 *
	 * @return the body
	 */
	public String getBody() {
		return body;
	}

	/**
	 * Sets the body.
	 *
	 * @param body the new body
	 */
	public void setBody(String body) {
		this.body = body;
	}

	/**
	 * Gets the subject.
	 *
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * Sets the subject.
	 *
	 * @param subject the new subject
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * Gets the sender name.
	 *
	 * @return the sender name
	 */
	public String getSenderName() {
		return senderName;
	}

	/**
	 * Sets the sender name.
	 *
	 * @param senderName the new sender name
	 */
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	/**
	 * Gets the template name.
	 *
	 * @return the template name
	 */
	public String getTemplateName() {
		return templateName;
	}

	/**
	 * Sets the template name.
	 *
	 * @param templateName the new template name
	 */
	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	/**
	 * Gets the replacements.
	 *
	 * @return the replacements
	 */
	public Object getReplacements() {
		return replacements;
	}

	/**
	 * Sets the replacements.
	 *
	 * @param replacements the new replacements
	 */
	public void setReplacements(Object replacements) {
		this.replacements = replacements;
	}

	
	/**
	 * Gets the campaign content attachments.
	 *
	 * @return the campaign content attachments
	 */
	public CampaignContentAttachments getCampaignContentAttachments() {
		return campaignContentAttachments;
	}

	/**
	 * Sets the campaign content attachments.
	 *
	 * @param campaignContentAttachments the new campaign content attachments
	 */
	public void setCampaignContentAttachments(CampaignContentAttachments campaignContentAttachments) {
		this.campaignContentAttachments = campaignContentAttachments;
	}

	/**
	 * Gets the template id.
	 *
	 * @return the template id
	 */
	public String getTemplateId() {
		return templateId;
	}

	/**
	 * Sets the template id.
	 *
	 * @param templateId the new template id
	 */
	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}

	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	public CampaignContentMessage getMessage() {
		return message;
	}

	/**
	 * Sets the message.
	 *
	 * @param message the new message
	 */
	public void setMessage(CampaignContentMessage message) {
		this.message = message;
	}

	/**
	 * Gets the action.
	 *
	 * @return the action
	 */
	public Action getAction() {
		return action;
	}

	/**
	 * Sets the action.
	 *
	 * @param action the new action
	 */
	public void setAction(Action action) {
		this.action = action;
	}

	/**
	 * Gets the media.
	 *
	 * @return the media
	 */
	public CampaignContentMedia getMedia() {
		return media;
	}

	/**
	 * Sets the media.
	 *
	 * @param media the new media
	 */
	public void setMedia(CampaignContentMedia media) {
		this.media = media;
	}

	/**
	 * Gets the icon.
	 *
	 * @return the icon
	 */
	public CampaignContentIcon getIcon() {
		return icon;
	}

	/**
	 * Sets the icon.
	 *
	 * @param icon the new icon
	 */
	public void setIcon(CampaignContentIcon icon) {
		this.icon = icon;
	}

	/**
	 * Gets the platform specific content.
	 *
	 * @return the platform specific content
	 */
	public PlatformSpecificContent getPlatformSpecificContent() {
		return platformSpecificContent;
	}

	/**
	 * Sets the platform specific content.
	 *
	 * @param platformSpecificContent the new platform specific content
	 */
	public void setPlatformSpecificContent(PlatformSpecificContent platformSpecificContent) {
		this.platformSpecificContent = platformSpecificContent;
	}

}

package payload.campaign;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import helper.enums.CampaignMethod;
import payload.campaign.campaigncontent.Content;

import com.fasterxml.jackson.annotation.JsonInclude.Include;

// TODO: Auto-generated Javadoc
/**
 * The Class CampaignPayload.
 */
@JsonInclude(Include.NON_DEFAULT)
public class CampaignPayload {
	
	/** The campaign name. */
	@JsonProperty(value="name")
	private String campaignName;
	
	/** The campaign send time. */
	@JsonProperty(value="when")
	private String campaignSendTime;
	
	/** The content, defined as Object type because it can be a single Content object as well a list of Content objects*/
	private Object content;
	
	/** The provider nick name. */
	@JsonProperty(value="provider_nick_name")
	private String providerNickName;
	
	/** The provider group nickname. */
	@JsonProperty(value="provider_group_nickname")
	private String providerGroupNickname;
	
	/** The campaign send to. */
	@JsonProperty(value="where")
	private Where campaignSendTo;
	
	/** The respect frequency caps. */
	@JsonProperty(value="respect_frequency_caps")
	private boolean respectFrequencyCaps;
	
	/** The estimate only. */
	@JsonProperty(value="estimate_only")
	private boolean estimateOnly;
	
	/** The async estimate. */
	@JsonProperty(value="async_estimate")
	private boolean asyncEstimate;
	
	/** The time to live for app inbox. */
	@JsonProperty(value="time_to_live")
	private int timeToLiveForAppInbox;
	
	/** The time to live for push. */
	@JsonProperty(value="ttl")
	private int timeToLiveForPush;
	
	/** The wzrk cid. */
	@JsonProperty(value="wzrk_cid")
	private String wzrkCid;
	
	/** The wzrk bc. */
	@JsonProperty(value="wzrk_bc")
	private String wzrkBc;
	
	/** The wzrk bi. */
	@JsonProperty(value="wzrk_bi")
	private String wzrkBi;
	
	/** The include system control group. */
	@JsonProperty(value="system_control_group_include")
	private boolean includeSystemControlGroup;
	
	/** The control group. */
	@JsonProperty(value="control_group")
	private ControlGroup controlGroup;
	
	/** The wzrk acts. */
	@JsonProperty(value="wzrk_acts")
	private String wzrkActs;
	
	/** The respect throttle. */
	@JsonProperty(value="respect_throttle")
	private boolean respectThrottle;
	
	/** The skip estimate. */
	@JsonProperty(value="skip_estimate")
	private boolean skipEstimate;
	
	/** The send to all devices. */
	@JsonProperty(value="send_to_all_devices")
	private boolean sendToAllDevices;
	
	/** The segment. */
	private int segment;
	
	/** The send message to. */
	@JsonProperty(value="to")
	private To sendMessageTo;
	
	/** The tag group. */
	@JsonProperty(value="tag_group")
	private String tagGroup;
	
	/** The badge id. */
	@JsonProperty(value="badge_id")
	private int badgeId;
	
	/** The badge icon. */
	@JsonProperty(value="badge_icon")
	private String badgeIcon;
	
	/** The mutable content. */
	@JsonProperty(value="mutable_content")
	private boolean mutableContent;
	
	/** The campaign id. */
	@JsonProperty(value="id")
	private int campaignId;
	
	/** The template type. */
	@JsonProperty(value="template_type")
	private String templateType;
	
	/** The target mode. */
	@JsonProperty(value="target_mode")
	private String targetMode;
	
	/** The devices. */
	private List<String> devices;
	
	/** The webhook endpoint name. */
	@JsonProperty(value="webhook_endpoint_name")
	private String webhookEndpointName;
	
	/** The webhook fields. */
	@JsonProperty(value="webhook_fields")
	private List<String> webhookFields;
	
	/** The webhook key value. */
	@JsonProperty(value="webhook_key_value")
	private List<String> webhookKeyValue;
	
	/** The tags. */
	private List<String> tags;
	
	/** The orientation. */
	private String orientation;
	
	/**
	 * Gets the orientation.
	 *
	 * @return the orientation
	 */
	public String getOrientation() {
		return orientation;
	}

	/**
	 * Sets the orientation.
	 *
	 * @param orientation the new orientation
	 */
	public void setOrientation(String orientation) {
		this.orientation = orientation;
	}

	/**
	 * Gets the tags.
	 *
	 * @return the tags
	 */
	public List<String> getTags() {
		return tags;
	}

	/**
	 * Sets the tags.
	 *
	 * @param tags the new tags
	 */
	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	/**
	 * Gets the webhook endpoint name.
	 *
	 * @return the webhook endpoint name
	 */
	public String getWebhookEndpointName() {
		return webhookEndpointName;
	}

	/**
	 * Sets the webhook endpoint name.
	 *
	 * @param webhookEndpointName the new webhook endpoint name
	 */
	public void setWebhookEndpointName(String webhookEndpointName) {
		this.webhookEndpointName = webhookEndpointName;
	}

	/**
	 * Gets the webhook fields.
	 *
	 * @return the webhook fields
	 */
	public List<String> getWebhookFields() {
		return webhookFields;
	}

	/**
	 * Sets the webhook fields.
	 *
	 * @param webhookFields the new webhook fields
	 */
	public void setWebhookFields(List<String> webhookFields) {
		this.webhookFields = webhookFields;
	}

	/**
	 * Gets the webhook key value.
	 *
	 * @return the webhook key value
	 */
	public List<String> getWebhookKeyValue() {
		return webhookKeyValue;
	}

	/**
	 * Sets the webhook key value.
	 *
	 * @param webhookKeyValue the new webhook key value
	 */
	public void setWebhookKeyValue(List<String> webhookKeyValue) {
		this.webhookKeyValue = webhookKeyValue;
	}

	/**
	 * Gets the devices.
	 *
	 * @return the devices
	 */
	public List<String> getDevices() {
		return devices;
	}

	/**
	 * Sets the devices.
	 *
	 * @param devices the new devices
	 */
	public void setDevices(List<String> devices) {
		this.devices = devices;
	}

	/**
	 * Gets the template type.
	 *
	 * @return the template type
	 */
	public String getTemplateType() {
		return templateType;
	}

	/**
	 * Sets the template type.
	 *
	 * @param templateType the new template type
	 */
	public void setTemplateType(String templateType) {
		this.templateType = templateType;
	}

	/**
	 * Sets the target mode.
	 *
	 * @param targetMode the new target mode
	 */
	public void setTargetMode(String targetMode) {
		this.targetMode = targetMode;
	}


	/**
	 * Gets the target mode.
	 *
	 * @return the target mode
	 */
	public String getTargetMode() {
		return targetMode;
	}

	/**
	 * Sets the target mode.
	 *
	 * @param targetMode the new target mode
	 */
	public void setTargetMode(CampaignMethod targetMode) {
		if(targetMode==CampaignMethod.WEBPUSH){
			this.targetMode = "webpush";
		}
		else if(targetMode==CampaignMethod.MOBILEPUSH){
			this.targetMode = "push";
		}
		else if(targetMode==CampaignMethod.EMAIL){
			this.targetMode = "email";
		}
		else if(targetMode==CampaignMethod.SMS){
			this.targetMode = "sms";
		}
		else if(targetMode==CampaignMethod.WEBHOOKS){
			this.targetMode = "webhook";
		}
		else if(targetMode==CampaignMethod.APPINBOX){
			this.targetMode = "notificationinbox";
		}
		else if(targetMode==CampaignMethod.WHATSAPP) {
			this.targetMode = "whatsapp";
		}
	}

	/**
	 * Gets the campaign name.
	 *
	 * @return the campaign name
	 */
	public String getCampaignName() {
		return campaignName;
	}

	/**
	 * Sets the campaign name.
	 *
	 * @param campaignName the new campaign name
	 */
	public void setCampaignName(String campaignName) {
		this.campaignName = campaignName;
	}

	/**
	 * Gets the campaign send time.
	 *
	 * @return the campaign send time
	 */
	public String getCampaignSendTime() {
		return campaignSendTime;
	}

	/**
	 * Sets the campaign send time.
	 *
	 * @param campaignSendTime the new campaign send time
	 */
	public void setCampaignSendTime(String campaignSendTime) {
		this.campaignSendTime = campaignSendTime;
	}

	/**
	 * Gets the content.
	 *
	 * @return the content
	 */
	public Object getContent() {
		return content;
	}

	/**
	 * Sets the content.
	 *
	 * @param content the new content
	 */
	public void setContent(Content content) {
		this.content = content;
	}
	
	/**
	 * Sets the content.
	 *
	 * @param content the new content
	 */
	public void setContent(List<Content> content) {
		this.content = content;
	}

	/**
	 * Gets the provider nick name.
	 *
	 * @return the provider nick name
	 */
	public String getProviderNickName() {
		return providerNickName;
	}

	/**
	 * Sets the provider nick name.
	 *
	 * @param providerNickName the new provider nick name
	 */
	public void setProviderNickName(String providerNickName) {
		this.providerNickName = providerNickName;
	}

	/**
	 * Gets the provider group nickname.
	 *
	 * @return the provider group nickname
	 */
	public String getProviderGroupNickname() {
		return providerGroupNickname;
	}

	/**
	 * Sets the provider group nickname.
	 *
	 * @param providerGroupNickname the new provider group nickname
	 */
	public void setProviderGroupNickname(String providerGroupNickname) {
		this.providerGroupNickname = providerGroupNickname;
	}

	/**
	 * Gets the campaign send to.
	 *
	 * @return the campaign send to
	 */
	public Where getCampaignSendTo() {
		return campaignSendTo;
	}

	/**
	 * Sets the campaign send to.
	 *
	 * @param campaignSendTo the new campaign send to
	 */
	public void setCampaignSendTo(Where campaignSendTo) {
		this.campaignSendTo = campaignSendTo;
	}

	/**
	 * Checks if is respect frequency caps.
	 *
	 * @return true, if is respect frequency caps
	 */
	public boolean isRespectFrequencyCaps() {
		return respectFrequencyCaps;
	}

	/**
	 * Sets the respect frequency caps.
	 *
	 * @param respectFrequencyCaps the new respect frequency caps
	 */
	public void setRespectFrequencyCaps(boolean respectFrequencyCaps) {
		this.respectFrequencyCaps = respectFrequencyCaps;
	}

	/**
	 * Checks if is estimate only.
	 *
	 * @return true, if is estimate only
	 */
	public boolean isEstimateOnly() {
		return estimateOnly;
	}

	/**
	 * Sets the estimate only.
	 *
	 * @param estimateOnly the new estimate only
	 */
	public void setEstimateOnly(boolean estimateOnly) {
		this.estimateOnly = estimateOnly;
	}

	/**
	 * Checks if is async estimate.
	 *
	 * @return true, if is async estimate
	 */
	public boolean isAsyncEstimate() {
		return asyncEstimate;
	}

	/**
	 * Sets the async estimate.
	 *
	 * @param asyncEstimate the new async estimate
	 */
	public void setAsyncEstimate(boolean asyncEstimate) {
		this.asyncEstimate = asyncEstimate;
	}

	/**
	 * Gets the time to live for push.
	 *
	 * @return the time to live for push
	 */
	public int getTimeToLiveForPush() {
		return timeToLiveForPush;
	}

	/**
	 * Sets the time to live for push.
	 *
	 * @param timeToLiveForPush the new time to live for push
	 */
	public void setTimeToLiveForPush(int timeToLiveForPush) {
		this.timeToLiveForPush = timeToLiveForPush;
	}

	/**
	 * Sets the content.
	 *
	 * @param content the new content
	 */
	public void setContent(Object content) {
		this.content = content;
	}

	/**
	 * Gets the wzrk cid.
	 *
	 * @return the wzrk cid
	 */
	public String getWzrkCid() {
		return wzrkCid;
	}

	/**
	 * Sets the wzrk cid.
	 *
	 * @param wzrkCid the new wzrk cid
	 */
	public void setWzrkCid(String wzrkCid) {
		this.wzrkCid = wzrkCid;
	}

	/**
	 * Gets the wzrk bc.
	 *
	 * @return the wzrk bc
	 */
	public String getWzrkBc() {
		return wzrkBc;
	}

	/**
	 * Sets the wzrk bc.
	 *
	 * @param wzrkBc the new wzrk bc
	 */
	public void setWzrkBc(String wzrkBc) {
		this.wzrkBc = wzrkBc;
	}

	/**
	 * Gets the wzrk bi.
	 *
	 * @return the wzrk bi
	 */
	public String getWzrkBi() {
		return wzrkBi;
	}

	/**
	 * Sets the wzrk bi.
	 *
	 * @param wzrkBi the new wzrk bi
	 */
	public void setWzrkBi(String wzrkBi) {
		this.wzrkBi = wzrkBi;
	}

	/**
	 * Checks if is include system control group.
	 *
	 * @return true, if is include system control group
	 */
	public boolean isIncludeSystemControlGroup() {
		return includeSystemControlGroup;
	}

	/**
	 * Sets the include system control group.
	 *
	 * @param includeSystemControlGroup the new include system control group
	 */
	public void setIncludeSystemControlGroup(boolean includeSystemControlGroup) {
		this.includeSystemControlGroup = includeSystemControlGroup;
	}

	/**
	 * Gets the control group.
	 *
	 * @return the control group
	 */
	public ControlGroup getControlGroup() {
		return controlGroup;
	}

	/**
	 * Sets the control group.
	 *
	 * @param controlGroup the new control group
	 */
	public void setControlGroup(ControlGroup controlGroup) {
		this.controlGroup = controlGroup;
	}

	/**
	 * Gets the wzrk acts.
	 *
	 * @return the wzrk acts
	 */
	public String getWzrkActs() {
		return wzrkActs;
	}

	/**
	 * Sets the wzrk acts.
	 *
	 * @param wzrkActs the new wzrk acts
	 */
	public void setWzrkActs(String wzrkActs) {
		this.wzrkActs = wzrkActs;
	}

	/**
	 * Checks if is respect throttle.
	 *
	 * @return true, if is respect throttle
	 */
	public boolean isRespectThrottle() {
		return respectThrottle;
	}

	/**
	 * Sets the respect throttle.
	 *
	 * @param respectThrottle the new respect throttle
	 */
	public void setRespectThrottle(boolean respectThrottle) {
		this.respectThrottle = respectThrottle;
	}

	/**
	 * Checks if is skip estimate.
	 *
	 * @return true, if is skip estimate
	 */
	public boolean isSkipEstimate() {
		return skipEstimate;
	}

	/**
	 * Sets the skip estimate.
	 *
	 * @param skipEstimate the new skip estimate
	 */
	public void setSkipEstimate(boolean skipEstimate) {
		this.skipEstimate = skipEstimate;
	}

	/**
	 * Checks if is send to all devices.
	 *
	 * @return true, if is send to all devices
	 */
	public boolean isSendToAllDevices() {
		return sendToAllDevices;
	}

	/**
	 * Sets the send to all devices.
	 *
	 * @param sendToAllDevices the new send to all devices
	 */
	public void setSendToAllDevices(boolean sendToAllDevices) {
		this.sendToAllDevices = sendToAllDevices;
	}

	/**
	 * Gets the segment.
	 *
	 * @return the segment
	 */
	public int getSegment() {
		return segment;
	}

	/**
	 * Sets the segment.
	 *
	 * @param segment the new segment
	 */
	public void setSegment(int segment) {
		this.segment = segment;
	}

	/**
	 * Gets the send message to.
	 *
	 * @return the send message to
	 */
	public To getSendMessageTo() {
		return sendMessageTo;
	}

	/**
	 * Sets the send message to.
	 *
	 * @param sendMessageTo the new send message to
	 */
	public void setSendMessageTo(To sendMessageTo) {
		this.sendMessageTo = sendMessageTo;
	}

	/**
	 * Gets the tag group.
	 *
	 * @return the tag group
	 */
	public String getTagGroup() {
		return tagGroup;
	}

	/**
	 * Sets the tag group.
	 *
	 * @param tagGroup the new tag group
	 */
	public void setTagGroup(String tagGroup) {
		this.tagGroup = tagGroup;
	}

	/**
	 * Gets the badge id.
	 *
	 * @return the badge id
	 */
	public int getBadgeId() {
		return badgeId;
	}

	/**
	 * Sets the badge id.
	 *
	 * @param badgeId the new badge id
	 */
	public void setBadgeId(int badgeId) {
		this.badgeId = badgeId;
	}

	/**
	 * Gets the badge icon.
	 *
	 * @return the badge icon
	 */
	public String getBadgeIcon() {
		return badgeIcon;
	}

	/**
	 * Sets the badge icon.
	 *
	 * @param badgeIcon the new badge icon
	 */
	public void setBadgeIcon(String badgeIcon) {
		this.badgeIcon = badgeIcon;
	}

	/**
	 * Checks if is mutable content.
	 *
	 * @return true, if is mutable content
	 */
	public boolean isMutableContent() {
		return mutableContent;
	}

	/**
	 * Sets the mutable content.
	 *
	 * @param mutableContent the new mutable content
	 */
	public void setMutableContent(boolean mutableContent) {
		this.mutableContent = mutableContent;
	}

	/**
	 * Gets the campaign id.
	 *
	 * @return the campaign id
	 */
	public int getCampaignId() {
		return campaignId;
	}

	/**
	 * Sets the campaign id.
	 *
	 * @param campaignId the new campaign id
	 */
	public void setCampaignId(int campaignId) {
		this.campaignId = campaignId;
	}

	/**
	 * Gets the time to live for app inbox.
	 *
	 * @return the time to live for app inbox
	 */
	public int getTimeToLiveForAppInbox() {
		return timeToLiveForAppInbox;
	}

	/**
	 * Sets the time to live for app inbox.
	 *
	 * @param timeToLiveForAppInbox the new time to live for app inbox
	 */
	public void setTimeToLiveForAppInbox(int timeToLiveForAppInbox) {
		this.timeToLiveForAppInbox = timeToLiveForAppInbox;
	}

	
}

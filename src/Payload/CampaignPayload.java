package Payload;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import Helper.Enums.CampaignMethod;

import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_DEFAULT)
public class CampaignPayload {
	
	@JsonProperty(value="name")
	String campaignName;
	
	@JsonProperty(value="when")
	String campaignSendTime;
	
	Object content;
	
	@JsonProperty(value="provider_nick_name")
	String providerNickName;
	
	@JsonProperty(value="provider_group_nickname")
	String providerGroupNickname;
	
	@JsonProperty(value="where")
	Where campaignSendTo;
	
	@JsonProperty(value="respect_frequency_caps")
	boolean respectFrequencyCaps;
	
	@JsonProperty(value="estimate_only")
	boolean estimateOnly;
	
	@JsonProperty(value="async_estimate")
	boolean asyncEstimate;
	
	@JsonProperty(value="time_to_live")
	int timeToLiveForAppInbox;
	
	@JsonProperty(value="ttl")
	int timeToLiveForPush;
	
	@JsonProperty(value="wzrk_cid")
	String wzrkCid;
	
	@JsonProperty(value="wzrk_bc")
	String wzrkBc;
	
	@JsonProperty(value="wzrk_bi")
	String wzrkBi;
	
	@JsonProperty(value="system_control_group_include")
	boolean includeSystemControlGroup;
	
	@JsonProperty(value="control_group")
	ControlGroup controlGroup;
	
	@JsonProperty(value="wzrk_acts")
	String wzrkActs;
	
	@JsonProperty(value="respect_throttle")
	boolean respectThrottle;
	
	@JsonProperty(value="skip_estimate")
	boolean skipEstimate;
	
	@JsonProperty(value="send_to_all_devices")
	boolean sendToAllDevices;
	
	int segment;
	
	@JsonProperty(value="to")
	To sendMessageTo;
	
	@JsonProperty(value="tag_group")
	String tagGroup;
	
	@JsonProperty(value="badge_id")
	int badgeId;
	
	@JsonProperty(value="badge_icon")
	String badgeIcon;
	
	@JsonProperty(value="mutable_content")
	boolean mutableContent;
	
	@JsonProperty(value="id")
	int campaignId;
	
	@JsonProperty(value="template_type")
	String templateType;
	
	@JsonProperty(value="target_mode")
	String targetMode;
	
	List<String> devices;
	
	@JsonProperty(value="webhook_endpoint_name")
	String webhookEndpointName;
	
	@JsonProperty(value="webhook_fields")
	List<String> webhookFields;
	
	@JsonProperty(value="webhook_key_value")
	List<String> webhookKeyValue;
	
	List<String> tags;
	
	String orientation;
	
	public String getOrientation() {
		return orientation;
	}

	public void setOrientation(String orientation) {
		this.orientation = orientation;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public String getWebhookEndpointName() {
		return webhookEndpointName;
	}

	public void setWebhookEndpointName(String webhookEndpointName) {
		this.webhookEndpointName = webhookEndpointName;
	}

	public List<String> getWebhookFields() {
		return webhookFields;
	}

	public void setWebhookFields(List<String> webhookFields) {
		this.webhookFields = webhookFields;
	}

	public List<String> getWebhookKeyValue() {
		return webhookKeyValue;
	}

	public void setWebhookKeyValue(List<String> webhookKeyValue) {
		this.webhookKeyValue = webhookKeyValue;
	}

	public List<String> getDevices() {
		return devices;
	}

	public void setDevices(List<String> devices) {
		this.devices = devices;
	}

	public String getTemplateType() {
		return templateType;
	}

	public void setTemplateType(String templateType) {
		this.templateType = templateType;
	}

	public void setTargetMode(String targetMode) {
		this.targetMode = targetMode;
	}


	public String getTargetMode() {
		return targetMode;
	}

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

	public String getCampaignName() {
		return campaignName;
	}

	public void setCampaignName(String campaignName) {
		this.campaignName = campaignName;
	}

	public String getCampaignSendTime() {
		return campaignSendTime;
	}

	public void setCampaignSendTime(String campaignSendTime) {
		this.campaignSendTime = campaignSendTime;
	}

	public Object getContent() {
		return content;
	}

	public void setContent(Content content) {
		this.content = content;
	}
	public void setContent(List<Content> content) {
		this.content = content;
	}

	public String getProviderNickName() {
		return providerNickName;
	}

	public void setProviderNickName(String providerNickName) {
		this.providerNickName = providerNickName;
	}

	public String getProviderGroupNickname() {
		return providerGroupNickname;
	}

	public void setProviderGroupNickname(String providerGroupNickname) {
		this.providerGroupNickname = providerGroupNickname;
	}

	public Where getCampaignSendTo() {
		return campaignSendTo;
	}

	public void setCampaignSendTo(Where campaignSendTo) {
		this.campaignSendTo = campaignSendTo;
	}

	public boolean isRespectFrequencyCaps() {
		return respectFrequencyCaps;
	}

	public void setRespectFrequencyCaps(boolean respectFrequencyCaps) {
		this.respectFrequencyCaps = respectFrequencyCaps;
	}

	public boolean isEstimateOnly() {
		return estimateOnly;
	}

	public void setEstimateOnly(boolean estimateOnly) {
		this.estimateOnly = estimateOnly;
	}

	public boolean isAsyncEstimate() {
		return asyncEstimate;
	}

	public void setAsyncEstimate(boolean asyncEstimate) {
		this.asyncEstimate = asyncEstimate;
	}

	public int getTimeToLiveForPush() {
		return timeToLiveForPush;
	}

	public void setTimeToLiveForPush(int timeToLiveForPush) {
		this.timeToLiveForPush = timeToLiveForPush;
	}

	public void setContent(Object content) {
		this.content = content;
	}

	public String getWzrkCid() {
		return wzrkCid;
	}

	public void setWzrkCid(String wzrkCid) {
		this.wzrkCid = wzrkCid;
	}

	public String getWzrkBc() {
		return wzrkBc;
	}

	public void setWzrkBc(String wzrkBc) {
		this.wzrkBc = wzrkBc;
	}

	public String getWzrkBi() {
		return wzrkBi;
	}

	public void setWzrkBi(String wzrkBi) {
		this.wzrkBi = wzrkBi;
	}

	public boolean isIncludeSystemControlGroup() {
		return includeSystemControlGroup;
	}

	public void setIncludeSystemControlGroup(boolean includeSystemControlGroup) {
		this.includeSystemControlGroup = includeSystemControlGroup;
	}

	public ControlGroup getControlGroup() {
		return controlGroup;
	}

	public void setControlGroup(ControlGroup controlGroup) {
		this.controlGroup = controlGroup;
	}

	public String getWzrkActs() {
		return wzrkActs;
	}

	public void setWzrkActs(String wzrkActs) {
		this.wzrkActs = wzrkActs;
	}

	public boolean isRespectThrottle() {
		return respectThrottle;
	}

	public void setRespectThrottle(boolean respectThrottle) {
		this.respectThrottle = respectThrottle;
	}

	public boolean isSkipEstimate() {
		return skipEstimate;
	}

	public void setSkipEstimate(boolean skipEstimate) {
		this.skipEstimate = skipEstimate;
	}

	public boolean isSendToAllDevices() {
		return sendToAllDevices;
	}

	public void setSendToAllDevices(boolean sendToAllDevices) {
		this.sendToAllDevices = sendToAllDevices;
	}

	public int getSegment() {
		return segment;
	}

	public void setSegment(int segment) {
		this.segment = segment;
	}

	public To getSendMessageTo() {
		return sendMessageTo;
	}

	public void setSendMessageTo(To sendMessageTo) {
		this.sendMessageTo = sendMessageTo;
	}

	public String getTagGroup() {
		return tagGroup;
	}

	public void setTagGroup(String tagGroup) {
		this.tagGroup = tagGroup;
	}

	public int getBadgeId() {
		return badgeId;
	}

	public void setBadgeId(int badgeId) {
		this.badgeId = badgeId;
	}

	public String getBadgeIcon() {
		return badgeIcon;
	}

	public void setBadgeIcon(String badgeIcon) {
		this.badgeIcon = badgeIcon;
	}

	public boolean isMutableContent() {
		return mutableContent;
	}

	public void setMutableContent(boolean mutableContent) {
		this.mutableContent = mutableContent;
	}

	public int getCampaignId() {
		return campaignId;
	}

	public void setCampaignId(int campaignId) {
		this.campaignId = campaignId;
	}

	public int getTimeToLiveForAppInbox() {
		return timeToLiveForAppInbox;
	}

	public void setTimeToLiveForAppInbox(int timeToLiveForAppInbox) {
		this.timeToLiveForAppInbox = timeToLiveForAppInbox;
	}

	
}

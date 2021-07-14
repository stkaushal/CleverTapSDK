package campaign.unit;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import campaign.Campaigns;
import helper.ClevertapInstance;
import helper.enums.CampaignMethod;
import helper.enums.Region;
import http.HttpClient;
import payload.campaign.CampaignPayload;
import payload.campaign.ControlGroup;
import payload.campaign.DateRangePayload;
import payload.campaign.To;
import payload.campaign.Where;
import payload.campaign.campaigncontent.CampaignContentAttachments;
import payload.campaign.campaigncontent.CampaignContentIcon;
import payload.campaign.campaigncontent.CampaignContentMedia;
import payload.campaign.campaigncontent.CampaignContentMessage;
import payload.campaign.campaigncontent.CampaignContentTitle;
import payload.campaign.campaigncontent.Content;
import payload.campaign.campaigncontent.PlatformSpecificContent;
import payload.campaign.campaigncontent.actions.Action;
import payload.campaign.campaigncontent.actions.ActionLinks;
import payload.campaign.campaigncontent.actions.actionurl.ActionUrl;
import payload.campaign.campaigncontent.actions.actionurl.AndroidActionUrl;
import payload.campaign.campaigncontent.actions.actionurl.IosActionUrl;
import payload.campaign.campaigncontent.platformtype.PlatformTypeAndroid;
import payload.campaign.campaigncontent.platformtype.PlatformTypeChrome;
import payload.campaign.campaigncontent.platformtype.PlatformTypeFirefox;
import payload.campaign.campaigncontent.platformtype.PlatformTypeIos;
import payload.campaign.campaigncontent.platformtype.PlatformTypeSafari;
import response.Response;

public class CampaignsUnitTest {
	
	ClevertapInstance instance  = new ClevertapInstance("dummy", "dummy", Region.DEFAULT);   
	Campaigns resCampaigns = instance.getCampaignInstance();
	
	@Mock HttpClient client;
	@InjectMocks Campaigns campaigns;

	@BeforeEach
	public void setUp() throws Exception {
		System.out.println("Before Campaign test call");
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testStopScheduledCampaign() throws IOException, InterruptedException {
		Response response = null;
		JSONObject jsonResponse = new JSONObject();
		jsonResponse.put("status", "success");
		CampaignPayload payload = new CampaignPayload();
		payload.setCampaignName("Send Mail");
		
		Mockito.when(client.postRequest(Mockito.anyString(), Mockito.any(JSONObject.class))).thenReturn(jsonResponse);
		
		response = campaigns.stopScheduledCampaign(payload);
   
		Assertions.assertNotNull(response);
		Assertions.assertEquals("success", response.getStatus());	
	}

	@Test
	public void testGetCampaignReport() throws IOException, InterruptedException {
		Response response = null;
		JSONObject jsonResponse = new JSONObject();
		jsonResponse.put("status", "success");
		CampaignPayload payload = new CampaignPayload();
		payload.setCampaignName("Send Mail");
		payload.setCampaignSendTime("dummy");
		Content content = new Content();
		content.setTitle("dummy");
		content.setBody("dummy");
		content.setSubject("dummy");
		content.setSenderName("dummy");
		content.setTemplateId("dummy");
		content.setTemplateName("dummy");
		content.setReplacements("dummy");
		CampaignContentAttachments campaignContentAttachments = new CampaignContentAttachments();
		campaignContentAttachments.setAttachmentType("dummy");
		campaignContentAttachments.setAttachmentValue("dummy");
		content.setCampaignContentAttachments(campaignContentAttachments );
		PlatformTypeAndroid android = new PlatformTypeAndroid();
		android.setBackgroundImageURL("dummy");
		android.setDefaultSound(true);
		android.setLargeIconURL("dummy");
		android.setTimeToLive(10);
		PlatformSpecificContent platformSpecific = new PlatformSpecificContent(); 
		platformSpecific.setPlatformTypeAndroid(android);
		content.setPlatformSpecificContent(platformSpecific);
		payload.setContent(content);
		payload.setRespectFrequencyCaps(true);
		payload.setEstimateOnly(true);
		payload.setAsyncEstimate(true);
		payload.setTimeToLiveForPush(0);
		payload.setSegment(0);
		payload.setSendToAllDevices(true);
		payload.setSkipEstimate(true);
		payload.setRespectThrottle(true);
		payload.setWzrkActs("dummy");
		payload.setWzrkBc("dummy");
		payload.setWzrkBi("dummy");
		payload.setWzrkCid("dummy");
		Where where = new Where();
		where.setEventName("dummy");
		where.setFromDate(01012020);
		where.setToDate(01012021);
		payload.setCampaignSendTo(where);
		payload.setBadgeIcon("dummy");
		payload.setBadgeId(0);
		payload.setMutableContent(true);
		payload.setCampaignId(0);
		payload.setProviderGroupNickname("dummy");
		payload.setProviderNickName("dummy");
		payload.setIncludeSystemControlGroup(true);
		payload.setTagGroup("dummy");
		ControlGroup control_group = new ControlGroup();
		control_group.setName("dummy");
		control_group.setPercentage(90);
		control_group.setType("dummy");
		payload.setControlGroup(control_group);
		To to = new To();
		List<String> id = new ArrayList<String>();
		id.add("dummy");
		to.setEmail(id);
		to.setFbid(id);
		to.setIdentity(id);
		to.setObjectId(id);
		payload.setSendMessageTo(to);
		

		Mockito.when(client.postRequest(Mockito.anyString(), Mockito.any(JSONObject.class))).thenReturn(jsonResponse);
		
		response = campaigns.getCampaignReport(payload);
   
		Assertions.assertNotNull(response);
		Assertions.assertEquals("success", response.getStatus());
	}

	@Test
	public void testGetCampaigns() throws IOException, InterruptedException {
		Response response = null;
		JSONObject jsonResponse = new JSONObject();
		jsonResponse.put("status", "success");
		jsonResponse.put("processed", 1);
		JSONArray unProcessed = new JSONArray();
		JSONObject jsonUnProcessed = new JSONObject();
		jsonUnProcessed.put("test", "dummy");
		unProcessed.put(jsonUnProcessed);
		jsonResponse.put("unprocessed", unProcessed);
		jsonResponse.put("error", "Failed");
		jsonResponse.put("code", 200);
		jsonResponse.put("count", 1);
		jsonResponse.put("req_id", 1);
		JSONObject userT = new JSONObject();
		userT.put("type1", "test");
		jsonResponse.put("user_type", userT);
		jsonResponse.put("total_results", 1);
		JSONArray messages = new JSONArray();
		JSONObject jsonMessages = new JSONObject();
		jsonMessages.put("message id", 1);
		JSONArray msgData = new JSONArray();
		JSONObject jsonData = new JSONObject();
		jsonData.put("test", "dummy");
		msgData.put(jsonData);
		jsonMessages.put("data", msgData);
		jsonMessages.put("start_date", "dummy");
		JSONArray device = new JSONArray();
		device.put("dummy");
		jsonMessages.put("device", device);
		jsonMessages.put("conversion_event", "dummy");
		JSONArray lables = new JSONArray();
		jsonMessages.put("lables", lables);
		jsonMessages.put("channel", "dummy");
		jsonMessages.put("message_name", "dummy");
		jsonMessages.put("delivery", "dummy");
		messages.put(jsonMessages);
		
		jsonResponse.put("messages", messages);
		JSONObject jsonEstimates = new JSONObject();
		jsonEstimates.put("dummy", "test");
		jsonResponse.put("estimates", jsonEstimates);
		JSONObject resultCampReport = new JSONObject();
		resultCampReport.put("clicked", 1);
		resultCampReport.put("sent", 1);
		jsonResponse.put("result", resultCampReport);
		
		JSONArray campTargets = new JSONArray();
		JSONObject jsonCampTargets = new JSONObject();
		jsonCampTargets.put("id", 1);
		jsonCampTargets.put("name", "dummy");
		jsonCampTargets.put("scheduled_on", 1);
		jsonCampTargets.put("status", "dummy");
		campTargets.put(jsonCampTargets);
		jsonResponse.put("targets", campTargets);
		jsonResponse.put("message", "dummy");
		jsonResponse.put("extraData", "dummy");
		
		DateRangePayload timeRange = new DateRangePayload();
		timeRange.setFromDate(20210606);
		timeRange.setToDate(20210609);
		
		Mockito.when(client.postRequest(Mockito.anyString(), Mockito.any(JSONObject.class))).thenReturn(jsonResponse);
		
		response = campaigns.getCampaigns(timeRange);
   
		Assertions.assertNotNull(response);
		Assertions.assertNotNull(response.getOtherInfo());
		Assertions.assertNotNull(response.getCode());
		Assertions.assertNotNull(response.getCount());
		Assertions.assertNotNull(response.getError());
		Assertions.assertNotNull(response.getEstimates());
		Assertions.assertNotNull(response.getMessage());
		Assertions.assertNotNull(response.getMessages());
		Assertions.assertNotNull(response.getMessages().get(0).getChannel());
		Assertions.assertNotNull(response.getMessages().get(0).getConversionEvent());
		Assertions.assertNotNull(response.getMessages().get(0).getData());
		Assertions.assertNotNull(response.getMessages().get(0).getDelivery());
		Assertions.assertNotNull(response.getMessages().get(0).getDevice());
		Assertions.assertNotNull(response.getMessages().get(0).getLables());
		Assertions.assertNotNull(response.getMessages().get(0).getMessageId());
		Assertions.assertNotNull(response.getMessages().get(0).getMessageName());
		Assertions.assertNotNull(response.getMessages().get(0).getStartDate());
		Assertions.assertNotNull(response.getProcessed());
		Assertions.assertNotNull(response.getReqId());
		Assertions.assertNotNull(response.getResult());
		Assertions.assertNotNull(response.getResult().getClicked());
		Assertions.assertNotNull(response.getResult().getSent());
		Assertions.assertNotNull(response.getTargets());
		Assertions.assertNotNull(response.getTargets().get(0).getId());
		Assertions.assertNotNull(response.getTargets().get(0).getName());
		Assertions.assertNotNull(response.getTargets().get(0).getScheduledOn());
		Assertions.assertNotNull(response.getTargets().get(0).getStatus());
		Assertions.assertNotNull(response.getTotalResults());
		Assertions.assertNotNull(response.getUnprocessed());
		Assertions.assertNotNull(response.getUserType());
		Assertions.assertEquals("success", response.getStatus());
	}

	@Test
	public void testCreateCampaignTargetUserEvents() throws IOException, InterruptedException {
		Response response = null;
		JSONObject jsonResponse = new JSONObject();
		jsonResponse.put("status", "success");
		CampaignPayload payload = new CampaignPayload();
		payload.setCampaignName("Send Mail");
		Content content = new Content();
		CampaignContentTitle title = new CampaignContentTitle();
		title.setText("dummy");
		content.setTitle(title);
		CampaignContentMessage message = new CampaignContentMessage();
		message.setText("dummy");
		content.setMessage(message);
		CampaignContentIcon icon = new CampaignContentIcon();
		icon.setContentType("dummy");
		icon.setMediaUrl("dummy");
		content.setIcon(icon);
		CampaignContentMedia media = new CampaignContentMedia();
		media.setContentType("dummy");
		media.setMediaUrl("dummy");
		content.setMedia(media);
		Action action = new Action();
		List<ActionLinks> actionlinks = new ArrayList<ActionLinks>();
		ActionLinks links = new ActionLinks();
		ActionUrl actionUrl = new ActionUrl();
		AndroidActionUrl androidActionUrl = new AndroidActionUrl();
		androidActionUrl.setText("dummy");
		IosActionUrl iosActionUrl = new IosActionUrl();
		iosActionUrl.setText("dummy");
		actionUrl.setAndroidActionUrl(androidActionUrl);
		actionUrl.setIosActionUrl(iosActionUrl);
		links.setType("dummy");
		links.setBg("dummy");
		links.setColor("dummy");
		links.setText("dummy");
		actionlinks.add(links);
		action.setActionlinks(actionlinks );
		action.setActionUrl(actionUrl);
		content.setAction(action);
		PlatformSpecificContent platformSpecificContent = new PlatformSpecificContent();
		PlatformTypeAndroid platformTypeAndroid = new PlatformTypeAndroid();
		platformTypeAndroid.setBackgroundImageURL("dummy");
		platformTypeAndroid.setCategory("dummy");
		platformSpecificContent.setPlatformTypeAndroid(platformTypeAndroid);
		PlatformTypeChrome platformTypeChrome = new PlatformTypeChrome();
		platformTypeChrome.setIconURL("dummy");
		platformTypeChrome.setDeepLink("dummy");
		platformSpecificContent.setPlatformTypeChrome(platformTypeChrome );
		PlatformTypeFirefox platformTypeFirefox = new PlatformTypeFirefox();
		platformTypeFirefox.setDeepLink("dummy");
		platformTypeFirefox.setTimeToLive("dummy");
		platformSpecificContent.setPlatformTypeFirefox(platformTypeFirefox );
		PlatformTypeIos platformTypeIos = new PlatformTypeIos();
		platformTypeIos.setBackgroundImageURL("dummy");
		platformTypeIos.setDefaultSound(true);
		platformSpecificContent.setPlatformTypeIos(platformTypeIos );
		PlatformTypeSafari platformTypeSafari = new PlatformTypeSafari();
		platformTypeSafari.setRequireInteraction("dummy");
		platformTypeSafari.setIconURL("dummy");
		platformSpecificContent.setPlatformTypeSafari(platformTypeSafari );
		content.setPlatformSpecificContent(platformSpecificContent );
		payload.setContent(content);
		
		Mockito.when(client.postRequest(Mockito.anyString(), Mockito.any(JSONObject.class))).thenReturn(jsonResponse);
		
		response = campaigns.createCampaignTargetUserEvents(payload);
   
		Assertions.assertNotNull(response);
		Assertions.assertEquals("success", response.getStatus());
	}

	@Test
	public void testCreateCampaignTargetId() throws IOException, InterruptedException {
		Response responseSMS = null;
		Response responseEMAIL = null;
		Response responsePUSH = null;
		Response responseWEBPUSH = null;
		JSONObject jsonResponse = new JSONObject();
		jsonResponse.put("status", "success");
		CampaignPayload payload = new CampaignPayload();
		payload.setCampaignName("Send Mail");
		
		Mockito.when(client.postRequest(Mockito.anyString(), Mockito.any(JSONObject.class))).thenReturn(jsonResponse);
		
		responseSMS = campaigns.createCampaignTargetId(CampaignMethod.SMS, payload);
		responseEMAIL = campaigns.createCampaignTargetId(CampaignMethod.EMAIL, payload);
		responsePUSH = campaigns.createCampaignTargetId(CampaignMethod.MOBILEPUSH, payload);
		responseWEBPUSH = campaigns.createCampaignTargetId(CampaignMethod.WEBPUSH, payload);
   
		Assertions.assertNotNull(responseSMS);
		Assertions.assertNotNull(responseEMAIL);
		Assertions.assertNotNull(responsePUSH);
		Assertions.assertNotNull(responseWEBPUSH);
		Assertions.assertEquals("success", responseSMS.getStatus());
		Assertions.assertEquals("success", responseEMAIL.getStatus());
		Assertions.assertEquals("success", responsePUSH.getStatus());
		Assertions.assertEquals("success", responseWEBPUSH.getStatus());
	}

}

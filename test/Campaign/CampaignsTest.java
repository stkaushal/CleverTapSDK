package Campaign;

import java.io.IOException;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import HTTP.HttpClient;
import Helper.ClevertapInstance;
import Payload.CampaignPayload;
import Payload.Content;
import Payload.ControlGroup;
import Payload.To;
import Payload.Where;
import Response.Response;

public class CampaignsTest {
	
	ClevertapInstance instance  = new ClevertapInstance("dummy", "dummy");   
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
		payload.setName("Send Mail");
		
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
		payload.setName("Send Mail");
		payload.setFrom(01012020);
		payload.setToDate(01012021);
		payload.setWhen("dummy");
		Content content = new Content();
		content.setTitle("dummy");
		content.setBody("dummy");
		content.setSubject("dummy");
		content.setSender_name("dummy");
		content.setTemplate_id("dummy");
		content.setTemplate_name("dummy");
		content.setReplacements("dummy");
		content.setAttachments("dummy");
		HashMap<String, Object> platform_specific = new HashMap<String, Object>();
		platform_specific.put("key", "value");
		content.setPlatform_specific(platform_specific);
		payload.setContent(content);
		payload.setRespect_frequency_caps(true);
		payload.setEstimate_only(true);
		payload.setAsync_estimate(true);
		payload.setTtl(0);
		payload.setSegment(0);
		payload.setSend_to_all_devices(true);
		payload.setSkip_estimate(true);
		payload.setRespect_throttle(true);
		payload.setWzrk_acts("dummy");
		payload.setWzrk_bc("dummy");
		payload.setWzrk_bi("dummy");
		payload.setWzrk_cid("dummy");
		Where where = new Where();
		where.setEvent_name("dummy");
		where.setFrom(01012020);
		where.setProfile_fields("dummy");
		where.setTo(01012021);
		payload.setWhere(where);
		payload.setBadge_icon("dummy");
		payload.setBadge_id(0);
		payload.setMutable_content(true);
		payload.setId(0);
		payload.setProvider_group_nickname("dummy");
		payload.setProvider_nick_name("dummy");
		payload.setSystem_control_group_include(true);
		payload.setTag_group("dummy");
		ControlGroup control_group = new ControlGroup();
		control_group.setName("dummy");
		control_group.setPercentage(90);
		control_group.setType("dummy");
		payload.setControl_group(control_group);
		To to = new To();
		String[] id = {"dummy"};
		to.setEmail(id);
		to.setFBID(id);
		to.setIdentity(id);
		to.setObjectId(id);
		payload.setTo(to);
		

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
		jsonResponse.put("user_type", "test");
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
		
		CampaignPayload payload = new CampaignPayload();
		payload.setName("Send Mail");
		
		Mockito.when(client.postRequest(Mockito.anyString(), Mockito.any(JSONObject.class))).thenReturn(jsonResponse);
		
		response = campaigns.getCampaigns(payload);
   
		Assertions.assertNotNull(response);
		Assertions.assertNotNull(response.getOtherInfo());
		Assertions.assertNotNull(response.getCode());
		Assertions.assertNotNull(response.getCount());
		Assertions.assertNotNull(response.getError());
		Assertions.assertNotNull(response.getEstimates());
		Assertions.assertNotNull(response.getMessage());
		Assertions.assertNotNull(response.getMessages());
		Assertions.assertNotNull(response.getMessages().get(0).getChannel());
		Assertions.assertNotNull(response.getMessages().get(0).getConversion_event());
		Assertions.assertNotNull(response.getMessages().get(0).getData());
		Assertions.assertNotNull(response.getMessages().get(0).getDelivery());
		Assertions.assertNotNull(response.getMessages().get(0).getDevice());
		Assertions.assertNotNull(response.getMessages().get(0).getLables());
		Assertions.assertNotNull(response.getMessages().get(0).getMessage_id());
		Assertions.assertNotNull(response.getMessages().get(0).getMessage_name());
		Assertions.assertNotNull(response.getMessages().get(0).getStart_date());
		Assertions.assertNotNull(response.getProcessed());
		Assertions.assertNotNull(response.getReq_id());
		Assertions.assertNotNull(response.getResult());
		Assertions.assertNotNull(response.getResult().getClicked());
		Assertions.assertNotNull(response.getResult().getSent());
		Assertions.assertNotNull(response.getTargets());
		Assertions.assertNotNull(response.getTargets().get(0).getId());
		Assertions.assertNotNull(response.getTargets().get(0).getName());
		Assertions.assertNotNull(response.getTargets().get(0).getScheduled_on());
		Assertions.assertNotNull(response.getTargets().get(0).getStatus());
		Assertions.assertNotNull(response.getTotal_results());
		Assertions.assertNotNull(response.getUnprocessed());
		Assertions.assertNotNull(response.getUser_type());
		Assertions.assertEquals("success", response.getStatus());
	}

	@Test
	public void testCreateCampaignTargetUserEvents() throws IOException, InterruptedException {
		Response response = null;
		JSONObject jsonResponse = new JSONObject();
		jsonResponse.put("status", "success");
		CampaignPayload payload = new CampaignPayload();
		payload.setName("Send Mail");
		
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
		payload.setName("Send Mail");
		
		Mockito.when(client.postRequest(Mockito.anyString(), Mockito.any(JSONObject.class))).thenReturn(jsonResponse);
		
		responseSMS = campaigns.createCampaignTargetId("SMS", payload);
		responseEMAIL = campaigns.createCampaignTargetId("EMAIL", payload);
		responsePUSH = campaigns.createCampaignTargetId("PUSH", payload);
		responseWEBPUSH = campaigns.createCampaignTargetId("WEBPUSH", payload);
   
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

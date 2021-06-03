package Campaign;

import java.io.IOException;
import java.util.HashMap;

import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import HTTP.HttpClient;
import Payload.CampaignPayload;
import Payload.Content;
import Payload.ControlGroup;
import Payload.To;
import Payload.Where;
import Response.Response;

public class CampaignsTest {
	
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
		CampaignPayload payload = new CampaignPayload();
		payload.setName("Send Mail");
		
		Mockito.when(client.postRequest(Mockito.anyString(), Mockito.any(JSONObject.class))).thenReturn(jsonResponse);
		
		response = campaigns.getCampaigns(payload);
   
		Assertions.assertNotNull(response);
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

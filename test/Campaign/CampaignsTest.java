package Campaign;

import java.io.IOException;
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
		payload.setName("Send Mail");;
		
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
		payload.setName("Send Mail");;
		
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
		payload.setName("Send Mail");;
		
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
		payload.setName("Send Mail");;
		
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

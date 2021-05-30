package Campaign;

import java.io.IOException;

import org.json.JSONObject;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import HTTP.HttpClient;
import Payload.CampaignPayload;
import Response.Response;

public class Campaigns {
	
	private static final String urlStopScheduledCampaign = "https://api.clevertap.com/1/targets/stop.jsonPayload";
	private static final String urlGetCampaignReport = "https://api.clevertap.com/1/targets/result.jsonPayload";
	private static final String urlGetCampaigns = "https://api.clevertap.com/1/targets/list.jsonPayload";
	private static final String urlCreateCampaignTargetUserEvents = "https://api.clevertap.com/1/targets/create.jsonPayload";
	private static final String urlCreateCampaignTargetUserIdSMS = "https://api.clevertap.com/1/send/sms.jsonPayload";
	private static final String urlCreateCampaignTargetUserIdPush = "https://api.clevertap.com/1/send/push.jsonPayload";
	private static final String urlCreateCampaignTargetUserIdWebPush = "https://api.clevertap.com/1/send/webpush.jsonPayload";
	private static final String urlCreateCampaignTargetUserIdEmail = "https://api.clevertap.com/1/send/email.jsonPayload";
	

	private ObjectMapper objectMapper;
	private HttpClient client; 
	
	public Campaigns(){
		this.client = new HttpClient();
		this.objectMapper = new ObjectMapper();
		this.objectMapper.setSerializationInclusion(Include.NON_NULL);
		this.objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}

	public Response stopScheduledCampaign(CampaignPayload payload) throws IOException, InterruptedException
	{
		JSONObject jsonPayload = new JSONObject(objectMapper.writeValueAsString(payload));
		JSONObject jsonResponse = client.postRequest(urlStopScheduledCampaign, jsonPayload);
		Response res = objectMapper.readValue(jsonResponse.toString(), Response.class);		
		return res;
	}
	
	public Response getCampaignReport(CampaignPayload payload) throws IOException, InterruptedException
	{
		JSONObject jsonPayload = new JSONObject(objectMapper.writeValueAsString(payload));
		JSONObject jsonResponse = client.postRequest(urlGetCampaignReport, jsonPayload);
		Response res = objectMapper.readValue(jsonResponse.toString(), Response.class);		
		return res;
	}
	
	public Response getCampaigns(CampaignPayload payload) throws IOException, InterruptedException
	{
		JSONObject jsonPayload = new JSONObject(objectMapper.writeValueAsString(payload));
		JSONObject jsonResponse = client.postRequest(urlGetCampaigns, jsonPayload);
		Response res = objectMapper.readValue(jsonResponse.toString(), Response.class);		
		return res;
	}
	
	public Response createCampaignTargetUserEvents(CampaignPayload payload) throws IOException, InterruptedException
	{
		JSONObject jsonPayload = new JSONObject(objectMapper.writeValueAsString(payload));
		JSONObject jsonResponse = client.postRequest(urlCreateCampaignTargetUserEvents, jsonPayload);
		Response res = objectMapper.readValue(jsonResponse.toString(), Response.class);		
		return res;
	}
	
	public Response createCampaignTargetId(String method, CampaignPayload payload) throws IOException, InterruptedException
	{
		
		String url = null;
		if(method.equals("SMS"))
		{
			url = urlCreateCampaignTargetUserIdSMS;
		}
		else if(method.equals("EMAIL"))
		{
			url = urlCreateCampaignTargetUserIdEmail;
		}
		else if(method.equals("PUSH"))
		{
			url = urlCreateCampaignTargetUserIdPush;
		}
		else if(method.equals("WEBPUSH"))
		{
			url = urlCreateCampaignTargetUserIdWebPush;
		}
		
		JSONObject jsonPayload = new JSONObject(objectMapper.writeValueAsString(payload));
		JSONObject jsonResponse = client.postRequest(url, jsonPayload);
		Response res = objectMapper.readValue(jsonResponse.toString(), Response.class);	
		return res;
	}
	
}

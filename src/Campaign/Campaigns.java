package Campaign;

import java.io.IOException;

import org.json.JSONObject;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import HTTP.HttpClient;
import Helper.Enums.CampaignMethod;
import Helper.ClevertapInstance;
import Payload.CampaignPayload;
import Payload.DateRangePayload;
import Response.Response;

public class Campaigns {
	
	private static final String urlStopScheduledCampaign = "https://" + ClevertapInstance.getRegion() + "api.clevertap.com/1/targets/stop.json";
	private static final String urlGetCampaignReport = "https://" + ClevertapInstance.getRegion() + "api.clevertap.com/1/targets/result.json";
	private static final String urlGetCampaigns = "https://" + ClevertapInstance.getRegion() + "api.clevertap.com/1/targets/list.json";
	private static final String urlCreateCampaignTargetUserEvents = "https://" + ClevertapInstance.getRegion() + "api.clevertap.com/1/targets/create.json";
	private static final String urlCreateCampaignTargetUserIdSMS = "https://" + ClevertapInstance.getRegion() + "api.clevertap.com/1/send/sms.json";
	private static final String urlCreateCampaignTargetUserIdMobilePush = "https://" + ClevertapInstance.getRegion() + "api.clevertap.com/1/send/push.json";
	private static final String urlCreateCampaignTargetUserIdWebPush = "https://" + ClevertapInstance.getRegion() + "api.clevertap.com/1/send/webpush.json";
	private static final String urlCreateCampaignTargetUserIdEmail = "https://" + ClevertapInstance.getRegion() + "api.clevertap.com/1/send/email.json";
	

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
	
	public Response getCampaigns(DateRangePayload payload) throws IOException, InterruptedException
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
	
	public Response createCampaignTargetId(CampaignMethod method, CampaignPayload payload) throws IOException, InterruptedException
	{
		
		String url = null;
		if(method == CampaignMethod.SMS)
		{
			url = urlCreateCampaignTargetUserIdSMS;
		}
		else if(method == CampaignMethod.EMAIL)
		{
			url = urlCreateCampaignTargetUserIdEmail;
		}
		else if(method == CampaignMethod.MOBILEPUSH)
		{
			url = urlCreateCampaignTargetUserIdMobilePush;
		}
		else if(method == CampaignMethod.WEBPUSH)
		{
			url = urlCreateCampaignTargetUserIdWebPush;
		}
		
		JSONObject jsonPayload = new JSONObject(objectMapper.writeValueAsString(payload));
		JSONObject jsonResponse = client.postRequest(url, jsonPayload);
		Response res = objectMapper.readValue(jsonResponse.toString(), Response.class);	
		return res;
	}
	
}

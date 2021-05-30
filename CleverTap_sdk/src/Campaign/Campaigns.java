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
	
	static String urlStopScheduledCampaign = "https://api.clevertap.com/1/targets/stop.json";
	static String urlGetCampaignReport = "https://api.clevertap.com/1/targets/result.json";
	static String urlGetCampaigns = "https://api.clevertap.com/1/targets/list.json";
	static String urlCreateCampaignTargetUserEvents = "https://api.clevertap.com/1/targets/create.json";
	static String urlCreateCampaignTargetUserIdSMS = "https://api.clevertap.com/1/send/sms.json";
	static String urlCreateCampaignTargetUserIdPush = "https://api.clevertap.com/1/send/push.json";
	static String urlCreateCampaignTargetUserIdWebPush = "https://api.clevertap.com/1/send/webpush.json";
	static String urlCreateCampaignTargetUserIdEmail = "https://api.clevertap.com/1/send/email.json";
	

	ObjectMapper objectMapper = new ObjectMapper();
	
	public Campaigns(){
		this.objectMapper.setSerializationInclusion(Include.NON_NULL);
		this.objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}

	public Response stopScheduledCampaign(CampaignPayload payload) throws IOException, InterruptedException
	{
		HttpClient client = new HttpClient();
		
		
		JSONObject json = new JSONObject(objectMapper.writeValueAsString(payload));
		JSONObject obj = client.postRequest(urlStopScheduledCampaign, json);

		Response res = objectMapper.readValue(obj.toString(), Response.class);
		
		return res;
	}
	
	public Response getCampaignReport(CampaignPayload payload) throws IOException, InterruptedException
	{
		HttpClient client = new HttpClient();
		
		JSONObject json = new JSONObject(objectMapper.writeValueAsString(payload));
		JSONObject obj = client.postRequest(urlGetCampaignReport, json);

		Response res = objectMapper.readValue(obj.toString(), Response.class);
		
		return res;
	}
	
	public Response getCampaigns(CampaignPayload payload) throws IOException, InterruptedException
	{
		HttpClient client = new HttpClient();
		
		JSONObject json = new JSONObject(objectMapper.writeValueAsString(payload));
		JSONObject obj = client.postRequest(urlGetCampaigns, json);

		Response res = objectMapper.readValue(obj.toString(), Response.class);
		
		return res;
	}
	
	public Response createCampaignTargetUserEvents(CampaignPayload payload) throws IOException, InterruptedException
	{
		HttpClient client = new HttpClient();
		
		JSONObject json = new JSONObject(objectMapper.writeValueAsString(payload));
		JSONObject obj = client.postRequest(urlCreateCampaignTargetUserEvents, json);

		Response res = objectMapper.readValue(obj.toString(), Response.class);
		
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
		
		HttpClient client = new HttpClient();
		
		JSONObject json = new JSONObject(objectMapper.writeValueAsString(payload));
		JSONObject obj = client.postRequest(url, json);

		Response res = objectMapper.readValue(obj.toString(), Response.class);
		
		return res;
	}
	
}

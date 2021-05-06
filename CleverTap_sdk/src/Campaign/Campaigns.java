package Campaign;

import java.io.IOException;

import org.json.JSONObject;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;

import HTTP.Http_Client;
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
	
	public Response stopScheduledCampaign(CampaignPayload payload) throws IOException
	{
		String status;
		int code;
		String error;
		
		Response res = new Response();
		
		Http_Client client = new Http_Client();
		
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setSerializationInclusion(Include.NON_NULL);
		JSONObject json = new JSONObject(objectMapper.writeValueAsString(payload));
		JSONObject obj = client.post_request(urlStopScheduledCampaign, json);

		if(obj.has("status"))
		{
			status = obj.getString("status");
			res.setStatus(status);
		}
		if(obj.has("code"))
		{
			code = obj.getInt("code");
			res.setCode(code);
		}
		if(obj.has("error"))
		{
			error = obj.getString("error");
			res.setError(error);
		}
		return res;
	}
	
	public Response getCampaignReport(CampaignPayload payload) throws IOException
	{
		String status;
		int code;
		String error;
		JSONObject result;
		
		Response res = new Response();
		
		Http_Client client = new Http_Client();
		
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setSerializationInclusion(Include.NON_NULL);
		JSONObject json = new JSONObject(objectMapper.writeValueAsString(payload));
		JSONObject obj = client.post_request(urlGetCampaignReport, json);

		if(obj.has("status"))
		{
			status = obj.getString("status");
			res.setStatus(status);
		}
		if(obj.has("code"))
		{
			code = obj.getInt("code");
			res.setCode(code);
		}
		if(obj.has("result"))
		{
			result = obj.getJSONObject("result");
			res.setResult(result);
		}
		if(obj.has("error"))
		{
			error = obj.getString("error");
			res.setError(error);
		}
		return res;
	}
	
	public Response getCampaigns(CampaignPayload payload) throws IOException
	{
		String status;
		int code;
		String error;
		JSONObject targtes;
		
		Response res = new Response();
		
		Http_Client client = new Http_Client();
		
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setSerializationInclusion(Include.NON_NULL);
		JSONObject json = new JSONObject(objectMapper.writeValueAsString(payload));
		JSONObject obj = client.post_request(urlGetCampaigns, json);

		if(obj.has("status"))
		{
			status = obj.getString("status");
			res.setStatus(status);
		}
		if(obj.has("code"))
		{
			code = obj.getInt("code");
			res.setCode(code);
		}
		if(obj.has("targets"))
		{
			targtes = obj.getJSONObject("targtes");
			res.setTargets(targtes);
		}
		if(obj.has("error"))
		{
			error = obj.getString("error");
			res.setError(error);
		}
		return res;
	}
	public Response createCampaignTargetUserEvents(CampaignPayload payload) throws IOException
	{
		String status;
		int code;
		String error;
		JSONObject estimates;
		
		Response res = new Response();
		
		Http_Client client = new Http_Client();
		
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setSerializationInclusion(Include.NON_NULL);
		JSONObject json = new JSONObject(objectMapper.writeValueAsString(payload));
		JSONObject obj = client.post_request(urlCreateCampaignTargetUserEvents, json);

		if(obj.has("status"))
		{
			status = obj.getString("status");
			res.setStatus(status);
		}
		if(obj.has("code"))
		{
			code = obj.getInt("code");
			res.setCode(code);
		}
		if(obj.has("estimates"))
		{
			estimates = obj.getJSONObject("estimates");
			res.setEstimates(estimates);
		}
		if(obj.has("error"))
		{
			error = obj.getString("error");
			res.setError(error);
		}
		return res;
	}
	
	public Response createCampaignTargetId(String method, CampaignPayload payload) throws IOException
	{
		String status;
		int code;
		String error;
		String  campaign_message;
		
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
			
		Response res = new Response();
		
		Http_Client client = new Http_Client();
		
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setSerializationInclusion(Include.NON_NULL);
		JSONObject json = new JSONObject(objectMapper.writeValueAsString(payload));
		JSONObject obj = client.post_request(url, json);

		if(obj.has("status"))
		{
			status = obj.getString("status");
			res.setStatus(status);
		}
		if(obj.has("code"))
		{
			code = obj.getInt("code");
			res.setCode(code);
		}
		if(obj.has("campaign_message"))
		{
			campaign_message = obj.getString("campaign_message");
			res.setCampaign_message(campaign_message);
		}
		if(obj.has("error"))
		{
			error = obj.getString("error");
			res.setError(error);
		}
		return res;
	}
	
}

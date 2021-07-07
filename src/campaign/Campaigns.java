package campaign;

import java.io.IOException;

import org.json.JSONObject;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import helper.ClevertapInstance;
import helper.enums.CampaignMethod;
import http.HttpClient;
import payload.campaign.CampaignPayload;
import payload.campaign.DateRangePayload;
import response.Response;

// TODO: Auto-generated Javadoc
/**
 * The Class Campaigns.
 */
public class Campaigns {
	
	/** The Constant urlStopScheduledCampaign. */
	private static final String urlStopScheduledCampaign = "https://" + ClevertapInstance.getRegion() + "api.clevertap.com/1/targets/stop.json";
	
	/** The Constant urlGetCampaignReport. */
	private static final String urlGetCampaignReport = "https://" + ClevertapInstance.getRegion() + "api.clevertap.com/1/targets/result.json";
	
	/** The Constant urlGetCampaigns. */
	private static final String urlGetCampaigns = "https://" + ClevertapInstance.getRegion() + "api.clevertap.com/1/targets/list.json";
	
	/** The Constant urlCreateCampaignTargetUserEvents. */
	private static final String urlCreateCampaignTargetUserEvents = "https://" + ClevertapInstance.getRegion() + "api.clevertap.com/1/targets/create.json";
	
	/** The Constant urlCreateCampaignTargetUserIdSMS. */
	private static final String urlCreateCampaignTargetUserIdSMS = "https://" + ClevertapInstance.getRegion() + "api.clevertap.com/1/send/sms.json";
	
	/** The Constant urlCreateCampaignTargetUserIdMobilePush. */
	private static final String urlCreateCampaignTargetUserIdMobilePush = "https://" + ClevertapInstance.getRegion() + "api.clevertap.com/1/send/push.json";
	
	/** The Constant urlCreateCampaignTargetUserIdWebPush. */
	private static final String urlCreateCampaignTargetUserIdWebPush = "https://" + ClevertapInstance.getRegion() + "api.clevertap.com/1/send/webpush.json";
	
	/** The Constant urlCreateCampaignTargetUserIdEmail. */
	private static final String urlCreateCampaignTargetUserIdEmail = "https://" + ClevertapInstance.getRegion() + "api.clevertap.com/1/send/email.json";
	

	/** The object mapper. */
	private ObjectMapper objectMapper;
	
	/** The client. */
	private HttpClient client; 
	
	/**
	 * Instantiates a new campaigns.
	 */
	public Campaigns(){
		this.client = new HttpClient();
		this.objectMapper = new ObjectMapper();
		this.objectMapper.setSerializationInclusion(Include.NON_NULL);
		this.objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}

	/**
	 * Stop scheduled campaign.
	 *
	 * @param payload the payload
	 * @return the response
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws InterruptedException the interrupted exception
	 */
	public Response stopScheduledCampaign(CampaignPayload payload) throws IOException, InterruptedException
	{
		JSONObject jsonPayload = new JSONObject(objectMapper.writeValueAsString(payload));
		JSONObject jsonResponse = client.postRequest(urlStopScheduledCampaign, jsonPayload);
		Response res = objectMapper.readValue(jsonResponse.toString(), Response.class);		
		return res;
	}
	
	/**
	 * Gets the campaign report.
	 *
	 * @param payload the payload
	 * @return the campaign report
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws InterruptedException the interrupted exception
	 */
	public Response getCampaignReport(CampaignPayload payload) throws IOException, InterruptedException
	{
		JSONObject jsonPayload = new JSONObject(objectMapper.writeValueAsString(payload));
		JSONObject jsonResponse = client.postRequest(urlGetCampaignReport, jsonPayload);
		Response res = objectMapper.readValue(jsonResponse.toString(), Response.class);		
		return res;
	}
	
	/**
	 * Gets the campaigns.
	 *
	 * @param payload the payload
	 * @return the campaigns
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws InterruptedException the interrupted exception
	 */
	public Response getCampaigns(DateRangePayload payload) throws IOException, InterruptedException
	{
		JSONObject jsonPayload = new JSONObject(objectMapper.writeValueAsString(payload));
		JSONObject jsonResponse = client.postRequest(urlGetCampaigns, jsonPayload);
		Response res = objectMapper.readValue(jsonResponse.toString(), Response.class);		
		return res;
	}
	
	/**
	 * Creates the campaign target user events.
	 *
	 * @param payload the payload
	 * @return the response
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws InterruptedException the interrupted exception
	 */
	public Response createCampaignTargetUserEvents(CampaignPayload payload) throws IOException, InterruptedException
	{
		JSONObject jsonPayload = new JSONObject(objectMapper.writeValueAsString(payload));
		JSONObject jsonResponse = client.postRequest(urlCreateCampaignTargetUserEvents, jsonPayload);
		Response res = objectMapper.readValue(jsonResponse.toString(), Response.class);		
		return res;
	}
	
	/**
	 * Creates the campaign target id.
	 *
	 * @param method the method
	 * @param payload the payload
	 * @return the response
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws InterruptedException the interrupted exception
	 */
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

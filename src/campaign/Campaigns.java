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
 * The Campaigns Class.
 */
public class Campaigns {
	
	/** The API endpoint for stopping scheduled campaigns. */
	private static final String urlStopScheduledCampaign = "https://" + ClevertapInstance.getRegion() + "api.clevertap.com/1/targets/stop.json";
	
	/** The API endpoint to get campaign report. */
	private static final String urlGetCampaignReport = "https://" + ClevertapInstance.getRegion() + "api.clevertap.com/1/targets/result.json";
	
	/** The API endpoint for retrieving campaigns. */
	private static final String urlGetCampaigns = "https://" + ClevertapInstance.getRegion() + "api.clevertap.com/1/targets/list.json";
	
	/** The API endpoint for creating campaiInterruptedException the the requestinterrupted exceptiongns to target the users based on events. */
	private static final String urlCreateCampaignTargetUserEvents = "https://" + ClevertapInstance.getRegion() + "api.clevertap.com/1/targets/create.json";
	
	/** The API endpoint for creating SMS campaigns to target the users based on user id. */
	private static final String urlCreateCampaignTargetUserIdSMS = "https://" + ClevertapInstance.getRegion() + "api.clevertap.com/1/send/sms.json";
	
	/** The API endpoint for creating mobile push campaigns to target the users based on user id. */
	private static final String urlCreateCampaignTargetUserIdMobilePush = "https://" + ClevertapInstance.getRegion() + "api.clevertap.com/1/send/push.json";
	
	/** The API endpoint for creating web push campaigns to target the users based on user id. */
	private static final String urlCreateCampaignTargetUserIdWebPush = "https://" + ClevertapInstance.getRegion() + "api.clevertap.com/1/send/webpush.json";
	
	/** The API endpoint for creating email push campaigns to target the users based on user id.. */
	private static final String urlCreateCampaignTargetUserIdEmail = "https://" + ClevertapInstance.getRegion() + "api.clevertap.com/1/send/email.json";
	

	/** The object mapper. */
	private ObjectMapper objectMapper;
	
	/** The http client. */
	private HttpClient client; 
	
	/**
	 * Instantiates a new campaigns instance.
	 */
	public Campaigns(){
		this.client = HttpClient.getHttpClientInstance();
		this.objectMapper = new ObjectMapper();
		this.objectMapper.setSerializationInclusion(Include.NON_NULL);
		this.objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}

	/**
	 * Stops the scheduled campaigns.
	 *
	 * @param payload the campaign payload
	 * @return Response - the response from server
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
	 * @param payload the campaign payload
	 * @return campaign report
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
	 * @param payload the date range in which campaigns were created
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
	 * Creates the campaigns on targeted user events.
	 *
	 * @param payload the campaign payload
	 * @return Response - the response from server
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
	 * Creates the campaigns targeted by user id.
	 *
	 * @param method the method of campaigns(SMS, Email, etc.)
	 * @param payload the payload
	 * @return Response - the response from server
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

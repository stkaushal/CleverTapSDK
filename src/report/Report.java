package report;

import java.io.IOException;

import org.json.JSONObject;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import helper.ClevertapInstance;
import http.HttpClient;
import payload.report.ReportPayload;
import response.Response;

// TODO: Auto-generated Javadoc
/**
 * The Class Report.
 */
public class Report {
	
	/** The Constant urlGetRealTimeCounts. */
	private static final String urlGetRealTimeCounts = "https://" + ClevertapInstance.getRegion() + "api.clevertap.com/1/now.json";
	
	/** The Constant urlGetMessageReport. */
	private static final String urlGetMessageReport = "https://" + ClevertapInstance.getRegion() + "api.clevertap.com/1/message/report.json";
	
	/** The Constant urlGetTopPropertyCount. */
	private static final String urlGetTopPropertyCount = "https://" + ClevertapInstance.getRegion() + "api.clevertap.com/1/counts/top.json";
	
	/** The Constant urlGetTrends. */
	private static final String urlGetTrends = "https://" + ClevertapInstance.getRegion() + "api.clevertap.com/1/counts/trends.json";
	
	/** The Constant urlGetTopPropertyCountByReqId. */
	private static final String urlGetTopPropertyCountByReqId = "https://" + ClevertapInstance.getRegion() + "api.clevertap.com/1/counts/top.json?req_id=";
	
	/** The Constant urlGetTrendsByReqId. */
	private static final String urlGetTrendsByReqId = "https://" + ClevertapInstance.getRegion() + "api.clevertap.com/1/counts/trends.json?req_id=";
	
	/** The object mapper. */
	private ObjectMapper objectMapper;
	
	/** The client. */
	private HttpClient client;
	
	/**
	 * Instantiates a new report.
	 */
	public Report(){
		this.client = new HttpClient();
		this.objectMapper = new ObjectMapper();
		this.objectMapper.setSerializationInclusion(Include.NON_NULL);
		this.objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}
	
	
	/**
	 * Gets the real time counts.
	 *
	 * @param payload the payload
	 * @return the real time counts
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws InterruptedException the interrupted exception
	 */
	public Response getRealTimeCounts(ReportPayload payload) throws IOException, InterruptedException
	{
		JSONObject jsonPayload = new JSONObject(objectMapper.writeValueAsString(payload));
		JSONObject jsonResponse = client.postRequest(urlGetRealTimeCounts, jsonPayload);	
		Response res = objectMapper.readValue(jsonResponse.toString(), Response.class);
		return res;
	}
	
	/**
	 * Gets the message reports.
	 *
	 * @param payload the payload
	 * @return the message reports
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws InterruptedException the interrupted exception
	 */
	public Response getMessageReports(ReportPayload payload) throws IOException, InterruptedException
	{
		JSONObject jsonPayload = new JSONObject(objectMapper.writeValueAsString(payload));
		JSONObject jsonResponse = client.postRequest(urlGetMessageReport, jsonPayload);
		Response res = objectMapper.readValue(jsonResponse.toString(), Response.class);		
		return res;
	}
	
	/**
	 * Gets the top property count.
	 *
	 * @param payload the payload
	 * @return the top property count
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws InterruptedException the interrupted exception
	 */
	public Response getTopPropertyCount(ReportPayload payload) throws IOException, InterruptedException
	{
		JSONObject jsonPayload = new JSONObject(objectMapper.writeValueAsString(payload));
		JSONObject jsonResponse = client.postRequest(urlGetTopPropertyCount, jsonPayload);
		Response res = objectMapper.readValue(jsonResponse.toString(), Response.class);
		return res;
	}
	
	/**
	 * Gets the top property count by req id.
	 *
	 * @param ReqId the req id
	 * @return the top property count by req id
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws InterruptedException the interrupted exception
	 */
	public Response getTopPropertyCountByReqId(long ReqId) throws IOException, InterruptedException
	{
		String url = urlGetTopPropertyCountByReqId + String.valueOf(ReqId);
		JSONObject jsonResponse = client.getRequest(url);
		Response res = objectMapper.readValue(jsonResponse.toString(), Response.class);
		return res;
	}
	
	/**
	 * Gets the trends.
	 *
	 * @param payload the payload
	 * @return the trends
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws InterruptedException the interrupted exception
	 */
	public Response getTrends(ReportPayload payload) throws IOException, InterruptedException
	{
		JSONObject jsonPayload = new JSONObject(objectMapper.writeValueAsString(payload));
		JSONObject jsonResponse = client.postRequest(urlGetTrends, jsonPayload);
		Response res = objectMapper.readValue(jsonResponse.toString(), Response.class);
		return res;
	}
	
	/**
	 * Gets the trends by req id.
	 *
	 * @param ReqId the req id
	 * @return the trends by req id
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws InterruptedException the interrupted exception
	 */
	public Response getTrendsByReqId(long ReqId) throws IOException, InterruptedException
	{
		String url = urlGetTrendsByReqId + String.valueOf(ReqId);
		JSONObject jsonResponse = client.getRequest(url);
		Response res = objectMapper.readValue(jsonResponse.toString(), Response.class);
		return res;
	}
	
}

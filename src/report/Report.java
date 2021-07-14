package report;

import java.io.IOException;

import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;

import helper.ClevertapInstance;
import helper.ObjectMapperHelper;
import http.HttpClient;
import payload.report.ReportPayload;
import response.Response;

// TODO: Auto-generated Javadoc
/**
 * The singleton Report Class.
 */
final public class Report {
	
	/** The API endpoint to get real time count of users. */
	private static final String urlGetRealTimeCounts = "https://" + ClevertapInstance.getRegion() + "api.clevertap.com/1/now.json";
	
	/** The API endpoint to get campaign message report. */
	private static final String urlGetMessageReport = "https://" + ClevertapInstance.getRegion() + "api.clevertap.com/1/message/report.json";
	
	/** The API endpoint to get top property count. */
	private static final String urlGetTopPropertyCount = "https://" + ClevertapInstance.getRegion() + "api.clevertap.com/1/counts/top.json";
	
	/** The API endpoint to get trends. */
	private static final String urlGetTrends = "https://" + ClevertapInstance.getRegion() + "api.clevertap.com/1/counts/trends.json";
	
	/** The API endpoint to get property count using request id. */
	private static final String urlGetTopPropertyCountByReqId = "https://" + ClevertapInstance.getRegion() + "api.clevertap.com/1/counts/top.json?req_id=";
	
	/** The API endpoint to get trends using request id. */
	private static final String urlGetTrendsByReqId = "https://" + ClevertapInstance.getRegion() + "api.clevertap.com/1/counts/trends.json?req_id=";
	
	/** The object mapper. */
	private ObjectMapper objectMapper;
	
	/** The client. */
	private HttpClient client;
	
	/**
	 * Instantiates a new report.
	 */
	private Report(){
		this.client = HttpClient.getHttpClientInstance();
		this.objectMapper = ObjectMapperHelper.ObjectMapperHelperInstance().getObjectMapper();
	}
	
	/** The report. */
	private static Report report = null;
	
	/**
	 * Gets the reports instance.
	 *
	 * @return the reports instance
	 */
	public static Report getReportsInstance() {
		 if(report==null)
		 {
			 report = new Report();
		 }
	      return report;
	 }
	
	/**
	 * Gets the real-time count of active users in the past five minutes in app.
	 *
	 * @param payload the report payload
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
	 * Gets the message reports for sent messages.
	 *
	 * @param payload the report payload
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
	 * Gets the counts for the most and least frequently occurring properties for a particular event in a specified duration.
	 *
	 * @param payload the report payload
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
	 * Gets the counts for the most and least frequently occurring properties for a particular event in a specified duration using request id.
	 *
	 * @param reqId the request id
	 * @return the top property count
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws InterruptedException the interrupted exception
	 */
	public Response getTopPropertyCountByReqId(long reqId) throws IOException, InterruptedException
	{
		String url = urlGetTopPropertyCountByReqId + String.valueOf(reqId);
		JSONObject jsonResponse = client.getRequest(url);
		Response res = objectMapper.readValue(jsonResponse.toString(), Response.class);
		return res;
	}
	
	/**
	 * Gets the daily, weekly, and monthly event trends in a specified duration.
	 *
	 * @param payload the report payload
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
	 * Gets the daily, weekly, and monthly event trends in a specified duration using request id.
	 *
	 * @param reqId the request id
	 * @return the trends 
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws InterruptedException the interrupted exception
	 */
	public Response getTrendsByReqId(long reqId) throws IOException, InterruptedException
	{
		String url = urlGetTrendsByReqId + String.valueOf(reqId);
		JSONObject jsonResponse = client.getRequest(url);
		Response res = objectMapper.readValue(jsonResponse.toString(), Response.class);
		return res;
	}
	
}

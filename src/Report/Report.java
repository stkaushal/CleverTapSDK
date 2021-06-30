package Report;

import java.io.IOException;

import org.json.JSONObject;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import HTTP.HttpClient;
import Helper.ClevertapInstance;
import Payload.Report.ReportPayload;
import Response.Response;

public class Report {
	
	private static final String urlGetRealTimeCounts = "https://" + ClevertapInstance.getRegion() + "api.clevertap.com/1/now.json";
	private static final String urlGetMessageReport = "https://" + ClevertapInstance.getRegion() + "api.clevertap.com/1/message/report.json";
	private static final String urlGetTopPropertyCount = "https://" + ClevertapInstance.getRegion() + "api.clevertap.com/1/counts/top.json";
	private static final String urlGetTrends = "https://" + ClevertapInstance.getRegion() + "api.clevertap.com/1/counts/trends.json";
	private static final String urlGetTopPropertyCountByReqId = "https://" + ClevertapInstance.getRegion() + "api.clevertap.com/1/counts/top.json?req_id=";
	private static final String urlGetTrendsByReqId = "https://" + ClevertapInstance.getRegion() + "api.clevertap.com/1/counts/trends.json?req_id=";
	
	private ObjectMapper objectMapper;
	private HttpClient client;
	
	public Report(){
		this.client = new HttpClient();
		this.objectMapper = new ObjectMapper();
		this.objectMapper.setSerializationInclusion(Include.NON_NULL);
		this.objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}
	
	
	public Response getRealTimeCounts(ReportPayload payload) throws IOException, InterruptedException
	{
		JSONObject jsonPayload = new JSONObject(objectMapper.writeValueAsString(payload));
		JSONObject jsonResponse = client.postRequest(urlGetRealTimeCounts, jsonPayload);	
		Response res = objectMapper.readValue(jsonResponse.toString(), Response.class);
		return res;
	}
	
	public Response getMessageReports(ReportPayload payload) throws IOException, InterruptedException
	{
		JSONObject jsonPayload = new JSONObject(objectMapper.writeValueAsString(payload));
		JSONObject jsonResponse = client.postRequest(urlGetMessageReport, jsonPayload);
		Response res = objectMapper.readValue(jsonResponse.toString(), Response.class);		
		return res;
	}
	
	public Response getTopPropertyCount(ReportPayload payload) throws IOException, InterruptedException
	{
		JSONObject jsonPayload = new JSONObject(objectMapper.writeValueAsString(payload));
		JSONObject jsonResponse = client.postRequest(urlGetTopPropertyCount, jsonPayload);
		Response res = objectMapper.readValue(jsonResponse.toString(), Response.class);
		return res;
	}
	
	public Response getTopPropertyCountByReqId(long ReqId) throws IOException, InterruptedException
	{
		String url = urlGetTopPropertyCountByReqId + String.valueOf(ReqId);
		JSONObject jsonResponse = client.getRequest(url);
		Response res = objectMapper.readValue(jsonResponse.toString(), Response.class);
		return res;
	}
	
	public Response getTrends(ReportPayload payload) throws IOException, InterruptedException
	{
		JSONObject jsonPayload = new JSONObject(objectMapper.writeValueAsString(payload));
		JSONObject jsonResponse = client.postRequest(urlGetTrends, jsonPayload);
		Response res = objectMapper.readValue(jsonResponse.toString(), Response.class);
		return res;
	}
	public Response getTrendsByReqId(long ReqId) throws IOException, InterruptedException
	{
		String url = urlGetTrendsByReqId + String.valueOf(ReqId);
		JSONObject jsonResponse = client.getRequest(url);
		Response res = objectMapper.readValue(jsonResponse.toString(), Response.class);
		return res;
	}
	
}

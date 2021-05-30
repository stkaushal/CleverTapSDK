package Report;

import java.io.IOException;

import org.json.JSONObject;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import HTTP.HttpClient;
import Payload.ReportPayload;
import Response.Response;

public class Report {
	
	private static final String urlGetRealTimeCounts = "https://location.api.clevertap.com/1/now.jsonPayload";
	private static final String urlGetMessageReport = "https://api.clevertap.com/1/message/report.jsonPayload";
	private static final String urlGetTopPropertyCount = "https://api.clevertap.com/1/counts/top.jsonPayload";
	private static final String urlGetTrends = "https://api.clevertap.com/1/counts/trends.jsonPayload";
	
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
	
	public Response getTrends(ReportPayload payload) throws IOException, InterruptedException
	{
		JSONObject jsonPayload = new JSONObject(objectMapper.writeValueAsString(payload));
		JSONObject jsonResponse = client.postRequest(urlGetTrends, jsonPayload);
		Response res = objectMapper.readValue(jsonResponse.toString(), Response.class);
		return res;
	}
}

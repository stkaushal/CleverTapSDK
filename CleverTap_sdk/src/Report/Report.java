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
	
	static String urlGetRealTimeCounts = "https://location.api.clevertap.com/1/now.json";
	static String urlGetMessageReport = "https://api.clevertap.com/1/message/report.json";
	static String urlGetTopPropertyCount = "https://api.clevertap.com/1/counts/top.json";
	static String urlGetTrends = "https://api.clevertap.com/1/counts/trends.json";
	
	ObjectMapper objectMapper = new ObjectMapper();
	
	public Report(){
		this.objectMapper.setSerializationInclusion(Include.NON_NULL);
		this.objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}
	
	
	public Response getRealTimeCounts(ReportPayload payload) throws IOException, InterruptedException
	{
		HttpClient client = new HttpClient();
		
		
		JSONObject json = new JSONObject(objectMapper.writeValueAsString(payload));
		JSONObject obj = client.postRequest(urlGetRealTimeCounts, json);
				
		Response res = objectMapper.readValue(obj.toString(), Response.class);
		
		return res;
	}
	
	public Response getMessageReports(ReportPayload payload) throws IOException, InterruptedException
	{
		HttpClient client = new HttpClient();
		
		
		JSONObject json = new JSONObject(objectMapper.writeValueAsString(payload));
		JSONObject obj = client.postRequest(urlGetMessageReport, json);

		Response res = objectMapper.readValue(obj.toString(), Response.class);
		
		return res;
	}
	
	public Response getTopPropertyCount(ReportPayload payload) throws IOException, InterruptedException
	{
		HttpClient client = new HttpClient();
		
		JSONObject json = new JSONObject(objectMapper.writeValueAsString(payload));
		JSONObject obj = client.postRequest(urlGetTopPropertyCount, json);
		Response res = objectMapper.readValue(obj.toString(), Response.class);
		
		return res;
	}
	
	public Response getTrends(ReportPayload payload) throws IOException, InterruptedException
	{
		HttpClient client = new HttpClient();
		
		JSONObject json = new JSONObject(objectMapper.writeValueAsString(payload));
		JSONObject obj = client.postRequest(urlGetTrends, json);
		Response res = objectMapper.readValue(obj.toString(), Response.class);
		
		return res;
	}
}

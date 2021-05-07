package Report;

import java.io.IOException;

import org.json.JSONObject;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import HTTP.Http_Client;
import Payload.ReportPayload;
import Response.Response;

public class Report {
	
	static String urlGetRealTimeCounts = "https://location.api.clevertap.com/1/now.json";
	static String urlGetMessageReport = "https://api.clevertap.com/1/message/report.json";
	static String urlGetTopPropertyCount = "https://api.clevertap.com/1/counts/top.json";
	static String urlGetTrends = "https://api.clevertap.com/1/counts/trends.json";
	
	
	public Response getRealTimeCounts(ReportPayload payload) throws IOException
	{
		Http_Client client = new Http_Client();
		
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setSerializationInclusion(Include.NON_NULL);
		JSONObject json = new JSONObject(objectMapper.writeValueAsString(payload));
		JSONObject obj = client.post_request(urlGetRealTimeCounts, json);

		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		Response res = objectMapper.readValue(obj.toString(), Response.class);
		
		return res;
	}
	
	public Response getMessageReports(ReportPayload payload) throws IOException
	{
		Http_Client client = new Http_Client();
		
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setSerializationInclusion(Include.NON_NULL);
		JSONObject json = new JSONObject(objectMapper.writeValueAsString(payload));
		JSONObject obj = client.post_request(urlGetMessageReport, json);

		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		Response res = objectMapper.readValue(obj.toString(), Response.class);
		
		return res;
	}
	
	public Response getTopPropertyCount(ReportPayload payload) throws IOException
	{
		Http_Client client = new Http_Client();
		
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setSerializationInclusion(Include.NON_NULL);
		JSONObject json = new JSONObject(objectMapper.writeValueAsString(payload));
		JSONObject obj = client.post_request(urlGetTopPropertyCount, json);

		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		Response res = objectMapper.readValue(obj.toString(), Response.class);
		
		return res;
	}
	
	public Response getTrends(ReportPayload payload) throws IOException
	{
		Http_Client client = new Http_Client();
		
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setSerializationInclusion(Include.NON_NULL);
		JSONObject json = new JSONObject(objectMapper.writeValueAsString(payload));
		JSONObject obj = client.post_request(urlGetTrends, json);
		
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		Response res = objectMapper.readValue(obj.toString(), Response.class);
		
		return res;
	}
}

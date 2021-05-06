package Report;

import java.io.IOException;

import org.json.JSONObject;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
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
		String status;
		int count;
		int code;
		String error;
		JSONObject user_type;
		
		Response res = new Response();
		
		Http_Client client = new Http_Client();
		
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setSerializationInclusion(Include.NON_NULL);
		JSONObject json = new JSONObject(objectMapper.writeValueAsString(payload));
		JSONObject obj = client.post_request(urlGetRealTimeCounts, json);

		if(obj.has("status"))
		{
			status = obj.getString("status");
			res.setStatus(status);
		}
		if(obj.has("count"))
		{
			count = obj.getInt("count");
			res.setCount(count);
		}
		if(obj.has("user_type"))
		{
			user_type = obj.getJSONObject("req_id");
			res.setUser_type(user_type);
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
	
	public Response getMessageReports(ReportPayload payload) throws IOException
	{
		String status;
		int count;
		int code;
		String error;
		JSONObject message;
		
		Response res = new Response();
		
		Http_Client client = new Http_Client();
		
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setSerializationInclusion(Include.NON_NULL);
		JSONObject json = new JSONObject(objectMapper.writeValueAsString(payload));
		JSONObject obj = client.post_request(urlGetMessageReport, json);

		if(obj.has("status"))
		{
			status = obj.getString("status");
			res.setStatus(status);
		}
		if(obj.has("count"))
		{
			count = obj.getInt("count");
			res.setCount(count);
		}
		if(obj.has("message"))
		{
			message = obj.getJSONObject("message");
			res.setMessage(message);
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
	
	public Response getTopPropertyCount(ReportPayload payload) throws IOException
	{
		String status;
		int code;
		String error;
		JSONObject foo;
		JSONObject bar;
		
		Response res = new Response();
		
		Http_Client client = new Http_Client();
		
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setSerializationInclusion(Include.NON_NULL);
		JSONObject json = new JSONObject(objectMapper.writeValueAsString(payload));
		JSONObject obj = client.post_request(urlGetTopPropertyCount, json);

		if(obj.has("status"))
		{
			status = obj.getString("status");
			res.setStatus(status);
		}
		if(obj.has("bar"))
		{
			bar = obj.getJSONObject("bar");
			res.setBar(bar);
		}
		if(obj.has("foo"))
		{
			foo = obj.getJSONObject("foo");
			res.setFoo(foo);
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
	
	public Response getTrends(ReportPayload payload) throws IOException
	{
		String status;
		int code;
		String error;
		JSONObject foo;
		JSONObject bar;
		JSONObject foobar;
		
		Response res = new Response();
		
		Http_Client client = new Http_Client();
		
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setSerializationInclusion(Include.NON_NULL);
		JSONObject json = new JSONObject(objectMapper.writeValueAsString(payload));
		JSONObject obj = client.post_request(urlGetTrends, json);

		if(obj.has("status"))
		{
			status = obj.getString("status");
			res.setStatus(status);
		}
		if(obj.has("bar"))
		{
			bar = obj.getJSONObject("bar");
			res.setBar(bar);
		}
		if(obj.has("foo"))
		{
			foo = obj.getJSONObject("foo");
			res.setFoo(foo);
		}
		if(obj.has("foobar"))
		{
			foobar = obj.getJSONObject("foobar");
			res.setFoobar(foobar);
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
}

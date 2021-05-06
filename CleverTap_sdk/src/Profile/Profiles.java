package Profile;
import java.io.IOException;

import org.json.JSONObject;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;

import HTTP.Http_Client;
import Helper.Cursor;
import Payload.ProfilePayload;
import Response.GetUserProfileResponse;
import Response.Response;

public class Profiles {
	
	static String urlUpload = "https://api.clevertap.com/1/upload";
	static String urlGetProfileCursor = "https://api.clevertap.com/1/profiles.json";
	static String urlGetProfileCount = "https://api.clevertap.com/1/counts/profiles.json";
	static String urlDeleteProfile = "https://api.clevertap.com/1/delete/profiles.json";
	static String urlDemergeProfile = "https://api.clevertap.com/1/demerge/profiles.json";
	static String urlSubscribe = "https://api.clevertap.com/1/subscribe/";
	static String urlDisassociate = "https://api.clevertap.com/1/disassociate/";
	
	public Response uploadUserProfile(ProfilePayload payload) throws IOException
	{
		String status;
		int processed;
		String unprocessed;
		int code;
		String error;
		
		Response res = new Response();
		
		Http_Client client = new Http_Client();
		
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setSerializationInclusion(Include.NON_NULL);
		JSONObject json = new JSONObject(objectMapper.writeValueAsString(payload));
		
		JSONObject obj = client.post_request(urlUpload, json);
//		System.out.println("obj is::: "+obj);
		if(obj.has("status"))
		{
			status = obj.getString("status");
			res.setStatus(status);
		}
		if(obj.has("processed"))
		{
			processed = obj.getInt("processed");
			res.setProcessed(processed);
		}
		if(obj.has("unprocessed"))
		{
			unprocessed = obj.getString("unprocessed");
			res.setUnprocessed(unprocessed);
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
	
	public Cursor getUserProfileCursor(ProfilePayload payload, int batch_size) throws IOException
	{
		Cursor cur = new Cursor();
		String url = urlGetProfileCursor + "?batch_size=" + batch_size;
		
		Http_Client client = new Http_Client();
		
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setSerializationInclusion(Include.NON_NULL);
		JSONObject json = new JSONObject(objectMapper.writeValueAsString(payload));
		
		JSONObject obj = client.post_request(url, json);
		
		String cursor = null;
		if(obj.has("cursor")) {
			cursor = obj.getString("cursor");
			cur.setCur(cursor);
		}
		
		return cur;	
	}
	
	public GetUserProfileResponse getUserProfileData(Cursor cursor) throws IOException
	{
		String url = urlGetProfileCursor + "?cursor=" + cursor.getCur();
		GetUserProfileResponse res = new GetUserProfileResponse();
		
		Http_Client client = new Http_Client();
		JSONObject obj = client.get_request(url);
		
		String status = null;
		String next_cur = null;
		String records = null;
		
		if(obj.has("status"))
		{
			status = obj.getString("status");
			res.setStatus(status);
		}
		if(obj.has("next_cursor"))
		{
			next_cur = obj.getString("next_cursor");
			res.setNextCursor(next_cur);
		}
		if(obj.has("records"))
		{
			records = obj.getString("records");
			res.setRecords(records);
		}
		return res;	
	}
	
	public GetUserProfileResponse getUserProfileById(String id) throws IOException
	{
		String url = urlGetProfileCursor + "?email=" + id;
		GetUserProfileResponse res = new GetUserProfileResponse();
		
		Http_Client client = new Http_Client();
		JSONObject obj = client.get_request(url);
		
		String status = null;
		String records;
		
		if(obj.has("status"))
		{
			status = obj.getString("status");
			res.setStatus(status);
		}
		if(obj.has("records"))
		{
			records = obj.getString("records");
			res.setRecords(records);
		}
		return res;	
	}
	
	public Response uploadDeviceTokens(ProfilePayload[] payload) throws IOException
	{
		String status;
		int processed;
		String unprocessed;
		int code;
		String error;
		
		Response res = new Response();
		
		Http_Client client = new Http_Client();
		
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setSerializationInclusion(Include.NON_NULL);
		JSONObject json = new JSONObject(objectMapper.writeValueAsString(payload));
		JSONObject obj = client.post_request(urlUpload, json);

		if(obj.has("status"))
		{
			status = obj.getString("status");
			res.setStatus(status);
		}
		if(obj.has("processed"))
		{
			processed = obj.getInt("processed");
			res.setProcessed(processed);
		}
		if(obj.has("unprocessed"))
		{
			unprocessed = obj.getString("unprocessed");
			res.setUnprocessed(unprocessed);
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
	
	public Response getProfileCount(ProfilePayload payload) throws IOException
	{
		Response res = new Response();
		Http_Client client = new Http_Client();
		
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setSerializationInclusion(Include.NON_NULL);
		JSONObject json = new JSONObject(objectMapper.writeValueAsString(payload));
		JSONObject obj = client.post_request(urlGetProfileCount, json);
		
		String status = null;
		int count;
		long req_id;
		
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
		if(obj.has("req_id"))
		{
			req_id = obj.getLong("req_id");
			res.setReq_id(req_id);
		}
		return res;
	}
	
	public Response deleteUserProfile(ProfilePayload payload) throws IOException
	{
		Response res = new Response();
		Http_Client client = new Http_Client();
		
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setSerializationInclusion(Include.NON_NULL);
		JSONObject json = new JSONObject(objectMapper.writeValueAsString(payload));
		JSONObject obj = client.post_request(urlDeleteProfile, json);
		String status = null;
		if(obj.has("status"))
		{
			status = obj.getString("status");
			res.setStatus(status);
		}
		return res;
	}
	
	Response demergeUserProfile(ProfilePayload payload) throws IOException
	{
		Response res = new Response();
		Http_Client client = new Http_Client();
		
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setSerializationInclusion(Include.NON_NULL);
		JSONObject json = new JSONObject(objectMapper.writeValueAsString(payload));
		JSONObject obj = client.post_request(urlDemergeProfile, json);
		String status = null;
		if(obj.has("status"))
		{
			status = obj.getString("status");
			res.setStatus(status);
		}
		return res;
	}
	
	public Response subscribe(ProfilePayload[] payload) throws IOException
	{
		String status;
		int processed;
		String unprocessed;
		int code;
		String error;
		
		Response res = new Response();
		
		Http_Client client = new Http_Client();
		
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setSerializationInclusion(Include.NON_NULL);
		JSONObject json = new JSONObject(objectMapper.writeValueAsString(payload));
		JSONObject obj = client.post_request(urlSubscribe, json);

		if(obj.has("status"))
		{
			status = obj.getString("status");
			res.setStatus(status);
		}
		if(obj.has("processed"))
		{
			processed = obj.getInt("processed");
			res.setProcessed(processed);
		}
		if(obj.has("unprocessed"))
		{
			unprocessed = obj.getString("unprocessed");
			res.setUnprocessed(unprocessed);
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
	
	public Response dissociate(ProfilePayload payload) throws IOException
	{
		String status;
		int processed;
		String unprocessed;
		int code;
		String error;
		
		Response res = new Response();
		
		Http_Client client = new Http_Client();
		
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setSerializationInclusion(Include.NON_NULL);
		JSONObject json = new JSONObject(objectMapper.writeValueAsString(payload));
		JSONObject obj = client.post_request(urlDisassociate, json);

		if(obj.has("status"))
		{
			status = obj.getString("status");
			res.setStatus(status);
		}
		if(obj.has("processed"))
		{
			processed = obj.getInt("processed");
			res.setProcessed(processed);
		}
		if(obj.has("unprocessed"))
		{
			unprocessed = obj.getString("unprocessed");
			res.setUnprocessed(unprocessed);
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

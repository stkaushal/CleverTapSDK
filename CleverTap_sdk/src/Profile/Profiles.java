package Profile;
import java.io.IOException;

import org.json.JSONObject;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
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
		
		Http_Client client = new Http_Client();
		
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setSerializationInclusion(Include.NON_NULL);
		JSONObject json = new JSONObject(objectMapper.writeValueAsString(payload));
		
		JSONObject obj = client.post_request(urlUpload, json);
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		Response res = objectMapper.readValue(obj.toString(), Response.class);
		
		return res;
	}
	
	public Cursor getUserProfileCursor(ProfilePayload payload, int batch_size) throws IOException
	{
		String url = urlGetProfileCursor + "?batch_size=" + batch_size;
		
		Http_Client client = new Http_Client();
		
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setSerializationInclusion(Include.NON_NULL);
		JSONObject json = new JSONObject(objectMapper.writeValueAsString(payload));
		
		JSONObject obj = client.post_request(url, json);
		
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		Cursor cur = objectMapper.readValue(obj.toString(), Cursor.class);
		
		return cur;	
	}
	
	public GetUserProfileResponse getUserProfileData(Cursor cursor) throws IOException
	{
		String url = urlGetProfileCursor + "?cursor=" + cursor.getCursor();
		
		Http_Client client = new Http_Client();
		JSONObject obj = client.get_request(url);
		
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		GetUserProfileResponse res = objectMapper.readValue(obj.toString(), GetUserProfileResponse.class);
		
		return res;	
	}
	
	public GetUserProfileResponse getUserProfileById(String id) throws IOException
	{
		String url = urlGetProfileCursor + "?email=" + id;
		
		Http_Client client = new Http_Client();
		JSONObject obj = client.get_request(url);
		
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		GetUserProfileResponse res = objectMapper.readValue(obj.toString(), GetUserProfileResponse.class);
		
		return res;	
	}
	
	public Response uploadDeviceTokens(ProfilePayload[] payload) throws IOException
	{	
		Http_Client client = new Http_Client();
		
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setSerializationInclusion(Include.NON_NULL);
		JSONObject json = new JSONObject(objectMapper.writeValueAsString(payload));
		JSONObject obj = client.post_request(urlUpload, json);
		
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		Response res = objectMapper.readValue(obj.toString(), Response.class);

		return res;
	}
	
	public Response getProfileCount(ProfilePayload payload) throws IOException
	{
		Http_Client client = new Http_Client();
		
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setSerializationInclusion(Include.NON_NULL);
		JSONObject json = new JSONObject(objectMapper.writeValueAsString(payload));
		JSONObject obj = client.post_request(urlGetProfileCount, json);
		
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		Response res = objectMapper.readValue(obj.toString(), Response.class);
		return res;
	}
	
	public Response deleteUserProfile(ProfilePayload payload) throws IOException
	{
		Http_Client client = new Http_Client();
		
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setSerializationInclusion(Include.NON_NULL);
		JSONObject json = new JSONObject(objectMapper.writeValueAsString(payload));
		JSONObject obj = client.post_request(urlDeleteProfile, json);
		
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		Response res = objectMapper.readValue(obj.toString(), Response.class);
		
		return res;
	}
	
	public Response demergeUserProfile(ProfilePayload payload) throws IOException
	{
		Http_Client client = new Http_Client();
		
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setSerializationInclusion(Include.NON_NULL);
		JSONObject json = new JSONObject(objectMapper.writeValueAsString(payload));
		JSONObject obj = client.post_request(urlDemergeProfile, json);
		
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		Response res = objectMapper.readValue(obj.toString(), Response.class);
		
		return res;
	}
	
	public Response subscribe(ProfilePayload[] payload) throws IOException
	{
		Http_Client client = new Http_Client();
		
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setSerializationInclusion(Include.NON_NULL);
		JSONObject json = new JSONObject(objectMapper.writeValueAsString(payload));
		JSONObject obj = client.post_request(urlSubscribe, json);

		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		Response res = objectMapper.readValue(obj.toString(), Response.class);
		
		return res;
	}
	
	public Response dissociate(ProfilePayload payload) throws IOException
	{	
		Http_Client client = new Http_Client();
		
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setSerializationInclusion(Include.NON_NULL);
		JSONObject json = new JSONObject(objectMapper.writeValueAsString(payload));
		JSONObject obj = client.post_request(urlDisassociate, json);

		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		Response res = objectMapper.readValue(obj.toString(), Response.class);
		
		return res;
	}
}

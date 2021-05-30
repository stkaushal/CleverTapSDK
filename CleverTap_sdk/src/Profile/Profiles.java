package Profile;
import java.io.IOException;

import org.json.JSONObject;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import HTTP.HttpClient;
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
	
	ObjectMapper objectMapper = new ObjectMapper();
	
	public Profiles(){
		this.objectMapper.setSerializationInclusion(Include.NON_NULL);
		this.objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}


	public Response uploadUserProfile(ProfilePayload payload) throws IOException, InterruptedException
	{
		HttpClient client = new HttpClient();
		
		JSONObject json = new JSONObject(objectMapper.writeValueAsString(payload));
		JSONObject obj = client.postRequest(urlUpload, json);
		Response res = objectMapper.readValue(obj.toString(), Response.class);
		
		return res;
	}
	
	public Cursor getUserProfileCursor(ProfilePayload payload, int batch_size) throws IOException, InterruptedException
	{
		String url = urlGetProfileCursor + "?batch_size=" + batch_size;
		
		HttpClient client = new HttpClient();

		JSONObject json = new JSONObject(objectMapper.writeValueAsString(payload));
		JSONObject obj = client.postRequest(url, json);
		Cursor cur = objectMapper.readValue(obj.toString(), Cursor.class);
		
		return cur;	
	}
	
	public GetUserProfileResponse getUserProfileData(Cursor cursor) throws IOException, InterruptedException
	{
		String url = urlGetProfileCursor + "?cursor=" + cursor.getCursor();
		
		HttpClient client = new HttpClient();
		JSONObject obj = client.getRequest(url);
		GetUserProfileResponse res = objectMapper.readValue(obj.toString(), GetUserProfileResponse.class);
		
		return res;	
	}
	
	public GetUserProfileResponse getUserProfileById(String id) throws IOException, InterruptedException
	{
		String url = urlGetProfileCursor + "?email=" + id;
		
		HttpClient client = new HttpClient();
		JSONObject obj = client.getRequest(url);
		GetUserProfileResponse res = objectMapper.readValue(obj.toString(), GetUserProfileResponse.class);
		
		return res;	
	}
	
	public Response uploadDeviceTokens(ProfilePayload[] payload) throws IOException, InterruptedException
	{	
		HttpClient client = new HttpClient();
		
		JSONObject json = new JSONObject(objectMapper.writeValueAsString(payload));
		JSONObject obj = client.postRequest(urlUpload, json);
		Response res = objectMapper.readValue(obj.toString(), Response.class);

		return res;
	}
	
	public Response getProfileCount(ProfilePayload payload) throws IOException, InterruptedException
	{
		HttpClient client = new HttpClient();
		
		JSONObject json = new JSONObject(objectMapper.writeValueAsString(payload));
		JSONObject obj = client.postRequest(urlGetProfileCount, json);
		Response res = objectMapper.readValue(obj.toString(), Response.class);
		return res;
	}
	
	public Response deleteUserProfile(ProfilePayload payload) throws IOException, InterruptedException
	{
		HttpClient client = new HttpClient();
		
		JSONObject json = new JSONObject(objectMapper.writeValueAsString(payload));
		JSONObject obj = client.postRequest(urlDeleteProfile, json);
		Response res = objectMapper.readValue(obj.toString(), Response.class);
		
		return res;
	}
	
	public Response demergeUserProfile(ProfilePayload payload) throws IOException, InterruptedException
	{
		HttpClient client = new HttpClient();
		
		JSONObject json = new JSONObject(objectMapper.writeValueAsString(payload));
		JSONObject obj = client.postRequest(urlDemergeProfile, json);
		Response res = objectMapper.readValue(obj.toString(), Response.class);
		
		return res;
	}
	
	public Response subscribe(ProfilePayload[] payload) throws IOException, InterruptedException
	{
		HttpClient client = new HttpClient();
		
		JSONObject json = new JSONObject(objectMapper.writeValueAsString(payload));
		JSONObject obj = client.postRequest(urlSubscribe, json);
		Response res = objectMapper.readValue(obj.toString(), Response.class);
		
		return res;
	}
	
	public Response dissociate(ProfilePayload payload) throws IOException, InterruptedException
	{	
		HttpClient client = new HttpClient();
	
		JSONObject json = new JSONObject(objectMapper.writeValueAsString(payload));
		JSONObject obj = client.postRequest(urlDisassociate, json);
		Response res = objectMapper.readValue(obj.toString(), Response.class);
		
		return res;
	}
}

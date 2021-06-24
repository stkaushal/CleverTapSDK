package Profile;
import java.io.IOException;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import HTTP.HttpClient;
import Helper.ClevertapInstance;
import Helper.Cursor;
import Helper.UserIdentity;
import Payload.ProfilePayload;
import Response.GetUserProfileResponse;
import Response.Response;

public class Profiles {	
	
	private static final String urlUploadData = "https://" + ClevertapInstance.getRegion() + "api.clevertap.com/1/upload";
	private static final String urlGetProfileCursor = "https://" + ClevertapInstance.getRegion() + "api.clevertap.com/1/profiles.json";
	private static final String urlGetProfileById = "https://" + ClevertapInstance.getRegion() + "api.clevertap.com/1/profile.json";
	private static final String urlGetProfileCount = "https://" + ClevertapInstance.getRegion() + "api.clevertap.com/1/counts/profiles.json";
	private static final String urlDeleteProfile = "https://" + ClevertapInstance.getRegion() + "api.clevertap.com/1/delete/profiles.json";
	private static final String urlDemergeProfile = "https://" + ClevertapInstance.getRegion() + "api.clevertap.com/1/demerge/profiles.json";
	private static final String urlSubscribe = "https://" + ClevertapInstance.getRegion() + "api.clevertap.com/1/subscribe";
	private static final String urlDisassociate = "https://" + ClevertapInstance.getRegion() + "api.clevertap.com/1/disassociate";
	
	private ObjectMapper objectMapper;
	private HttpClient client; 
	
	public Profiles(){
		this.client = new HttpClient();
		this.objectMapper = new ObjectMapper();
		this.objectMapper.setSerializationInclusion(Include.NON_NULL);
		this.objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}


	public Response uploadUserProfile(List<ProfilePayload> payload) throws IOException, InterruptedException
	{
		JSONArray jsonPayloadArray = new JSONArray(objectMapper.writeValueAsString(payload));
		JSONObject jsonPayload = new JSONObject();
		jsonPayload.put("d", jsonPayloadArray);
		JSONObject jsonResponse = client.postRequest(urlUploadData, jsonPayload);
		Response res = objectMapper.readValue(jsonResponse.toString(), Response.class);
		
		return res;
	}
	
	public Cursor getUserProfileCursor(ProfilePayload payload, int batch_size, boolean app, boolean events, boolean profile) throws IOException, InterruptedException
	{
		String url = urlGetProfileCursor + "?batch_size=" + String.valueOf(batch_size) + "&" + "?app=" + String.valueOf(app) + 
				"&" + "?events=" + String.valueOf(events) + "&" + "?profile=" + String.valueOf(profile);  
		
		JSONObject jsonPayload = new JSONObject(objectMapper.writeValueAsString(payload));
		JSONObject jsonResponse = client.postRequest(url, jsonPayload);
		Cursor cur = objectMapper.readValue(jsonResponse.toString(), Cursor.class);
		
		return cur;	
	}
	
	public GetUserProfileResponse getUserProfileData(Cursor cursor) throws IOException, InterruptedException
	{
		String url = urlGetProfileCursor + "?cursor=" + cursor.getCursor();
		
		JSONObject jsonResponse = client.getRequest(url);
		GetUserProfileResponse res = objectMapper.readValue(jsonResponse.toString(), GetUserProfileResponse.class);
		
		return res;	
	}
	
	public GetUserProfileResponse getUserProfileById(UserIdentity type, String id) throws IOException, InterruptedException
	{
		String url = urlGetProfileById;
		if(type == UserIdentity.EMAIL)
		{
			url = url + "?email=" + id;
		}
		else if(type == UserIdentity.IDENTITY)
		{
			url = url + "?identity=" + id;
		}
		else if(type == UserIdentity.OBJECT_ID)
		{
			url = url + "?objectId=" + id;
		}
		
		JSONObject jsonResponse = client.getRequest(url); 
		GetUserProfileResponse res = objectMapper.readValue(jsonResponse.toString(), GetUserProfileResponse.class);
		
		return res;	
	}
	
	public Response uploadDeviceTokens(List<ProfilePayload> payload) throws IOException, InterruptedException
	{	
		JSONArray jsonPayloadArray = new JSONArray(objectMapper.writeValueAsString(payload));
		JSONObject jsonPayload = new JSONObject();
		jsonPayload.put("d", jsonPayloadArray);
		JSONObject jsonResponse = client.postRequest(urlUploadData, jsonPayload);
		Response res = objectMapper.readValue(jsonResponse.toString(), Response.class);

		return res;
	}
	
	public Response getProfileCount(ProfilePayload payload) throws IOException, InterruptedException
	{
		JSONObject jsonPayload = new JSONObject(objectMapper.writeValueAsString(payload));
		JSONObject jsonResponse = client.postRequest(urlGetProfileCount, jsonPayload);
		Response res = objectMapper.readValue(jsonResponse.toString(), Response.class);
		return res;
	}
	
	public Response deleteUserProfile(ProfilePayload payload) throws IOException, InterruptedException
	{
		JSONObject jsonPayload = new JSONObject(objectMapper.writeValueAsString(payload));
		JSONObject jsonResponse = client.postRequest(urlDeleteProfile, jsonPayload);
		Response res = objectMapper.readValue(jsonResponse.toString(), Response.class);
		
		return res;
	}
	
	public Response demergeUserProfile(ProfilePayload payload) throws IOException, InterruptedException
	{
		JSONObject jsonPayload = new JSONObject(objectMapper.writeValueAsString(payload));
		JSONObject jsonResponse = client.postRequest(urlDemergeProfile, jsonPayload);
		Response res = objectMapper.readValue(jsonResponse.toString(), Response.class);
		System.out.println(jsonPayload);
		return res;
	}
	
	public Response subscribe(List<ProfilePayload> payload) throws IOException, InterruptedException
	{
		JSONArray jsonPayloadArray = new JSONArray(objectMapper.writeValueAsString(payload));
		JSONObject jsonPayload = new JSONObject();
		jsonPayload.put("d", jsonPayloadArray);
		JSONObject jsonResponse = client.postRequest(urlSubscribe, jsonPayload);
		Response res = objectMapper.readValue(jsonResponse.toString(), Response.class);
		
		return res;
	}
	
	public Response disassociate(List<ProfilePayload> payload) throws IOException, InterruptedException
	{	
		JSONArray jsonPayloadArray = new JSONArray(objectMapper.writeValueAsString(payload));
		JSONObject jsonPayload = new JSONObject();
		jsonPayload.put("d", jsonPayloadArray);
		JSONObject jsonResponse = client.postRequest(urlDisassociate, jsonPayload);
		Response res = objectMapper.readValue(jsonResponse.toString(), Response.class);
		
		return res;
	}
}

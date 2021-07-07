package profile;
import java.io.IOException;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import helper.ClevertapInstance;
import helper.Cursor;
import helper.enums.UserIdentity;
import http.HttpClient;
import payload.profile.ProfilePayload;
import response.GetUserProfileResponse;
import response.Response;

// TODO: Auto-generated Javadoc
/**
 * The Class Profiles.
 */
public class Profiles {	
	
	/** The Constant urlUploadData. */
	private static final String urlUploadData = "https://" + ClevertapInstance.getRegion() + "api.clevertap.com/1/upload";
	
	/** The Constant urlGetProfileCursor. */
	private static final String urlGetProfileCursor = "https://" + ClevertapInstance.getRegion() + "api.clevertap.com/1/profiles.json";
	
	/** The Constant urlGetProfileById. */
	private static final String urlGetProfileById = "https://" + ClevertapInstance.getRegion() + "api.clevertap.com/1/profile.json";
	
	/** The Constant urlGetProfileCount. */
	private static final String urlGetProfileCount = "https://" + ClevertapInstance.getRegion() + "api.clevertap.com/1/counts/profiles.json";
	
	/** The Constant urlDeleteProfile. */
	private static final String urlDeleteProfile = "https://" + ClevertapInstance.getRegion() + "api.clevertap.com/1/delete/profiles.json";
	
	/** The Constant urlDemergeProfile. */
	private static final String urlDemergeProfile = "https://" + ClevertapInstance.getRegion() + "api.clevertap.com/1/demerge/profiles.json";
	
	/** The Constant urlSubscribe. */
	private static final String urlSubscribe = "https://" + ClevertapInstance.getRegion() + "api.clevertap.com/1/subscribe";
	
	/** The Constant urlDisassociate. */
	private static final String urlDisassociate = "https://" + ClevertapInstance.getRegion() + "api.clevertap.com/1/disassociate";
	
	/** The Constant urlGetProfileCountByReqId. */
	private static final String urlGetProfileCountByReqId = "https://" + ClevertapInstance.getRegion() + "api.clevertap.com/1/counts/profiles.json?req_id=";
	
	/** The object mapper. */
	private ObjectMapper objectMapper;
	
	/** The client. */
	private HttpClient client; 
	
	/**
	 * Instantiates a new profiles.
	 */
	public Profiles(){
		this.client = new HttpClient();
		this.objectMapper = new ObjectMapper();
		this.objectMapper.setSerializationInclusion(Include.NON_NULL);
		this.objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}


	/**
	 * Upload user profile.
	 *
	 * @param payload the payload
	 * @return the response
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws InterruptedException the interrupted exception
	 */
	public Response uploadUserProfile(List<ProfilePayload> payload) throws IOException, InterruptedException
	{
		JSONArray jsonPayloadArray = new JSONArray(objectMapper.writeValueAsString(payload));
		JSONObject jsonPayload = new JSONObject();
		jsonPayload.put("d", jsonPayloadArray);
		JSONObject jsonResponse = client.postRequest(urlUploadData, jsonPayload);
		Response res = objectMapper.readValue(jsonResponse.toString(), Response.class);
		
		return res;
	}
	
	/**
	 * Gets the user profile cursor.
	 *
	 * @param payload the payload
	 * @param batch_size the batch size
	 * @param app the app
	 * @param events the events
	 * @param profile the profile
	 * @return the user profile cursor
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws InterruptedException the interrupted exception
	 */
	public Cursor getUserProfileCursor(ProfilePayload payload, int batch_size, boolean app, boolean events, boolean profile) throws IOException, InterruptedException
	{
		String url = urlGetProfileCursor + "?batch_size=" + String.valueOf(batch_size) + "&" + "?app=" + String.valueOf(app) + 
				"&" + "?events=" + String.valueOf(events) + "&" + "?profile=" + String.valueOf(profile);  
		
		JSONObject jsonPayload = new JSONObject(objectMapper.writeValueAsString(payload));
		JSONObject jsonResponse = client.postRequest(url, jsonPayload);
		Cursor cur = objectMapper.readValue(jsonResponse.toString(), Cursor.class);
		
		return cur;	
	}
	
	/**
	 * Gets the user profile data.
	 *
	 * @param cursor the cursor
	 * @return the user profile data
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws InterruptedException the interrupted exception
	 */
	public GetUserProfileResponse getUserProfileData(String cursor) throws IOException, InterruptedException
	{
		String url = urlGetProfileCursor + "?cursor=" + cursor;
		
		JSONObject jsonResponse = client.getRequest(url);
		GetUserProfileResponse res = objectMapper.readValue(jsonResponse.toString(), GetUserProfileResponse.class);
		
		return res;	
	}
	
	/**
	 * Gets the user profile by id.
	 *
	 * @param type the type
	 * @param id the id
	 * @return the user profile by id
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws InterruptedException the interrupted exception
	 */
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
	
	/**
	 * Upload device tokens.
	 *
	 * @param payload the payload
	 * @return the response
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws InterruptedException the interrupted exception
	 */
	public Response uploadDeviceTokens(List<ProfilePayload> payload) throws IOException, InterruptedException
	{	
		JSONArray jsonPayloadArray = new JSONArray(objectMapper.writeValueAsString(payload));
		JSONObject jsonPayload = new JSONObject();
		jsonPayload.put("d", jsonPayloadArray);
		JSONObject jsonResponse = client.postRequest(urlUploadData, jsonPayload);
		Response res = objectMapper.readValue(jsonResponse.toString(), Response.class);

		return res;
	}
	
	/**
	 * Gets the profile count.
	 *
	 * @param payload the payload
	 * @return the profile count
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws InterruptedException the interrupted exception
	 */
	public Response getProfileCount(ProfilePayload payload) throws IOException, InterruptedException
	{
		JSONObject jsonPayload = new JSONObject(objectMapper.writeValueAsString(payload));
		JSONObject jsonResponse = client.postRequest(urlGetProfileCount, jsonPayload);
		Response res = objectMapper.readValue(jsonResponse.toString(), Response.class);
		return res;
	}
	
	/**
	 * Delete user profile.
	 *
	 * @param payload the payload
	 * @return the response
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws InterruptedException the interrupted exception
	 */
	public Response deleteUserProfile(ProfilePayload payload) throws IOException, InterruptedException
	{
		JSONObject jsonPayload = new JSONObject(objectMapper.writeValueAsString(payload));
		JSONObject jsonResponse = client.postRequest(urlDeleteProfile, jsonPayload);
		Response res = objectMapper.readValue(jsonResponse.toString(), Response.class);
		
		return res;
	}
	
	/**
	 * Demerge user profile.
	 *
	 * @param payload the payload
	 * @return the response
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws InterruptedException the interrupted exception
	 */
	public Response demergeUserProfile(ProfilePayload payload) throws IOException, InterruptedException
	{
		JSONObject jsonPayload = new JSONObject(objectMapper.writeValueAsString(payload));
		JSONObject jsonResponse = client.postRequest(urlDemergeProfile, jsonPayload);
		Response res = objectMapper.readValue(jsonResponse.toString(), Response.class);
		return res;
	}
	
	/**
	 * Subscribe.
	 *
	 * @param payload the payload
	 * @return the response
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws InterruptedException the interrupted exception
	 */
	public Response subscribe(List<ProfilePayload> payload) throws IOException, InterruptedException
	{
		JSONArray jsonPayloadArray = new JSONArray(objectMapper.writeValueAsString(payload));
		JSONObject jsonPayload = new JSONObject();
		jsonPayload.put("d", jsonPayloadArray);
		JSONObject jsonResponse = client.postRequest(urlSubscribe, jsonPayload);
		Response res = objectMapper.readValue(jsonResponse.toString(), Response.class);
		
		return res;
	}
	
	/**
	 * Disassociate.
	 *
	 * @param payload the payload
	 * @return the response
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws InterruptedException the interrupted exception
	 */
	public Response disassociate(List<ProfilePayload> payload) throws IOException, InterruptedException
	{	
		JSONArray jsonPayloadArray = new JSONArray(objectMapper.writeValueAsString(payload));
		JSONObject jsonPayload = new JSONObject();
		jsonPayload.put("d", jsonPayloadArray);
		JSONObject jsonResponse = client.postRequest(urlDisassociate, jsonPayload);
		Response res = objectMapper.readValue(jsonResponse.toString(), Response.class);
		
		return res;
	}
	
	/**
	 * Gets the profile count by req id.
	 *
	 * @param ReqId the req id
	 * @return the profile count by req id
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws InterruptedException the interrupted exception
	 */
	public Response getProfileCountByReqId(long ReqId) throws IOException, InterruptedException
	{
		String url = urlGetProfileCountByReqId + String.valueOf(ReqId);
		JSONObject jsonResponse = client.getRequest(url);
		Response res = objectMapper.readValue(jsonResponse.toString(), Response.class);
		return res;
	}
}

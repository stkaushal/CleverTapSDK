package Profile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import HTTP.HttpClient;
import Helper.Cursor;
import Payload.ProfilePayload;
import Response.GetUserProfileResponse;
import Response.Response;

public class ProfilesTest {
	
	@Mock Cursor cursorMock;
	@Mock HttpClient client;
	@InjectMocks Profiles profile;

	@Before
	public void setUp() throws Exception {
		System.out.println("Before profile test call");
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testUploadUserProfile() throws IOException, InterruptedException {
		Response response = null;
		JSONObject jsonResponse = new JSONObject();
		jsonResponse.put("status", "success");
		ProfilePayload payload = new ProfilePayload();
		payload.setFBID("Random_id");
		List<ProfilePayload> payloadList = new ArrayList<ProfilePayload>();
		payloadList.add(payload);
		
		Mockito.when(client.postRequest(Mockito.anyString(), Mockito.any(JSONObject.class))).thenReturn(jsonResponse);
		
		response = profile.uploadUserProfile(payloadList);
   
		Assert.assertNotNull(response);
        Assert.assertEquals("success", response.getStatus());
	}

	@Test
	public void testGetUserProfileCursor() throws IOException, InterruptedException {
  
		Cursor cursor = null;
		JSONObject jsonResponse = new JSONObject();
		jsonResponse.put("cursor", "fhsklaioclamlkkjadajj");
		ProfilePayload payload = new ProfilePayload();
		payload.setFBID("Random_id");
		
		Mockito.when(client.postRequest(Mockito.anyString(), Mockito.any(JSONObject.class))).thenReturn(jsonResponse);

		cursor = profile.getUserProfileCursor(payload, 0);
		
        Assert.assertNotNull(cursor);
        Assert.assertEquals("fhsklaioclamlkkjadajj", cursor.getCursor());
	}
	

	@Test
	public void testGetUserProfileData() throws IOException, InterruptedException {
		GetUserProfileResponse response = null;
		JSONObject jsonResponse = new JSONObject();
		jsonResponse.put("status", "success");
		
		Mockito.when(client.getRequest(Mockito.anyString())).thenReturn(jsonResponse);
		
		response = profile.getUserProfileData(cursorMock);
		
        Assert.assertNotNull(response);
        Assert.assertEquals("success", response.getStatus());
	}
	

	@Test
	public void testGetUserProfileById() throws IOException, InterruptedException {
		
        GetUserProfileResponse response = null;
		JSONObject jsonResponse = new JSONObject();
		jsonResponse.put("status", "success");
		
		Mockito.when(client.getRequest(Mockito.anyString())).thenReturn(jsonResponse);
		
		response = profile.getUserProfileById("dummy");
		
        Assert.assertNotNull(response);
        Assert.assertEquals("success", response.getStatus());
	}

	@Test
	public void testUploadDeviceTokens() throws IOException, InterruptedException {
		Response response = null;
		JSONObject jsonResponse = new JSONObject();
		jsonResponse.put("status", "success");
		
		ProfilePayload payload = new ProfilePayload();
		payload.setFBID("Random_id");
		List<ProfilePayload> payloadList = new ArrayList<ProfilePayload>();
		payloadList.add(payload);
		
		Mockito.when(client.postRequest(Mockito.anyString(), Mockito.any(JSONObject.class))).thenReturn(jsonResponse);
		
		response = profile.uploadDeviceTokens(payloadList);
   
		Assert.assertNotNull(response);
        Assert.assertEquals("success", response.getStatus());
        
	}

	@Test
	public void testGetProfileCount() throws IOException, InterruptedException {
		Response response = null;
		JSONObject jsonResponse = new JSONObject();
		jsonResponse.put("status", "success");
		
		ProfilePayload payload = new ProfilePayload();
		payload.setFBID("Random_id");
		
		Mockito.when(client.postRequest(Mockito.anyString(), Mockito.any(JSONObject.class))).thenReturn(jsonResponse);
		
		response = profile.getProfileCount(payload);
   
		Assert.assertNotNull(response);
        Assert.assertEquals("success", response.getStatus());
	}

	@Test
	public void testDeleteUserProfile() throws IOException, InterruptedException {
		Response response = null;
		JSONObject jsonResponse = new JSONObject();
		jsonResponse.put("status", "success");
		
		ProfilePayload payload = new ProfilePayload();
		payload.setFBID("Random_id");
		
		Mockito.when(client.postRequest(Mockito.anyString(), Mockito.any(JSONObject.class))).thenReturn(jsonResponse);
		
		response = profile.deleteUserProfile(payload);
   
		Assert.assertNotNull(response);
		Assert.assertEquals("success", response.getStatus());
	}

	@Test
	public void testDemergeUserProfile() throws IOException, InterruptedException {
		Response response = null;
		JSONObject jsonResponse = new JSONObject();
		jsonResponse.put("status", "success");
		
		ProfilePayload payload = new ProfilePayload();
		payload.setFBID("Random_id");
		
		Mockito.when(client.postRequest(Mockito.anyString(), Mockito.any(JSONObject.class))).thenReturn(jsonResponse);
		
		response = profile.demergeUserProfile(payload);
   
		Assert.assertNotNull(response);
		Assert.assertEquals("success", response.getStatus());
	}

	@Test
	public void testSubscribe() throws IOException, InterruptedException {
		Response response = null;
		JSONObject jsonResponse = new JSONObject();
		jsonResponse.put("status", "success");
		
		ProfilePayload payload = new ProfilePayload();
		payload.setFBID("Random_id");
		List<ProfilePayload> payloadList = new ArrayList<ProfilePayload>();
		payloadList.add(payload);
		
		Mockito.when(client.postRequest(Mockito.anyString(), Mockito.any(JSONObject.class))).thenReturn(jsonResponse);
		
		response = profile.subscribe(payloadList);
   
		Assert.assertNotNull(response);
        Assert.assertEquals("success", response.getStatus());
		
	}

	@Test
	public void testDissociate() throws IOException, InterruptedException {
		Response response = null;
		JSONObject jsonResponse = new JSONObject();
		jsonResponse.put("status", "success");
		
		ProfilePayload payload = new ProfilePayload();
		payload.setFBID("Random_id");
		List<ProfilePayload> payloadList = new ArrayList<ProfilePayload>();
		payloadList.add(payload);
		
		Mockito.when(client.postRequest(Mockito.anyString(), Mockito.any(JSONObject.class))).thenReturn(jsonResponse);
		
		response = profile.dissociate(payloadList);
   
		Assert.assertNotNull(response);
        Assert.assertEquals("success", response.getStatus());
	}

}

package Profile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import HTTP.HttpClient;
import Helper.Cursor;
import Payload.CategoryResubscribe;
import Payload.CategoryUnsubscribe;
import Payload.Keys;
import Payload.ProfileData;
import Payload.ProfilePayload;
import Payload.TokenData;
import Response.GetUserProfileResponse;
import Response.Response;

public class ProfilesTest {
	
	@Mock Cursor cursorMock;
	@Mock HttpClient client;
	@InjectMocks Profiles profile;

	@BeforeEach
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
		payload.setValue("random");
		payload.setFBID("Random_id");
		payload.setType("Payload");
		payload.setStatus("success");
		payload.setFrom(01032020);
		payload.setTo(11022020);
		payload.setEvent_name("testing class");
		payload.setObjectId("dksjka");
		payload.setTs("10112020002");
		String[] identity = {"dummy"};
		String[] identities = {"dummy"};
		String[] guid = {"dummy"};
		payload.setIdentity(identity);
		payload.setIndentities(identities);
		payload.setGuid(guid);
		HashMap<String, String> evtProps = new HashMap<String, String>();
		evtProps.put("type", "test");
		payload.setEvent_properties(evtProps);
		
		ProfileData profileData = new ProfileData();
		profileData.setName("dummy");
		profileData.setEmail("dummy");
		profileData.setPhone("dummy");
		profileData.setGender("dummy");
		profileData.setMSG_sms(true);
		profileData.setMSG_email(true);
		profileData.setMSG_whatsapp(true);
		profileData.setMSG_dndEmail(true);
		profileData.setMSG_dndPhone(true);
		profileData.setDOB("01012020");
		CategoryUnsubscribe categoryUnsubscribe = new CategoryUnsubscribe();
		CategoryResubscribe categoryResubscribe = new CategoryResubscribe();
		String[] email = {"dummy"};
		categoryUnsubscribe.setEmail(email);
		categoryResubscribe.setEmail(email);
		profileData.setCategory_resubscribe(categoryResubscribe);
		profileData.setCategory_unsubscribe(categoryUnsubscribe);
		HashMap<String, Object> extra_data = new HashMap<String, Object>();
		extra_data.put("extra", "data");
		profileData.setExtra_data(extra_data);
		
		payload.setProfileData(profileData);
		
		TokenData tokenData = new TokenData();
		tokenData.setId("dummy");
		tokenData.setType("test");
		Keys keys = new Keys();
		keys.setAuth("auth");
		keys.setP256dh("jjfjfj");
		tokenData.setKeys(keys);
		
		payload.setTokenData(tokenData);
		
		List<ProfilePayload> payloadList = new ArrayList<ProfilePayload>();
		payloadList.add(payload);
		
		Mockito.when(client.postRequest(Mockito.anyString(), Mockito.any(JSONObject.class))).thenReturn(jsonResponse);
		
		response = profile.uploadUserProfile(payloadList);
   
		Assertions.assertNotNull(response);
		Assertions.assertEquals("success", response.getStatus());
	}

	@Test
	public void testGetUserProfileCursor() throws IOException, InterruptedException {
  
		Cursor cursor = null;
		JSONObject jsonResponse = new JSONObject();
		jsonResponse.put("cursor", "fhsklaioclamlkkjadajj");
		jsonResponse.put("status", "success");
		ProfilePayload payload = new ProfilePayload();
		payload.setFBID("Random_id");
		
		Mockito.when(client.postRequest(Mockito.anyString(), Mockito.any(JSONObject.class))).thenReturn(jsonResponse);

		cursor = profile.getUserProfileCursor(payload, 0);
		
		Assertions.assertNotNull(cursor);
		Assertions.assertEquals("fhsklaioclamlkkjadajj", cursor.getCursor());
		Assertions.assertEquals("success", cursor.getStatus());
	}
	

	@Test
	public void testGetUserProfileData() throws IOException, InterruptedException {
		GetUserProfileResponse response = null;
		JSONObject jsonResponse = new JSONObject();
		jsonResponse.put("status", "success");
		
		Mockito.when(client.getRequest(Mockito.anyString())).thenReturn(jsonResponse);
		
		response = profile.getUserProfileData(cursorMock);
		
		Assertions.assertNotNull(response);
		Assertions.assertEquals("success", response.getStatus());
	}
	

	@Test
	public void testGetUserProfileById() throws IOException, InterruptedException {
		
        GetUserProfileResponse response = null;
		JSONObject jsonResponse = new JSONObject();
		jsonResponse.put("status", "success");
		
		Mockito.when(client.getRequest(Mockito.anyString())).thenReturn(jsonResponse);
		
		response = profile.getUserProfileById("dummy");
		
		Assertions.assertNotNull(response);
		Assertions.assertEquals("success", response.getStatus());
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
   
		Assertions.assertNotNull(response);
		Assertions.assertEquals("success", response.getStatus());
        
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
   
		Assertions.assertNotNull(response);
		Assertions.assertEquals("success", response.getStatus());
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
   
		Assertions.assertNotNull(response);
		Assertions.assertEquals("success", response.getStatus());
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
   
		Assertions.assertNotNull(response);
		Assertions.assertEquals("success", response.getStatus());
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
   
		Assertions.assertNotNull(response);
		Assertions.assertEquals("success", response.getStatus());
		
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
   
		Assertions.assertNotNull(response);
		Assertions.assertEquals("success", response.getStatus());
	}

}

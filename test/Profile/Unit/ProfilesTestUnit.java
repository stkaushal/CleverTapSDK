package Profile.Unit;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import HTTP.HttpClient;
import Helper.ClevertapInstance;
import Helper.Cursor;
import Helper.Enums.Region;
import Helper.Enums.UserIdentity;
import Payload.Profile.Keys;
import Payload.Profile.ProfilePayload;
import Payload.Profile.TokenData;
import Payload.Profile.ProfileData.CategoryResubscribe;
import Payload.Profile.ProfileData.CategoryUnsubscribe;
import Payload.Profile.ProfileData.ProfileData;
import Profile.Profiles;
import Response.GetUserProfileResponse;
import Response.Response;

public class ProfilesTestUnit {

	ClevertapInstance instance = new ClevertapInstance("dummy", "dummy", Region.NONE);
	Profiles resProfiles = instance.getProfileInstance();

	@Mock
	Cursor cursorMock;
	@Mock
	HttpClient client;
	@InjectMocks
	Profiles profile;

	@BeforeEach
	public void setUp() throws Exception {
		System.out.println("Before profile test call");
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testUploadUserProfile() throws IOException, InterruptedException {

		ProfilePayload payload = new ProfilePayload();
		payload.setValue("random");
		payload.setFbId("Random_id");
		payload.setType("Payload");
		payload.setStatus("success");
		payload.setFromDate(01032020);
		payload.setToDate(11022020);
		payload.setEventName("testing class");
		payload.setObjectId("dksjka");
		payload.setTimestamp("10112020002");
		String[] identity = { "dummy" };
		String[] identities = { "dummy" };
		String[] guid = { "dummy" };
		payload.setUserIdentity(identity);
		payload.setIdentities(identities);
		payload.setGuid(guid);
		HashMap<String, String> evtProps = new HashMap<String, String>();
		evtProps.put("type", "test");
		payload.setEventProperties(evtProps);

		ProfileData profileData = new ProfileData();
		profileData.setName("dummy");
		profileData.setEmail("dummy");
		profileData.setPhone("dummy");
		profileData.setGender("dummy");
		profileData.setMsgSMS(true);
		profileData.setMsgEmail(true);
		profileData.setMsgWhatsapp(true);
		profileData.setMsgDndEmail(true);
		profileData.setMsgDndPhone(true);
		profileData.setDob("01012020");
		CategoryUnsubscribe categoryUnsubscribe = new CategoryUnsubscribe();
		CategoryResubscribe categoryResubscribe = new CategoryResubscribe();
		String[] email = { "dummy" };
		categoryUnsubscribe.setEmail(email);
		categoryResubscribe.setEmail(email);
		profileData.setCategoryResubscribe(categoryResubscribe);
		profileData.setCategoryUnsubscribe(categoryUnsubscribe);
		HashMap<String, Object> extra_data = new HashMap<String, Object>();
		extra_data.put("extra", "data");
		profileData.setUserInfo(extra_data);

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

		Response response = null;

		JSONObject jsonResponse = new JSONObject();
		jsonResponse.put("status", "success");

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
		payload.setFbId("Random_id");

		Mockito.when(client.postRequest(Mockito.anyString(), Mockito.any(JSONObject.class))).thenReturn(jsonResponse);

		cursor = profile.getUserProfileCursor(payload, 0, true, true, true);
		
		Assertions.assertNotNull(cursor);
		Assertions.assertEquals("fhsklaioclamlkkjadajj", cursor.getCursor());
		Assertions.assertEquals("success", cursor.getStatus());
	}

	@Test
	public void testGetUserProfileData() throws IOException, InterruptedException {
		GetUserProfileResponse response = null;

		JSONObject jsonResponse = new JSONObject();
		jsonResponse.put("status", "success");
		jsonResponse.put("next_cursor", "dummy");

		JSONArray records = new JSONArray();
		JSONObject jsonRecords = new JSONObject();
		jsonRecords.put("email", "dummy");
		jsonRecords.put("name", "dummy");
		jsonRecords.put("identity", "dummy");
		JSONObject profileData = new JSONObject();
		profileData.put("test", "dummy");
		jsonRecords.put("profileData", profileData);
		JSONObject events = new JSONObject();
		events.put("test", "dummy");
		jsonRecords.put("events", events);
		JSONArray platformInfo = new JSONArray();
		JSONObject jsonPlatformInfo = new JSONObject();
		jsonPlatformInfo.put("test", "dummy");
		platformInfo.put(jsonPlatformInfo);
		jsonRecords.put("platformInfo", platformInfo);

		records.put(jsonRecords);
		jsonResponse.put("records", records);

		Mockito.when(client.getRequest(Mockito.anyString())).thenReturn(jsonResponse);

		response = profile.getUserProfileData("");

		Assertions.assertNotNull(response);
		Assertions.assertNotNull(response.getNextCursor());
		Assertions.assertNotNull(response.getRecords());
		Assertions.assertNotNull(response.getRecords().get(0).getEmail());
		Assertions.assertNotNull(response.getRecords().get(0).getEvents());
		Assertions.assertNotNull(response.getRecords().get(0).getIdentity());
		Assertions.assertNotNull(response.getRecords().get(0).getName());
		Assertions.assertNotNull(response.getRecords().get(0).getPlatformInfo());
		Assertions.assertNotNull(response.getRecords().get(0).getProfileData());
		System.out.println(response.getRecords());
		Assertions.assertEquals("success", response.getStatus());
	}

	@Test
	public void testGetUserProfileById() throws IOException, InterruptedException {

		GetUserProfileResponse response = null;
		JSONObject jsonResponse = new JSONObject();
		jsonResponse.put("status", "success");

		Mockito.when(client.getRequest(Mockito.anyString())).thenReturn(jsonResponse);

		response = profile.getUserProfileById(UserIdentity.EMAIL, "dummy");

		Assertions.assertNotNull(response);
		Assertions.assertEquals("success", response.getStatus());
	}

	@Test
	public void testUploadDeviceTokens() throws IOException, InterruptedException {
		Response response = null;
		JSONObject jsonResponse = new JSONObject();
		jsonResponse.put("status", "success");

		ProfilePayload payload = new ProfilePayload();
		payload.setFbId("Random_id");
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
		payload.setFbId("Random_id");

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
		payload.setFbId("Random_id");

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
		payload.setFbId("Random_id");

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
		payload.setFbId("Random_id");
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
		payload.setFbId("Random_id");
		List<ProfilePayload> payloadList = new ArrayList<ProfilePayload>();
		payloadList.add(payload);

		Mockito.when(client.postRequest(Mockito.anyString(), Mockito.any(JSONObject.class))).thenReturn(jsonResponse);

		response = profile.disassociate(payloadList);

		Assertions.assertNotNull(response);
		Assertions.assertEquals("success", response.getStatus());
	}

}

package profile.integration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import helper.ClevertapInstance;
import helper.enums.Region;
import helper.enums.UserIdentity;
import payload.Cursor;
import payload.profile.TokenKeys;
import payload.profile.ProfilePayload;
import payload.profile.TokenData;
import payload.profile.profiledata.CategoryResubscribe;
import payload.profile.profiledata.CategoryUnsubscribe;
import payload.profile.profiledata.ProfileData;
import profile.Profiles;
import response.GetUserProfileResponse;
import response.Response;

@TestMethodOrder(OrderAnnotation.class)
public class ProfilesIntegrationTest {

	String clevertapID = "4R8-K98-8Z6Z";
	String clevertapPassword = "AOE-RUW-CHUL";
	ClevertapInstance instance = new ClevertapInstance(clevertapID, clevertapPassword, Region.DEFAULT);
	Profiles profileInstance = instance.getProfileInstance();

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("Before profile integration test call");
	}

	@Test
	@Order(1)
	void testUploadUserProfile() throws IOException, InterruptedException {
		ProfilePayload payload = new ProfilePayload();
		payload.setUserIdentity("894683");
		payload.setType("profile");
		ProfileData profileData = new ProfileData();
		profileData.setName("Dharmender Sheshma");
		profileData.setEmail("dharmender.sheshma@clevertap.com");
		profileData.setPhone("+919116724916");
		profileData.setGender("M");
		profileData.setMsgSMS(true);
		profileData.setMsgEmail(true);
		profileData.setMsgWhatsapp(true);
		profileData.setMsgDndPhone(false);
		profileData.setMsgDndEmail(false);
		CategoryUnsubscribe categoryUnsubscribe = new CategoryUnsubscribe();
		String[] categoryUS = { "MailBox" };
		categoryUnsubscribe.setEmail(categoryUS);
		profileData.setCategoryUnsubscribe(categoryUnsubscribe);

		CategoryResubscribe categoryResubscribe = new CategoryResubscribe();
		String[] categoryRS = { "Cricket" };
		categoryResubscribe.setEmail(categoryRS);
		profileData.setCategoryResubscribe(categoryResubscribe);
		profileData.setDob("$D_847996200000");
		profileData.setCustomerType("Gold");
		HashMap<String, Object> userInfo = new HashMap<String, Object>();
		userInfo.put("Profession", "Manager");

		profileData.setUserInfo(userInfo);

		payload.setProfileData(profileData);
		List<ProfilePayload> payloadList = new ArrayList<ProfilePayload>();
		payloadList.add(payload);

		Response resUploadProfile = profileInstance.uploadUserProfile(payloadList);

		Assertions.assertNotNull(resUploadProfile);
		Assertions.assertEquals("success", resUploadProfile.getStatus());
	}

	@Test
	@Order(2)
	void testGetUserProfileCursor() throws IOException, InterruptedException {
		ProfilePayload payloadCursor = new ProfilePayload();
		payloadCursor.setEventName("charged");
		payloadCursor.setFromDate(20210606);
		payloadCursor.setToDate(20210609);
		Cursor cursor = profileInstance.getUserProfileCursor(payloadCursor, 1000, true, true, true);

		Assertions.assertNotNull(cursor);
		Assertions.assertEquals("success", cursor.getStatus());
	}

	@Test
	@Order(3)
	void testGetUserProfileData() throws IOException, InterruptedException {
		GetUserProfileResponse getProfileEv = instance.getProfileInstance().getUserProfileData("");

		Assertions.assertNotNull(getProfileEv);
		Assertions.assertEquals("fail", getProfileEv.getStatus());
	}

	@Test
	@Order(4)
	void testGetUserProfileById() throws IOException, InterruptedException {
		GetUserProfileResponse getProfileId = instance.getProfileInstance().getUserProfileById(UserIdentity.EMAIL,
				"dharmender.sheshma@clevertap.com");

		Assertions.assertNotNull(getProfileId);
		Assertions.assertEquals("success", getProfileId.getStatus());
	}

	@Test
	@Order(5)
	void testUploadDeviceTokens() throws IOException, InterruptedException {
		ProfilePayload tokenPayload = new ProfilePayload();
		tokenPayload.setType("token");
		TokenData tokenData = new TokenData();
		tokenData.setId("sjddsjnoollfjks");
		tokenData.setType("chrome");
		TokenKeys tokenKeys = new TokenKeys();
		tokenKeys.setP256dh("dummy1 P256dh");
		tokenKeys.setAuth("dummy2 Auth");
		tokenData.setKeys(tokenKeys);
		tokenPayload.setTokenData(tokenData);
		tokenPayload.setObjectId("IZ8MGYYO9pLJraUK-D9Dfw");
		List<ProfilePayload> payloadTokensList = new ArrayList<ProfilePayload>();
		payloadTokensList.add(tokenPayload);
		Response uploadTokensResponse = instance.getProfileInstance().uploadDeviceTokens(payloadTokensList);

		Assertions.assertNotNull(uploadTokensResponse);
		Assertions.assertEquals("success", uploadTokensResponse.getStatus());
	}

	@Test
	@Order(6)
	void testGetProfileCount() throws IOException, InterruptedException {
		ProfilePayload payload = new ProfilePayload();
		payload.setEventName("Charged");
		payload.setFromDate(20210606);
		payload.setToDate(20210624);

		Response response = profileInstance.getProfileCount(payload);

		Assertions.assertNotNull(response);

		if (response.getStatus().equals("partial")) {
			Response responseFinal = profileInstance.getProfileCountByReqId(response.getReqId());

			Assertions.assertNotNull(responseFinal);
			Assertions.assertNotNull(responseFinal.getCount());
			Assertions.assertEquals("success", responseFinal.getStatus());
		}

	}

	@Test
	@Order(7)
	void testDeleteUserProfile() throws IOException, InterruptedException {
		ProfilePayload userDeletePayload = new ProfilePayload();
		userDeletePayload.setUserIdentity("894683");
		Response resUserDeletePayload = instance.getProfileInstance().deleteUserProfile(userDeletePayload);

		Assertions.assertNotNull(resUserDeletePayload);
		Assertions.assertEquals("success", resUserDeletePayload.getStatus());
	}

	@Test
	@Order(8)
	void testDemergeUserProfile() throws IOException, InterruptedException {
		ProfilePayload userDemergePayload = new ProfilePayload();
		String[] id = {"894683", "911672"};
		userDemergePayload.setIdentities(id);
		Response resUserDemergePayload= instance.getProfileInstance().demergeUserProfile(userDemergePayload);

		Assertions.assertNotNull(resUserDemergePayload);
		Assertions.assertEquals("success", resUserDemergePayload.getStatus());
	}

	@Test
	@Order(9)
	void testSubscribe() throws IOException, InterruptedException {
		List<ProfilePayload> paySubscribeList = new ArrayList<ProfilePayload>();
		ProfilePayload subscribePayload = new ProfilePayload();
		subscribePayload.setType("phone");
		subscribePayload.setValue("+919116724916");
		subscribePayload.setStatus("Resubscribe");
		paySubscribeList.add(subscribePayload);
		Response resSubscribePayload= instance.getProfileInstance().subscribe(paySubscribeList);

		Assertions.assertNotNull(resSubscribePayload);
		Assertions.assertEquals("success", resSubscribePayload.getStatus());
	}

	@Test
	@Order(10)
	void testDisassociate() throws IOException, InterruptedException {
		List<ProfilePayload> payDisasList = new ArrayList<ProfilePayload>();
		ProfilePayload disassociatePayload = new ProfilePayload();
		disassociatePayload.setType("phone");
		disassociatePayload.setValue("+919116724916");
		payDisasList.add(disassociatePayload);
		Response resDisasPayload= instance.getProfileInstance().disassociate(payDisasList);
		
		Assertions.assertNotNull(resDisasPayload);
		Assertions.assertEquals("success", resDisasPayload.getStatus());
	}

}

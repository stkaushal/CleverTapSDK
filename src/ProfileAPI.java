import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.json.JSONObject;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import Helper.ClevertapInstance;
import Helper.Cursor;
import Helper.Region;
import Payload.CategoryResubscribe;
import Payload.CategoryUnsubscribe;
import Payload.Keys;
import Payload.ProfileData;
import Payload.ProfilePayload;
import Payload.TokenData;
import Response.GetUserProfileResponse;
import Response.Response;

public class ProfileAPI {
	
    public static void main(String[] args) throws IOException, InterruptedException {
    	
	   String Cid = "4R8-K98-8Z6Z";
	   String CPswd = "AOE-RUW-CHUL";
	   ClevertapInstance instance  = new ClevertapInstance(Cid, CPswd, Region.NONE);
	   
	   ObjectMapper jsonMapper = new ObjectMapper();
	   jsonMapper.setSerializationInclusion(Include.NON_NULL);
	   jsonMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	   
	   //Upload profile//
	   
//	   ProfilePayload payload = new ProfilePayload();
//	   payload.setUserIdentity("911672");
//	   payload.setType("profile");
//	   ProfileData profileData = new ProfileData();
//	   profileData.setName("Dharmender Sheshma");
//	   profileData.setEmail("dharmendra.shesma@gmail.com");
//	   profileData.setPhone("+919116724916");
//	   profileData.setGender("M");
//	   profileData.setMsgSMS(true);
//	   profileData.setMsgEmail(true);
//	   profileData.setMsgWhatsapp(true);
//	   profileData.setMsgDndPhone(false);
//	   profileData.setMsgDndEmail(false);
//	   CategoryUnsubscribe categoryUnsubscribe = new CategoryUnsubscribe();
//	   String[] categoryUS = {"Newsletter"};
//	   categoryUnsubscribe.setEmail(categoryUS);
//	   profileData.setCategoryUnsubscribe(categoryUnsubscribe);
//	   
//	   CategoryResubscribe categoryResubscribe = new CategoryResubscribe();
//	   String[] categoryRS = {"Football"};
//	   categoryResubscribe.setEmail(categoryRS);
//	   profileData.setCategoryResubscribe(categoryResubscribe);
//	   profileData.setDob("$D_847996200000");
//	   profileData.setCustomerType("Platinum");
//	   HashMap<String, Object> userInfo = new HashMap<String, Object>(); 
//	   userInfo.put("Profession", "Student");
//	   
//	   profileData.setUserInfo(userInfo);
//	   
//	   payload.setProfileData(profileData);
//	   List<ProfilePayload> payloadList = new ArrayList<ProfilePayload>();
//	   payloadList.add(payload);
//	   
//	   Response resUploadProfile = instance.getProfileInstance().uploadUserProfile(payloadList);
//	   JSONObject uploadProfileResponse= new JSONObject(jsonMapper.writeValueAsString(resUploadProfile));
//	   System.out.println(uploadProfileResponse.toString(4));
	   
	   //Get profile by ID//
	   
//	   GetUserProfileResponse getProfileId = instance.getProfileInstance().getUserProfileById("email", "dharmendra.shesma@gmail.com");
//	 
//	   JSONObject getProfileIdResponse= new JSONObject(jsonMapper.writeValueAsString(getProfileId));
//	   System.out.println(getProfileIdResponse.toString(4));
	   
	   
	   //get profile by cursor//
	   
//	   ProfilePayload payloadCursor = new ProfilePayload(); GetUserProfileResponse getProfileId = instance.getProfileInstance().getUserProfileById("identity", "1");
//	 
//	   JSONObject getProfileIdResponse= new JSONObject(jsonMapper.writeValueAsString(getProfileId));
//	   System.out.println(getProfileIdResponse.toString(4));
//	   payloadCursor.setEventName("charged");
//	   payloadCursor.setFromDate(20210606);
//	   payloadCursor.setToDate(20210609);
//	   Cursor cursor = instance.getProfileInstance().getUserProfileCursor(payloadCursor, 1000);
//	   GetUserProfileResponse getProfileEv = instance.getProfileInstance().getUserProfileData(cursor);
//	   while(getProfileEv.getNextCursor()!=null)
//	   {
//		   JSONObject getProfileEvResponse= new JSONObject(jsonMapper.writeValueAsString(getProfileEv));
//		   System.out.println(getProfileEvResponse.toString(4));
//		   cursor.setCursor(getProfileEv.getNextCursor());
//		   getProfileEv = instance.getProfileInstance().getUserProfileData(cursor);
//	   }
//	   JSONObject getProfileEvResponse= new JSONObject(jsonMapper.writeValueAsString(getProfileEv));
//	   System.out.println(getProfileEvResponse.toString(4));
	   
	   //Delete profile//
	   
//	   ProfilePayload userDeletePayload = new ProfilePayload();
//	   userDeletePayload.setUserIdentity("123456");
//	   Response resUserDeletePayload = instance.getProfileInstance().deleteUserProfile(userDeletePayload);
//	   JSONObject getProfileIdDeleteResponse= new JSONObject(jsonMapper.writeValueAsString(resUserDeletePayload));
//	   System.out.println(getProfileIdDeleteResponse.toString(4));
	   
	   //Upload device tokens//
	   
//	   ProfilePayload tokenPayload = new ProfilePayload();
//	   tokenPayload.setType("token");
//	   TokenData tokenData = new TokenData();
//	   tokenData.setId("sjddsjnoosjfjks");
//	   tokenData.setType("chrome");
//	   Keys keys = new Keys();
//	   keys.setP256dh("dummy P256dh");
//	   keys.setAuth("dummy Auth");
//	   tokenData.setKeys(keys);
//	   tokenPayload.setTokenData(tokenData);
//	   tokenPayload.setObjectId("IZ8MGYYO9pLJraUK-D9Dfw");
//	   List<ProfilePayload> payloadTokensList = new ArrayList<ProfilePayload>();
//	   payloadTokensList.add(tokenPayload);
//	   Response uploadTokensResponse = instance.getProfileInstance().uploadDeviceTokens(payloadTokensList);
//	   JSONObject uploadTokensResponseJSON= new JSONObject(jsonMapper.writeValueAsString(uploadTokensResponse));
//	   System.out.println(uploadTokensResponseJSON.toString(4));
	   
	   //Demerge//
	   
//	   ProfilePayload userDemergePayload = new ProfilePayload();
//	   String[] id = {"1999999", "12345"};
//	   userDemergePayload.setIdentities(id);
//	   Response resUserDemergePayload= instance.getProfileInstance().demergeUserProfile(userDemergePayload);
//	   JSONObject getProfileIdDemergeResponse= new JSONObject(jsonMapper.writeValueAsString(resUserDemergePayload));
//	   System.out.println(getProfileIdDemergeResponse.toString(4));
   
	   //Subscribe//
	   
//	   List<ProfilePayload> paySubscribeList = new ArrayList<ProfilePayload>();
//	   ProfilePayload subscribePayload = new ProfilePayload();
//	   subscribePayload.setType("phone");
//	   subscribePayload.setValue("+919116724916");
//	   subscribePayload.setStatus("Resubscribe");
//	   paySubscribeList.add(subscribePayload);
//	   Response resSubscribePayload= instance.getProfileInstance().subscribe(paySubscribeList);
//	   JSONObject getSubscribeResponse= new JSONObject(jsonMapper.writeValueAsString(resSubscribePayload));
//	   System.out.println(getSubscribeResponse.toString(4));
	   
	   // Disassociate //
	   
//	   List<ProfilePayload> payDisasList = new ArrayList<ProfilePayload>();
//	   ProfilePayload disassociatePayload = new ProfilePayload();
//	   disassociatePayload.setType("phone");
//	   disassociatePayload.setValue("+919116724916");
//	   payDisasList.add(disassociatePayload);
//	   Response resDisasPayload= instance.getProfileInstance().disassociate(payDisasList);
//	   JSONObject getSubscribeResponse= new JSONObject(jsonMapper.writeValueAsString(resDisasPayload));
//	   System.out.println(getSubscribeResponse.toString(4));
	   
	   
	   
	   
    }
    
    
}
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
import Helper.Enums.*;
import Payload.Profile.Keys;
import Payload.Profile.ProfilePayload;
import Payload.Profile.TokenData;
import Payload.Profile.ProfileData.CategoryResubscribe;
import Payload.Profile.ProfileData.CategoryUnsubscribe;
import Payload.Profile.ProfileData.ProfileData;
import Response.GetUserProfileResponse;
import Response.Response;

public class ProfileAPI {
	
    public static void main(String[] args) throws IOException, InterruptedException {
//    	String Cid = "4R8-K98-8Z6Z";
//		String CPswd = "AOE-RUW-CHUL";
    	String Cid = "W8W-897-865Z";
		String CPswd = "042043bfc0ec4fd5ac14291840ec6c1e";
    	ClevertapInstance instance  = new ClevertapInstance(Cid, CPswd, Region.DEVELOPMENT);
	   
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
	   
//	   GetUserProfileResponse getProfileId = instance.getProfileInstance().getUserProfileById(UserIdentity.EMAIL, "email1@gmail.com");
//	 
//	   JSONObject getProfileIdResponse= new JSONObject(jsonMapper.writeValueAsString(getProfileId));
//	   System.out.println(getProfileIdResponse.toString(4));
	   
	   
	   //get profile by cursor//
	   
//	   ProfilePayload payloadCursor = new ProfilePayload(); 
//	
//	   payloadCursor.setEventName("Identity Set");
//	   payloadCursor.setFromDate(20210705);
//	   payloadCursor.setToDate(20210705);
//	   Cursor cursor = instance.getProfileInstance().getUserProfileCursor(payloadCursor, 1000, true, true, true);
//	   GetUserProfileResponse getProfileEv = instance.getProfileInstance().getUserProfileData(cursor.getCursor());
//	   while(getProfileEv.getNextCursor()!=null)
//	   {
//		   JSONObject getProfileEvResponse= new JSONObject(jsonMapper.writeValueAsString(getProfileEv));
//		   System.out.println(getProfileEvResponse.toString(4));
//		   cursor.setCursor(getProfileEv.getNextCursor());
//		   getProfileEv = instance.getProfileInstance().getUserProfileData(cursor.getCursor());
//	   }
	   
	   //Delete profile//
	   
//	   ProfilePayload userDeletePayload = new ProfilePayload();
//	   userDeletePayload.setUserIdentity("+916376440361");
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
	   
	   
	   //Profile count//
	   
	   ProfilePayload countProile = new ProfilePayload();
	   countProile.setEventName("Identity Set");
	   countProile.setFromDate(20210705);
	   countProile.setToDate(20210705);
	   	
	   Response resCount = instance.getProfileInstance().getProfileCount(countProile);
	   JSONObject getcountResponse= new JSONObject(jsonMapper.writeValueAsString(resCount));
	   System.out.println("count response before::"+getcountResponse.toString(4));
	   System.out.println("status::"+resCount.getStatus());
	   
	   if(resCount.getStatus().equals("partial")) {
		   Response reqIdCount = instance.getProfileInstance().getProfileCountByReqId(resCount.getReqId());
		   JSONObject getcountReqIdResponse= new JSONObject(jsonMapper.writeValueAsString(reqIdCount));
		   System.out.println("count response after::"+getcountReqIdResponse.toString(4));
	   }
    }
    
    
}
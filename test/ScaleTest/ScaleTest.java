package ScaleTest;

import java.io.FileWriter;
import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import Helper.ClevertapInstance;
import Helper.Enums.CampaignMethod;
import Helper.Enums.Region;
import Payload.*;
import Payload.Profile.ProfilePayload;
import Payload.Profile.ProfileData.ProfileData;
import Response.Response;

class ScaleTest {

	String Cid = "W8W-897-865Z";
	String CPswd = "042043bfc0ec4fd5ac14291840ec6c1e";
	ClevertapInstance instance  = new ClevertapInstance(Cid, CPswd, Region.DEVELOPMENT);

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("Before scale test");
	}

	@Test
	void testUploadUserProfile() throws IOException, InterruptedException {
		int count = 0;
		for(int j = 0; j < 50; j++) {
			List<ProfilePayload> payloadList = new ArrayList<ProfilePayload>();
	
			for(int i = 0; i < 1000; i++) {
				ProfilePayload payload = new ProfilePayload();
				payload.setUserIdentity("person"+String.valueOf(count));
				payload.setType("profile");
	
				ProfileData profileData = new ProfileData();
				profileData.setName("Person"+String.valueOf(count));
				profileData.setEmail("person"+String.valueOf(count)+"@clevertap.com");
				
//				String number = String.valueOf(count);
//				for(int k = number.length(); k < 10; k++)
//				{
//					number += "0";
//				}
//				profileData.setPhone("+91"+number);
				profileData.setGender("M");
				profileData.setMsgSMS(true);
				profileData.setMsgEmail(true);
				profileData.setMsgWhatsapp(true);
				profileData.setMsgDndPhone(false);
				profileData.setMsgDndEmail(false);
				profileData.setDob("$D_911079285");
				profileData.setCustomerType("Platinum");
	
				payload.setProfileData(profileData);
	
				payloadList.add(payload);	
				
				count++;
				
			}
	
			Response resUploadProfile = instance.getProfileInstance().uploadUserProfile(payloadList);
			System.out.println(resUploadProfile.getProcessed());
//			try {
//				TimeUnit.SECONDS.sleep(10);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
		}
//		try {
//			TimeUnit.SECONDS.sleep(120);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		ProfilePayload countProile = new ProfilePayload();
		countProile.setEventName("Identity Set");
		countProile.setFromDate(20210630);
		countProile.setToDate(20210630);

		Response resCount = instance.getProfileInstance().getProfileCount(countProile);

		if(resCount.getStatus().equals("partial")) {
			Response reqIdCount = instance.getProfileInstance().getProfileCountByReqId(resCount.getReqId());
			Assertions.assertEquals(50000, reqIdCount.getCount());
		}
		else
		{
			Assertions.assertEquals(50000, resCount.getCount());
		}
	}

//	@Test
//	void testUploadevents() throws IOException, InterruptedException {
//		for(int j = 0; j < 50; j++) {
//			List<EventPayload> uploadList = new ArrayList<EventPayload>();
//			for(int i = 0; i < 1000; i++) {
//				EventPayload uploadPayload = new EventPayload();
//				uploadPayload.setIdentity("newmrscool64115@gmail.com");
//				uploadPayload.setTs(Instant.now().getEpochSecond());
//				uploadPayload.setType("event");
//				uploadPayload.setEventNameUpload("Photo Downloaded");
//				HashMap<String, Object> evtData = new HashMap<String, Object>();
//				evtData.put("Photo Name", "NAture "+String.valueOf(i)+String.valueOf(j));
//				evtData.put("Category", "Photos");
//				evtData.put("Price", 300+i+j);
//	
//				uploadPayload.setEventData(evtData);
//	
//				uploadList.add(uploadPayload);
//			}
////			Response resUpload = instance.getEventInstance().uploadEvents(uploadList);
////			System.out.println(resUpload.getProcessed());
////			try {
////				TimeUnit.SECONDS.sleep(2);
////			} catch (InterruptedException e) {
////				e.printStackTrace();
////			}
//		}
////		try {
////			TimeUnit.SECONDS.sleep(10);
////		} catch (InterruptedException e) {
////			e.printStackTrace();
////		}
////		
//		EventPayload countPayload = new EventPayload();
//		countPayload.setEventNameDownload("Photo Downloaded");
//
//		countPayload.setFromDate(20210630);
//		countPayload.setToDate(20210630);
//
//		Response resCount = instance.getEventInstance().getEventCount(countPayload);
//		
//		if(resCount.getStatus().equals("partial")) {
//			Response reqIdCount = instance.getEventInstance().getEventCountByReqId(resCount.getReqId());
//			Assertions.assertEquals(50000, reqIdCount.getCount());
//		}
//		else
//		{
//			Assertions.assertEquals(50000, resCount.getCount());
//		}
//
//	}
	
//	@Test
//	void createCampaignTest() throws IOException, InterruptedException {
//		for(int j = 0; j < 10; j++) {
//			CampaignPayload campaignPayload = new CampaignPayload();
//			To sendMessageTo = new To();
//			List<String> emailId = new ArrayList<String>();
//			for(int i = 0; i < 1000; i++) {
//				emailId.add("Newcool"+String.valueOf(i)+String.valueOf(j)+"@gmail.com");
//			}
//			sendMessageTo.setEmail(emailId);
//			campaignPayload.setSendMessageTo(sendMessageTo);
//			campaignPayload.setTagGroup("Target group for Integration testing");
//			campaignPayload.setRespectFrequencyCaps(false);
//			Content content = new Content();
//			content.setTitle("Hello");
//			content.setBody("Scale Integration test success");
//			content.setSubject("Email API call under scale integration tets");
//			content.setSenderName("Tester");
//			campaignPayload.setContent(content);
//			campaignPayload.setCampaignSendTime("now");
//	
////			Response resCreateCampaignTID = instance.getCampaignInstance().createCampaignTargetId(CampaignMethod.EMAIL, campaignPayload);
////			System.out.println(resCreateCampaignTID.getEstimates());
//		}
//		
//	}

}

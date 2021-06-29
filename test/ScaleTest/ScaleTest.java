package ScaleTest;

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

		for(int j = 0; j < 10; j++) {
			List<ProfilePayload> payloadList = new ArrayList<ProfilePayload>();
	
			for(int i = 0; i < 1000; i++) {
				ProfilePayload payload = new ProfilePayload();
				payload.setUserIdentity("newUser"+String.valueOf(i)+String.valueOf(j));
				payload.setType("profile");
	
				ProfileData profileData = new ProfileData();
				profileData.setName("NewMrCool"+String.valueOf(i)+String.valueOf(j));
				profileData.setEmail("Newcool"+String.valueOf(i)+String.valueOf(j)+"@gmail.com");
				profileData.setPhone("+91"+String.valueOf((long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L));
				profileData.setGender("M");
				profileData.setMsgSMS(true);
				profileData.setMsgEmail(true);
				profileData.setMsgWhatsapp(true);
				profileData.setMsgDndPhone(false);
				profileData.setMsgDndEmail(false);
				profileData.setDob("$D_911079284");
				profileData.setCustomerType("Gold");
	
				payload.setProfileData(profileData);
	
				payloadList.add(payload);		
			}
	
//			Response resUploadProfile = instance.getProfileInstance().uploadUserProfile(payloadList);
//			System.out.println(resUploadProfile.getProcessed());
//			try {
//				TimeUnit.SECONDS.sleep(10);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
		}

		ProfilePayload countProile = new ProfilePayload();
		countProile.setEventName("Identity Set");
		countProile.setFromDate(20210629);
		countProile.setToDate(20210629);

		Response resCount = instance.getProfileInstance().getProfileCount(countProile);

		if(resCount.getStatus().equals("partial")) {
			Response reqIdCount = instance.getProfileInstance().getProfileCountByReqId(resCount.getReqId());
			Assertions.assertEquals(11012, reqIdCount.getCount());
		}
		else
		{
			Assertions.assertEquals(11012, resCount.getCount());
		}
	}

	@Test
	void testUploadevents() throws IOException, InterruptedException {
		for(int j = 0; j < 10; j++) {
			List<EventPayload> uploadList = new ArrayList<EventPayload>();
			for(int i = 0; i < 1000; i++) {
				EventPayload uploadPayload = new EventPayload();
				uploadPayload.setIdentity("Newcool"+String.valueOf(i)+String.valueOf(j)+"@gmail.com");
				uploadPayload.setTs(Instant.now().getEpochSecond());
				uploadPayload.setType("event");
				uploadPayload.setEventNameUpload("Food Canceled");
				HashMap<String, Object> evtData = new HashMap<String, Object>();
				evtData.put("Food Name", "Pizza "+String.valueOf(i)+String.valueOf(j));
				evtData.put("Category", "Italian");
				evtData.put("Price", 500+i+j);
	
				uploadPayload.setEventData(evtData);
	
				uploadList.add(uploadPayload);
			}
			//Response resUpload = instance.getEventInstance().uploadEvents(uploadList);
			//System.out.println(resUpload.getProcessed());
		}
		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		EventPayload countPayload = new EventPayload();
		countPayload.setEventNameDownload("Food Canceled");

		countPayload.setFromDate(20210629);
		countPayload.setToDate(20210629);

		Response resCount = instance.getEventInstance().getEventCount(countPayload);
		
		if(resCount.getStatus().equals("partial")) {
			Response reqIdCount = instance.getEventInstance().getEventCountByReqId(resCount.getReqId());
			Assertions.assertEquals(10000, reqIdCount.getCount());
		}
		else
		{
			Assertions.assertEquals(10000, resCount.getCount());
		}

	}
	
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

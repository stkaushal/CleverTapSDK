package scaletest;

import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import helper.ClevertapInstance;
import helper.enums.Region;
import payload.event.EventPayload;
import payload.profile.ProfilePayload;
import payload.profile.profiledata.ProfileData;
import response.Response;

class ScaleTest {

	String clevertapID = "TEST-69W-8RW-5R6Z";
	String clevertapPassword = "af0f2e63751341fca0c934a386f5eabe";
	ClevertapInstance instance  = new ClevertapInstance(clevertapID, clevertapPassword, Region.DEVELOPMENT);

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("Before scale test");
	}

	@Test
	void testUploadUserProfile() throws IOException, InterruptedException {
		int count = 0;
		for(int j = 0; j < 1; j++) {
			List<ProfilePayload> payloadList = new ArrayList<ProfilePayload>();
	
			for(int i = 0; i < 1000; i++) {
				ProfilePayload payload = new ProfilePayload();
				String email = "fmail"+String.valueOf(Instant.now())+"@yahoomail.com";
				payload.setUserIdentity(email);
				payload.setType("profile");
	
				ProfileData profileData = new ProfileData();
				profileData.setName("F"+String.valueOf(Instant.now()));
				profileData.setGender("M");
				profileData.setMsgSMS(true);
				profileData.setMsgEmail(true);
				profileData.setMsgWhatsapp(true);
				profileData.setMsgDndPhone(false);
				profileData.setMsgDndEmail(false);
				profileData.setDob("$D_911079111");
				profileData.setCustomerType("Gold");
	
				payload.setProfileData(profileData);
	
				payloadList.add(payload);	
				
				count++;
			}
			Response resUploadProfile = instance.getProfileInstance().uploadUserProfile(payloadList);
			System.out.println(resUploadProfile.getProcessed());
		}
//		
//		TimeUnit.SECONDS.sleep(10);
		
//		ProfilePayload countProile = new ProfilePayload();
//		countProile.setEventName("Identity Set");
//		countProile.setFromDate(20210701);
//		countProile.setToDate(20210701);
//
//		Response resCount = instance.getProfileInstance().getProfileCount(countProile);
//
//		if(resCount.getStatus().equals("partial")) {
//			Response reqIdCount = instance.getProfileInstance().getProfileCountByReqId(resCount.getReqId());
//			Assertions.assertEquals(1700000, reqIdCount.getCount());
//		}
//		else
//		{
//			Assertions.assertEquals(1700000, resCount.getCount());
//		}
	}

//	@Test
//	void testUploadevents() throws IOException, InterruptedException {
//		int count = 0;
//		for(int j = 0; j < 1000; j++) {
//			List<EventPayload> uploadList = new ArrayList<EventPayload>();
//			for(int i = 0; i < 1000; i++) {
//				EventPayload uploadPayload = new EventPayload();
//				String email = "fmail"+String.valueOf(count)+"@yahoomail.com";
//				uploadPayload.setIdentity(email);
//				uploadPayload.setTs(Instant.now().getEpochSecond());
//				uploadPayload.setType("event");
//				uploadPayload.setEventNameUpload("Book Viewed");
//				HashMap<String, Object> evtData = new HashMap<String, Object>();
//				evtData.put("Book Name", "Sun Shines "+String.valueOf(i)+String.valueOf(j));
//				evtData.put("Category", "Spanish Books");
//				evtData.put("Price", 200+i+j);
//	
//				uploadPayload.setEventData(evtData);
//	
//				uploadList.add(uploadPayload);
//				
//				count++;
//			}
//			Response resUpload = instance.getEventInstance().uploadEvents(uploadList);
//			System.out.println(resUpload.getProcessed());
//
//		}
//		TimeUnit.SECONDS.sleep(10);
//		
//		EventPayload countPayload = new EventPayload();
//		countPayload.setEventNameDownload("Book Viewed");
//
//		countPayload.setFromDate(20210701);
//		countPayload.setToDate(20210701);
//
//		Response resCount = instance.getEventInstance().getEventCount(countPayload);
//		
//		if(resCount.getStatus().equals("partial")) {
//			Response reqIdCount = instance.getEventInstance().getEventCountByReqId(resCount.getReqId());
//			Assertions.assertEquals(1000000, reqIdCount.getCount());
//		}
//		else
//		{
//			Assertions.assertEquals(1000000, resCount.getCount());
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

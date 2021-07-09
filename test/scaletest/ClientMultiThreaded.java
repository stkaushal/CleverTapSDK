package scaletest;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import event.Event;
import payload.event.EventPayload;
import payload.profile.ProfilePayload;
import payload.profile.profiledata.ProfileData;
import profile.Profiles;
import response.Response;

public class ClientMultiThreaded extends Thread {
	Profiles instanceP;
	Event instanceE;
	int id;

	public ClientMultiThreaded(Profiles instance, int id) {
		this.instanceP = instance;
		this.id = id;
	}
	public ClientMultiThreaded(Event instance, int id) {
		this.instanceE = instance;
		this.id = id;
	}

	@Override
	public void run() {
		try{
			for(int j = 0; j < 10; j++) {
				List<ProfilePayload> payloadList = new ArrayList<ProfilePayload>();

				for(int i = 0; i < 1000; i++) {
					ProfilePayload payload = new ProfilePayload();
					String email = "thread"+String.valueOf(Instant.now())+"@gmail.com";
					String id = String.valueOf(Instant.now());
					payload.setUserIdentity(id);
					payload.setType("profile");

					ProfileData profileData = new ProfileData();
					profileData.setName("N"+String.valueOf(Instant.now()));
					profileData.setGender("F");
					profileData.setMsgSMS(true);
					profileData.setMsgEmail(true);
					profileData.setMsgWhatsapp(true);
					profileData.setMsgDndPhone(false);
					profileData.setMsgDndEmail(false);
					profileData.setDob("$D_911079111");
					profileData.setCustomerType("Silver");

					payload.setProfileData(profileData);

					payloadList.add(payload);	

				}
				Response resUploadProfile = instanceP.uploadUserProfile(payloadList);
				System.out.println("For thread " + id + ", req no: "+(j+1) + ", profile uploaded:: " +resUploadProfile.getProcessed());
			}
			
//			for(int j = 0; j < 10; j++) {
//				List<EventPayload> uploadList = new ArrayList<EventPayload>();
//				for(int i = 0; i < 1000; i++) {
//					EventPayload uploadPayload = new EventPayload();
//					String email = "thread2021-07-06T06:25:24.432137Z@hotmail.com";
//					uploadPayload.setIdentity(email);
//					uploadPayload.setTs(Instant.now().getEpochSecond());
//					uploadPayload.setType("event");
//					uploadPayload.setEventNameUpload("Book Viewed");
//					HashMap<String, Object> evtData = new HashMap<String, Object>();
//					evtData.put("Book Name", "Sun Shines "+String.valueOf(i)+String.valueOf(j));
//					evtData.put("Category", "Spanish Books");
//					evtData.put("Price", 200+i+j);
//		
//					uploadPayload.setEventData(evtData);
//		
//					uploadList.add(uploadPayload);
//					
//				}
//				
//				Response resUpload = instanceE.uploadEvents(uploadList);
//				System.out.println("For thread " + id + ", req no: "+(j+1) + ", event uploaded:: " +resUpload.getProcessed());
//				
//			}
//		
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}

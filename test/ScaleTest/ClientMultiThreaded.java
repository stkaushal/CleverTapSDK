package ScaleTest;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import Helper.ClevertapInstance;
import Payload.Profile.ProfilePayload;
import Payload.Profile.ProfileData.ProfileData;
import Profile.Profiles;
import Response.Response;

public class ClientMultiThreaded extends Thread {
	Profiles instance;
	int id;

	public ClientMultiThreaded(Profiles instance, int id) {
		this.instance = instance;
		this.id = id;
	}

	@Override
	public void run() {
		try{
			for(int j = 0; j < 10; j++) {
				List<ProfilePayload> payloadList = new ArrayList<ProfilePayload>();

				for(int i = 0; i < 1000; i++) {
					ProfilePayload payload = new ProfilePayload();
					String email = "thread"+String.valueOf(Instant.now())+"@hotmail.com";
					payload.setUserIdentity(email);
					payload.setType("profile");

					ProfileData profileData = new ProfileData();
					profileData.setName("T"+String.valueOf(Instant.now()));
					profileData.setGender("M");
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
				Response resUploadProfile = instance.uploadUserProfile(payloadList);
				System.out.println("For thread " + id + ", req no: "+(j+1) + " profile uploaded:: " +resUploadProfile.getProcessed());
			}
		
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
